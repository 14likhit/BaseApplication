package com.amotrade.baseapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.amotrade.baseapplication.base.BaseFragment
import com.amotrade.baseapplication.data.CakeData
import com.amotrade.baseapplication.data.CakeMenu
import com.amotrade.baseapplication.data.repository.LocalRepository
import com.amotrade.baseapplication.databinding.FragmentMainBinding
import com.amotrade.baseapplication.ui.adapter.CakeListAdapter
import com.amotrade.baseapplication.utils.isIdEven
import com.amotrade.baseapplication.viewmodel.MainViewModel
import com.amotrade.baseapplication.viewmodelfactory.MainViewModelFactory


class MainFragment : BaseFragment() {

    private lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var viewModelMain: MainViewModel

    private lateinit var fragmentMainBinding: FragmentMainBinding

    private lateinit var cakeListAdapter: CakeListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false)

        viewModelFactory = MainViewModelFactory(LocalRepository(getBaseActivity()!!.application))

        viewModelMain = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        setObservers()

        return fragmentMainBinding.root
    }

    override fun initViews(view: View) {
        super.initViews(view)

        getCakeData()
    }

    private fun getCakeData() {
        viewModelMain.getCakeMenuData()
    }

    private fun setObservers() {
        viewModelMain.getCakeMenuLiveData().observe(viewLifecycleOwner, {
            setCakeView(it)
        })
    }

    private fun setCakeView(it: CakeMenu?) {
        if (it != null) {
            cakeListAdapter = CakeListAdapter(it.batters.batter, object : CakeItemClickListener{
                override fun onCakeClick(cake: CakeData) {
                    if(isIdEven(cake.id.toInt())){
                        showMessage("EvenCakeClick")
                    }else{
                        showMessage("OddCakeClick")
                    }
                }

            })
            fragmentMainBinding.cakeRV.apply {
                layoutManager = LinearLayoutManager(getBaseActivity()!!)
                adapter = cakeListAdapter
            }
        }
    }
}