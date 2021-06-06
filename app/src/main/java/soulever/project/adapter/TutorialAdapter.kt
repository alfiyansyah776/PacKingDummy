package soulever.project.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import soulever.project.R
import soulever.project.databinding.ListItemRvTutorialBinding
import soulever.project.entity.Tutorial
import soulever.project.ui.ArticleActivity
import java.util.*

class TutorialAdapter : RecyclerView.Adapter<TutorialAdapter.ViewHolder>() {

    private var listTutorials = ArrayList<Tutorial>()
    fun setTutorials(tutorials: List<Tutorial>?) {
        if (tutorials == null) return
        this.listTutorials.clear()
        this.listTutorials.addAll(tutorials)
    }

    class ViewHolder(private val binding: ListItemRvTutorialBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tutorial: Tutorial) {
            with(binding)
            {
                tvTutorial.text = tutorial.Title
                itemView.setOnClickListener {
                    Toast.makeText(
                        itemView.context,
                        "${tutorial.Title} Selected",
                        Toast.LENGTH_LONG
                    ).show()
                    val intent = Intent(itemView.context, ArticleActivity::class.java)
                    intent.putExtra(ArticleActivity.ARTICLE_ID, tutorial.id)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(tutorial.Image)
                    .fitCenter()
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_baseline_loading_24)
                            .error(R.drawable.ic_error)
                    )
                    .into(ivTutorial)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemTutorialBinding =
            ListItemRvTutorialBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemTutorialBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tutorial = listTutorials[position]
        holder.bind(tutorial)
    }

    override fun getItemCount(): Int {
        return listTutorials.size
    }

}