package soulever.project.ui.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import soulever.project.entity.Recommended

class PesananViewModel : ViewModel() {
    private lateinit var auth: FirebaseAuth
    private var databaseReference: DatabaseReference? = null
    private var database: FirebaseDatabase? = null
    var n: Int? = null
    private var orderResult: MutableLiveData<List<Recommended>> =
        MutableLiveData<List<Recommended>>()


    fun getPesanan(): LiveData<List<Recommended>> {
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("Profile")

        val currentUser = auth.currentUser
        val currentUserDb = databaseReference?.child(currentUser?.uid!!)
        val order = currentUserDb?.child("Order")
        order?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val orderList = ArrayList<Recommended>()
                for (i in snapshot.children) {
                    /*val Kemasan = snapshot.child("kemasan").getValue(String::class.java)
                    val Jenis = snapshot.child("jenis").getValue(String::class.java)
                    val Bahan = snapshot.child("bahan").getValue(String::class.java)
                    val Warna = snapshot.child("warna").getValue(String::class.java)
                    val Harga = snapshot.child("harga").getValue(String::class.java)
                    val Image = snapshot.child("image").getValue(String::class.java)*/
                    val recommended = i.getValue(Recommended::class.java)
                    orderList.add(recommended!!)
                }
                orderResult.postValue(orderList)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

        return orderResult

    }
}