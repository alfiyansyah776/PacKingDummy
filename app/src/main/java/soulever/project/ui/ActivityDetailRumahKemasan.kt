package soulever.project.ui

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import soulever.project.R
import soulever.project.databinding.ActivityDetailRumahKemasanBinding
import soulever.project.entity.RumahKemasan

class ActivityDetailRumahKemasan : AppCompatActivity() {
    private lateinit var binding: ActivityDetailRumahKemasanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRumahKemasanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.getSupportActionBar()?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar()?.setCustomView(R.layout.action_bar);

        val rumahKemasan: RumahKemasan? = intent.getParcelableExtra<RumahKemasan>("extra_item")
        if (rumahKemasan != null) {
            Glide.with(this)
                .load(rumahKemasan.Image)
                .fitCenter()
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_baseline_loading_24)
                        .error(R.drawable.ic_error)
                )
                .into(binding.ivLogoRumahKemasan)

            binding.tvNamaRumahKemasan.text = rumahKemasan.Nama
            binding.tvAlamat.text = rumahKemasan.Alamat
            binding.tvTahunBerdiri.text = rumahKemasan.Tahun
            binding.tvKelembagaan.text = rumahKemasan.Kelembagaan
            binding.tvNomorKontakPerson.text = rumahKemasan.Kontak
            binding.tvDasarHukum.text = rumahKemasan.DasarHukum
        }
    }
}