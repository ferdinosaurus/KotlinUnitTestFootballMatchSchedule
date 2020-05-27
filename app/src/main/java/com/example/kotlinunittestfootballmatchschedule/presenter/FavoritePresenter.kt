package com.example.kotlinunittestfootballmatchschedule.presenter

import android.app.Activity
import com.example.kotlinunittestfootballmatchschedule.database.dao.FavoriteDao
import com.example.kotlinunittestfootballmatchschedule.database.model.FavoriteModel
import com.example.kotlinunittestfootballmatchschedule.view.FavoriteView

class FavoritePresenter(activity: Activity, private val view: FavoriteView) {
    private var favoriteDao:FavoriteDao = FavoriteDao(activity)
    fun getAllFavorite() {
        view.showLoading()
        val favoriteModelList:List<FavoriteModel> =  favoriteDao.getAll()
        view.showFavorite(favoriteModelList)
        view.hideLoading()
    }
}