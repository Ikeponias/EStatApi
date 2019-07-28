package com.example.estatapi.data

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class EStatsData (

    @JsonProperty(value = "GET_STATS_DATA")
    val statsData: StatsData
)