package com.example.kotlinunittestfootballmatchschedule.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinunittestfootballmatchschedule.R
import com.example.kotlinunittestfootballmatchschedule.api.ApiRepository
import com.example.kotlinunittestfootballmatchschedule.model.Event
import com.example.kotlinunittestfootballmatchschedule.model.Team
import com.example.kotlinunittestfootballmatchschedule.presenter.EventDetailPresenter
import com.example.kotlinunittestfootballmatchschedule.ui.EventDetailUI
import com.example.kotlinunittestfootballmatchschedule.view.EventDetailView
import com.google.gson.Gson
import org.jetbrains.anko.setContentView

class EventDetailActivity : AppCompatActivity(), EventDetailView {

    private lateinit var eventDetailUI: EventDetailUI

    private lateinit var eventDetailPresenter: EventDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val eventId = intent.getStringExtra("extraEventId")
        setContentView(R.layout.activity_event_detail)
        eventDetailUI = EventDetailUI(this)
        eventDetailUI.setContentView(this)

        eventDetailPresenter = EventDetailPresenter(this,ApiRepository(), Gson())

        eventDetailPresenter.getEventDetail(eventId)

    }

    override fun showLoading() {
        eventDetailUI.showLoading()
    }

    override fun hideLoading() {
        eventDetailUI.hideLoading()
    }

    override fun showNoEvent() {
        eventDetailUI.showNoEvent()
    }

    override fun showDetailEvent(data: Event) {
        eventDetailUI.showDetailEvent(data)
        eventDetailPresenter.getDetailTeam(data.idHomeTeam,data.idAwayTeam)
    }

    override fun showDetailHome(data: Team) {
        eventDetailUI.showDetailHome(data)
    }

    override fun showDetailAway(data: Team) {
        eventDetailUI.showDetailAway(data)
    }
}
