package soulever.project.utils

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import soulever.project.R
import soulever.project.entity.Recommended
import soulever.project.entity.RumahKemasan
import soulever.project.entity.Tutorial


object DummyData {
    fun generateDummyTutorial(): List<Tutorial> {
        val tutorials = ArrayList<Tutorial>()
        tutorials.add(
            Tutorial(1, "Pengenalan Merek menurut DJKI", R.drawable.photo2)
        )
        tutorials.add(
            Tutorial(2, "Kemasan Berkelanjutan Bagi IKM", R.drawable.photo1)
        )

        tutorials.add(
            Tutorial(3, "Teknologi Percetakan Zaman Sekarang", R.drawable.photo3)
        )

        return tutorials

    }

    fun generateDummyCollection(): List<Recommended> {
        val recommendeds = ArrayList<Recommended>()

        recommendeds.add(
            Recommended(
                "Pempek",
                "Cup",
                "Kertas",
                "Putih",
                "800",
                "https://storage.googleapis.com/packing-bucket/rekomendasi-pempek/1.jpeg"
            )
        )
        recommendeds.add(
            Recommended(
                "Pempek",
                "Box Fail Food",
                "Kertas dan Mika",
                "Coklat",
                "1000",
                "https://storage.googleapis.com/packing-bucket/rekomendasi-pempek/2.jpeg"
            )
        )
        recommendeds.add(
            Recommended(
                "Pempek",
                "Besek Anyaman",
                "Anyaman Bambu",
                "Coklat",
                "2000",
                "https://storage.googleapis.com/packing-bucket/rekomendasi-pempek/5.jpeg"
            )
        )

        return recommendeds
    }

