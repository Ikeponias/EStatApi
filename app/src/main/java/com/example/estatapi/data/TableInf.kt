package com.example.estatapi.data

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class TableInf(

    @JsonProperty(value = "CYCLE")
    val cycle: String,

    @JsonProperty(value = "OPEN_DATE")
    val openDate: String,

    @JsonProperty(value = "OVERALL_TOTAL_NUMBER")
    val overallTotalNumber: Int,

    @JsonProperty(value = "SMALL_AREA")
    val smallArea: Int,

    @JsonProperty(value = "STATISTICS_NAME")
    val statisticsName: String,

    @JsonProperty(value = "@id")
    val id : String, // 0003191360

    @JsonProperty(value = "SURVEY_DATE")
    val surveyDate: String,

    @JsonProperty(value = "TITLE")
    val title: String,

    @JsonProperty(value = "TITLE_SPEC")
    val titleSpec: TitleSpec,

    @JsonProperty(value = "UPDATED_DATE")
    val updatedDate: String
)