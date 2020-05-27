package com.example.kotlinunittestfootballmatchschedule.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinunittestfootballmatchschedule.database.dao.FavoriteDao
import com.example.kotlinunittestfootballmatchschedule.database.model.FavoriteModel
import com.example.kotlinunittestfootballmatchschedule.presenter.FavoritePresenter
import com.example.kotlinunittestfootballmatchschedule.ui.FavoriteItemUI
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.sdk27.coroutines.onClick

class FavoriteAdapter(private val context: Context, private val items: MutableList<FavoriteModel>,private val favoritePresenter: FavoritePresenter, private val listener:(FavoriteModel) ->Unit )
    : RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {

    private val favoriteDao:FavoriteDao = FavoriteDao(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(FavoriteItemUI().createView(AnkoContext.create(context,parent)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position],listener)
        holder.btnDelete.onClick {
            favoriteDao.deleteByID(items[position].id as Long)
            favoritePresenter.getAllFavorite()
        }
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        private var tvName: TextView = itemView.findViewById(FavoriteItemUI.tvFavoriteName)
        private var tvDate: TextView = itemView.findViewById(FavoriteItemUI.tvFavoriteDate)
        var btnDelete: TextView = itemView.findViewById(FavoriteItemUI.btnFavoriteDelete)



        fun bindItem(items: FavoriteModel, listener: (FavoriteModel) -> Unit) {
            tvName.text = items.strEvent
            tvDate.text = items.dateEvent

            containerView.setOnClickListener { listener(items) }
        }
    }
}