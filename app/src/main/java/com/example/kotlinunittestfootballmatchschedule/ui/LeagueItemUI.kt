package com.example.kotlinunittestfootballmatchschedule.ui

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.example.kotlinunittestfootballmatchschedule.R
import org.jetbrains.anko.*

class LeagueItemUI: AnkoComponent<ViewGroup> {

    companion object {
        const val tvLeagueName = 1
        const val ivLeagueImage = 2

    }
    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui){
        verticalLayout {
            lparams(matchParent, wrapContent)

            padding = dip(16)


            imageView{

                id = ivLeagueImage
                layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
            }.lparams{
                width = 500
                height = 500
                gravity = Gravity.CENTER
            }

            textView {
                id = tvLeagueName
                text = "Club Name"
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