package soulever.project.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import soulever.project.R
import soulever.project.databinding.ListItemRvRumahKemasanBinding
import soulever.project.entity.RumahKemasan
import soulever.project.ui.ActivityDetailRumahKemasan

class RumahKemasanAdapter : RecyclerView.Adapter<RumahKemasanAdapter.RumahKemasanViewHolder>() {
    private val listRumahKemasan = ArrayList<RumahKemasan>()
    fun setRumahKemasan(rumahKemasan: List<RumahKemasan>?) {
        if (rumahKemasan == null) return
        this.listRumahKemasan.clear()
        this.listRumahKemasan.addAll(rumahKemasan)
    }

    class RumahKemasanViewHolder(private val binding: ListItemRvRumahKemasanBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(rumahkemasan: RumahKemasan) {
            with(binding)
            {
                namaRumahKemasan.text = rumahkemasan.Nama
                alamatRumahKemasan.text = rumahkemasan.Alamat
                Glide.with(itemView.context)
                    .load(rumahkemasan.Image)
                    .fitCenter()
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_baseline_loading_24)
                            .error(R.drawable.ic_error)
                    )
                    .into(ivLogoRumahKemasan)
            }

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, ActivityDetailRumahKemasan::class.java)
                intent.putExtra("extra_item", rumahkemasan)
                itemView.context.startActivity(intent)

            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RumahKemasanViewHolder {
        val listRumahKemasanBinding = ListItemRvRumahKemasanBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RumahKemasanViewHolder(listRumahKemasanBinding)
    }

    override fun onBindViewHolder(holder: RumahKemasanViewHolder, position: Int) {
        val rumahKemasan = listRumahKemasan[position]
        holder.bind(rumahKemasan)
    }

    override fun getItemCount(): Int {
        return listRumahKemasan.size
    }


}