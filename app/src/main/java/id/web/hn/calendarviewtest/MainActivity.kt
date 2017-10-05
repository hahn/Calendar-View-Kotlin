package id.web.hn.calendarviewtest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG = "WADADADA"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter: CalendarAdapter
        val layoutManager= LinearLayoutManager(applicationContext)
        val calendar1 = CalendarItem("Default Calendar", 1)
        val calendar2 = CalendarItem("Material Calendar", 2)
        val calendar3 = CalendarItem("Ketiga", 3)

        val items = arrayListOf(calendar1, calendar2, calendar3)


        adapter = CalendarAdapter(items as List<CalendarItem>){

            val pos = it.id
            loadcalendar(pos)
        }
        rv.layoutManager = layoutManager
        rv.adapter = adapter
        adapter.notifyDataSetChanged()


    }

    private fun loadcalendar(pos: Int){
        val intent : Intent
        when(pos){
            1 -> intent = Intent(this, DefaultCalendar::class.java)
            2 -> intent = Intent(this, MaterialCalendar::class.java)
            3 -> intent = Intent(this, CustomCalendar::class.java)
            else -> intent = Intent(this, DefaultCalendar::class.java)
        }

        startActivity(intent)
    }
}
