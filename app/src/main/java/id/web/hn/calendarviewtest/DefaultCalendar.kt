package id.web.hn.calendarviewtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_default_calendar.*
import java.text.SimpleDateFormat
import java.util.*

class DefaultCalendar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_default_calendar)

        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.US)
        val tgl = SimpleDateFormat("dd", Locale.US)
        val now = Date().time
        val cal = Calendar.getInstance()
        cal.add(Calendar.DAY_OF_YEAR, 6)
        val minggu = cal.time

        calendar.minDate = now
        calendar.maxDate = minggu.time
        calendar.firstDayOfWeek = tgl.format(now).toInt()
        
        calendar.setOnDateChangeListener { calendarView, year, month, day ->
            Toast.makeText(applicationContext, "year: $day", Toast.LENGTH_SHORT).show()
        }


    }
}
