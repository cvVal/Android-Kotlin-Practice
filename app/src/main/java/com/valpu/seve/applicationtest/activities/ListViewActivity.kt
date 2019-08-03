package com.valpu.seve.applicationtest.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.valpu.seve.applicationtest.R
import com.valpu.seve.applicationtest.adapters.PersonAdapter
import com.valpu.seve.applicationtest.models.Person
import com.valpu.seve.mylibrary.ToolbarActivity
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : ToolbarActivity() {

    private lateinit var adapter: PersonAdapter
    private lateinit var peopleList: List<Person>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        toolbarToLoad(toolbar as Toolbar)

        peopleList = getPersons()
        adapter = PersonAdapter(this, R.layout.list_view_person, peopleList)
        list_view.adapter = adapter
    }

    private fun getPersons() : List<Person> {

        return listOf(
            Person("Seve", "Valdez", 28),
            Person("Fer", "Gonzalez", 29),
            Person("Al", "Delgado", 38),
            Person("Finick", "Zoo", 20),
            Person("Frozone", "Incredible", 35),
            Person("Aladin", "Aladinne", 26),
            Person("Yax", "Zoo", 30),
            Person("Perl", "Rabbit", 27),
            Person("Judy", "Hopps", 22),
            Person("Cv", "Valdez", 28),
            Person("Fernanda", "Gonzalez", 29),
            Person("Esther", "Delgado", 38),
            Person("MR. I", "Zoo", 20),
            Person("Jack Jack", "Incredible", 35),
            Person("Persa", "Aladinne", 26),
            Person("Chief Bogo", "Zoo", 30),
            Person("Perl", "Rabbit", 27),
            Person("Mickey", "Mouse", 22)
        )
    }
}
