package com.example.estatapi.data

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
data class StatsData(

    @JsonProperty(value = "STATISTICAL_DATA")
    val statisticalData: StatisticalData
): Serializable