package org.d3if4038.themountain.listview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if4038.themountain.network.TheMountainApiService
import org.d3if4038.themountain.network.TheMountainProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception


enum class TheMountainApiStatus {LOADING, ERROR, DONE}
class ListviewViewModel : ViewModel() {
    private val _status = MutableLiveData<TheMountainApiStatus>()
    val status: LiveData<TheMountainApiStatus>
    get() = _status

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _properties = MutableLiveData<List<TheMountainProperty>>()
    val _navigateToSelectedItem : LiveData<TheMountainProperty>
    get() = _navigateToSelectedItem

    init {
        getDataTheMountain()
    }

    private fun getDataTheMountain(){
        coroutineScope.launch{
            var getPropertiesDeffered = TheMountainApiStatus.TheMountainApi.retrofitService.getProperties()
            try {
                _status.value = TheMountainApiStatus.LOADING
                var  listResult = getPropertiesDeffered.await()
                _status.value = TheMountainApiStatus.DONE
                if (listResult.size > 0){
                    _properties.value = listResult
                }
            } catch (e: Exception){
                _status.value = TheMountainApiStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }

    fun displayItemDetails(theMountainProperty: TheMountainProperty){
        _navigateToSelectedItem.value = theMountainProperty
    }
    fun displayItemDetailsComplete() {
        _navigateToSelectedItem.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}