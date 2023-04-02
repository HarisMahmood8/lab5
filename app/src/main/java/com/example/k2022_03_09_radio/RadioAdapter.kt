package com.example.k2022_03_09_radio

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RadioAdapter(private val radios: ArrayList<Radio>) :
    RecyclerView.Adapter<RadioAdapter.RadioViewHolder>() {
    private var selectedRadioPosition = -1
    private var selectedRadio: MediaPlayer? = null
    private val radioImages = arrayListOf(
        R.drawable.radio1,
        R.drawable.radio2,
        R.drawable.radio3,
        R.drawable.radio4,
        R.drawable.radio5,
        R.drawable.radio6,
        R.drawable.radio7,
        R.drawable.radio8,
        R.drawable.radio9,
        R.drawable.radio10
    )

    inner class RadioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvTitle)
        val streamUrl: TextView = itemView.findViewById(R.id.tvFrequency)
        val imageView: ImageView = itemView.findViewById(R.id.ivRadio)
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

        val imageResource = when (radio.name) {
            "Radio 1: Jazz24" -> R.drawable.radio1
            "Radio 2: WNYC-FM" -> R.drawable.radio2
            "Radio 3: HEART FM" -> R.drawable.radio3
            "Radio 4: Smooth Radio" -> R.drawable.radio4
            "Radio 5: TalkSPORT" -> R.drawable.radio5
            "Radio 6: Radio Paradise" -> R.drawable.radio6
            "Radio 7: The Current" -> R.drawable.radio7
            "Radio 8: Awesome 80s" -> R.drawable.radio8
            "Radio 9: Capital XTRA" -> R.drawable.radio9
            "Radio 10: KCRW" -> R.drawable.radio10
            else -> R.drawable.radio1
        }

        holder.imageView.setImageResource(imageResource)

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

