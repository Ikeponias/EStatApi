package com.example.estatapi.data

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class SurveyDataObj(

    @JsonProperty(value = "@id")
    val id : String, // time

    @JsonProperty(value = "@name")
    val name : String, // 時間軸(年次)

    @JsonProperty(value = "CLASS")
    val surveyDataList: List<SurveyData>
) {

    fun getSurveyDataByCode(code: String): SurveyData? {
        return surveyDataList.find { s -> s.code == code }
    }
}