package com.alim.myapplication

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import kotlinx.android.synthetic.main.activity_move_with_data.*

class MoveWithData : Activity() {
    val REQUEST_IMAGE_CAPTURE = 0
    private val TAKE_PICTURE = 1
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        btnCapture.setOnClickListener {
            ambilgambar()
        }

        val nama=intent.getStringExtra("Username")
        val password=intent.getIntExtra("password",0)
        tv_data_received.setText("User Name ="+ nama + ",\nPassword ="+password)
    }
    fun ambilgambar() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageprofile.setImageBitmap(imageBitmap)
        }

    }
}
