package soulever.project.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import soulever.project.R
import soulever.project.databinding.ListItemRvCollectionBinding
import soulever.project.entity.Recommended
import soulever.project.ui.DetailCollectionActivity
import java.util.ArrayList

class CollectionAdapter : RecyclerView.Adapter<CollectionAdapter.ViewHolder>() {
    private var listCollections = ArrayList<Recommended>()
    fun setCollections(collections: List<Recommended>) {
        if (collections.size > 0) {
            this.listCollections.clear()
        }
        this.listCollections.addAll(collections)
    }
    class ViewHolder (private val binding : ListItemRvCollectionBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(recommendedItem : Recommended)
        {
            with(binding)
            {
                tvNama.text= recommendedItem.Kemasan
                tvBahan.text = recommendedItem.Jenis
                tvDeskripsi.text = recommendedItem.Bahan
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context,DetailCollectionActivity::class.java)
                    intent.putExtra(DetailCollectionActivity.EXTRA_COLLECTION,recommendedItem)
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load(recommendedItem.Image)
                    .fitCenter()
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_baseline_loading_24)
                            .error(R.drawable.ic_error))
                    .into(ivCollection)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemCollectionBinding = ListItemRvCollectionBinding.inflate(LayoutInflater.from(parent.context),parent,false)
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