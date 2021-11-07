package com.example.navigationproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationproject.R
import com.example.navigationproject.databinding.MainFragmentBinding
import androidx.navigation.Navigation

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //return inflater.inflate(R.layout.main_fragment, container, false)
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)




        binding.button1.setOnClickListener {
            var action: MainFragmentDirections.ActionMainFragmentToNewFragment = MainFragmentDirections.actionMainFragmentToNewFragment()

            action.setMessage("1")
            action.setImage(R.drawable.android_image_1.toString())
            Navigation.findNavController(it).navigate(action)

        }
        binding.button2.setOnClickListener {
            var action: MainFragmentDirections.ActionMainFragmentToNewFragment = MainFragmentDirections.actionMainFragmentToNewFragment()
            action.setMessage("2")
            action.setImage(R.drawable.android_image_2.toString())
            Navigation.findNavController(it).navigate(action)

        }
        binding.button3.setOnClickListener {
            var action: MainFragmentDirections.ActionMainFragmentToNewFragment = MainFragmentDirections.actionMainFragmentToNewFragment()
            action.setMessage("3")
            action.setImage(R.drawable.android_image_3.toString())
            Navigation.findNavController(it).navigate(action)

        }




    }

}