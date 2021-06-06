package soulever.project.ui.ViewModel

import androidx.lifecycle.ViewModel
import soulever.project.entity.Recommended
import soulever.project.utils.DummyData

class CollectionViewModel : ViewModel() {
    fun getCollections(): List<Recommended> = DummyData.generateDummyCollection()
}