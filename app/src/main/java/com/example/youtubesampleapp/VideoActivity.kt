package com.example.youtubesampleapp

import android.os.Bundle
import android.widget.TextView
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

class VideoActivity : YouTubeBaseActivity() {
    private lateinit var videoView: YouTubePlayerView
    private lateinit var txtTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        title = "Video Detail screen"
        videoView = findViewById(R.id.videoView)
        txtTitle = findViewById(R.id.title)

        val b = intent.extras
        var video = Video()

        if (b != null) video = b.getParcelable("video")!!

        txtTitle.text = video.description

        videoView.initialize(
            "AIzaSyC13KQh0kEaSMlFf7TdEPLh3Fp6xznCA6E",
            object : YouTubePlayer.OnInitializedListener {
                override fun onInitializationSuccess(
                    p0: YouTubePlayer.Provider?,
                    p1: YouTubePlayer?,
                    p2: Boolean
                ) {
                    p1?.loadVideo(video.videoId)
                    p1?.play()
                }

                override fun onInitializationFailure(
                    p0: YouTubePlayer.Provider?,
                    p1: YouTubeInitializationResult?
                ) {

                }

            })
    }


}