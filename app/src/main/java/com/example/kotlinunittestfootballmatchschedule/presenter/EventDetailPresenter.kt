package com.example.kotlinunittestfootballmatchschedule.presenter

import com.example.kotlinunittestfootballmatchschedule.api.ApiRepository
import com.example.kotlinunittestfootballmatchschedule.api.TheSportDBApi
import com.example.kotlinunittestfootballmatchschedule.model.EventResponse
import com.example.kotlinunittestfootballmatchschedule.model.TeamsResponse
import com.example.kotlinunittestfootballmatchschedule.view.EventDetailView
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class EventDetailPresenter(private val view: EventDetailView,
                           private val apiRepository: ApiRepository,
                           private val gson: Gson) {
    fun getEventDetail(eventId: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getDetailEvent(eventId)),
                EventResponse::class.java
            )
            uiThread {
                if(data.events!=null){
                    data.events[0]
                    view.showDetailEvent(data.events[0])
                }else{
                    view.showNoEvent()
                }
                view.hideLoading()
            }
        }
    }

    fun getDetailTeam(teamHomeId: String?,teamAwayId: String?){
        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getDetailTeam(teamHomeId)),
                TeamsResponse::class.java
            )
            uiThread {
                if(data.teams!=null){
                    view.showDetailHome(data.teams[0])
                }
            }
        }

        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getDetailTeam(teamAwayId)),
                TeamsResponse::class.java
            )
            uiThread {
                if(data.teams!=null){
                    view.showDetailAway(data.teams[0])
                }
            }
        }
    }
}