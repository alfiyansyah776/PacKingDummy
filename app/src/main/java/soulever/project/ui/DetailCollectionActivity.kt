package soulever.project.ui

import android.content.ContentValues
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import soulever.project.R
import soulever.project.databinding.ActivityDetailCollectionBinding
import soulever.project.db.DatabaseContract
import soulever.project.db.TopCollectionHelper
import soulever.project.entity.Recommended


class DetailCollectionActivity : AppCompatActivity() {
    companion object
    {
        const val EXTRA_COLLECTION = "extra_collection"
    }
    private lateinit var topCollectionHelper : TopCollectionHelper
    private lateinit var binding : ActivityDetailCollectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCollectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        topCollectionHelper = TopCollectionHelper.getInstance(applicationContext)
        topCollectionHelper.open()

        val topCollection : Recommended?= intent.getParcelableExtra("extra_collection")
        if (topCollection != null)
        {
            Glide.with(this)
                .load(topCollection.Image)
                .fitCenter()
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_baseline_loading_24)
                        .error(R.drawable.ic_error)
                )
                .into(binding.imageView)
            binding.tvJenisProduk.text = topCollection.Kemasan
            binding.tvBahan.text = topCollection.Bahan
            binding.tvWarna.text = topCollection.Warna
            binding.tvJenisKemasan.text=topCollection.Jenis
        }



        binding.btnorder.setOnClickListener {
            val values = ContentValues()
            if (topCollection != null) {
                values.put(DatabaseContract.TopCollectionColumns.KEMASAN,topCollection.Kemasan)
                values.put(DatabaseContract.TopCollectionColumns.BAHAN,topCollection.Bahan)
                values.put(DatabaseContract.TopCollectionColumns.IMAGE,topCollection.Image)
                values.put(DatabaseContract.TopCollectionColumns.JENIS,topCollection.Jenis)
                values.put(DatabaseContract.TopCollectionColumns.HARGA,topCollection.Harga)
                values.put(DatabaseContract.TopCollectionColumns.WARNA,topCollection.Warna)
                topCollectionHelper.insert(values)
            }

        }

    }


}