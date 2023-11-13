package com.example.sultanposts.core

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class BaseViewModel : ViewModel() {

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()

    protected fun <T : Any> makeRequest(
        single: Single<T>,
        onSuccess: (T) -> Unit,
        onError: (Throwable) -> Unit,
    ) {
        val disposable = single
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {result -> onSuccess(result)},
                {error -> onError(error)}
            )
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}