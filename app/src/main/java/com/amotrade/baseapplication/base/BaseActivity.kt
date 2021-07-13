package com.amotrade.baseapplication.base

import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.amotrade.baseapplication.R

/**
 * Parent Activity for all the Activities.
 */
abstract class BaseActivity : AppCompatActivity() {

    fun setupToolbar(
        title: String?,
        homeButtonEnable: Boolean
    ) {
        val toolbar = findViewById<Toolbar>(R.id.toolbar) ?: return

        if (homeButtonEnable) {
            val backArrow = findViewById<AppCompatImageView>(R.id.backArrowIV)
            backArrow.setOnClickListener { onBackPressed() }
            backArrow.visibility = View.VISIBLE
        }

        val titleTextView = findViewById<TextView>(R.id.toolbar_title_text_view)
        titleTextView.text = title


        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false)
            actionBar.setDisplayShowHomeEnabled(false)

        }
    }



    fun getCurrentFragment(): BaseFragment? {
        return supportFragmentManager.findFragmentById(R.id.container) as BaseFragment?
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (getCurrentFragment() == null || !getCurrentFragment()!!.onBackPressed()) {
            super.onBackPressed()
        }
    }

    // Fragment Related
    fun replaceFragment(fragment: Fragment, tag: String, addToBackStack: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment, tag)
        if (addToBackStack) {
            transaction.addToBackStack(tag)
        }
        transaction.commit()
    }

    fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun showMessage(messageResId: Int) {
        Toast.makeText(
            this, this.getString(messageResId), Toast.LENGTH_SHORT
        ).show()
    }

}