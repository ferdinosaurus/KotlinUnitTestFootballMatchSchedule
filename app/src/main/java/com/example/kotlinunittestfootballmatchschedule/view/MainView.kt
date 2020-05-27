package com.example.kotlinunittestfootballmatchschedule.view

import com.example.kotlinunittestfootballmatchschedule.model.LeagueParcelable


interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showLeagueList(data: List<LeagueParcelable>)


}