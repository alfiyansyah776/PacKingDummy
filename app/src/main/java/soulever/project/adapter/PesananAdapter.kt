package soulever.project.adapter

import android.content.Intent
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
import soulever.project.databinding.ListItemRvPesananv2Binding
import soulever.project.entity.Recommended
import soulever.project.ui.PesananActivity

class PesananAdapter : RecyclerView.Adapter<PesananAdapter.MainViewHolder>() {
    private lateinit var auth: FirebaseAuth
    private var databaseReference: DatabaseReference? = null
    private var database: FirebaseDatabase? = null
    private var n = 0

    fun setRecommendedList(recommendeds: List<Recommended>?) {
        if (recommendeds != null) {
            pesananList = recommendeds.toMutableList()
        }
        notifyDataSetChanged()
    }

    inner class MainViewHolder(private val binding: ListItemRvPesananv2Binding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(recommended: Recommended) {
            auth = FirebaseAuth.getInstance()
            database = FirebaseDatabase.getInstance()
            databaseReference = database?.reference!!.child("Profile")
            val currentUser = auth.currentUser
            val currentUserDb = databaseReference?.child(currentUser?.uid!!)
            val currentOrder = currentUserDb?.child("Order")
            val deleteOrder = currentOrder?.orderByChild("jenis")?.equalTo(recommended.jenis)
            n = getOrderCount()
            with(binding)
            {
                tvBahan.text = recommended.bahan
                tvJenisKemasan.text = recommended.jenis
                hargaDummy.text = "Harga : "
                tvHarga.text = ("Rp. ${recommended.harga}")

                Glide.with(itemView.context)
                    .load(recommended.image)
                    .fitCenter()
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_baseline_loading_24)
                            .error(R.drawable.ic_error)
                    )
                    .into(ivPesanan)

                binding.checkout.setOnClickListener {
                    Toast.makeText(
                        itemView.context,
                        "${recommended.bahan} berhasil di pesan!!",
                        Toast.LENGTH_LONG
                    ).show()
                    Handler(Looper.getMainLooper()).postDelayed({
                        deleteOrder?.addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                for (i in snapshot.children) {
                                    i.ref.removeValue()
                                    currentUserDb.child("OrderCount").setValue(n - 1)
                                }
                            }

                            override fun onCancelled(error: DatabaseError) {
                                TODO("Not yet implemented")
                            }

                        })

                        val intent = Intent(itemView.context, PesananActivity::class.java)
                        intent.putExtra("extra_item", recommended)
                        itemView.context.startActivity(intent)

                    }, 2000)

                }

                /*val arrayAdapter = ArrayAdapter(itemView.context,android.R.layout.simple_spinner_item,DummyData.getAllRumahKemasan())
                 arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)*/
            }
        }
    }

    var pesananList = mutableListOf<Recommended>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemRecommendedBinding =
            ListItemRvPesananv2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(itemRecommendedBinding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val recommended = pesananList[position]
        holder.bind(recommended)
    }

    override fun getItemCount(): Int {
        return pesananList.size
    }

    private fun getOrderCount(): Int {
        val currentUser = auth.currentUser
        val currentUserDb = databaseReference?.child(currentUser?.uid!!)
        currentUserDb?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.hasChild("OrderCount")) {
                    n = snapshot.child("OrderCount").getValue(Int::class.java)!!
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("ERROR", "DATABASE ERROR")
            }
        })


        return n
    }


}