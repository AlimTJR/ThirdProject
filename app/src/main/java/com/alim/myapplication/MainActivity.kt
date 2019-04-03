package com.alim.myapplication

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_move_with_data.*
import android.content.ActivityNotFoundException



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_move_activity_data.setOnClickListener{
            val intent = Intent(this, MoveWithData::class.java)
            intent.putExtra("Username","m Alim Tajri")
            intent.putExtra("password",124123213)
            startActivity(intent)
        }

        btn_dial_number.setOnClickListener {
            val Nomor = "098328732122"
            val dialaksi = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$Nomor"))
            startActivity(dialaksi)
        }

        profile.setOnClickListener {
            val uri = Uri.parse("https://www.instagram.com/alim.tjr")
            val i = Intent(Intent.ACTION_VIEW, uri)
            i.setPackage("com.instagram.android")
            try {
                startActivity(i)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://instagram.com/xxx")
                    )
                )
            }

        }

    }

}