package com.amotrade.baseapplication.data.repository

import android.app.Application
import android.content.Context
import com.amotrade.baseapplication.data.CakeMenu
import com.google.gson.Gson
import java.io.IOException

class LocalRepository(val context: Application) {

    fun getCakeMenuData(): CakeMenu {
        return getData()
    }

    private fun getData(): CakeMenu {
        val response = loadJSONFromAsset(context, "data.json")
        return Gson().fromJson(response, CakeMenu::class.java)
    }


    private fun loadJSONFromAsset(context: Context, fileName: String): String? {
        var json: String? = null
        try {
            val `is` = context.assets.open(fileName)
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            json = String(buffer, Charsets.UTF_8)
        } catch (ex: IOException) {
            return null
        }

        return json
    }

}