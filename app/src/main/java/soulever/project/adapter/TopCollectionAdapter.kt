package soulever.project.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import soulever.project.R
import soulever.project.databinding.ListItemRvCollectionBinding
import soulever.project.databinding.ListItemRvTutorialBinding
import soulever.project.entity.Recommended
import soulever.project.entity.TopCollectionData
import soulever.project.entity.Tutorial
import soulever.project.ui.DetailCollectionActivity
import soulever.project.ui.adapter.TutorialAdapter
import java.util.ArrayList

class TopCollectionAdapter : RecyclerView.Adapter<TopCollectionAdapter.ViewHolder>() {
    var listCollections = ArrayList<TopCollectionData>()
    fun setCollections(collections: List<TopCollectionData>) {
        if (collections.size > 0) {
            this.listCollections.clear()
        }
        this.listCollections.addAll(collections)
        notifyDataSetChanged()
    }
    class ViewHolder (private val binding : ListItemRvCollectionBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(collection : TopCollectionData)
        {
            with(binding)
            {
                tvNama.text= collection.Kemasan
                tvBahan.text = collection.Bahan
                tvDeskripsi.text = collection.Jenis
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context,DetailCollectionActivity::class.java)
                    intent.putExtra(DetailCollectionActivity.EXTRA_COLLECTION,collection)
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load(collection.Image)
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