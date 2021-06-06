package soulever.project.ui.ViewModel

import androidx.lifecycle.ViewModel
import soulever.project.entity.RumahKemasan
import soulever.project.utils.DummyData

class RumahKemasanTerdekatViewModel : ViewModel() {
    fun getRumahKemasanTerdekat(): List<RumahKemasan> = DummyData.getDummyRumahKemasanTerdekat()
}