package com.example.kotlinunittestfootballmatchschedule.presenter

import com.example.kotlinunittestfootballmatchschedule.api.ApiRepository
import com.example.kotlinunittestfootballmatchschedule.api.TheSportDBApi
import com.example.kotlinunittestfootballmatchschedule.model.Event
import com.example.kotlinunittestfootballmatchschedule.model.EventResponse
import com.example.kotlinunittestfootballmatchschedule.view.EventView
import com.google.gson.Gson
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class EventPresenterTest {
    @Mock
    private lateinit var view: EventView

    @Mock
    private lateinit var gson: Gson

    @Mock
    private lateinit var apiRepository: ApiRepository

    @Mock
    private lateinit var apiResponse: Deferred<String>

    private lateinit var presenter:EventPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = EventPresenter(view, apiRepository, gson)
    }

    @Test
    fun testGetNextEvent() {
        val events: MutableList<Event> = mutableListOf()
        val response = EventResponse(events)
        val leagueId = "4328"

        GlobalScope.launch {
            Mockito.`when`(apiRepository.doRequest(TheSportDBApi.getNextEvent(leagueId))).thenReturn(response.toString())

            presenter.getNextEvent(leagueId)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showEvent(events)
            Mockito.verify(view).hideLoading()
        }
    }

    @Test
    fun testGetPrevEvent(){
        val events: MutableList<Event> = mutableListOf()
        val response = EventResponse(events)
        val leagueId = "4328"

        GlobalScope.launch {
            Mockito.`when`(apiRepository.doRequest(TheSportDBApi.getPrevEvent(leagueId))).thenReturn(response.toString())

            presenter.getPrevEvent(leagueId)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showEvent(events)
            Mockito.verify(view).hideLoading()
        }
    }

    @Test
    fun getSearchEvent(){
        val events: MutableList<Event> = mutableListOf()
        val response = EventResponse(events)
        val leagueSearch = "liv"

        GlobalScope.launch {
            Mockito.`when`(apiRepository.doRequest(TheSportDBApi.getSearchEvent(leagueSearch))).thenReturn(response.toString())

            presenter.getSearchEvent(leagueSearch)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showEvent(events)
            Mockito.verify(view).hideLoading()
        }
    }
}