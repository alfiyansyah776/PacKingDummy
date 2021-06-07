package soulever.project.ui.ViewModel

import androidx.lifecycle.ViewModel
import soulever.project.entity.Tutorial
import soulever.project.utils.DummyData

class TutorialViewModel : ViewModel() {
    fun getTutorials(): List<Tutorial> = DummyData.generateDummyTutorial()
}