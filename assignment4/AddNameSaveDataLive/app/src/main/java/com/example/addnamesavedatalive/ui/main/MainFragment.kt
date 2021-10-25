package com.example.addnamesavedatalive.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.addnamesavedatalive.BR.myViewModel
import com.example.addnamesavedatalive.R
import com.example.addnamesavedatalive.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }


    private lateinit var viewModel: MainViewModel
    lateinit var binding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        binding.setLifecycleOwner(this)
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.setVariable(myViewModel, viewModel)

        binding.output.text = viewModel.getResult().toString()
//        val resultObserver = Observer<String> {
//            output -> binding.output.text = output.toString()
//
//        }



        binding.button.setOnClickListener{
            val newName = binding.editTextTextPersonName.text.toString() + "\n"

            if (newName!="\n"){

                var output = binding.output.text

                if(output != "No names to display!"){

                    val add = StringBuilder()
                    add.append(newName).append(output)
                    val nameList = add.toString()
                    viewModel.setName(nameList)
                    binding.output.text = nameList
                    binding.editTextTextPersonName.text = null

                }else {

                    binding.output.text = newName
                    viewModel.setName(newName)
                    binding.editTextTextPersonName.text = null

                }
            }
        }

    }

}

