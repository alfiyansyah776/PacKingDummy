package soulever.project.ui.ViewModel

import androidx.lifecycle.ViewModel
import soulever.project.entity.RumahKemasan
import soulever.project.utils.DummyData

class RumahKemasanViewModel : ViewModel() {
    fun getRumahKemasan(): List<RumahKemasan> = DummyData.generateDummyRumahKemasan()
}