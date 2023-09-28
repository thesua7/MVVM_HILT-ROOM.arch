package com.thesua7.mvvm_hilt_roomarch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.thesua7.mvvm_hilt_roomarch.databaseModel.UserEntity
import com.thesua7.mvvm_hilt_roomarch.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var editText: EditText
    private lateinit var button: Button

    lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.tv_view)
        editText = findViewById(R.id.et_input)
        button = findViewById(R.id.btn_demo)


        button.setOnClickListener{
            val userEntity = UserEntity(name = editText.text.toString())
            viewModel.insertRecords(userEntity)
            editText.setText("")

        }
        initViewModel()



    }

    private fun initViewModel(){
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getRecordObserver().observe(this) { value ->
            textView.setText("")
            value?.forEach {
                textView.append(it.name + "\n")
            }
        }
    }
}