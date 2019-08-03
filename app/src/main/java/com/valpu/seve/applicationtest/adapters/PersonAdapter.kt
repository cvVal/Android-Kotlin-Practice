package com.valpu.seve.applicationtest.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.valpu.seve.applicationtest.models.Person
import com.valpu.seve.applicationtest.others.inflate
import kotlinx.android.synthetic.main.list_view_person.view.*

class PersonAdapter(val context: Context, var layout: Int, private val list: List<Person>) : BaseAdapter() {

    //private val myInflater: LayoutInflater = LayoutInflater.from(context) Substitution by extension function

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view: View
        val viewHolder: PersonViewHolder

        if (convertView == null) {

            //view = myInflater.inflate(layout, parent, false) Substitution by extension function
            view = parent.inflate(layout)
            viewHolder = PersonViewHolder(view)
            view.tag = viewHolder

        } else {

            view = convertView
            viewHolder = view.tag as PersonViewHolder
        }

        val fullName = "${list[position].firstName}, ${list[position].lastName}"
        viewHolder.fullName.text = fullName
        viewHolder.age.text = "${list[position].age}"

        return view
    }
}

private class PersonViewHolder(view: View) {
    val fullName: TextView = view.tv_name
    val age: TextView = view.tv_age
}