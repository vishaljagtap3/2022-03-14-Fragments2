package com.aavidsoft.fragments2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aavidsoft.fragments2.databinding.HomeFragmentBinding
import com.aavidsoft.fragments2.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private lateinit var binding : LoginFragmentBinding

    var data : String? = null
    set(value) {
        field = value
        binding.txtData.text = value
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(layoutInflater)

        binding.btnLogin.setOnClickListener {
            var homeFragment = HomeFragment()

            var inputBundle = Bundle()
            inputBundle.putString("username", binding.edtUsername.text.toString())
            inputBundle.putInt("usercode", 101)

            homeFragment.arguments = inputBundle
            homeFragment.onDataListener = MyOnDataListener()

            parentFragmentManager.beginTransaction()
                .add(R.id.mainContainer, homeFragment, null)
                .addToBackStack(null)
                .commit()
        }

        return binding.root
    }

    inner class MyOnDataListener : HomeFragment.OnDataListener {
        override fun onData(data: String) {
            this@LoginFragment.data = data
        }
    }
}




