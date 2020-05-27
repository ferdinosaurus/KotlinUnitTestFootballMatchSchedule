package com.example.kotlinunittestfootballmatchschedule.database.dao

import android.content.Context
import android.util.Log
import com.example.kotlinunittestfootballmatchschedule.database.database
import com.example.kotlinunittestfootballmatchschedule.database.model.FavoriteModel
import com.example.kotlinunittestfootballmatchschedule.model.Event
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.toast

import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

import java.lang.Exception

class FavoriteDao(context:Context){

    private var context:Context = context

    fun insertData(event:Event,status:String){
        try{
            context.database.use {
                insert(
                    FavoriteModel.TABLE_FAVORITE,
                    FavoriteModel.ID_EVENT to event.idEvent,
                    FavoriteModel.STR_DATEEV to event.dateEvent,
                    FavoriteModel.STR_TIMEEV to event.strTime,
                    FavoriteModel.STR_EVENT to event.strEvent,
                    FavoriteModel.STR_STATUS to status,
                    FavoriteModel.STR_SPORT to event.strSport,
                    FavoriteModel.STR_LEAGUE to event.strLeague,
                    FavoriteModel.STR_TEAMH to event.strHomeTeam,
                    FavoriteModel.STR_TEAMA to event.strAwayTeam,
                    FavoriteModel.INT_SCOREH to event.intHomeScore,
                    FavoriteModel.INT_SCOREA to event.intAwayScore)
            }
            context.toast("masuk")
        }catch (e:Exception){
            context.toast(e.toString())
        }
    }

    fun getAll():List<FavoriteModel>{
        val favoriteModelList:ArrayList<FavoriteModel> = arrayListOf()
        try{

            context.database.use {

                val result = select(FavoriteModel.TABLE_FAVORITE)
                result.toString()
                val favoriteTemp = result.parseList(classParser<FavoriteModel>())

                favoriteModelList.addAll(favoriteTemp)

            }
        }catch (e:Exception){
            Log.d("dataFavorite",e.toString())
            context.toast(e.toString())
        }
        return favoriteModelList
    }

    fun getAllByStatus(status: String):List<FavoriteModel>{
        val favoriteModelList:ArrayList<FavoriteModel> = arrayListOf()
        try{

            context.database.use {

                val result = select(FavoriteModel.TABLE_FAVORITE)
                    .whereArgs(FavoriteModel.STR_STATUS+" = {status}",
                "status" to status
                )
                result.toString()
                val favoriteTemp = result.parseList(classParser<FavoriteModel>())

                favoriteModelList.addAll(favoriteTemp)

            }
        }catch (e:Exception){
            Log.d("dataFavorite",e.toString())
            context.toast(e.toString())
        }
        return favoriteModelList
    }

    fun deleteByID(id: Long){
        try{
            context.database.use {
                delete(FavoriteModel.TABLE_FAVORITE,FavoriteModel.ID+" = {id}","id" to id)
            }
        }catch (e:Exception){
            Log.d("dataFavorite",e.toString())
            context.toast(e.toString())
        }

    }


}