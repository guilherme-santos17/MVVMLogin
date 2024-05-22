package br.unisanta.mvvmlogin.model

import java.io.Serializable

data class User(
    val userName: String,
    val password: String,
    var email: String = "",
    var profilePictureUrl: String = "",
) : Serializable

