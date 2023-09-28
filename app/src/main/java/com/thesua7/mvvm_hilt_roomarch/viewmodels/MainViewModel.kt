package com.thesua7.mvvm_hilt_roomarch.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thesua7.mvvm_hilt_roomarch.databaseModel.RoomRepository
import com.thesua7.mvvm_hilt_roomarch.databaseModel.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val roomRepository: RoomRepository) : ViewModel() {

    lateinit var userData:MutableLiveData<List<UserEntity>>
    init {

        userData = MutableLiveData()
        loadRecords()
    }

    fun getRecordObserver(): MutableLiveData<List<UserEntity>>{
        return  userData
    }

    fun loadRecords(){
        val list = roomRepository.getRecords()
        userData.postValue(list)
    }

    fun insertRecords(userEntity: UserEntity){
        roomRepository.insertRecord(userEntity)
        loadRecords()
    }
}