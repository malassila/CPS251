package com.example.assignmentfinal.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignmentfinal.Contact
import com.example.assignmentfinal.R
import com.example.assignmentfinal.databinding.MainFragmentBinding

class MainFragment : Fragment(){

    private var adapter: RecyclerAdapter? = null
    private var toastDuration = Toast.LENGTH_SHORT

    companion object {
        fun newInstance() = MainFragment()
    }

    val viewModel : MainViewModel by viewModels()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listenerSetup()
        observerSetup()
        recyclerSetup()
    }

    private fun listenerSetup(){
        binding.addButton.setOnClickListener {
            val name = binding.personName.text.toString()
            val phone = binding.personNumber.text.toString()

            if (name != "" && phone != ""){
                var valContact = Contact(name, phone)
                viewModel.insertContact(valContact)
                clearFields()
            }else{
                Toast.makeText(context, "Please Enter a Name and a Phone Number",toastDuration).show()
            }
        }

        binding.findButton.setOnClickListener {
            val name = binding.personName.text.toString()

            if (name != ""){
                viewModel.findContact(name)
                clearFields()
            }else{
                Toast.makeText(context, "Please Enter a Name",toastDuration).show()
            }
        }

        binding.ascButton.setOnClickListener{
            viewModel.ascendingOrder()
        }

        binding.descButton.setOnClickListener {
            viewModel.descendingOrder()
        }


    }

    private fun observerSetup(){
        viewModel.getAllContacts()?.observe(this, Observer { contacts -> contacts?.let {
            adapter?.setContactList(it)
        } })

        viewModel.getSearchResults().observe(this, Observer { contacts -> contacts?.let {
            if (it.isNotEmpty()){
                adapter?.setContactList(it)
            } else {
                Toast.makeText(context,
                    "No Match Found", toastDuration).show()
            }
        } })
    }

    private fun recyclerSetup(){
        adapter = RecyclerAdapter(R.layout.cards)
        binding.contactRecycler.layoutManager = LinearLayoutManager(context)
        binding.contactRecycler.adapter = adapter

        adapter!!.settingListener(object: RecyclerAdapter.onItemCickListener{
            override fun onClick(string: String) {
                var contactId: Int = Integer.parseInt(string)
                viewModel.deleteContact(contactId)
            }

        })
    }



    private fun clearFields(){
        binding.personName.setText("")
        binding.personNumber.setText("")
    }

}