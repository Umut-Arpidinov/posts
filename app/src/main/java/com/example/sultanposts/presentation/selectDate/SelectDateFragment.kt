package com.example.sultanposts.presentation.selectDate

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.fragment.app.viewModels
import com.example.sultanposts.R
import com.example.sultanposts.core.BaseFragment
import com.example.sultanposts.data.datasource.remote.model.BookRequest
import com.example.sultanposts.data.local.Preference
import com.example.sultanposts.databinding.FragmentSelectDateBinding
import com.example.sultanposts.presentation.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar
import javax.inject.Inject
import kotlin.math.min

@AndroidEntryPoint
class SelectDateFragment : BaseFragment<FragmentSelectDateBinding>(),
    DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    override fun getViewBinding(): FragmentSelectDateBinding =
        FragmentSelectDateBinding.inflate(layoutInflater)

    @Inject
    lateinit var preference: Preference

    private val viewModel: SelectViewModel by viewModels()

    var address: String? = null
    var service: String? = null
    var subservice: String? = null

    var day = 0
    var month = 0
    var year = 0
    var hour = 0
    var minute = 0

    var savedDay = 0
    var savedMonth = 0
    var savedYear = 0
    var savedHour = 0
    var savedMinute = 0

    override fun initViews() {
        super.initViews()
        pickDate()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        savedDay = dayOfMonth
        savedMonth = month
        savedYear = year
        getDateTimeCalendar()
        binding.tvSelectedDate.text = "$savedDay.$savedMonth.$savedYear"
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        savedHour = hourOfDay
        savedMinute = minute
        binding.tvSelectedTime.text = "$savedHour:$savedMinute"
    }

    private fun getDateTimeCalendar() {
        val cal = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
        hour = cal.get(Calendar.HOUR)
        minute = cal.get(Calendar.MINUTE)
    }

    private fun pickDate() {
        binding.btnSelectDate.setOnClickListener {
            getDateTimeCalendar()
            DatePickerDialog(requireContext(), this, year, month, day).show()
        }
        binding.btnSelectTime.setOnClickListener {
            getDateTimeCalendar()
            TimePickerDialog(requireContext(), this, hour, minute, true).show()
        }
    }

    override fun initListeners() {
        super.initListeners()
        binding.btnBook.setOnClickListener {
            viewModel.book(
                BookRequest(
                    preference.id,
                    address,
                    service,
                    subservice,
                    "$savedYear-$savedMonth-$savedDay",
                    "$savedHour:$savedMinute"
                )
            )
        }
    }

    override fun observeData() {
        super.observeData()
        viewModel.response.observe(viewLifecycleOwner) { response ->
            if (response.status == "success") {
                showAlert("Вы забронировали очередь")
            } else {
                showAlert("Это время не свободно")
            }
        }
    }

    private fun showAlert(msg: String) {
        AlertDialog.Builder(requireContext())
            .setTitle(msg)
            .setCancelable(true)
            .setNegativeButton(
                "Ok",
                DialogInterface.OnClickListener { dialogInterface, i ->
                    dialogInterface.cancel()
                })
            .show()
    }

}