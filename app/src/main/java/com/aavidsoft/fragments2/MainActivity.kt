package com.aavidsoft.fragments2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    lateinit var loginFragment : LoginFragment

    //way 1
    var data : String? = null
    set(value) {
        field = value
        loginFragment.data = value
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginFragment = supportFragmentManager.findFragmentById(R.id.loginFragment) as LoginFragment
    }
}