package soulever.project.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import soulever.project.databinding.FragmentProfilBinding
import soulever.project.ui.EditProfileActivity

class ProfilFragment : Fragment() {
    private lateinit var binding: FragmentProfilBinding
    private lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null
    var username: String? = null
    var email: String? = null
    var name: String? = null
    var address: String? = null
    var tele: String? = null

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
        binding.btnedtprofile.setOnClickListener {
            val intent = Intent(activity, EditProfileActivity::class.java)
            intent.putExtra(EditProfileActivity._USERNAME, username)
            intent.putExtra(EditProfileActivity._EMAIL, email)
            intent.putExtra(EditProfileActivity._NAME, name)
            intent.putExtra(EditProfileActivity._ADDRESS, address)
            intent.putExtra(EditProfileActivity._TELEPHONE, tele)
            startActivity(intent)
        }
    }

    private fun loadProfile() {
        val user = auth.currentUser
        val currentUser = databaseReference?.child(user?.uid!!)

        currentUser?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                username = snapshot.child("Username").value.toString()
                email = snapshot.child("Email").value.toString()
                name = snapshot.child("Name").value.toString()
                address = snapshot.child("Address").value.toString()
                tele = snapshot.child("Telephone").value.toString()

                binding.tvusername.text = username
                binding.tvemail.text = email
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("Error", "Failed to read database")
            }

        })
    }

}