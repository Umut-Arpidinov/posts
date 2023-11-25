package com.example.sultanposts.presentation.branch.service_detailed

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.sultanposts.R
import com.example.sultanposts.core.BaseFragment
import com.example.sultanposts.databinding.ServiceDetailedFragmentBinding
import com.example.sultanposts.domain.enitity.service.Subservice
import com.example.sultanposts.presentation.branch.services.ServiceDetailedAdapter

class ServiceDetailedFragment : BaseFragment<ServiceDetailedFragmentBinding>() {


    private val id = arguments?.getInt("id")


    private val servicedDetailedAdapter = ServiceDetailedAdapter(this::onClick)
    override fun getViewBinding(): ServiceDetailedFragmentBinding =
        ServiceDetailedFragmentBinding.inflate(layoutInflater)


    override fun initViews() {
        super.initViews()
        servicedDetailedAdapter.submitList(generaTeList())
    }


    private fun generaTeList(): List<Subservice> {

        if (id == 3) {
            return listOf(
                Subservice(1, "Перевыпуск карт"),
                Subservice(1, "Смена номера"),
                Subservice(1, "Снятие/пополнение счета"),
                Subservice(1, "Претензионные вопросы"),
                Subservice(1, "Денежные переводы"),
                )
        } else if (id == 2) {
            return listOf(

                Subservice(1, "Прочие услуги"),
                Subservice(1, "Открытие счета"),
                Subservice(1, "Переводы в национальной валюте"),
                Subservice(1, "Переводы в иностранной валюте"),
                Subservice(1, "Обналичивание"),
            )
        } else if (id == 1) {
            return listOf(

                Subservice(1, "Обмен валют"),
                Subservice(1, "Обналичивание денежных средств"),
                Subservice(1, "Пополнение счета / прием платежей")
            )
        }

        else return emptyList()

    }

    fun onClick(id : Int){
        val bundle = Bundle()
        bundle.putInt("id", id)
        findNavController().navigate(R.id.selectDateFragment, bundle)
    }



}