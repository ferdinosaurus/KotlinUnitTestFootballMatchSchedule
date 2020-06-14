package com.example.kotlinunittestfootballmatchschedule.presenter

import android.app.Activity
import com.example.kotlinunittestfootballmatchschedule.R
import com.example.kotlinunittestfootballmatchschedule.model.LeagueParcelable
import com.example.kotlinunittestfootballmatchschedule.view.MainView

class MainPresenter(private val activity: Activity,
                    private val view: MainView
                    ) {


    fun setupData(){
        view.showLoading()

        val leagueParcelables: MutableList<LeagueParcelable> = mutableListOf()



        val leagueId = activity.resources.getStringArray(R.array.league_id)
        val leagueName = activity.resources.getStringArray(R.array.league_name)
        val leagueImage = activity.resources.obtainTypedArray(R.array.league_image)
        val leagueDesc = activity.resources.getStringArray(R.array.league_desc)


        for (i in leagueName.indices){
            leagueParcelables.add(LeagueParcelable(leagueId[i],leagueName[i],leagueImage.getResourceId(i,0),
                leagueDesc[i]
            ))
        }

        view.showLeagueList(leagueParcelables)

        view.hideLoading()
    }
}