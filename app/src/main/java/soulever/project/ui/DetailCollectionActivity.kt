package soulever.project.ui

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import soulever.project.R
import soulever.project.databinding.ActivityDetailCollectionBinding
import soulever.project.db.DatabaseContract
import soulever.project.db.TopCollectionHelper
import soulever.project.entity.Recommended


class DetailCollectionActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TOP_COLLECTION = "extra_top_collection"
    }

    private lateinit var topCollectionHelper: TopCollectionHelper
    private lateinit var binding: ActivityDetailCollectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCollectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.getSupportActionBar()?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar()?.setCustomView(R.layout.action_bar);
        topCollectionHelper = TopCollectionHelper.getInstance(applicationContext)
        topCollectionHelper.open()

        val topCollection: Recommended? = intent.getParcelableExtra(EXTRA_TOP_COLLECTION)
        if (topCollection != null) {
            Glide.with(this)
                .load(topCollection.image)
                .fitCenter()
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_baseline_loading_24)
                        .error(R.drawable.ic_error)
                )
                .into(binding.imageView)
            binding.tvJenisProduk.text = topCollection.jenis
            binding.tvBahan.text = topCollection.bahan
            binding.tvWarna.text = topCollection.warna
            binding.tvJenisKemasan.text = topCollection.kemasan
            binding.tvHarga.text = topCollection.harga
        }



        binding.btnorder.setOnClickListener {
            val values = ContentValues()
            if (topCollection != null) {
                if (topCollection.kemasan != null) {
                    values.put(DatabaseContract.TopCollectionColumns.KEMASAN, topCollection.kemasan)
                } else {
                    values.put(DatabaseContract.TopCollectionColumns.KEMASAN, "")
                }
                if (topCollection.jenis != null) {
                    values.put(DatabaseContract.TopCollectionColumns.JENIS, topCollection.jenis)
                } else {
                    values.put(DatabaseContract.TopCollectionColumns.JENIS, "")
                }
                if (topCollection.bahan != null) {

                    values.put(DatabaseContract.TopCollectionColumns.BAHAN, topCollection.bahan)
                } else {
                    values.put(DatabaseContract.TopCollectionColumns.BAHAN, "")
                }

                if (topCollection.warna != null) {
                    values.put(DatabaseContract.TopCollectionColumns.WARNA, topCollection.warna)
                } else {
                    values.put(DatabaseContract.TopCollectionColumns.WARNA, "")
                }
                if (topCollection.harga != null) {
                    values.put(DatabaseContract.TopCollectionColumns.HARGA, topCollection.harga)
                } else {
                    values.put(DatabaseContract.TopCollectionColumns.HARGA, "")
                }
                if (topCollection.image != null) {
                    values.put(DatabaseContract.TopCollectionColumns.IMAGE, topCollection.image)
                } else {
                    values.put(DatabaseContract.TopCollectionColumns.IMAGE, "")
                }


                Toast.makeText(
                    this,
                    "${topCollection.kemasan} Berhasil dimasukkan ke Top Collection",
                    Toast.LENGTH_SHORT
                ).show()
                Log.d("isidb", values.toString())
                topCollectionHelper.insert(values)
            }

        }

    }


}