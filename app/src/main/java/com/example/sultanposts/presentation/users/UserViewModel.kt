package com.example.sultanposts.presentation.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sultanposts.core.BaseViewModel
import com.example.sultanposts.domain.enitity.User
import com.example.sultanposts.domain.usecase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
): BaseViewModel() {

    private val _users: MutableLiveData<List<User>> = MutableLiveData()
    val users: LiveData<List<User>> get() = _users

     fun getUsers(){
        makeRequest(
            getUsersUseCase(),
            onSuccess = {_users.value = it},
            onError = {it.printStackTrace()}
        )
    }
}