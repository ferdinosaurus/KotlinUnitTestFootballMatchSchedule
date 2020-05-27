package com.example.kotlinunittestfootballmatchschedule.ui

import android.app.Activity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinunittestfootballmatchschedule.activity.EventActivity
import com.example.kotlinunittestfootballmatchschedule.activity.EventDetailActivity
import com.example.kotlinunittestfootballmatchschedule.adapter.EventAdapter
import com.example.kotlinunittestfootballmatchschedule.model.Event
import com.example.kotlinunittestfootballmatchschedule.view.EventView
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk27.coroutines.onQueryTextListener

class EventUI(activity: Activity) : AnkoComponent<EventActivity>, EventView {

    private var activity:Activity = activity
    private lateinit var recyclerView:RecyclerView

    lateinit var buttonPrev:Button
    lateinit var buttonNext:Button
    lateinit var searchView:SearchView


    private var events: MutableList<Event> = mutableListOf()
    private lateinit var progressBar:ProgressBar


    override fun createView(ui: AnkoContext<EventActivity>) = with(ui) {
        linearLayout {

            padding = dip(16)

            lparams (width = matchParent, height = matchParent)
            orientation = LinearLayout.VERTICAL

            searchView = searchView {
                onQueryTextListener {

                }

            }.lparams(matchParent, wrapContent)

            linearLayout {
                lparams(matchParent, wrapContent)
                orientation = LinearLayout.HORIZONTAL

                buttonPrev = button {
                    text = "prev"
                }.lparams{
                    width = dip(0)
                    height = matchParent
                    weight = 1F
                }


                buttonNext = button {
                    text = "next"
                }.lparams{
                    width = dip(0)
                    height = matchParent
                    weight = 1F
                }

            }

            progressBar = progressBar {
            }.lparams(matchParent, wrapContent)

            recyclerView = recyclerView {
                lparams(matchParent, wrapContent)

                layoutManager = LinearLayoutManager(context)
                adapter = EventAdapter(context,events){
                    context.toast("id = "+it.idEvent)
                }
            }

        }
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showNoEvent() {
        recyclerView.visibility = View.GONE
    }

    override fun showEvent(data: List<Event>){

        recyclerView.visibility = View.VISIBLE
        recyclerView.adapter = EventAdapter(activity,data as MutableList<Event>){
            activity.startActivity<EventDetailActivity>("extraEventId" to it.idEvent)

        }
    }
}