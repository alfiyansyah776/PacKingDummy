package soulever.project.adapter

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import soulever.project.R
import soulever.project.databinding.ListItemRvRecommendedBinding
import soulever.project.entity.Recommended


class RecommendedAdapter : RecyclerView.Adapter<RecommendedAdapter.MainViewHolder>() {
    private var pos: Int = 0
    private lateinit var auth: FirebaseAuth
    private var databaseReference: DatabaseReference? = null
    private var database: FirebaseDatabase? = null
    private var n = 0
    fun setRecommendedList(recommendeds: List<Recommended>) {
        recommendedsList = recommendeds.toMutableList()
        notifyDataSetChanged()
    }

    inner class MainViewHolder(private val binding: ListItemRvRecommendedBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(recommended: Recommended) {
            auth = FirebaseAuth.getInstance()
            database = FirebaseDatabase.getInstance()
            databaseReference = database?.reference!!.child("Profile")

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

                binding.btnorder.setOnClickListener {
                    n = getOrderCount()
                    pos = adapterPosition
                    Handler(Looper.getMainLooper()).postDelayed({
                        orderData(n, pos)
                    }, 3000)
                    Toast.makeText(
                        itemView.context,
                        "${recommended.bahan} berhasil di pesan",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    var recommendedsList = mutableListOf<Recommended>()
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

    private fun getOrderCount(): Int {
        val currentUser = auth.currentUser
        val currentUserDb = databaseReference?.child(currentUser?.uid!!)
        currentUserDb?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.hasChild("OrderCount")) {
                    n = snapshot.child("OrderCount").getValue(Int::class.java)!! + 1
                } else {
                    n = 1
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("ERROR", "DATABASE ERROR")
            }
        })
        return n
    }

    private fun orderData(n: Int, position: Int) {
        val currentUser = auth.currentUser
        val currentUserDb = databaseReference?.child(currentUser?.uid!!)
        pos = position
        val orderScales = currentUserDb?.child("Order")
        val collectionScales = currentUserDb?.child("Collection")
        currentUserDb?.child("OrderCount")?.setValue(n)
        orderScales?.child("Order $n")?.setValue(recommendedsList[pos])
        collectionScales?.child("Collection $n")?.setValue(recommendedsList[pos])
    }

}