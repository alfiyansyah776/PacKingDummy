package soulever.project.utils

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import soulever.project.R
import soulever.project.entity.Collections
import soulever.project.entity.Recommended
import soulever.project.entity.RumahKemasan
import soulever.project.entity.Tutorial


object DummyData {
    fun generateDummyTutorial() : List<Tutorial> {
        val tutorials = ArrayList<Tutorial>()

        tutorials.add(
            Tutorial("Cara masang solatip", R.drawable.image_artikel_1)
        )
        tutorials.add(
            Tutorial("Cara make gunting", R.drawable.image_artikel_1)
        )
        tutorials.add(
            Tutorial("Cara ngelipet kardus", R.drawable.image_artikel_1)
        )

        return tutorials

    }

    fun generateDummyCollection() : List<Collections>{
        val collections = ArrayList<Collections>()

        collections.add(
            Collections(
                "Ini Nama",
                "Kardus",
                "Pertama-tama pasang sabuk",
                R.drawable.contoh_collection
            )
        )
        collections.add(
            Collections(
                "Ini Nama",
                "Kardus",
                "Pertama-tama pasang sabuk",
                R.drawable.contoh_collection
            )
        )
        collections.add(
            Collections(
                "Ini Nama",
                "Kardus",
                "Pertama-tama pasang sabuk",
                R.drawable.contoh_collection
            )
        )
        return collections
    }

