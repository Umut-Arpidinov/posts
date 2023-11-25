package com.example.sultanposts.presentation.branch.services

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sultanposts.core.BaseRepository
import com.example.sultanposts.core.BaseViewModel
import com.example.sultanposts.data.repository.UserRepositoryImpl
import com.example.sultanposts.domain.enitity.service.ServiceX
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ServiceFragmentViewModel @Inject constructor(
    private val repository: UserRepositoryImpl
) : BaseViewModel() {


    private val _service : MutableLiveData<List<ServiceX>> = MutableLiveData()
    val service: LiveData<List<ServiceX>> = _service




    fun fetchService(){
        makeRequest(
            repository.fetchService(),
            onSuccess = {_service.value = it},
            onError = {it.printStackTrace()}
        )
    }


}