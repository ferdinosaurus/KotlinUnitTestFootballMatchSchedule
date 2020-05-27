package com.example.kotlinunittestfootballmatchschedule.ui

import android.app.Activity
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinunittestfootballmatchschedule.activity.FavoriteActivity
import com.example.kotlinunittestfootballmatchschedule.adapter.FavoriteAdapter
import com.example.kotlinunittestfootballmatchschedule.database.model.FavoriteModel
import com.example.kotlinunittestfootballmatchschedule.presenter.FavoritePresenter
import com.example.kotlinunittestfootballmatchschedule.view.FavoriteView
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class FavoriteUI (activity: Activity): AnkoComponent<FavoriteActivity>, FavoriteView  {

    private var activity:Activity = activity
    private val favoritePresenter:FavoritePresenter = FavoritePresenter(activity,this)
    private lateinit var recyclerView: RecyclerView

    private var favoriteModelList: MutableList<FavoriteModel> = mutableListOf()
    private lateinit var progressBar: ProgressBar


    override fun createView(ui: AnkoContext<FavoriteActivity>) = with(ui) {
        linearLayout {

            padding = dip(16)
            lparams (width = matchParent, height = matchParent)
            orientation = LinearLayout.VERTICAL

            progressBar = progressBar {
            }.lparams(matchParent, wrapContent)

            recyclerView = recyclerView {
                lparams(matchParent, wrapContent)

                layoutManager = LinearLayoutManager(context)
                adapter = FavoriteAdapter(context,favoriteModelList,favoritePresenter){
                    context.toast("id = "+it.idEvent)
                }
            }

        }
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showNoFavorite() {
        recyclerView.visibility = View.GONE
    }

    override fun showFavorite(data: List<FavoriteModel>) {
        recyclerView.visibility = View.VISIBLE
        recyclerView.adapter = FavoriteAdapter(activity,data as MutableList<FavoriteModel>,favoritePresenter){
            activity.toast("data : "+it.idEvent)
        }
    }
}