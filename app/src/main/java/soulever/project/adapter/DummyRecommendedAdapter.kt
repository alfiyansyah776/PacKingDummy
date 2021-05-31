package soulever.project.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import soulever.project.R
import soulever.project.databinding.ListItemRvRecommendedBinding
import soulever.project.entity.Recommended
import soulever.project.ui.PesananActivity
import soulever.project.utils.DummyData

class DummyRecommendedAdapter : RecyclerView.Adapter<DummyRecommendedAdapter.MainViewHolder>() {
    fun setRecommendedList(recommendeds : List<Recommended>)
    {
        recommendedsList = recommendeds.toMutableList()
        notifyDataSetChanged()
    }
    inner class MainViewHolder (private val binding : ListItemRvRecommendedBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(recommended: Recommended)
        {
            with(binding)
            {
                tvJenisProduk.text = recommended.Jenis
                tvBahan.text = recommended.Bahan
                tvJenisKemasan.text = recommended.Kemasan
                tvWarna.text = recommended.Warna
                tvHarga.text = recommended.Harga

                Glide.with(itemView.context)
                    .load(recommended.Image)
                    .fitCenter()
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_baseline_loading_24)
                            .error(R.drawable.ic_error))
                    .into(imageView)

            }
            itemView.setOnClickListener {

            }
        }
    }

    private var recommendedsList = mutableListOf<Recommended>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemRecommendedBinding = ListItemRvRecommendedBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainViewHolder(itemRecommendedBinding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val recommended = recommendedsList[position]
        holder.bind(recommended)
    }

    override fun getItemCount(): Int {
        return recommendedsList.size
    }


}