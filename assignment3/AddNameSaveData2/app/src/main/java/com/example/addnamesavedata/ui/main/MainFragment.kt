package com.example.addnamesavedata.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.addnamesavedata.R
import com.example.addnamesavedata.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding

    companion object {
        fun newInstance() = MainFragment()
    }


    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return(binding.root)


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        binding.output.text = viewModel.getResult();

        binding.button.setOnClickListener{
            val newName = binding.editTextTextPersonName.text.toString() + "\n"

            if (newName!="\n"){

                var output = binding.output.text

                if(output != "No names to display!"){

                    val add = StringBuilder()
                    add.append(newName).append(output)
                    val nameList = add.toString();
                    viewModel.setName(nameList);
                    binding.output.text = nameList;
                    binding.editTextTextPersonName.text = null

                }else {

                    binding.output.text = newName
                    viewModel.setName(newName);
                    binding.editTextTextPersonName.text = null

                }
            }
        }

    }

}