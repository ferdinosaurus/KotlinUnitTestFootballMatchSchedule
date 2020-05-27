package com.example.kotlinunittestfootballmatchschedule.ui

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.kotlinunittestfootballmatchschedule.R
import org.jetbrains.anko.*

class EventItemUI: AnkoComponent<ViewGroup> {

    companion object {
        const val tvEventName = 1
        const val tvEventDate = 2

    }
    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui){
        verticalLayout {
            lparams(matchParent, wrapContent)

            padding = dip(16)

            textView {
                id = tvEventName
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
                id = tvEventDate
                text = "Event date"
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