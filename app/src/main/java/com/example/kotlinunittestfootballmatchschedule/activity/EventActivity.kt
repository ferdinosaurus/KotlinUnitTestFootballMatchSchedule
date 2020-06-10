package com.example.kotlinunittestfootballmatchschedule.activity

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinunittestfootballmatchschedule.api.ApiRepository
import com.example.kotlinunittestfootballmatchschedule.model.Event
import com.example.kotlinunittestfootballmatchschedule.model.LeagueParcelable
import com.example.kotlinunittestfootballmatchschedule.presenter.EventPresenter
import com.example.kotlinunittestfootballmatchschedule.ui.EventUI
import com.example.kotlinunittestfootballmatchschedule.view.EventView
import com.google.gson.Gson
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.setContentView

class EventActivity : AppCompatActivity(), EventView {

    private lateinit var leagueParcelable: LeagueParcelable
    private lateinit var eventUI: EventUI
    private lateinit var eventPresenter: EventPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //leagueId = intent.getStringExtra("ExtraLeagueId")
        leagueParcelable= intent.getParcelableExtra("ExtraLeague")
        eventUI = EventUI(this)
        eventUI.setContentView(this)
        eventPresenter = EventPresenter(this, ApiRepository(),Gson())


        eventPresenter.getPrevEvent(leagueParcelable.id)
        eventUI.buttonPrev.onClick {
            eventPresenter.getPrevEvent(leagueParcelable.id)
        }
        eventUI.buttonNext.onClick {
            eventPresenter.getNextEvent(leagueParcelable.id)
        }

        eventUI.searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                eventPresenter.getSearchEvent(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                eventPresenter.getSearchEvent(newText)
                return false
            }
        })

    }

    override fun showLoading() {
        eventUI.showLoading()
    }

    override fun hideLoading() {
        eventUI.hideLoading()
    }

    override fun showNoEvent() {
        eventUI.showNoEvent()
    }

    override fun showEvent(data: List<Event>) {
        eventUI.showEvent(data)
    }
}
