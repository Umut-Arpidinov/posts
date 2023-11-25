package com.example.sultanposts.presentation.branch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sultanposts.core.BaseViewModel
import com.example.sultanposts.data.repository.UserRepository
import com.example.sultanposts.domain.enitity.Branch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChooseFragmentViewModel @Inject constructor(
    private val repository: UserRepository,
) : BaseViewModel() {

    private val _branch: MutableLiveData<List<Branch>> = MutableLiveData()
    val branch: LiveData<List<Branch>> = _branch


    fun getBranches() {
        makeRequest(
            repository.fetchBranches(),
            onSuccess = {_branch.value = it},
            onError = {it.printStackTrace()}
            )
    }
}