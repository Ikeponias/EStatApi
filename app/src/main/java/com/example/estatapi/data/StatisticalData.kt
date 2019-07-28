package com.example.estatapi.data

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty


@JsonIgnoreProperties(ignoreUnknown = true)
data class StatisticalData(

    @JsonProperty(value = "CLASS_INF")
    val surveyDataInf: SurveyDataInf,

    @JsonProperty(value = "DATA_INF")
    val dataInf: DataInf,

    @JsonProperty(value = "TABLE_INF")
    val tableInf: TableInf
)