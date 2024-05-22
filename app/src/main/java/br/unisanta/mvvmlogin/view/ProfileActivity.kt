package br.unisanta.mvvmlogin.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.unisanta.mvvmlogin.R
import br.unisanta.mvvmlogin.databinding.ActivityProfileBinding
import br.unisanta.mvvmlogin.model.User
import br.unisanta.mvvmlogin.viewmodel.LoginViewModel

class ProfileActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityProfileBinding.inflate(layoutInflater)
    }
    private val viewModel = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val user = intent.getSerializableExtra("USER") as? User

        user?.let { userObj ->
            binding.edtUserName.setText(userObj.userName)
            binding.edtEmail.setText(userObj.email)
            binding.imgProfilePicture.setImageResource(R.drawable.profile_picture)

            binding.btnSave.setOnClickListener {
                userObj.email = binding.edtEmail.text.toString()
                viewModel.updateUser(userObj)
                Toast.makeText(this, "Perfil atualizado com sucesso!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
