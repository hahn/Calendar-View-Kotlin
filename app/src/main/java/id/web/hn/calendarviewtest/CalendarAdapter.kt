package id.web.hn.calendarviewtest

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.AdapterView
import kotlinx.android.synthetic.main.view_calendar_item.view.*

/**
 * Created by hahn on 04.10.17.
 * Project: CalendarViewTest
 */


data class CalendarItem(val nama: String, val id: Int)

class CalendarAdapter(val items: List<CalendarItem>, val listener: (CalendarItem)-> Unit):
        RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_calendar_item, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    override fun getItemCount(): Int = items.size


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(item: CalendarItem, listener: (CalendarItem) -> Unit) = with(itemView){
            itemView.rv_txt_item.text = item.nama

            setOnClickListener{ listener(item) }
        }

    }

}