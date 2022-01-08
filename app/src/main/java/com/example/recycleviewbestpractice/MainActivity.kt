package com.example.recycleviewbestpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var mainRecyclerViewAdapter: MainRecyclerViewAdapter
    private lateinit var musicList: ArrayList<Music>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        musicList = ArrayList()

        for (i in 0..10){
            musicList.add(Music("Ozodbek Nazarbekov", "Onam", R.drawable.image_music))
        }

        mainRecyclerViewAdapter = MainRecyclerViewAdapter(musicList)

        findViewById<RecyclerView>(R.id.rv_main).apply {
            adapter = mainRecyclerViewAdapter
            layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        }

    }
}