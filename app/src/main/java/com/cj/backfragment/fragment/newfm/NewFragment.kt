package com.cj.backfragment.fragment.newfm

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cj.backfragment.R

class NewFragment : Fragment() {

    companion object {
        fun newInstance() = NewFragment()
    }

    private lateinit var viewModel: NewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.new_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NewViewModel::class.java)
        // TODO: Use the ViewModel
    }

}