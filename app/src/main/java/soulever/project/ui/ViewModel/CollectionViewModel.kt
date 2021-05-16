package soulever.project.ui.ViewModel

import androidx.lifecycle.ViewModel
import soulever.project.entity.Collections
import soulever.project.utils.DummyData

class CollectionViewModel : ViewModel() {
    fun getCollections() : List<Collections> = DummyData.generateDummyCollection()
}