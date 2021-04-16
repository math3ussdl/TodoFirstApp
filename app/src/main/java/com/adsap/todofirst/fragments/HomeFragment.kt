package com.adsap.todofirst.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.adsap.todofirst.R
import com.adsap.todofirst.activities.MainActivity
import com.adsap.todofirst.models.list.TodoList


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val activity: MainActivity = activity as MainActivity
        val todosList: ArrayList<TodoList> = activity.getLists()

        todosList.forEach {
            print(it.title)
        }

        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}