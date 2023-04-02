package com.example.k2022_03_09_radio

import com.example.k2022_03_09_radio.RadioAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RadioAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = RadioAdapter(getRadios())
        recyclerView.adapter = adapter
    }

    private fun getRadios(): ArrayList<Radio> {
        val radios = ArrayList<Radio>()

        radios.add(Radio("Radio 1: Jazz24", "http://icecast.omroep.nl/radio2-bb-mp3"))
        radios.add(Radio("Radio 2: WNYC-FM", "http://fm939.wnyc.org/wnycfm"))
        radios.add(Radio("Radio 3: HEART FM", "http://media-the.musicradio.com/HeartLondonMP3"))
        radios.add(Radio("Radio 4: Smooth Radio", "http://media-the.musicradio.com/SmoothUKMP3"))
        radios.add(Radio("Radio 5: TalkSPORT", "https://radio.talksport.com/stream?aw_0_1st.collectionid=4527&aw_0_1st.skey=1619979784"))
        radios.add(Radio("Radio 6: Radio Paradise", "http://stream.radioparadise.com/mp3-192"))
        radios.add(Radio("Radio 7: The Current", "https://current.stream.publicradio.org/kcmp.mp3"))
        radios.add(Radio("Radio 8: Awesome 80s", "http://listen.181fm.com/181-awesome80s_128k.mp3"))
        radios.add(Radio("Radio 9: Capital XTRA", "http://media-the.musicradio.com/CapitalXTRALondonMP3"))
        radios.add(Radio("Radio 10: KCRW", "https://kcrw.streamguys1.com/kcrw_192k_mp3_on_air"))

        return radios
    }
}





