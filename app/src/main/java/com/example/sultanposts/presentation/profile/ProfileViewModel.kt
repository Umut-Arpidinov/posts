package com.example.sultanposts.presentation.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sultanposts.core.BaseViewModel
import com.example.sultanposts.data.datasource.remote.model.ProfileResponse
import com.example.sultanposts.data.repository.UserRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repositoryImpl: UserRepositoryImpl) :
    BaseViewModel() {

    private val _response: MutableLiveData<ProfileResponse> = MutableLiveData()
    val response: LiveData<ProfileResponse> = _response

    fun getProfileData(id: String) {
        makeRequest(
            repositoryImpl.getProfileData(id),
            onSuccess = { _response.value = it },
            onError = {
                handleError(it)
            }
        )
    }

    private fun handleError(error: Throwable) {
        if (error is HttpException) {
            when (error.code()) {
                400 -> {
                    val errorBody = error.response()?.errorBody()?.string()
                    try {
                        val errorJson = JSONObject(errorBody)
                        val status = errorJson.getString("status")
                        val response = ProfileResponse(status)
                        _response.value = response
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }

}