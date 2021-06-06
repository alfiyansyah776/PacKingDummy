package soulever.project.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import soulever.project.R
import soulever.project.databinding.ListItemRvRecommendedBinding
import soulever.project.entity.Recommended

class DummyRecommendedAdapter : RecyclerView.Adapter<DummyRecommendedAdapter.MainViewHolder>() {
    fun setRecommendedList(recommendeds: List<Recommended>) {
        recommendedsList = recommendeds.toMutableList()
        notifyDataSetChanged()
    }

    inner class MainViewHolder(private val binding: ListItemRvRecommendedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recommended: Recommended) {
            with(binding)
            {
                tvJenisProduk.text = recommended.jenis
                tvBahan.text = recommended.bahan
                tvJenisKemasan.text = recommended.kemasan
                tvWarna.text = recommended.warna
                tvHarga.text = recommended.harga

                Glide.with(itemView.context)
                    .load(recommended.image)
                    .fitCenter()
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_baseline_loading_24)
                            .error(R.drawable.ic_error)
                    )
                    .into(imageView)

            }
            itemView.setOnClickListener {

            }
        }
    }

    private var recommendedsList = mutableListOf<Recommended>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemRecommendedBinding =
            ListItemRvRecommendedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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