package com.example.kotlinunittestfootballmatchschedule.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinunittestfootballmatchschedule.model.Event
import com.example.kotlinunittestfootballmatchschedule.ui.EventItemUI
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext

class EventAdapter(private val context: Context, private val items: MutableList<Event>, private val listener:(Event) ->Unit )
    : RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(EventItemUI().createView(AnkoContext.create(context,parent)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position],listener)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        private var tvEventName: TextView = itemView.findViewById(EventItemUI.tvEventName)
        private var tvEventDate: TextView = itemView.findViewById(EventItemUI.tvEventDate)


        fun bindItem(items: Event, listener: (Event) -> Unit) {
            tvEventName.text = items.strEvent
            tvEventDate.text = items.dateEvent

            containerView.setOnClickListener { listener(items) }
        }
    }
}