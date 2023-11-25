package com.example.sultanposts.presentation.tickets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sultanposts.core.BaseViewModel
import com.example.sultanposts.data.datasource.remote.model.HistoryResponse
import com.example.sultanposts.data.repository.UserRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class TicketsViewModel @Inject constructor(private val repositoryImpl: UserRepositoryImpl) :
    BaseViewModel() {

    private val _response: MutableLiveData<List<HistoryResponse>> = MutableLiveData()
    val response: LiveData<List<HistoryResponse>> = _response

    fun getHistory(id: String) {
        makeRequest(
            repositoryImpl.getHistory(id),
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
                        val response = HistoryResponse(status)
                        _response.value = listOf(response) //not sure
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }

}