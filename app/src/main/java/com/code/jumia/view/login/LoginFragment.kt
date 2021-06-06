package com.code.jumia.view.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.code.jumia.R
import com.code.jumia.model.response.login.Country
import com.code.jumia.view.BasicFragment
import com.code.jumia.viewmodel.BaseViewModel
import com.code.jumia.viewmodel.login.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject

class LoginFragment : BasicFragment() {
    private val viewModel: LoginViewModel by inject()
    private val countriesAdapter = CountryListAdapter(arrayListOf())
    override fun getViewModel(): BaseViewModel = viewModel

    override fun showLoading() {
        loading_view.visibility = View.VISIBLE
    }

    private fun observeViewModel() {
        viewModel.countries.observe(this, Observer { countries ->
            countries?.let {
                countriesList.visibility = View.VISIBLE
                countriesAdapter.updateCountries(it as List<Country>)
            }
        })
    }

    override fun hideLoading() {
        loading_view.visibility = View.GONE
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_login, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        viewModel.getCountries()
    }

    private fun initUI() {
        countriesList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countriesAdapter
        }
    }
}