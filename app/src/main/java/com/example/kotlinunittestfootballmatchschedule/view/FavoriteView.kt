package com.example.kotlinunittestfootballmatchschedule.view

import com.example.kotlinunittestfootballmatchschedule.database.model.FavoriteModel


interface FavoriteView{
    fun showLoading()
    fun hideLoading()
    fun showNoFavorite()
    fun showFavorite(data: List<FavoriteModel>)
}