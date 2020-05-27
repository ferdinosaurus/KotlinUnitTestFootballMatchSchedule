package com.example.kotlinunittestfootballmatchschedule.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.kotlinunittestfootballmatchschedule.database.model.FavoriteModel.Companion.ID
import com.example.kotlinunittestfootballmatchschedule.database.model.FavoriteModel.Companion.ID_EVENT
import com.example.kotlinunittestfootballmatchschedule.database.model.FavoriteModel.Companion.INT_SCOREA
import com.example.kotlinunittestfootballmatchschedule.database.model.FavoriteModel.Companion.INT_SCOREH
import com.example.kotlinunittestfootballmatchschedule.database.model.FavoriteModel.Companion.STR_DATEEV
import com.example.kotlinunittestfootballmatchschedule.database.model.FavoriteModel.Companion.STR_EVENT
import com.example.kotlinunittestfootballmatchschedule.database.model.FavoriteModel.Companion.STR_LEAGUE
import com.example.kotlinunittestfootballmatchschedule.database.model.FavoriteModel.Companion.STR_SPORT
import com.example.kotlinunittestfootballmatchschedule.database.model.FavoriteModel.Companion.STR_STATUS
import com.example.kotlinunittestfootballmatchschedule.database.model.FavoriteModel.Companion.STR_TEAMA
import com.example.kotlinunittestfootballmatchschedule.database.model.FavoriteModel.Companion.STR_TEAMH
import com.example.kotlinunittestfootballmatchschedule.database.model.FavoriteModel.Companion.STR_TIMEEV
import com.example.kotlinunittestfootballmatchschedule.database.model.FavoriteModel.Companion.TABLE_FAVORITE
import org.jetbrains.anko.db.*

class MyDatabaseOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "FavoriteTeam.db", null, 1) {
    companion object {
        private var instance: MyDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): MyDatabaseOpenHelper {
            if (instance == null) {
                instance = MyDatabaseOpenHelper(ctx.applicationContext)
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables
        createTable(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable("TABLE_FAVORITE", true)
    }
}

// Access property for Context
val Context.database: MyDatabaseOpenHelper
    get() = MyDatabaseOpenHelper.getInstance(applicationContext)

private fun createTable(db: SQLiteDatabase) {
    db.createTable(
        TABLE_FAVORITE, true,
        ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
        ID_EVENT to TEXT + UNIQUE,
        STR_STATUS to TEXT,
        STR_DATEEV to TEXT,
        STR_TIMEEV to TEXT,
        STR_EVENT to TEXT,
        STR_SPORT to TEXT,
        STR_LEAGUE to TEXT,
        STR_TEAMH to TEXT,
        STR_TEAMA to TEXT,
        INT_SCOREH to TEXT,
        INT_SCOREA to TEXT
    )
}