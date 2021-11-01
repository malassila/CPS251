
package com.example.lifecycleaware.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lifecycleaware.R
import com.example.lifecycleaware.DemoObserver
import com.example.lifecycleaware.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)

    }

    private lateinit var demoObserver: DemoObserver

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        demoObserver = DemoObserver()

        binding.message.append(demoObserver.onCreate())
        binding.message.append(demoObserver.onResume())
        binding.message.append(demoObserver.onStart())
        binding.message.append(demoObserver.onPause())
        binding.message.append(demoObserver.onStop())
        binding.message.append(demoObserver.onDestroy())

    }




}