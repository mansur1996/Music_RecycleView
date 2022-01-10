package com.example.recycleviewbestpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var mainRecyclerViewAdapter: MainRecyclerViewAdapter
    private lateinit var musicList: ArrayList<Music>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        musicList = ArrayList()

        for (i in 0..10){
            musicList.add(Music("Yulduz Usmonova", "Muxabbat", R.drawable.image_music, R.raw.music))
        }
        val mainRv = findViewById<RecyclerView>(R.id.rv_main)

        mainRecyclerViewAdapter = MainRecyclerViewAdapter(musicList, MainRecyclerViewAdapter.ItemClickListener{
            //Snackbar.make(mainRv, "$it", Snackbar.LENGTH_LONG).show()
            startPlayerActivity(it)
        })

        findViewById<RecyclerView>(R.id.rv_main).apply {
            adapter = mainRecyclerViewAdapter
            layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        }

        mainRv.adapter = mainRecyclerViewAdapter
        mainRv.layoutManager = LinearLayoutManager(this)
    }
    private fun startPlayerActivity(music: Music){
        val intent = Intent(this, PlayerActivity::class.java)
        intent.putExtra("music", music)
        startActivity(intent)
    }
}