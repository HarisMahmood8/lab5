package com.example.k2022_03_09_radio

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RadioAdapter(private val radios: ArrayList<Radio>) :
    RecyclerView.Adapter<RadioAdapter.RadioViewHolder>() {
    private var selectedRadioPosition = -1
    private var selectedRadio: MediaPlayer? = null

    inner class RadioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvTitle)
        val streamUrl: TextView = itemView.findViewById(R.id.tvFrequency)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.radio_item, parent, false)
        return RadioViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RadioViewHolder, position: Int) {
        val radio = radios[position]

        holder.name.text = radio.name
        holder.streamUrl.text = radio.streamUrl

        holder.itemView.setOnClickListener {
            if (selectedRadioPosition == holder.adapterPosition) {
                if (selectedRadio != null && selectedRadio!!.isPlaying) {
                    selectedRadio!!.stop()
                }
                selectedRadio = null
                selectedRadioPosition = RecyclerView.NO_POSITION
            } else {
                if (selectedRadio != null && selectedRadio!!.isPlaying) {
                    selectedRadio!!.stop()
                }

                selectedRadio = MediaPlayer()
                selectedRadio!!.setAudioAttributes(
                    AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
                )
                selectedRadio!!.setDataSource(radio.streamUrl)
                selectedRadio!!.prepareAsync()

                selectedRadio!!.setOnPreparedListener {
                    selectedRadio!!.start()
                }

                selectedRadioPosition = holder.adapterPosition
            }
        }
    }



    override fun getItemCount(): Int {
        return radios.size
    }
}

