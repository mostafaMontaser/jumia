package com.code.jumia.dispatcher.login

import com.code.jumia.dispatcher.BaseDispatcher
import com.code.jumia.repository.local.login.LoginLocalRepo
import com.code.jumia.repository.remote.login.LoginRemoteRepo

class LoginDispatcher(localRepo: LoginLocalRepo, remoteRepo: LoginRemoteRepo) : BaseDispatcher(localRepo, remoteRepo)