package com.aavidsoft.fragments2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aavidsoft.fragments2.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    private lateinit var binding : HomeFragmentBinding
    private var userName : String? = null
    private var userCode : Int? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(layoutInflater)

        userName = arguments?.getString("username")
        userCode = arguments?.getInt("usercode")

        binding.txtUserInfo.text = "$userName ($userCode)"

        binding.btnFinish.setOnClickListener {

            //way2 -- direct to loginfragment
            (parentFragmentManager.findFragmentById(R.id.loginFragment) as LoginFragment)
                .data = binding.edtData.text.toString()

            //way 1 -- through the main activity
            //(activity as MainActivity).data = binding.edtData.text.toString()
            parentFragmentManager.beginTransaction()
                .remove(this)
                .commit()
        }

        return binding.root
    }

}

