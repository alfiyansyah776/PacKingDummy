package soulever.project.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import soulever.project.R
import soulever.project.entity.Tutorial

object DummyData {
    fun generateDummyTutorial() : List<Tutorial> {
        val tutorials = ArrayList<Tutorial>()
        val tutorialResult = MutableLiveData<List<Tutorial>>()

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
}