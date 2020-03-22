package com.shanya.volleydemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {
            val stringRequest = StringRequest(
                Request.Method.GET,
                "https://raw.githubusercontent.com/Shanyaliux/VolleyDemo/master/app/jsonfile/volleydemo.json",
                Response.Listener {
                    nameTextView.text = Gson().fromJson(it,Student::class.java).name
                    chineseTextView.text = Gson().fromJson(it,Student::class.java).chinese.toString()
                    mathTextView.text = Gson().fromJson(it,Student::class.java).math.toString()
                    englishTextView.text = Gson().fromJson(it,Student::class.java).english.toString()
                },
                Response.ErrorListener {
                    Log.d("VolleyErrorListener",it.toString())
                }
            )
            VolleySingleton.getInstance(application).requestQueue.add(stringRequest)
        }


    }


}
