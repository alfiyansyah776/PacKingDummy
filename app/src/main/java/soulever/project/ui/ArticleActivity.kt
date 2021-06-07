package soulever.project.ui

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import soulever.project.R
import soulever.project.databinding.ActivityArticleBinding

class ArticleActivity : AppCompatActivity() {
    private var id = 0
    private lateinit var binding: ActivityArticleBinding

    companion object {
        const val ARTICLE_ID = "id"
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.getSupportActionBar()?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar()?.setCustomView(R.layout.action_bar);
        val extras = intent.extras
        if (extras != null) {
            id = extras.getInt(ARTICLE_ID, 0)
        }

        webPopulate(id)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScripEnabled")
    private fun webPopulate(idArcticle: Int) {
        binding.webView.webViewClient = WebViewClient()

        if (idArcticle == 1) {
            binding.webView.apply {
                loadUrl("https://e-klinikdesainmerekemas.kemenperin.go.id/web/article_detail/aeqVJqGR/kemasan-berkelanjutan-bagi-ikm")
                settings.javaScriptEnabled = true
                settings.safeBrowsingEnabled = true
            }
        } else if (idArcticle == 2) {
            binding.webView.apply {
                loadUrl("https://e-klinikdesainmerekemas.kemenperin.go.id/web/article_detail/3nqdjW2Z/pengenalan-merek-menurut-djki")
                settings.javaScriptEnabled = true
                settings.safeBrowsingEnabled = true
            }
        } else if (idArcticle == 3) {
            binding.webView.apply {
                loadUrl("https://e-klinikdesainmerekemas.kemenperin.go.id/web/article_detail/yMWXPWGQ/teknologi-percetakan-zaman-sekarang")
                settings.javaScriptEnabled = true
                settings.safeBrowsingEnabled = true
            }
        }

    }
}