package com.laraknife.interfazjetpackcompose1.viewmodel.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {
    private val _user = MutableLiveData<String>()
    val user: LiveData<String> = _user
    private val _mail = MutableLiveData<String>()
    val mail: LiveData<String> = _mail
    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password
    private val _passwordConfirm = MutableLiveData<String>()
    val passwordConfirm: LiveData<String> = _passwordConfirm
    private val _valido = MutableLiveData<Boolean>()
    val valido: LiveData<Boolean> = _valido

    fun reset(){
        _user.value = ""
        _mail.value = ""
        _password.value = ""
        _passwordConfirm.value = ""
        _valido.value = false
    }

    fun changeUser(data: String){
        _user.value = data
    }

    fun changeMail(data: String){
        _mail.value = data
    }

    fun changePassword(data: String){
        _password.value = data
    }

    fun changePasswordConfirm(data: String){
        _passwordConfirm.value = data
    }

    fun verifyLogin(){
        // Sólo valida que los campos no estén vavios, pero aquí irían las validaciones correspondientes
        if (_mail.value != null && _password.value != null && _mail.value != "" && _password.value != "") {
            _valido.value = true
        }else _valido.value = false
    }

    fun verifyRegister(){
        if (_user.value!=null && _mail.value!=null && _mail.value != "" && _password.value != "" && _password.value==_passwordConfirm.value){
            _valido.value = true
        }else _valido.value = false
    }
}