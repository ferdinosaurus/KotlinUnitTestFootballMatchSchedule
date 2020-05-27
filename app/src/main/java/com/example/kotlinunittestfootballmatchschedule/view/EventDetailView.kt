package com.example.kotlinunittestfootballmatchschedule.view

import com.example.kotlinunittestfootballmatchschedule.model.Event
import com.example.kotlinunittestfootballmatchschedule.model.Team

interface EventDetailView{
    fun showLoading()
    fun hideLoading()
    fun showNoEvent()
    fun showDetailEvent(data: Event)
    fun showDetailHome(data: Team)
    fun showDetailAway(data: Team)

}