package soulever.project.ui.ViewModel

import androidx.lifecycle.ViewModel
import soulever.project.entity.Collections
import soulever.project.entity.Recommended
import soulever.project.entity.TopCollectionData
import soulever.project.utils.DummyData

class CollectionViewModel : ViewModel() {
    fun getCollections() : List<TopCollectionData> = DummyData.generateDummyCollection()
}