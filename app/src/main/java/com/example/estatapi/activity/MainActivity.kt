package com.example.estatapi.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.estatapi.R
import com.example.estatapi.RequiredConstants
import com.example.estatapi.data.StatsData
import com.example.estatapi.data.SurveyData
import com.example.estatapi.datafactory.StatsDataFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val statsDataFactory = StatsDataFactory()
        statsDataFactory.setOnCallback()
        statsDataFactory.setOnCallbackFromActivity(object: StatsDataFactory.ICallbackTaskFromActivity{
            override fun callback() {
                val adapter1: ArrayAdapter<SurveyData> = ArrayAdapter(
                    this@MainActivity,
                    R.layout.support_simple_spinner_dropdown_item,
                    statsDataFactory.statsData.statisticalData.surveyDataInf.getSurveyDataObjById(RequiredConstants.CAT01).surveyDataList
                )
                val adapter2: ArrayAdapter<SurveyData> = ArrayAdapter(
                    this@MainActivity,
                    R.layout.support_simple_spinner_dropdown_item,
                    statsDataFactory.statsData.statisticalData.surveyDataInf.getSurveyDataObjById(RequiredConstants.CAT02).surveyDataList
                )

                val spinner1: Spinner = findViewById(R.id.spinner1)
                spinner1.adapter = adapter1
                val spinner2: Spinner = findViewById(R.id.spinner2)
                spinner2.adapter = adapter2
            }
        })

        submit_button.setOnClickListener{
            val intent = Intent(this, SurveyResultActivity::class.java)
            val cat01Code: String = (spinner1.selectedItem as SurveyData).code
            val cat01Name: String  = (spinner1.selectedItem as SurveyData).name
            val cat02Code: String = (spinner2.selectedItem as SurveyData).code
            val cat02Name: String = (spinner2.selectedItem as SurveyData).name

            intent.putExtra(RequiredConstants.CAT01_CODE, cat01Code)
            intent.putExtra(RequiredConstants.CAT01_NAME, cat01Name)
            intent.putExtra(RequiredConstants.CAT02_CODE, cat02Code)
            intent.putExtra(RequiredConstants.CAT02_NAME, cat02Name)

            startActivity(intent)
        }
    }
}
