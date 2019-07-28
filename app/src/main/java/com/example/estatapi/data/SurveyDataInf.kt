package com.example.estatapi.data

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class SurveyDataInf(

    @JsonProperty(value = "CLASS_OBJ")
    val surveyDataObjList: List<SurveyDataObj>
)
{
    fun getSurveyDataObjById(id: String): SurveyDataObj{
        return surveyDataObjList.first { s -> s.id == id }
    }
}