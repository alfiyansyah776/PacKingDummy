package soulever.project.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import soulever.project.R
import soulever.project.databinding.ListItemRvPesananBinding
import soulever.project.entity.Recommended
import soulever.project.utils.DummyData

class PesananAdapter : RecyclerView.Adapter<PesananAdapter.MainViewHolder>() {
    fun setRecommendedList(recommendeds: List<Recommended>?)
    {
        if (recommendeds != null) {
            pesananList = recommendeds.toMutableList()
        }
        notifyDataSetChanged()
    }
    class MainViewHolder (private val binding : ListItemRvPesananBinding) : RecyclerView.ViewHolder(binding.root) {
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
                    .into(ivPesanan)

                val arrayAdapter = ArrayAdapter(itemView.context,android.R.layout.simple_spinner_item,DummyData.getAllRumahKemasan())
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerRumahKemasan.adapter = arrayAdapter
                Toast.makeText(itemView.context,spinnerRumahKemasan.onItemSelectedListener.toString(),Toast.LENGTH_LONG).show()
            }
        }
    }

    var pesananList = mutableListOf<Recommended>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemRecommendedBinding = ListItemRvPesananBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MainViewHolder(itemRecommendedBinding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val recommended = pesananList[position]
        holder.bind(recommended)
    }

    override fun getItemCount(): Int {
        return pesananList.size
    }


}