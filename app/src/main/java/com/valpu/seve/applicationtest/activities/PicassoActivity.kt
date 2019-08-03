package com.valpu.seve.applicationtest.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.squareup.picasso.Picasso
import com.valpu.seve.applicationtest.CircleTransform
import com.valpu.seve.applicationtest.R
import com.valpu.seve.mylibrary.ToolbarActivity
import kotlinx.android.synthetic.main.activity_picasso.*

class PicassoActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picasso)

        toolbarToLoad(toolbar as Toolbar)

        button_loader.setOnClickListener { loadImages() }

        Picasso.with(this).load("https://static.pexels.com/photos/288264/pexels-photo-288264.jpeg").fetch()
    }

    private fun loadImages() {
        Picasso.with(this)
                .load("https://static.pexels.com/photos/288264/pexels-photo-288264.jpeg")
                .resize(300,300)
//                .centerInside()
            .centerCrop()
            .into(image_top)

//        val context: Context = this

//        Picasso.with(this)
//            .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
//            .fetch(object : Callback {
//                override fun onSuccess() {
//                    image_bottom.alpha = 0f
//                    Picasso.with(context)
//                        .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
//                        .fit()
//                        .into(image_bottom)
//                    image_bottom.animate().setDuration(1000).alpha(1f).start()
//                }
//
//                override fun onError() {
//
//                }
//
//            })

        Picasso.with(this)
            .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
            .fit()
            .transform(CircleTransform())
            .into(image_bottom)

//        Picasso.with(this)
//            .load("https://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
//            .fit()
//            .into(image_bottom)

    }
}
