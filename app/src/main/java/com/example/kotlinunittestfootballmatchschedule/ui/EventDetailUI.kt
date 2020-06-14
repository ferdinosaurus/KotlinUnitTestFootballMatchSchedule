package com.example.kotlinunittestfootballmatchschedule.ui

import android.app.Activity
import android.view.Gravity
import android.view.View
import android.widget.*
import com.example.kotlinunittestfootballmatchschedule.activity.EventDetailActivity
import com.example.kotlinunittestfootballmatchschedule.database.dao.FavoriteDao
import com.example.kotlinunittestfootballmatchschedule.model.Event
import com.example.kotlinunittestfootballmatchschedule.model.Team
import com.example.kotlinunittestfootballmatchschedule.view.EventDetailView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class EventDetailUI(activity: Activity): AnkoComponent<EventDetailActivity>, EventDetailView {


    private var favoriteDao:FavoriteDao = FavoriteDao(activity)

    private lateinit var progressBar: ProgressBar
    private lateinit var linearLayout:LinearLayout


    private lateinit var txtStrEvent:TextView

    private lateinit var txtDateEvent:TextView

    private lateinit var txtStrHomeTeam:TextView
    private lateinit var txtStrAwayTeam:TextView

    private lateinit var txtStrHomeImage:ImageView
    private lateinit var txtStrAwayImage:ImageView



    private lateinit var txtIntHomeScore:TextView
    private lateinit var txtIntAwayScore:TextView

    private lateinit var txtintHomeShots:TextView
    private lateinit var txtintAwayShots:TextView



    private lateinit var txtStrHomeLineupGoalkeeper:TextView
    private lateinit var txtstrAwayLineupGoalkeeper:TextView

    private lateinit var txtStrHomeLineupDefense:TextView
    private lateinit var txtStrAwayLineupDefense:TextView

    private lateinit var txtStrHomeLineupMidfield:TextView
    private lateinit var txtStrAwayLineupMidfield:TextView

    private lateinit var txtStrHomeLineupForward:TextView
    private lateinit var txtStrAwayLineupForward:TextView

    private lateinit var txtStrHomeLineupSubstitutes:TextView
    private lateinit var txtStrAwayLineupSubstitutes:TextView

    private lateinit var txtStrHomeFormation:TextView
    private lateinit var txtStrAwayFormation:TextView


    private lateinit var btnInsertFavorite:Button



    override fun createView(ui: AnkoContext<EventDetailActivity>)= with(ui) {
        linearLayout{
            lparams(matchParent, wrapContent)

            progressBar = progressBar {
            }.lparams(matchParent, wrapContent)

            linearLayout = linearLayout {
                lparams(matchParent, wrapContent)
                orientation = LinearLayout.VERTICAL

                txtStrEvent = textView {
                    gravity = Gravity.CENTER
                }.lparams{
                    width = matchParent
                    height = wrapContent
                }
                txtDateEvent = textView {
                    gravity = Gravity.CENTER
                }.lparams{
                    width = matchParent
                    height = wrapContent
                }



                linearLayout {
                    lparams(matchParent, wrapContent)
                    orientation = LinearLayout.HORIZONTAL

                    txtStrHomeImage = imageView {
                    }.lparams{
                        width = dip(0)
                        height = dip(150)
                        weight = 1F
                        gravity = Gravity.CENTER
                    }

                    textView {
                        text = " VS "
                        gravity = Gravity.CENTER
                    }.lparams{
                        width = dip(0)
                        height = matchParent
                        weight = 1F
                    }

                    txtStrAwayImage = imageView {

                    }.lparams{
                        width = dip(0)
                        height = dip(200)
                        weight = 1F
                        gravity = Gravity.CENTER
                    }

                }


                linearLayout {
                    lparams(matchParent, wrapContent)
                    orientation = LinearLayout.HORIZONTAL

                    txtStrHomeTeam = textView {
                        gravity = Gravity.CENTER
                    }.lparams{
                        width = dip(0)
                        height = matchParent
                        weight = 1F
                    }

                    textView {
                        text = " VS "
                        gravity = Gravity.CENTER
                    }.lparams{
                        width = dip(0)
                        height = matchParent
                        weight = 1F
                    }

                    txtStrAwayTeam = textView {
                        gravity = Gravity.CENTER}.lparams{
                        width = dip(0)
                        height = matchParent
                        weight = 1F
                    }

                }

                btnInsertFavorite = button {
                    text = "add to favorite"
                }.lparams(matchParent, wrapContent)

                scrollView {
                    linearLayout {
                        lparams(matchParent, wrapContent)
                        orientation = LinearLayout.VERTICAL

                        linearLayout {
                            lparams(matchParent, wrapContent)
                            orientation = LinearLayout.HORIZONTAL

                            txtIntHomeScore = textView {
                                gravity = Gravity.CENTER
                            }.lparams{
                                width = dip(0)
                                height = matchParent
                                weight = 1F
                            }

                            textView {
                                text = " SCORE "
                                gravity = Gravity.CENTER
                            }.lparams{
                                width = dip(0)
                                height = matchParent
                                weight = 1F
                            }

                            txtIntAwayScore = textView {
                                gravity = Gravity.CENTER}.lparams{
                                width = dip(0)
                                height = matchParent
                                weight = 1F
                            }

                        }
                        linearLayout {
                            lparams(matchParent, wrapContent)
                            orientation = LinearLayout.HORIZONTAL

                            txtintHomeShots = textView {
                                gravity = Gravity.CENTER
                            }.lparams{
                                width = dip(0)
                                height = matchParent
                                weight = 1F
                            }

                            textView {
                                text = " SHOT "
                                gravity = Gravity.CENTER
                            }.lparams{
                                width = dip(0)
                                height = matchParent
                                weight = 1F
                            }

                            txtintAwayShots = textView {
                                gravity = Gravity.CENTER}.lparams{
                                width = dip(0)
                                height = matchParent
                                weight = 1F
                            }

                        }
                        linearLayout {
                            lparams(matchParent, wrapContent)
                            orientation = LinearLayout.HORIZONTAL

                            txtStrHomeLineupGoalkeeper = textView {
                                gravity = Gravity.CENTER
                            }.lparams{
                                width = dip(0)
                                height = matchParent
                                weight = 1F
                            }

                            textView {
                                text = "Goalkeeper"
                                gravity = Gravity.CENTER
                            }.lparams{
                                width = dip(0)
                                height = matchParent
                                weight = 1F
                            }

                            txtstrAwayLineupGoalkeeper = textView {
                                gravity = Gravity.CENTER}.lparams{
                                width = dip(0)
                                height = matchParent
                                weight = 1F
                            }

                        }
                        linearLayout {
                            lparams(matchParent, wrapContent)
                            orientation = LinearLayout.HORIZONTAL

                            txtStrHomeLineupDefense = textView {
                                gravity = Gravity.CENTER
                            }.lparams{
                                width = dip(0)
                                height = matchParent
                                weight = 1F
                            }

                            textView {
                                text = "Defense"
                                gravity = Gravity.CENTER
                            }.lparams{
                                width = dip(0)
                                height = matchParent
                                weight = 1F
                            }

                            txtStrAwayLineupDefense = textView {

                                gravity = Gravity.CENTER
                            }.lparams{
                                width = dip(0)
                                height = matchParent
                                weight = 1F
                            }
                        }
                        linearLayout {
                            lparams(matchParent, wrapContent)
                            orientation = LinearLayout.HORIZONTAL

                            txtStrHomeLineupMidfield = textView {
                                gravity = Gravity.CENTER
                            }.lparams{
                                width = dip(0)
                                height = matchParent
                                weight = 1F
                            }

                            textView {
                                text = "Midfield"
                                gravity = Gravity.CENTER
                            }.lparams{
                                width = dip(0)
                                height = matchParent
                                weight = 1F
                            }

                            txtStrAwayLineupMidfield = textView {

                                gravity = Gravity.CENTER
                            }.lparams{
                                width = dip(0)
                                height = matchParent
                                weight = 1F
                            }
                        }
                        linearLayout {
                            lparams(matchParent, wrapContent)
                            orientation = LinearLayout.HORIZONTAL

                            txtStrHomeLineupForward = textView {
                                gravity = Gravity.CENTER
                            }.lparams{
                                width = dip(0)
                                height = matchParent
                                weight = 1F
                            }

                            textView {
                                text = "Forward"
                                gravity = Gravity.CENTER
                            }.lparams{
                                width = dip(0)
                                height = matchParent
                                weight = 1F
                            }

                            txtStrAwayLineupForward = textView {
                                gravity = Gravity.CENTER
                            }.lparams{
                                width = dip(0)
                                height = matchParent
                                weight = 1F
                            }
                        }
                        linearLayout {
                            lparams(matchParent, wrapContent)
                            orientation = LinearLayout.HORIZONTAL

                            txtStrHomeLineupSubstitutes = textView {
                                gravity = Gravity.CENTER
                            }.lparams{
                                width = dip(0)
                                height = matchParent
                                weight = 1F
                            }

                            textView {
                                text = "Substitutes"
                                gravity = Gravity.CENTER
                            }.lparams{
                                width = dip(0)
                                height = matchParent
                                weight = 1F
                            }

                            txtStrAwayLineupSubstitutes = textView {
                                gravity = Gravity.CENTER
                            }.lparams{
                                width = dip(0)
                                height = matchParent
                                weight = 1F
                            }
                        }
                        linearLayout {
                            lparams(matchParent, wrapContent)
                            orientation = LinearLayout.HORIZONTAL

                            txtStrHomeFormation = textView {
                                gravity = Gravity.CENTER
                            }.lparams{
                                width = dip(0)
                                height = matchParent
                                weight = 1F
                            }

                            textView {
                                text = "Formation"
                                gravity = Gravity.CENTER
                            }.lparams{
                                width = dip(0)
                                height = matchParent
                                weight = 1F
                            }

                            txtStrAwayFormation = textView {
                                gravity = Gravity.CENTER
                            }.lparams{
                                width = dip(0)
                                height = matchParent
                                weight = 1F
                            }
                        }
                    }
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

    override fun showNoEvent() {
    }

    override fun showDetailEvent(data: Event) {
        txtStrEvent.text = data.strEvent
        txtDateEvent.text = data.dateEvent

        txtStrHomeTeam.text = data.strHomeTeam
        txtStrAwayTeam.text = data.strAwayTeam

        txtIntHomeScore.text = data.intHomeScore
        txtIntAwayScore.text = data.intAwayScore

        txtintHomeShots.text = data.intHomeShots
        txtintAwayShots.text = data.intAwayShots

        txtStrHomeLineupGoalkeeper.text = data.strHomeLineupGoalkeeper //StringHelper.splitString(data.strHomeLineupGoalkeeper as String,";")
        txtstrAwayLineupGoalkeeper.text = data.strAwayLineupGoalkeeper //StringHelper.splitString(data.strAwayLineupGoalkeeper as String,";")


        txtStrHomeLineupDefense.text = data.strHomeLineupDefense //StringHelper.splitString(data.strHomeLineupDefense as String,";")
        txtStrAwayLineupDefense.text = data.strAwayLineupDefense//StringHelper.splitString(data.strAwayLineupDefense as String,";")

        txtStrHomeLineupMidfield.text = data.strHomeLineupMidfield //StringHelper.splitString(data.strHomeLineupMidfield as String,";")
        txtStrAwayLineupMidfield.text = data.strAwayLineupMidfield //StringHelper.splitString(data.strAwayLineupMidfield as String,";")

        txtStrHomeLineupForward.text = data.strHomeLineupForward //StringHelper.splitString(data.strHomeLineupForward as String,";")
        txtStrAwayLineupForward.text = data.strAwayLineupForward //StringHelper.splitString(data.strAwayLineupForward as String,";")

        txtStrHomeLineupSubstitutes.text = data.strHomeLineupSubstitutes //StringHelper.splitString(data.strHomeLineupSubstitutes as String,";")
        txtStrAwayLineupSubstitutes.text = data.strAwayLineupSubstitutes //StringHelper.splitString(data.strAwayLineupSubstitutes as String,";")

        txtStrHomeFormation.text = data.strHomeFormation
        txtStrAwayFormation.text = data.strAwayFormation

        btnInsertFavorite.onClick {
            favoriteDao.insertData(data,"STATUS")
        }

    }

    override fun showDetailHome(data: Team) {
        Picasso.get().load(data.strTeamBadge).fit().into(txtStrHomeImage)
    }

    override fun showDetailAway(data: Team) {
        Picasso.get().load(data.strTeamBadge).fit().into(txtStrAwayImage)
    }

}