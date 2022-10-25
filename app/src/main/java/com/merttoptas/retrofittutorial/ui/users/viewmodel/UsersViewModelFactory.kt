package com.merttoptas.retrofittutorial.ui.users.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.merttoptas.retrofittutorial.data.repository.UsersRepository

@Deprecated("use usersviewmodelfactory")
class UsersViewModelFactory(private val usersRepository: UsersRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UsersViewModel(usersRepository) as T
    }

}