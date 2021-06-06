package soulever.project.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import soulever.project.ui.ViewModel.ListCollectionViewModel
import soulever.project.ui.ViewModel.PesananViewModel

class ViewModelFactory() : ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                ViewModelFactory().apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(PesananViewModel::class.java) -> {
                return PesananViewModel() as T
            }
            modelClass.isAssignableFrom(ListCollectionViewModel::class.java) -> {
                return ListCollectionViewModel() as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}