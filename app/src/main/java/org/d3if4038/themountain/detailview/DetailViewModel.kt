package org.d3if4038.themountain.detailview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.d3if4038.themountain.network.TheMountainProperty

class DetailViewModel(theMountainProperty: TheMountainProperty,
                      app: Application) : AndroidViewModel(app) {
    private val _selectedItem = MutableLiveData<TheMountainProperty>()
    val selectedItem : LiveData<TheMountainProperty>
    get() = _selectedItem as LiveData<TheMountainProperty>

    init {
        _selectedItem.value = theMountainProperty
    }
}