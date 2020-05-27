package com.example.kotlinunittestfootballmatchschedule.presenter

import com.example.kotlinunittestfootballmatchschedule.api.ApiRepository
import com.example.kotlinunittestfootballmatchschedule.api.TheSportDBApi
import com.example.kotlinunittestfootballmatchschedule.model.Event
import com.example.kotlinunittestfootballmatchschedule.model.EventResponse
import com.example.kotlinunittestfootballmatchschedule.model.Team
import com.example.kotlinunittestfootballmatchschedule.model.TeamsResponse
import com.example.kotlinunittestfootballmatchschedule.view.EventDetailView
import com.google.gson.Gson
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class EventDetailPresenterTest {
    @Mock
    private lateinit var view: EventDetailView

    @Mock
    private lateinit var gson: Gson

    @Mock
    private lateinit var apiRepository: ApiRepository

    @Mock
    private lateinit var apiResponse: Deferred<String>

    private lateinit var presenter:EventDetailPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = EventDetailPresenter(view, apiRepository, gson)
    }

    @Test
    fun testGetEventDetail() {
        val events: MutableList<Event> = mutableListOf()
        val response = EventResponse(events)
        val leagueId = "4328"

        GlobalScope.launch {
            Mockito.`when`(apiRepository.doRequest(TheSportDBApi.getDetailEvent(leagueId))).thenReturn(response.toString())

            presenter.getEventDetail(leagueId)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showDetailEvent(events[0])
            Mockito.verify(view).hideLoading()
        }
    }

    @Test
    fun testGetDetailTeam(){
        val teams: MutableList<Team> = mutableListOf()
        val response = TeamsResponse(teams)
        val leagueId = "4328"

        GlobalScope.launch {
            Mockito.`when`(apiRepository.doRequest(TheSportDBApi.getDetailTeam(leagueId))).thenReturn(response.toString())

            presenter.getEventDetail(leagueId)

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showDetailHome(teams[0])
            Mockito.verify(view).showDetailAway(teams[0])
            Mockito.verify(view).hideLoading()
        }
    }

}