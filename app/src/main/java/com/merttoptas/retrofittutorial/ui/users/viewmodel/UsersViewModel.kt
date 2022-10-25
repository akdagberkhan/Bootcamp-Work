package com.merttoptas.retrofittutorial.ui.users.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.merttoptas.retrofittutorial.data.model.DataState
import com.merttoptas.retrofittutorial.data.model.Users
import com.merttoptas.retrofittutorial.data.repository.UsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(private val usersRepository: UsersRepository) : ViewModel() {

    private var _userLiveData = MutableLiveData<DataState<List<Users>?>>()
    val userLiveData : LiveData<DataState<List<Users>?>>
        get() = _userLiveData

    private val _eventStateLiveData = MutableLiveData<UsersViewEvent>()
    val eventStateLiveData :LiveData<UsersViewEvent>
        get() = _eventStateLiveData

    init {
        getUsers()
    }

    private fun getUsers() {
        _userLiveData.postValue(DataState.Loading())
        usersRepository.getUsers().enqueue(object : Callback<List<Users>> {
            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        _userLiveData.postValue(DataState.Success(it))

                    } ?: kotlin.run {
                        _userLiveData.postValue(DataState.Error("Data Empty"))
                    }
                } else {
                    _userLiveData.postValue(DataState.Error(response.message()))
                }
            }
            override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                _userLiveData.postValue(DataState.Error(t.message.toString()))
                _eventStateLiveData.postValue(UsersViewEvent.ShowMessage(t.message.toString()))
            }
        })
    }
}

sealed class UsersViewEvent {
    object NavigateToDetail : UsersViewEvent()
    class ShowMessage(val message: String?) : UsersViewEvent()
}