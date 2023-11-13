package com.example.sultanposts.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract  class BaseFragment<T: ViewBinding> : Fragment() {

    private var _binding: T? = null

    protected val binding: T get() = _binding!!

    protected abstract fun getViewBinding(): T


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getViewBinding()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListeners()
        observeData()
    }

    open fun initViews(){}
    open fun initListeners(){}
    open fun observeData(){}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}