package com.amotrade.baseapplication.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.amotrade.baseapplication.R
import com.amotrade.baseapplication.base.BaseActivity
import com.amotrade.baseapplication.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
    }
}