package com.example.kotlinunittestfootballmatchschedule.view

import com.example.kotlinunittestfootballmatchschedule.model.Event


interface EventView{
    fun showLoading()
    fun hideLoading()
    fun showNoEvent()
    fun showEvent(data: List<Event>)
}