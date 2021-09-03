package com.pandorina.kekodchallenge1weatherview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerViewWeather = findViewById<RecyclerView>(R.id.rv_weather)
        val linearLayoutWeatherDetail = findViewById<LinearLayout>(R.id.ll_weather_data)
        val imageViewBigSun = findViewById<ImageView>(R.id.iv_big_sun)

        AnimationUtils.loadAnimation(applicationContext, R.anim.anim_bottom_to_up).let {
            recyclerViewWeather.startAnimation(it)
        }

        AnimationUtils.loadAnimation(applicationContext, R.anim.anim_left_to_right).let {
            imageViewBigSun.startAnimation(it)
        }

        AnimationUtils.loadAnimation(applicationContext, R.anim.anim_right_to_left).let {
            linearLayoutWeatherDetail.startAnimation(it)
        }

        val list = listOf(
            Weather("Now", R.drawable.ic_weather_sunny),
            Weather("12", R.drawable.ic_weather_partly_cloudy),
            Weather("13", R.drawable.ic_weather_partly_cloudy),
            Weather("14", R.drawable.ic_weather_rainy),
            Weather("15", R.drawable.ic_weather_heavy_rainy),
            Weather("16", R.drawable.ic_weather_sunny),
            Weather("17", R.drawable.ic_weather_partly_cloudy),
            Weather("18", R.drawable.ic_weather_sunny),
        )

        recyclerViewWeather.apply {
            adapter = WeatherAdapter(list)
            setHasFixedSize(true)
        }

    }
}