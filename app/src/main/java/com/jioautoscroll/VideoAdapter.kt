package com.jioautoscroll

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import kohii.v1.core.Common
import kohii.v1.core.Playback
import kohii.v1.core.Playback.Controller
import kohii.v1.exoplayer.Kohii

class VideoAdapter(
  private val kohii: Kohii,val videoItems: List<VideoItem>) : Adapter<PlayerViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
    val view = LayoutInflater.from(parent.context)
      .inflate(R.layout.holder_video_item, parent, false)
    return PlayerViewHolder(view)
  }


  override fun getItemCount(): Int = videoItems.size

  override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
    val videoItem = videoItems.get(position)
    kohii.setUp(videoItem.url) {
      tag = "${videoItem.url}+${position}"
      preload = true
      repeatMode = Common.REPEAT_MODE_ONE
      controller = object : Controller {
        override fun kohiiCanStart(): Boolean = true
        override fun kohiiCanPause(): Boolean = true
        override fun setupRenderer(playback: Playback, renderer: Any?) {
          holder.playerContainer.setOnClickListener {
            val playable = playback.playable ?: return@setOnClickListener
            if (playable.isPlaying()) {
              playback.manager.pause(playable)
            } else {
              playback.manager.play(playable)
            }
          }
        }

        override fun teardownRenderer(playback: Playback, renderer: Any?) {
          holder.playerContainer.setOnClickListener(null)
        }
      }
    }.bind(holder.playerView)
  }
}
