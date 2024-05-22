package br.unisanta.mvvmlogin.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.unisanta.mvvmlogin.databinding.ActivityLoginBinding
import br.unisanta.mvvmlogin.model.User
import br.unisanta.mvvmlogin.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    private val viewModel = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCadastrar.setOnClickListener {
            val conteudoUser = binding.edtUserName.text.toString()
            val conteudoPass = binding.edtPassword.text.toString()
            val usuario = User(conteudoUser, conteudoPass)
            viewModel.register(usuario)
            Toast.makeText(this, "$conteudoUser , $conteudoPass", Toast.LENGTH_SHORT).show()
        }

        binding.btnLogar.setOnClickListener {
            val conteudoUser = binding.edtUserName.text.toString()
            val conteudoPass = binding.edtPassword.text.toString()
            val usuario = User(conteudoUser, conteudoPass)
            if (viewModel.login(usuario)) {
                Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ProfileActivity::class.java).apply {
                    putExtra("USER", usuario)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Verifique o login e senha!", Toast.LENGTH_SHORT).show()
            }
            Log.i("BtnLogar", "$conteudoUser, $conteudoPass")
        }
    }
}
