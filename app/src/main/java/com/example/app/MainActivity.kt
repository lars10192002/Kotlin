package com.example.app

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.app.entity.User
import com.example.core.utils.CacheUtils

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val usernameKey = "username"
    private val passwordKey = "password"
    private lateinit var et_username : EditText
    private lateinit var et_password : EditText
    private lateinit var et_code : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et_username = findViewById(R.id.et_username)
        et_password = findViewById(R.id.et_password)
        et_code = findViewById(R.id.et_code)

        et_username?.setText(CacheUtils.get(usernameKey))
        var btn = getDelegate().findViewById<Button>(R.id.btn_login)
        btn?.setOnClickListener {  }
    }

    override fun onClick(v: View?) {

        var user: User? = null
        var user2: User = User()

        et_username?.setText("AAAAA")
    }
}