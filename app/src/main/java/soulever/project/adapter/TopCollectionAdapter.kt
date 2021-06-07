package soulever.project.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import soulever.project.R
import soulever.project.databinding.ListItemRvCollectionBinding
import soulever.project.entity.Recommended
import java.util.*

class TopCollectionAdapter : RecyclerView.Adapter<TopCollectionAdapter.ViewHolder>() {
    var listCollections = ArrayList<Recommended>()
    fun setCollections(collections: List<Recommended>) {
        if (collections.size > 0) {
            this.listCollections.clear()
        }
        this.listCollections.addAll(collections)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ListItemRvCollectionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(collection: Recommended) {
            with(binding)
            {
                tvNama.text = collection.kemasan
                tvBahan.text = collection.jenis
                tvDeskripsi.text = collection.bahan
/*                itemView.setOnClickListener {
                    val intent = Intent(itemView.context,DetailCollectionActivity::class.java)
                    intent.putExtra(DetailCollectionActivity.EXTRA_TOP_COLLECTION,collection)
                    itemView.context.startActivity(intent)
                }*/

                Glide.with(itemView.context)
                    .load(collection.image)
                    .fitCenter()
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_baseline_loading_24)
                            .error(R.drawable.ic_error)
                    )
                    .into(ivCollection)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemCollectionBinding =
            ListItemRvCollectionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemCollectionBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val collection = listCollections[position]
        holder.bind(collection)
    }

    override fun getItemCount(): Int {
        return listCollections.size
    }


}