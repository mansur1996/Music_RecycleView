package com.example.recycleviewbestpractice

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.io.Serializable

class PlayerActivity : AppCompatActivity() {
    lateinit var music: Music
    lateinit var mediaPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        music = SerializableExtra()

        initViews()
    }

    private fun initViews(){
        val tvTitle = findViewById<TextView>(R.id.tv_title_music)
        val tvAlbum = findViewById<TextView>(R.id.tv_album_music)
        val imageMusic = findViewById<ImageView>(R.id.img_music)
        val playButton = findViewById<Button>(R.id.btn_play_music)

        tvTitle.text = music.title
        tvAlbum.text = music.album
        imageMusic.setImageResource(music.image)

        mediaPlayer = MediaPlayer.create(this, music.file)
        playButton.setOnClickListener{
            if(!mediaPlayer.isPlaying){
                mediaPlayer.start()
                playButton.setText("Stop")
            }else{
                playButton.setText("Start")
                mediaPlayer.pause()
            }
        }
    }
    private fun SerializableExtra() : Music{
        return intent.getSerializableExtra("music") as Music
    }
}