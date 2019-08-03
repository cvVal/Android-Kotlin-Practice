package com.valpu.seve.mylibrary

import android.support.v7.app.AppCompatActivity
import com.valpu.seve.mylibrary.interfaces.Toolbar

open class ToolbarActivity : AppCompatActivity(), Toolbar {

    protected var _toolbar: android.support.v7.widget.Toolbar? = null

    override fun toolbarToLoad(toolbar: android.support.v7.widget.Toolbar?) {

        _toolbar = toolbar
        _toolbar?.let { setSupportActionBar(_toolbar) }
    }

    override fun enabledHomeDisplay(value: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(value)
    }
}
