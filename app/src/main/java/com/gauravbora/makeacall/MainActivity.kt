package com.gauravbora.makeacall

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import com.gauravbora.makeacall.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        checkPermission()

        binding.img.setOnClickListener{
            val phoneNumber=binding.noEt.text
            if (phoneNumber != null) {
                if(phoneNumber.isNotEmpty() ){
                    val cIntent=Intent(Intent.ACTION_CALL)
                    cIntent.data= Uri.parse("tel: $phoneNumber")
                    startActivity(cIntent)
                }
            }

        }

    }

    private fun checkPermission() {

        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE),101)
        }

    }
}