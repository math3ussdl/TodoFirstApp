package com.adsap.todofirst.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.adsap.todofirst.R
import com.adsap.todofirst.api.endpoints.TodoListEndpoint
import com.adsap.todofirst.api.endpoints.UserEndpoint
import com.adsap.todofirst.fragments.HomeFragment
import com.adsap.todofirst.fragments.ListsFragment
import com.adsap.todofirst.fragments.SettingsFragment
import com.adsap.todofirst.fragments.UsersFragment
import com.adsap.todofirst.models.list.TodoList
import com.adsap.todofirst.models.list.TodoListsResponse
import com.adsap.todofirst.models.user.UsersResponse
import com.adsap.todofirst.utils.NetworkUtils
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chipBar = findViewById<ChipNavigationBar>(R.id.chip_nav_bar)
        val homeFragment = HomeFragment()
        val usersFragment = UsersFragment()
        val listsFragment = ListsFragment()
        val settingsFragment = SettingsFragment()

        makeCurrentFragment(homeFragment)

        chipBar.setItemSelected(R.id.mi_home)
        chipBar.setOnItemSelectedListener {
            when (it) {
                R.id.mi_home -> makeCurrentFragment(homeFragment)
                R.id.mi_users -> makeCurrentFragment(usersFragment)
                R.id.mi_lists -> makeCurrentFragment(listsFragment)
                R.id.mi_settings -> makeCurrentFragment(settingsFragment)
            }
        }
    }

    fun getLists(): ArrayList<TodoList> {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("http://10.0.2.2:8000/api/")

        val todoListEndpoint = retrofitClient.create(TodoListEndpoint::class.java)
        val cb = todoListEndpoint.getLists()
        val list: ArrayList<TodoList> = ArrayList()

        cb.enqueue(object : Callback<TodoListsResponse> {
            override fun onFailure(call: Call<TodoListsResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<TodoListsResponse>, response: Response<TodoListsResponse>) {
                if (response.isSuccessful) {
                    response.body()?.data?.forEach {
                        list.add(it)
                    }
                } else {
                    Toast.makeText(baseContext, "Something went wrong!!", Toast.LENGTH_SHORT).show()
                }
            }
        })

        return list
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}