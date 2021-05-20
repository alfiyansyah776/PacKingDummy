package soulever.project.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import soulever.project.R
import soulever.project.databinding.FragmentProfilBinding

class ProfilFragment : Fragment() {
    private lateinit var binding : FragmentProfilBinding
    private lateinit var auth : FirebaseAuth
    var databaseReference : DatabaseReference? = null
    var database : FirebaseDatabase? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("Profile")
        binding = FragmentProfilBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        loadProfile()
    }

    private fun loadProfile(){
        val user = auth.currentUser
        val currentUser = databaseReference?.child(user?.uid!!)

        currentUser?.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.mtUsername.text = snapshot.child("Username").value.toString()
                binding.mtEmail.text = snapshot.child("Email").value.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("Error", "Failed to read database")
            }

        })
    }

}