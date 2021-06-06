package com.code.jumia.di


import androidx.lifecycle.ViewModel
import com.code.jumia.dispatcher.login.LoginDispatcher
import com.code.jumia.model.retrofit.Service
import com.code.jumia.repository.local.BaseLocalRepo
import com.code.jumia.repository.local.login.LoginLocalRepo
import com.code.jumia.repository.remote.login.LoginRemoteRepo
import com.code.jumia.viewmodel.login.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module



val localRepoModule = module {
    single { BaseLocalRepo() }
}
val networkModule = module {
    single { Service.getService() }
}

val test = module {
    viewModel { LoginViewModel(get()) }
    single { LoginDispatcher(get(), get()) }
    single { LoginRemoteRepo(get()) }
    single { LoginLocalRepo() }
}