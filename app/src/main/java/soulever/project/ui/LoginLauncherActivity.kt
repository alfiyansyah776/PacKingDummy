package soulever.project.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import soulever.project.databinding.ActivityLoginLauncherBinding

class LoginLauncherActivity : AppCompatActivity(){
    private lateinit var LoginLauncherBinding : ActivityLoginLauncherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoginLauncherBinding = ActivityLoginLauncherBinding.inflate(layoutInflater)
        setContentView(LoginLauncherBinding.root)

        LoginLauncherBinding.login.setOnClickListener {
            val intent = Intent(this@LoginLauncherActivity, LoginActivity::class.java )
            startActivity(intent)
        }

        LoginLauncherBinding.register.setOnClickListener {
            val intent = Intent(this@LoginLauncherActivity, RegisterActivity::class.java )
            startActivity(intent)
        }
    }
}