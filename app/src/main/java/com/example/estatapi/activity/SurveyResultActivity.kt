package com.example.estatapi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.estatapi.R
import com.example.estatapi.RequiredConstants
import com.example.estatapi.SurveyResultViewAdapter
import com.example.estatapi.data.StatsData
import com.example.estatapi.data.SurveyData
import com.example.estatapi.data.SurveyResult
import com.example.estatapi.datafactory.StatsDataFactory
import com.example.estatapi.datafactory.SurveyResultFactory
import kotlinx.android.synthetic.main.activity_survey_result.*

class SurveyResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey_result)

        val cat01Code: String = intent.getStringExtra(RequiredConstants.CAT01_CODE)
        val cat01Name: String = intent.getStringExtra(RequiredConstants.CAT01_NAME)
        val cat02Code: String = intent.getStringExtra(RequiredConstants.CAT02_CODE)
        val cat02Name: String = intent.getStringExtra(RequiredConstants.CAT02_NAME)

        val statsDataFactory = StatsDataFactory()
        statsDataFactory.setOnCallback()
        statsDataFactory.setOnCallbackFromActivity(object: StatsDataFactory.ICallbackTaskFromActivity{
            override fun callback() {
                val surveyResultFactory = SurveyResultFactory()
                val surveyResult: SurveyResult =
                    surveyResultFactory.create(Pair(cat01Code, cat01Name), Pair(cat02Code, cat02Name), statsDataFactory.statsData)
                val recyclerView: RecyclerView = findViewById(R.id.result_list)
                val adapter = SurveyResultViewAdapter(this@SurveyResultActivity, surveyResult.surveyDataObj, surveyResult.dataValueList)
                recyclerView.layoutManager = LinearLayoutManager(this@SurveyResultActivity)
                recyclerView.adapter = adapter
                cat01.text = cat01Name
                cat02.text = cat02Name
            }
        })
    }
}
