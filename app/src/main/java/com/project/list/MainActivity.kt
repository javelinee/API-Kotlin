package com.project.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.list.Adapter.FileAdapter
import com.project.list.Data.BookData
import com.project.list.Interface.Base
import com.project.list.Interface.BookInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    lateinit var fileAdapter : FileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv.layoutManager = LinearLayoutManager(this)
        fileAdapter = FileAdapter(this, listOf())
        rv.adapter = fileAdapter

        data()
    }

    fun data(){
        val apiData = Base.retrofit.create(BookInterface::class.java)
        val api = apiData.getData()

        api.enqueue(object : retrofit2.Callback<List<BookData>>{
            override fun onFailure(call: Call<List<BookData>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Cannot call API", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<BookData>>, response: Response<List<BookData>>) {
                fileAdapter.setBook(response.body()!!)
            }
        })
    }
}
