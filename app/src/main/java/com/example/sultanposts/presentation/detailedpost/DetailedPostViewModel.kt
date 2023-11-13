package com.example.sultanposts.presentation.detailedpost

import androidx.lifecycle.ViewModel
import com.example.sultanposts.core.BaseViewModel
import com.example.sultanposts.domain.usecase.GetUsersPostsByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class DetailedPostViewModel @Inject constructor(
    getUsersPostsByIdUseCase: GetUsersPostsByIdUseCase
) : BaseViewModel() {

}