package soulever.project.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import soulever.project.R
import soulever.project.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditProfileBinding
    private var username: String? = null
    private var email: String? = null
    private var name: String? = null
    private var address: String? = null
    private var tele: String? = null
    private lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null

    companion object {
        const val _USERNAME = "username"
        const val _EMAIL = "email"
        const val _NAME = "name"
        const val _ADDRESS = "address"
        const val _TELEPHONE = "telephone"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.getSupportActionBar()?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar()?.setCustomView(R.layout.action_bar);
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("Profile")

        val extras = intent.extras
        if (extras != null) {
            username = extras.getString(_USERNAME, "username")
            email = extras.getString(_EMAIL, "email")
            name = extras.getString(_NAME, "name")
            address = extras.getString(_ADDRESS, "address")
            tele = extras.getString(_TELEPHONE, "telephone")
        }

        populateData()
        binding.buttonsave.setOnClickListener {
            updateData()
            Toast.makeText(this@EditProfileActivity, "Data Telah Diubah", Toast.LENGTH_LONG).show()
        }
    }

    private fun populateData() {
        binding.edtusername.setText(username)
        binding.edtemail.setText(email)
        binding.edtname.setText(name)
        binding.edtaddress.setText(address)
        binding.edttelephone.setText(tele)
    }

    private fun updateData() {
        val currentUser = auth.currentUser
        if (binding.edtusername.text.toString() != username) {
            databaseReference?.child(currentUser?.uid!!)?.child("Username")
                ?.setValue(binding.edtusername.text.toString())
        }

        if (binding.edtname.text.toString() == "" || binding.edtname.text.toString() != name) {
            databaseReference?.child(currentUser?.uid!!)?.child("Name")
                ?.setValue(binding.edtname.text.toString())
        }

        if (binding.edtemail.text.toString() != name) {
            databaseReference?.child(currentUser?.uid!!)?.child("Email")
                ?.setValue(binding.edtemail.text.toString())
        }

        if (binding.edtaddress.text.toString() == "" || binding.edtaddress.text.toString() != name) {
            databaseReference?.child(currentUser?.uid!!)?.child("Address")
                ?.setValue(binding.edtaddress.text.toString())
        }

        if (binding.edttelephone.text.toString() == "" || binding.edttelephone.text.toString() != name) {
            databaseReference?.child(currentUser?.uid!!)?.child("Telephone")
                ?.setValue(binding.edttelephone.text.toString())
        }

    }
}