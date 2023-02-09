package com.example.youtubesampleapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.view.*
import android.view.View.OnTouchListener
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.recyclerview.widget.RecyclerView


class VideoAdapter internal constructor(private val videoList: List<Video>) :
    RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.video_view, parent, false)
        return VideoViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.videoWeb.loadData(
            "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/" + videoList[position].videoId!! + "?autoplay=1\" frameborder=\"0\" allowfullscreen></iframe>",
            "text/html",
            "utf-8"
        )

        //holder.videoWeb.loadUrl("https://www.youtube.com/embed/" + videoList[position].videoId!! + "?autoplay=1")

        /*holder.videoWeb.setOnTouchListener(object :OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                val intent = Intent(holder.context, VideoActivity::class.java)
                val b = Bundle()
                b.putParcelable("video", videoList[holder.adapterPosition])

                intent.putExtras(b)

                holder.context.startActivity(intent)
                return true
            }
        })*/

        /*holder.itemView.setOnClickListener(object : OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(holder.context, VideoActivity::class.java)
                val b = Bundle()
                b.putParcelable("video", videoList[holder.adapterPosition])

                intent.putExtras(b)

                holder.context.startActivity(intent)
            }

        })*/
        /*holder.videoWeb.initialize(
            "GOOGLE_CLOUD_KEY", // Hidden for the security purpose
            object : YouTubePlayer.OnInitializedListener {
                override fun onInitializationSuccess(
                    p0: YouTubePlayer.Provider?,
                    p1: YouTubePlayer?,
                    p2: Boolean
                ) {
                    p1?.loadVideo(videoList[holder.adapterPosition].videoId)
                    p1?.play()
                }

                override fun onInitializationFailure(
                    p0: YouTubePlayer.Provider?,
                    p1: YouTubeInitializationResult?
                ) {

                }
            })
        holder.videoWeb.setOnClickListener(object :OnClickListener{
            override fun onClick(v: View?) {
                val intent = Intent(holder.context, VideoActivity::class.java)
                val b = Bundle()
                b.putParcelable("video", videoList[holder.adapterPosition])

                intent.putExtras(b)

                holder.context.startActivity(intent)
            }

        })*/
    }

    inner class VideoViewHolder(itemView: View, context: Context) :
        RecyclerView.ViewHolder(itemView) {
        var videoWeb: WebView = itemView.findViewById(R.id.webView)
        var context = context

        init {
            videoWeb.settings.javaScriptEnabled = true
            /*videoWeb.settings.domStorageEnabled = true
            videoWeb.isClickable = true*/
            videoWeb.setOnTouchListener(OnTouchListener { v, event ->

                if (v.id === R.id.webView
                    && event.action == MotionEvent.ACTION_DOWN
                ) {
                    val intent = Intent(context, VideoActivity::class.java)
                    val b = Bundle()
                    b.putParcelable("video", videoList[adapterPosition])

                    intent.putExtras(b)

                    context.startActivity(intent)
                }
                false
            })
            videoWeb.webViewClient = object : WebViewClient() {}
        }
    }

    override fun getItemCount(): Int {
        return videoList.size
    }

    private class AutoPlayVideoWebViewClient : WebViewClient() {
        override fun onPageFinished(view: WebView, url: String) {
            super.onPageFinished(view, url)
            val delta: Long = 100
            val downTime = SystemClock.uptimeMillis()
            val x = (view.left + view.width / 2).toFloat()
            val y = (view.top + view.height / 2).toFloat()
            val tapDownEvent =
                MotionEvent.obtain(downTime, downTime + delta, MotionEvent.ACTION_DOWN, x, y, 0)
            tapDownEvent.source = InputDevice.SOURCE_CLASS_POINTER
            val tapUpEvent =
                MotionEvent.obtain(downTime, downTime + delta + 2, MotionEvent.ACTION_UP, x, y, 0)
            tapUpEvent.source = InputDevice.SOURCE_CLASS_POINTER
            view.dispatchTouchEvent(tapDownEvent)
            view.dispatchTouchEvent(tapUpEvent)
        }
    }
}