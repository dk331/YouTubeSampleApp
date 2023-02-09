package com.example.youtubesampleapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var videos: List<Video>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Video List screen"
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val json = "[\n" +
                "  {\n" +
                "    \"title\": \"Watch Sky News live\",\n" +
                "    \"description\": \"Watch Sky News live. Today's top story: the world marks 20 years since the September 11th attacks on the World Trade Center and the Pentagon.\",\n" +
                "    \"thumbnail\": \"https://i.ytimg.com/vi/9Auq9mYxFEE/maxresdefault_live.jpg\",\n" +
                "    \"videoId\": \"9Auq9mYxFEE\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"title\": \"DW News livestream | Headline news from around the world\",\n" +
                "    \"description\": \"DW News goes deep beneath the surface, providing the key stories from Europe and around the world.\",\n" +
                "    \"thumbnail\": \"https://i.ytimg.com/vi/GE_SfNVNyqk/maxresdefault_live.jpg\",\n" +
                "    \"videoId\": \"GE_SfNVNyqk\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"title\": \"FRANCE 24 English – LIVE\",\n" +
                "    \"description\": \"Watch FRANCE 24 live in English on YouTube for free: all the latest International News broadcasted from Paris, France.\",\n" +
                "    \"thumbnail\": \"https://i.ytimg.com/vi/h3MuIUNCCzI/maxresdefault_live.jpg\",\n" +
                "    \"videoId\": \"h3MuIUNCCzI\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"title\": \"Talaash || Search || Motivational Story || @MUSA TANVEER\",\n" +
                "    \"description\": \"Watch Sky News live. Today's top story: the world marks 20 years since the September 11th attacks on the World Trade Center and the Pentagon.\",\n" +
                "    \"thumbnail\": \"https://i.ytimg.com/vi/iTE7hkpt50s/maxresdefault.jpg\",\n" +
                "    \"videoId\": \"iTE7hkpt50s\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"title\": \"Don’t Underestimate Indian Kid Don’t Miss End #shorts #youtubeshorts | Samayra Narula \",\n" +
                "    \"description\": \"Hope you like this video and please don’t forget to Subscribe this channel Press Bell Button for more update https://m.youtube.com/c/samayranarulaofficialFollow My Instagram Instagram : https://www.instagram.com/samayranarula?r=nametagLike\",\n" +
                "    \"thumbnail\": \"https://i.ytimg.com/vi/uvOzYLG7HSE/maxresdefault.jpg\",\n" +
                "    \"videoId\": \"9Auq9mYxFEE\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"title\": \"Machine Gun Kelly's AWKWARD Interview: \\\"Ask Better Questions\\\" | Daily Pop | E! News\",\n" +
                "    \"description\": \"After the \\\"Bloody Valentine\\\" singer seemed to become agitated during a \\\"Sunday TODAY\\\" interview, host Willie Geist suggests to pull the plug. Watch the tense moment!Watch “Daily Pop” Weekdays at 8am PT | 11am ET.#MachineGunKelly #ENews #DailyPop #WillieGeistSubscribe:\",\n" +
                "    \"thumbnail\": \"https://i.ytimg.com/vi/TK93uOXzn4Q/maxresdefault.jpg\",\n" +
                "    \"videoId\": \"TK93uOXzn4Q\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"title\": \"Timothee Chalamet Shares A First Look At Warner Bros. Upcoming Film ‘Wonka’ | THR News\",\n" +
                "    \"description\": \"Timothee Chalamet offered a first look at Warner Bros. upcoming film, ‘Wonka.’ To learn more about this story: https://www.hollywoodreporter.com/movies/movie-news/timothee-chalamet-wonka-first-look-warner-bros-1235029366/ ►►Subscribe for more entertainment news: See our latest videos: http://thr.cm/syLedfw\",\n" +
                "    \"thumbnail\": \"https://i.ytimg.com/vi/ouCyd0vzpYc/maxresdefault.jpg\",\n" +
                "    \"videoId\": \"ouCyd0vzpYc\"\n" +
                "  }\n" +
                "]"

        videos = Gson().fromJson(json, Array<Video>::class.java).asList()
        val videoAdapter = VideoAdapter(videos!!)
        recyclerView.adapter = videoAdapter
    }
}