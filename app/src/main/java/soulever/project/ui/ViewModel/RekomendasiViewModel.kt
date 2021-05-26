package soulever.project.ui.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import soulever.project.entity.Recommended
import soulever.project.utils.DummyData

class RekomendasiViewModel : ViewModel() {
    var servicesLiveData: MutableLiveData<List<Recommended>>? = null
    fun getUser() : LiveData<List<Recommended>>? {
        servicesLiveData = DummyData.generateDummyRecommended()
        return servicesLiveData
    }
}