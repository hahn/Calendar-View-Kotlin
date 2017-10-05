package id.web.hn.calendarviewtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CalendarView
import com.prolificinteractive.materialcalendarview.CalendarDay
import kotlinx.android.synthetic.main.activity_material_calendar.*
import java.util.*

class MaterialCalendar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_calendar)

//        calendarView.selectedDate
        val min = calendarView.currentDate
        Log.d("TAG", "date: ${min.date}")

        val cal = Calendar.getInstance()
        val today = cal.time
        cal.add(Calendar.DAY_OF_YEAR, 12)
        val minggu = cal.time
        val cminggu = CalendarDay.from(minggu)
        val ctoday = CalendarDay.today()
        calendarView.currentDate = cminggu


        Log.d("TAG", "sudah diganti: ${calendarView.currentDate.date}")

        calendarView.setOnClickListener { view ->
            Log.d("TAG", "date: ")
        }

    }
}
