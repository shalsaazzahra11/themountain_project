package org.d3if4038.themountain.detailview

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if4038.themountain.network.TheMountainProperty

class DetailViewModelFactory(
    private val theMountainProperty: TheMountainProperty,
    private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(theMountainProperty,application) as T
    }
        throw IllegalArgumentException("Unknowm ViewModel class")
    }
}