package id.web.hn.calendarviewtest.custom

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.web.hn.calendarviewtest.R
import kotlinx.android.synthetic.main.custom_calendar_agenda_item.view.*
import kotlinx.android.synthetic.main.custom_calendar_single_cell.view.*
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by hahn on 04.10.17.
 * Project: CalendarViewTest
 */

// untuk tanggal
//data class CustomCalendarItem(val day: String, val tgl: String)
data class CustomCalendarItem(val date: Date)

//untuk handle jam poli

data class AgendaItem(val id: Int, val isi: String)

class CustomCalendarAdapter(val items: List<CustomCalendarItem>, val listener: (CustomCalendarItem) -> Unit):
        RecyclerView.Adapter<CustomCalendarAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.custom_calendar_single_cell, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(items[position], listener)

    }

    override fun getItemCount(): Int = items.size


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(item: CustomCalendarItem, listener: (CustomCalendarItem) -> Unit) = with(itemView){
            val sdf = SimpleDateFormat("dd", Locale.getDefault())
            val sdfHari = SimpleDateFormat("E", Locale.getDefault())
            calendar_date_hari.text = sdfHari.format(item.date)
            calendar_date_tgl.text = sdf.format(item.date)

            setOnClickListener{ listener(item) }
        }

    }

}

class AgendaAdapter(val items: List<AgendaItem>, val listener: (AgendaItem) -> Unit):
        RecyclerView.Adapter<AgendaAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.custom_calendar_agenda_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
          holder.bind(items[position], listener)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(item: AgendaItem, listener: (AgendaItem) -> Unit) = with(itemView){
            itemView.agenda_id.text = item.id.toString()
            itemView.agenda_isi.text = item.isi
            Log.d("TAG", "agenda text: ${item.isi}")

            setOnClickListener{ listener(item) }

        }

    }

}