package com.example.sultanposts.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class BaseViewModel : ViewModel() {

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
    var isLoading: MutableLiveData<Boolean> = MutableLiveData()
    protected var isError: MutableLiveData<Throwable> = MutableLiveData()
    var viewModelError: MutableLiveData<Throwable> = MutableLiveData()

    protected fun <T : Any> makeRequest(
        single: Single<T>,
        onSuccess: (T) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val disposable = single
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                isLoading.value = true
            }
            .doOnTerminate {
                isLoading.value = false
            }
            .doOnError {
                viewModelError.value = it
            }
            .subscribe(
                { result -> onSuccess(result) },
                { error -> onError(error) },

                )
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}