package com.example.estatapi.data

data class SurveyResult (
    val cat01Data: Pair<String, String>,

    val cat02Data: Pair<String, String>,

    val surveyDataObj: SurveyDataObj,

    val dataValueList: List<DataValue>
)