    fun generateDummyRecommended() : MutableLiveData<List<Recommended>>
    {
        val serviceSetterGetter = MutableLiveData<List<Recommended>>()
        val postServices = DataRepository.create()
        postServices.getPosts().enqueue(object : Callback<List<Recommended>> {
            override fun onResponse(
                call: Call<List<Recommended>>,
                response: Response<List<Recommended>>
            ) {
                val data = response.body()
                serviceSetterGetter.value = data!!
            }

            override fun onFailure(call: Call<List<Recommended>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        }
        )

        return serviceSetterGetter
    }

    fun generateDummyRumahKemasan() : List<RumahKemasan>
    {
        val daftarrumahkemasan = ArrayList<RumahKemasan>()

        daftarrumahkemasan.add(
            RumahKemasan("https://e-klinikdesainmerekemas.kemenperin.go.id/storage/uploads/images/uptd-rumah-kemasan-aceh_1619766954.jpg","UPTD Rumah Kemasan Aceh","Jl. Pocut Baren No. 11 Banda Aceh, Aceh","0812-6914-216","2018","UPTD","Pergub no 34 Tahun 2018")
        )
        daftarrumahkemasan.add(
            RumahKemasan("https://e-klinikdesainmerekemas.kemenperin.go.id/storage/uploads/images/uptd-rumah-kemasan-aceh_1619766954.jpg","UPTD Rumah Kemasan Aceh","Jl. Pocut Baren No. 11 Banda Aceh, Aceh","0812-6914-216","2018","UPTD","Pergub no 34 Tahun 2018")
        )
        daftarrumahkemasan.add(
            RumahKemasan("https://e-klinikdesainmerekemas.kemenperin.go.id/storage/uploads/images/uptd-rumah-kemasan-aceh_1619766954.jpg","UPTD Rumah Kemasan Aceh","Jl. Pocut Baren No. 11 Banda Aceh, Aceh","0812-6914-216","2018","UPTD","Pergub no 34 Tahun 2018")
        )
        daftarrumahkemasan.add(
            RumahKemasan("https://e-klinikdesainmerekemas.kemenperin.go.id/storage/uploads/images/uptd-rumah-kemasan-aceh_1619766954.jpg","UPTD Rumah Kemasan Aceh","Jl. Pocut Baren No. 11 Banda Aceh, Aceh","0812-6914-216","2018","UPTD","Pergub no 34 Tahun 2018")
        )
        daftarrumahkemasan.add(
            RumahKemasan("https://e-klinikdesainmerekemas.kemenperin.go.id/storage/uploads/images/uptd-rumah-kemasan-aceh_1619766954.jpg","UPTD Rumah Kemasan Aceh","Jl. Pocut Baren No. 11 Banda Aceh, Aceh","0812-6914-216","2018","UPTD","Pergub no 34 Tahun 2018")
        )
        daftarrumahkemasan.add(
            RumahKemasan("https://e-klinikdesainmerekemas.kemenperin.go.id/storage/uploads/images/uptd-rumah-kemasan-aceh_1619766954.jpg","UPTD Rumah Kemasan Aceh","Jl. Pocut Baren No. 11 Banda Aceh, Aceh","0812-6914-216","2018","UPTD","Pergub no 34 Tahun 2018")
        )
        daftarrumahkemasan.add(
            RumahKemasan("https://e-klinikdesainmerekemas.kemenperin.go.id/storage/uploads/images/uptd-rumah-kemasan-aceh_1619766954.jpg","UPTD Rumah Kemasan Aceh","Jl. Pocut Baren No. 11 Banda Aceh, Aceh","0812-6914-216","2018","UPTD","Pergub no 34 Tahun 2018")
        )
        daftarrumahkemasan.add(
            RumahKemasan("https://e-klinikdesainmerekemas.kemenperin.go.id/storage/uploads/images/uptd-rumah-kemasan-aceh_1619766954.jpg","UPTD Rumah Kemasan Aceh","Jl. Pocut Baren No. 11 Banda Aceh, Aceh","0812-6914-216","2018","UPTD","Pergub no 34 Tahun 2018")
        )


        return daftarrumahkemasan
    }

    fun getDummyRumahKemasanTerdekat () : List<RumahKemasan>
    {
        val daftarRumahKemasanTerdekat = ArrayList<RumahKemasan>()
        daftarRumahKemasanTerdekat.add(
            RumahKemasan("https://e-klinikdesainmerekemas.kemenperin.go.id/storage/uploads/images/uptd-pengembangan-teknologi-dan-standardisasi-industri-provinsi-banten_1619766929.jpg",
            "UPTD Pengembangan Teknologi dan Standardisasi Industri Provinsi Banten",
            "Jl. Ciwaru Raya No. 57, Serang, Banten",
            "0819-1120-0374",
            "2018",
            "UPT",
            "Pergub Nomor 3 Tahun 2008 tentang Pembentukan Organisasi dan Tata Kerja Unit Pelaksana Teknis Daerah Provinsi Banten",
            )
        )
        daftarRumahKemasanTerdekat.add(
            RumahKemasan("https://e-klinikdesainmerekemas.kemenperin.go.id/storage/uploads/images/upt-industri-makanan-dan-minuman-provinsi-jawa-timur_1619762145.jpg",
            "UPT Industri Makanan dan Minuman Provinsi Jawa Timur",
            "Jl. Raya Trosobo Km. 20, Taman Sidoarjo, Jawa Timur",
            "0896-7586-4061",
            "2007",
            "UPT",
            "Pergub no 133 Tahun 2008")
        )
        daftarRumahKemasanTerdekat.add(
            RumahKemasan(
                "https://e-klinikdesainmerekemas.kemenperin.go.id/storage/uploads/images/balai-teknologi-cepat-guna-provinsi-yogyakarta_1619761089.jpg",
                "Balai Teknologi Cepat Guna Provinsi Yogyakarta",
                "Jl. Kusumanegara No.168, Muja Muju, Kec. Umbulharjo, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55165",
                "0812-2760-097",
                "2018",
                "Balai (BPPTG)",
                "Pergub DIY no.49 tahun 2008 tentang tugas dan fungsi Dinas dan UPT Perindustrian dan Perdagangan DIY"
            )
        )

        return daftarRumahKemasanTerdekat
    }

    fun getAllRumahKemasan() : List<RumahKemasan>
    {
        val rumahKemasanTerdekat = DummyData.getDummyRumahKemasanTerdekat()
        val rumahKemasanAll = DummyData.generateDummyRumahKemasan()
        val seluruhRumahKemasan = rumahKemasanTerdekat + rumahKemasanAll

/*        val namaSeluruhRumahKemasan = ArrayList<String>()

        for(i in 0..seluruhRumahKemasan.size - 1)
        {
            namaSeluruhRumahKemasan.add(seluruhRumahKemasan[i].Nama)
        }

        Log.d("TAG", namaSeluruhRumahKemasan.toString())*/

        return seluruhRumahKemasan
    }

}