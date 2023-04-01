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
        radios.add(Radio("Radio 3: KEXP-FM", "https://live-aacplus-64.kexp.org/kexp64.aac"))
        radios.add(Radio("Radio 4:BBC RADIO 1", "http://bbcmedia.ic.llnwd.net/stream/bbcmedia_radio1_mf_p"))
        radios.add(Radio("Radio 5: Absolute Radio 80s", "http://icy-e-bab-06-cr.sharp-stream.com/absoluteradio80s.mp3"))
        radios.add(Radio("Radio 6: KUTX", "https://kutx.org/wp-content/uploads/2018/08/KUTX-989-2.mp3"))
        radios.add(Radio("Radio 7: The Current", "https://current.stream.publicradio.org/kcmp.mp3"))
        radios.add(Radio("Radio 8: CBC Radio One", "http://cbc_r1_tor.akacast.akamaistream.net/7/469/451661/v1/rc.akacast.akamaistream.net/cbc_r1_tor"))
        radios.add(Radio("Radio 9: NPR News", "https://npr-ice.streamguys1.com/live.mp3"))
        radios.add(Radio("Radio 10: KCRW", "https://kcrw.streamguys1.com/kcrw_192k_mp3_on_air"))

        return radios
    }
}





