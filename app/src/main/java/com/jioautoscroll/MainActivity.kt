package com.jioautoscroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import kohii.v1.core.MemoryMode

class MainActivity : AppCompatActivity() {

    private lateinit var viewpager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val kohii = KohiiProvider.get(this)

        viewpager = findViewById(R.id.viewPager)

        kohii.register(this, memoryMode = MemoryMode.HIGH)
            .addBucket(viewpager)
        var videoItems = ArrayList<VideoItem>()

        var item = VideoItem("http://infinityandroid.com/videos/video1.mp4","Celebration")
        var item2 = VideoItem("http://infinityandroid.com/videos/video2.mp4","Party")
        var item3 = VideoItem("https://s3.ap-south-1.amazonaws.com/jep-content/HelloJio/videos/mentalhood/mp4Low/MH_WC_2.mp4","Karishma Kapoor")
        var item4 = VideoItem("http://infinityandroid.com/videos/video4.mp4","Nature")
        var item5 = VideoItem("https://s3.ap-south-1.amazonaws.com/jep-content/HelloJio/videos/made_in_china/mp4Low/MIC-WC-2.mp4","Made in china")
        var item6 = VideoItem("https://s3.ap-south-1.amazonaws.com/jep-content/HelloJio/videos/ragini_mms/mp4Low/RMS-WC-3.mp4","Ragini MMS")
        var item7 = VideoItem("https://s3.ap-south-1.amazonaws.com/jep-content/HelloJio/videos/broken_2/mp4Low/BR-GC-1.mp4","Broken")

        videoItems.add(item)
        videoItems.add(item2)
        videoItems.add(item3)
        videoItems.add(item4)
        videoItems.add(item5)
        videoItems.add(item6)
        videoItems.add(item7)
        viewpager.adapter = VideoAdapter(kohii,videoItems)
        viewpager.offscreenPageLimit = 6

    }
}