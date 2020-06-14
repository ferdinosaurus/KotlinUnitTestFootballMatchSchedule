package com.example.kotlinunittestfootballmatchschedule.database.model


data class FavoriteModel(
    val id: Long?,
    val idEvent: String?,
    val dateEvent: String?,
    val strStatus:String?,
    val strTime: String?,
    val strEvent: String?,
    val strSport: String?,
    val strLeague: String?,
    val strHomeTeam: String?,
    val strAwayTeam: String?,
    val intHomeScore: String?,
    val intAwayScore: String?
)

{
    companion object {
        const val TABLE_FAVORITE: String = "TABLE_FAVORITE"
        const val ID: String = "ID_"
        const val ID_EVENT: String = "ID_EVENT"
        const val STR_DATEEV: String = "STR_DATEEV"
        const val STR_STATUS:String = "STR_STATUS"
        const val STR_TIMEEV: String = "STR_TIMEEV"
        const val STR_EVENT: String = "STR_EVENT"
        const val STR_SPORT: String = "STR_SPORT"
        const val STR_LEAGUE: String = "STR_LEAGUE"
        const val STR_TEAMH: String = "STR_TEAMH"
        const val STR_TEAMA: String = "STR_TEAMA"
        const val INT_SCOREH: String = "INT_SCOREH"
        const val INT_SCOREA: String = "INT_SCOREA"
    }
}