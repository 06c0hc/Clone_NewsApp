package com.example.newsapp

import android.app.Application
import com.android.volley.toolbox.Volley
import com.example.newsapp.retrofit.NetworkService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//앱 실행 시 최초로 한번만 초기화를 수행
class MyApplication: Application() {

    companion object {
        val QUERY = "travel"//검색 키워드
        val API_KEY = "Your API_Key" //발급 받은 인증키
        val BASE_URL = "https://newsapi.org"

        //요청시 사용자의 클라이언트에 대한 정보(운영체제, 앱, 브라우저 등)
        val USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36"


        //add....................................
        var networkService: NetworkService//네트워크 서비스 객체

         val retrofit: Retrofit
            //retrofit 프로퍼티의 게터 재정의
            get() = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        //MyApplication 객체 생성 시 초기화
        init{
            //네트워크 서비스 객체 생성
            networkService = retrofit.create(NetworkService::class.java)
        }
    }

}