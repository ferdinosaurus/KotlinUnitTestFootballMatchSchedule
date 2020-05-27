package com.example.kotlinunittestfootballmatchschedule.ui

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.kotlinunittestfootballmatchschedule.R
import org.jetbrains.anko.*

class FavoriteItemUI: AnkoComponent<ViewGroup> {

    companion object {
        const val tvFavoriteName = 1
        const val tvFavoriteDate = 2
        const val btnFavoriteDelete = 3

    }
    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui){
        verticalLayout {
            lparams(matchParent, wrapContent)

            padding = dip(16)

            textView {
                id = tvFavoriteName
                text = "Event Name"
                textSize = 20F
                textColor = ContextCompat.getColor(context, R.color.colorPrimaryDark)
                gravity = Gravity.CENTER
            }.lparams{
                width = matchParent
                height = wrapContent
                topMargin = 5
            }

            textView {
                id = tvFavoriteDate
                text = "Event date"
                textSize = 20F
                textColor = ContextCompat.getColor(context, R.color.colorPrimaryDark)
                gravity = Gravity.CENTER
            }.lparams{
                width = matchParent
                height = wrapContent
                topMargin = 5
            }

            button {
                id = btnFavoriteDelete
                text = "delete"
                textSize = 20F
                textColor = ContextCompat.getColor(context, R.color.colorPrimaryDark)
                gravity = Gravity.CENTER
            }.lparams{
                width = matchParent
                height = wrapContent
                topMargin = 5
            }



        }
    }
}