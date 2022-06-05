package com.example.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.app.entity.User
import com.example.app.widget.CodeView
import com.example.core.utils.CacheUtils
import com.example.core.utils.Utils
import com.example.lesson.LessonActivity

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
        var img_code = findViewById<CodeView>(R.id.code_view)
        btn?.setOnClickListener (this)
        img_code.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v is CodeView){
            v.updateCode()

        }else{
            login()
        }

        var user: User? = null
        var user2: User = User()

        et_username?.setText("AAAAA")
    }

    private fun login() {
        val username =et_username.text.toString()
        val password = et_password.text.toString()
        val code = et_code.text.toString()

        val user = User(username, password, code)
        if (verify(user)){
            CacheUtils.save(usernameKey, username)
            CacheUtils.save(passwordKey, password)
            startActivity(Intent(this, LessonActivity::class.java))
        }

    }

    private fun verify(user: User): Boolean {

        if (user.username != null && user.username!!.length < 4){
            Utils.toast("用戶名不合法")
            return false
        }
        if( user.password != null && user.password!!.length < 4){
            Utils.toast("密碼不合法")
            return false
        }
        return true
    }
}