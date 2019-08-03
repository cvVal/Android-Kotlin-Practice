package com.valpu.seve.applicationtest.activities

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.Toast
import com.valpu.seve.applicationtest.R
import com.valpu.seve.mylibrary.ToolbarActivity
import kotlinx.android.synthetic.main.activity_permissions.*

class PermissionsActivity : ToolbarActivity() {

    private val requestCameraPermission = 100
    private val requestCameraPicture = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permissions)

        //button_picture.setOnClickListener { getPictureFromCameraAskingPermissions() }

        button_picture.setOnClickListener { getPictureFromCameraWithoutPermissions() }
    }

    private fun getPictureFromCameraWithoutPermissions() {

        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intent.resolveActivity(packageManager) != null) {

            startActivityForResult(intent, requestCameraPicture)

        } else {


        }
    }

    private fun getPictureFromCameraAskingPermissions() {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), requestCameraPermission)
        } else {

            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, requestCameraPicture)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        when (requestCode) {

            requestCameraPermission -> {

                if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(intent, requestCameraPicture)
                } else {

                    Toast.makeText(this, "You cannot take a picture if you deny the permission", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        when (requestCode) {

            requestCameraPicture -> {

                if (resultCode == Activity.RESULT_OK) {

                    val extras = data!!.extras
                    val imageBitMap = extras.get("data") as Bitmap

                    image_view_picture.setImageBitmap(imageBitMap)
                } else {

                    Toast.makeText(this, "Picture not taken", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
