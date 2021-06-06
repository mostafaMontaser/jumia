package com.code.jumia.view.login

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.code.jumia.R
import com.code.jumia.model.response.login.Country
import com.code.jumia.view.BaseActivity
import com.code.jumia.view.BasicActivity
import com.code.jumia.view.util.BaseView
import com.code.jumia.viewmodel.BaseViewModel
import com.code.jumia.viewmodel.login.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject


@Suppress("UNCHECKED_CAST")
class LoginActivity : BaseActivity() {
//    private val viewModel: LoginViewModel by inject()
    private val countriesAdapter = CountryListAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_frag)
//        countriesList.apply {
//            layoutManager = LinearLayoutManager(applicationContext)
//            adapter = countriesAdapter
//        }
       // observeViewModel(viewModel)
        //viewModel.getCountries()
    }

//    override fun getViewModel(): BaseViewModel {
//        return viewModel
//    }

    private fun observeViewModel(viewModel: LoginViewModel?) {
        viewModel?.countries?.observe(this, Observer { countries ->
            countries?.let {
                countriesList.visibility = View.VISIBLE
                countriesAdapter.updateCountries(it as List<Country>)
            }
        })
    }

//    override fun showLoading() {
//        loading_view.visibility = View.VISIBLE
//
//    }
//
//    override fun hideLoading() {
//        loading_view.visibility = View.GONE
//    }

}
