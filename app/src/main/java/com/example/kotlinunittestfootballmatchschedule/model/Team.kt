package com.example.kotlinunittestfootballmatchschedule.model

import com.google.gson.annotations.SerializedName

class Team {
    @SerializedName("idTeam")
    var idTeam: String? = null

    @SerializedName("strTeam")
    var strTeam: String? = null

    @SerializedName("strTeamBadge")
    var strTeamBadge: String? = null

}