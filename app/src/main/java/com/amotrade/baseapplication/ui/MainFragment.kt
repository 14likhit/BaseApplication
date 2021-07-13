package com.amotrade.baseapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amotrade.baseapplication.base.BaseFragment
import com.amotrade.baseapplication.databinding.FragmentMainBinding


class MainFragment : BaseFragment() {

    private lateinit var fragmentMainBinding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMainBinding = FragmentMainBinding.inflate(inflater,container,false)
        return fragmentMainBinding.root
    }
}