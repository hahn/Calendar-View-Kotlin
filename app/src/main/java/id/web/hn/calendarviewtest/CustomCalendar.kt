package id.web.hn.calendarviewtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.Toast
import id.web.hn.calendarviewtest.custom.*
import kotlinx.android.synthetic.main.activity_custom_calendar.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CustomCalendar : AppCompatActivity() {

    private val MAX_COLUMN = 7
    lateinit var adapter: CustomCalendarAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_calendar)
        val llm = LinearLayoutManager(applicationContext)
        val grd = GridLayoutManager(applicationContext, MAX_COLUMN)

        rv_jam.layoutManager = llm
        rv_cal.layoutManager = grd
        setupCalendar()

    }

    private fun setupCalendar() {

        val dl: MutableList<CustomCalendarItem> = ArrayList()
        val calendar = Calendar.getInstance()
        val today = Calendar.getInstance().time
        calendar.time = today
        while (dl.size < MAX_COLUMN){
            val cs = CustomCalendarItem(calendar.time)
            dl.add(cs)
            calendar.add(Calendar.DAY_OF_MONTH, 1)
        }

        adapter = CustomCalendarAdapter(dl){
            val sdf = SimpleDateFormat("E, dd MMMM YYYY", Locale.getDefault())
            txt_tanggal.text = sdf.format(it.date.time)
            var x = 0
            val ran = Random()
            val alis: MutableList<AgendaItem> = ArrayList()
            while(alis.size < MAX_COLUMN - ran.nextInt(2..7)){
                val ag = AgendaItem(x, "$x agenda tgl ${sdf.format(it.date.time)} ")
                alis.add(ag)
                x++
            }

            loadAgenda(alis)
    }
        rv_cal.adapter = adapter
        adapter.notifyDataSetChanged()

    }

    private fun loadAgenda(agendaList: List<AgendaItem>) {

        val agendaAdapter = AgendaAdapter(agendaList){
            Toast.makeText(applicationContext, "agenda: ${it.isi}", Toast.LENGTH_SHORT).show()
        }

        rv_jam.adapter = agendaAdapter
        agendaAdapter.notifyDataSetChanged()
    }

    private fun Random.nextInt(range: IntRange): Int =
            range.start + nextInt(range.last - range.start)
}
