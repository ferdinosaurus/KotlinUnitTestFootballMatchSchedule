package com.example.kotlinunittestfootballmatchschedule.api

import org.junit.Test

import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class TheSportDBApiTest {

    @Test
    fun getNextEvent() {
        val apiRepository = mock(ApiRepository::class.java)
        val url = "https://www.thesportsdb.com/api/v1/json/1/eventsnextleague.php?id=4328"
        apiRepository.doRequest(url)
        verify(apiRepository).doRequest(url)
    }

    @Test
    fun getPrevEvent() {
        val apiRepository = mock(ApiRepository::class.java)
        val url = "https://www.thesportsdb.com/api/v1/json/1/eventspastleague.php?id=4328"
        apiRepository.doRequest(url)
        verify(apiRepository).doRequest(url)
    }

    @Test
    fun getSearchEvent() {
        val apiRepository = mock(ApiRepository::class.java)
        val search = "liverpool"
        val url = "https://www.thesportsdb.com/api/v1/json/1/searchevents.php?e="+search
        apiRepository.doRequest(url)
        verify(apiRepository).doRequest(url)
    }

    @Test
    fun getDetailEvent() {
        val apiRepository = mock(ApiRepository::class.java)
        val url = "https://www.thesportsdb.com/api/v1/json/1/lookupevent.php?id=602410"
        apiRepository.doRequest(url)
        verify(apiRepository).doRequest(url)
    }

    @Test
    fun getDetailTeam() {
        val apiRepository = mock(ApiRepository::class.java)
        val url = "https://www.thesportsdb.com/api/v1/json/1/lookupevent.php?id=602410"
        apiRepository.doRequest(url)
        verify(apiRepository).doRequest(url)
    }
}