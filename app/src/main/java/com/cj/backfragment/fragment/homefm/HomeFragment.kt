package com.cj.backfragment.fragment.homefm

import android.app.Activity
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cj.backfragment.ChangeFragment
import com.cj.backfragment.R
import com.cj.backfragment.fragment.homefm.detail.DetailFragment
import com.uits.baseproject.base.BaseContainerFragment
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    fun newInstance(someInt: Int): HomeFragment? {
        val myFragment = HomeFragment()
        val args = Bundle()
        args.putInt("someInt", someInt)
        myFragment.arguments = args
        return myFragment
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mTVHome.setOnClickListener {
            if (parentFragment is BaseContainerFragment) {
                (parentFragment as BaseContainerFragment?)?.replaceFragment(DetailFragment().newInstance(2)!!, true)
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }
}