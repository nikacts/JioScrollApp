package com.jioautoscroll

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class PlayerViewHolder(itemView: View) : ViewHolder(itemView) {

  val playerContainer: ViewGroup = itemView.findViewById(R.id.playerContainer)
  val playerView: ViewGroup = itemView.findViewById(R.id.playerView)
}