    fun generateDummyRecommended(idRekomendasi: String): MutableLiveData<List<Recommended>> {
        val serviceSetterGetter = MutableLiveData<List<Recommended>>()
        val postServices = DataRepository.create()
        postServices.getPosts(idRekomendasi).enqueue(object : Callback<List<Recommended>> {
            override fun onResponse(
                call: Call<List<Recommended>>,
                response: Response<List<Recommended>>
            ) {
                val data = response.body()
                serviceSetterGetter.value = data!!
                Log.d("isiygditambah", serviceSetterGetter.toString())
            }

            override fun onFailure(call: Call<List<Recommended>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        }
        )

        return serviceSetterGetter
    }

    fun generateDummyRumahKemasan(): List<RumahKemasan> {
        val daftarrumahkemasan = ArrayList<RumahKemasan>()

        daftarrumahkemasan.add(
            RumahKemasan(
                "https://e-klinikdesainmerekemas.kemenperin.go.id/storage/uploads/images/uptd-rumah-kemasan-aceh_1619766954.jpg",
                "UPTD Rumah Kemasan Aceh",
                "Jl. Pocut Baren No. 11 Banda Aceh, Aceh",
                "0812-6914-216",
                "2018",
                "UPTD",
                "Pergub no 34 Tahun 2018"
            )
        )
        daftarrumahkemasan.add(
            RumahKemasan(
                "https://e-klinikdesainmerekemas.kemenperin.go.id/storage/uploads/images/pondok-desain-dan-promosi-kota-padang-panjang_1619761220.jpg",
                "Pondok Desain dan Promosi Kota Padang Panjang",
                "Jl. Kamarullah Bukit Surungan, Padang Panjang",
                "0813-6309-2660",
                "2016",
                "UPT",
                "-"
            )
        )
        daftarrumahkemasan.add(
            RumahKemasan(
                "https://e-klinikdesainmerekemas.kemenperin.go.id/storage/uploads/images/rumah-kemasan-kabupaten-tanah-datar_1619761950.jpg",
                "Rumah Kemasan Kabupaten Tanah Datar",
                "Jl. Datuah Bandaro Kuniang No. 43B, Kuburajo Lima Kaum, Kabupaten Tanah Datar",
                "0822-8503-0187",
                "2019",
                "BUMD",
                "-"
            )
        )
        daftarrumahkemasan.add(
            RumahKemasan(
                "https://e-klinikdesainmerekemas.kemenperin.go.id/storage/uploads/images/uptd-kemasan-kota-jambi_1619766783.jpg",
                "UPTD Kemasan Kota Jambi",
                "Terminal Angkutan Bongkar Muat, Jl. Lingkar Barat Paal X, Kota Baru, Kota Jambi",
                "0852-6649-7879",
                "2013",
                "Satker",
                "-"
            )
        )
        daftarrumahkemasan.add(
            RumahKemasan(
                "https://e-klinikdesainmerekemas.kemenperin.go.id/storage/uploads/images/upt-textile-dan-kemasan-provinsi-sumatera-selatan_1619766405.jpg",
                "UPT Textile dan Kemasan Provinsi Sumatera Selatan",
                "Komplek Dekranasda Jakabaring Jl. Gubernur H. Bastari Jakabaring, Palembang",
                "0878-9764-2334",
                "2014",
                "UPTD",
                "Pergub Sumsel no. 45 tahun 2014 yang diperbarui dengan Pergub no. 10 tahun 2018 tentang pembentukan UPTD Industri Pangan dan Tekstil"
            )
        )
        daftarrumahkemasan.add(
            RumahKemasan(
                "https://e-klinikdesainmerekemas.kemenperin.go.id/storage/uploads/images/rumah-kemasan-kabupaten-banjar_1619761904.jpg",
                "Rumah Kemasan Kabupaten Banjar",
                "Dinas Perindustrian dan Perdagangan Kabupaten Banjar, Jl. Perwira No.44G, Martapura, Kabupaten Banjar",
                "0852-5199-7755",
                "2016",
                "UPT",
                "SK Bupati Banjar No. 583 tahun 2016"
            )
        )
        daftarrumahkemasan.add(
            RumahKemasan(
                "https://e-klinikdesainmerekemas.kemenperin.go.id/storage/uploads/images/uptd-pelatihan-dan-koperasi-ukm_1619766888.jpg",
                "UPTD Pelatihan dan Koperasi UKM",
                "Jl. D.I. Panjaitan No. 3 Samarinda, Kalimantan Timur",
                "0822-5027-0044",
                "2019",
                "UPTD",
                "Pergub No. 26 tahun 2019"
            )
        )

        return daftarrumahkemasan
    }

    fun getDummyRumahKemasanTerdekat(): List<RumahKemasan> {
        val daftarRumahKemasanTerdekat = ArrayList<RumahKemasan>()
        daftarRumahKemasanTerdekat.add(
            RumahKemasan(
                "https://e-klinikdesainmerekemas.kemenperin.go.id/storage/uploads/images/uptd-pengembangan-teknologi-dan-standardisasi-industri-provinsi-banten_1619766929.jpg",
                "UPTD Pengembangan Teknologi dan Standardisasi Industri Provinsi Banten",
                "Jl. Ciwaru Raya No. 57, Serang, Banten",
                "0819-1120-0374",
                "2018",
                "UPT",
                "Pergub Nomor 3 Tahun 2008 tentang Pembentukan Organisasi dan Tata Kerja Unit Pelaksana Teknis Daerah Provinsi Banten",
            )
        )
        daftarRumahKemasanTerdekat.add(
            RumahKemasan(
                "https://e-klinikdesainmerekemas.kemenperin.go.id/storage/uploads/images/upt-industri-makanan-dan-minuman-provinsi-jawa-timur_1619762145.jpg",
                "UPT Industri Makanan dan Minuman Provinsi Jawa Timur",
                "Jl. Raya Trosobo Km. 20, Taman Sidoarjo, Jawa Timur",
                "0896-7586-4061",
                "2007",
                "UPT",
                "Pergub no 133 Tahun 2008"
            )
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

    fun getAllRumahKemasan(): List<RumahKemasan> {
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