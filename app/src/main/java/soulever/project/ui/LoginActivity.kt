package soulever.project.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import soulever.project.R
import soulever.project.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var loginActivityBinding : ActivityLoginBinding
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginActivityBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginActivityBinding.root)

        auth = FirebaseAuth.getInstance()

        loginActivityBinding.LoginButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

//        Login()

        loginActivityBinding.register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun Login(){
        loginActivityBinding.LoginButton.setOnClickListener {
            if (TextUtils.isEmpty(loginActivityBinding.Email.text.toString())){
                loginActivityBinding.Email.setError("Please enter your email")
                return@setOnClickListener
            } else if (TextUtils.isEmpty(loginActivityBinding.Password.text.toString())){
                loginActivityBinding.Password.setError("Please enter your password")
                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(loginActivityBinding.Email.text.toString(), loginActivityBinding.Password.text.toString())
                .addOnCompleteListener {
                    if(it.isSuccessful){
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this@LoginActivity, "Login Failed, please try again!", Toast.LENGTH_LONG).show()

                    }
                }
        }
    }
}