package soulever.project.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import soulever.project.R
import soulever.project.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var activityRegisterBinding : ActivityRegisterBinding
    private lateinit var auth : FirebaseAuth
    var databaseReference : DatabaseReference? = null
    var database : FirebaseDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityRegisterBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(activityRegisterBinding.root)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("Profile")

        register()

        activityRegisterBinding.ayologin.setOnClickListener {
            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
            finish()
            startActivity(intent)
        }



    }

    private fun register(){
        activityRegisterBinding.LoginButton.setOnClickListener {
            if (TextUtils.isEmpty(activityRegisterBinding.username.text.toString())){
                activityRegisterBinding.username.setError("Please Enter Username")
                return@setOnClickListener
            } else if (TextUtils.isEmpty(activityRegisterBinding.email.text.toString())){
                activityRegisterBinding.email.setError("Please Enter your Email")
                return@setOnClickListener
            } else if (TextUtils.isEmpty(activityRegisterBinding.Password.text.toString())){
                activityRegisterBinding.Password.setError("Please Enter Your Password")
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(activityRegisterBinding.email.text.toString(), activityRegisterBinding.Password.text.toString())
                .addOnCompleteListener{
                    if (it.isSuccessful){
                        val currentUser = auth.currentUser
                        val currentUserdb = databaseReference?.child((currentUser?.uid!!))
                        currentUserdb?.child("Username")?.setValue(activityRegisterBinding.username.text.toString())

                        Toast.makeText(this@RegisterActivity, "Registration Success", Toast.LENGTH_LONG).show()
                        finish()
                    }else {
                        Toast.makeText(this@RegisterActivity, "Registration Failed, please try again!", Toast.LENGTH_LONG).show()
                    }
                }

        }
    }
}