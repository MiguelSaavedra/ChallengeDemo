package com.example.challengeapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.challengeapplication.data.remote.response.BaseResponse
import com.example.challengeapplication.data.remote.response.LoginResponse
import com.example.challengeapplication.data.remote.response.ResultResponse
import com.example.challengeapplication.home.HomeActivity
import com.example.challengeapplication.home.LoginViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<LoginViewModel>()
    var email: String = ""
    var pwd: String = ""
    var pwdBD: String = ""
    var userNameBD: String = ""
    var data: ResultResponse? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.loginUser()
        viewModel.loginResult.observe(this) {
            when (it) {
                is BaseResponse.Loading -> {
                    showLoading()
                }

                is BaseResponse.Success -> {
                    stopLoading()
                    it.data?.results?.forEach { config ->
                        processLogin(config.login)
                        data=config
                    }
                }

                is BaseResponse.Error -> {
                    processError(it.msg)
                }
                else -> {
                    stopLoading()
                }
            }
        }
        btn_login.setOnClickListener { doLogin() }

    }

    private fun navigateToHome() {
        val gson = Gson()
        val myJson = gson.toJson(data)
        val intent = Intent(this, HomeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        intent.putExtra("value",  myJson)
        startActivity(intent)
    }

    fun doLogin() {
        email = txtInput_email.text.toString()
        pwd = txt_pass.text.toString()
        if (pwdBD == pwd && userNameBD == email) {
            navigateToHome()
            showToast(getString(R.string.succes_acces))
        } else {
            showToast(getString(R.string.error_password_username))
        }

    }

    fun showLoading() {
        prgbar.visibility = View.VISIBLE
    }

    fun stopLoading() {
        prgbar.visibility = View.GONE
    }

    fun processLogin(data: LoginResponse?) {
        pwdBD = data?.password.toString()
        userNameBD = data?.username.toString()
        txtInput_email.setText(userNameBD)
        txt_pass.setText(pwdBD)
    }

    fun processError(msg: String?) {
        showToast("Error al recuperar datos, cierre la aplicacion y vuelva a intentar$msg")
    }

    fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }


}

