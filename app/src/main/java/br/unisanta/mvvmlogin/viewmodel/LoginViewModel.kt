package br.unisanta.mvvmlogin.viewmodel

import androidx.lifecycle.ViewModel
import br.unisanta.mvvmlogin.model.User

class LoginViewModel : ViewModel() {
    private val userList = mutableListOf<User>()

    fun register(user: User) {
        userList.add(user)
    }

    fun login(user: User): Boolean {
        return userList.any { it.userName == user.userName && it.password == user.password }
    }

    fun updateUser(updatedUser: User) {
        userList.find { it.userName == updatedUser.userName }?.apply {
            email = updatedUser.email
            profilePictureUrl = updatedUser.profilePictureUrl
        }
    }
}
