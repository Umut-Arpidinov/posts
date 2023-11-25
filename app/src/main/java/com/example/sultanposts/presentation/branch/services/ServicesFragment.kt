package com.example.sultanposts.presentation.branch.services


import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.sultanposts.R
import com.example.sultanposts.core.BaseFragment
import com.example.sultanposts.databinding.ServicesFragmentBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ServicesFragment : BaseFragment<ServicesFragmentBinding>() {


    private val viewModel by viewModels<ServiceFragmentViewModel>()

    private val args by navArgs<ServicesFragmentArgs>()

    override fun getViewBinding(): ServicesFragmentBinding =
        ServicesFragmentBinding.inflate(layoutInflater)

    private lateinit var serviceAdapter: ServiceAdapter

    override fun initViews() {
        super.initViews()
        hideNavBar()

        val services = args.branch.service
        val subservice = services.flatMap { it.subservice.map { it.title } }

        val adapter: ArrayAdapter<*> =

            ArrayAdapter(requireContext(), R.layout.sub_service_item, subservice)

        adapter.setDropDownViewResource(R.layout.sub_service_item)

        serviceAdapter = ServiceAdapter(adapter)

        binding.rvServices.adapter = serviceAdapter
        serviceAdapter.submitList(services)
    }

    override fun initListeners() {
        super.initListeners()

        serviceAdapter.onServiceListener {
            val bundle = Bundle()
            bundle.putInt("id",it.id)
            findNavController().navigate(R.id.serviceDetailedFragment, bundle)
        }



    }

    override fun observeData() {
        super.observeData()
    }

    private fun hideNavBar() {
        val navBar = activity?.findViewById<BottomNavigationView>(R.id.bottom_nav)
        navBar?.visibility = View.GONE
    }


}