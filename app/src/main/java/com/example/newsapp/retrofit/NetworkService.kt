package com.example.newsapp.retrofit

import com.example.newsapp.model.PageListModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//네트워크 서비스 인터페이스
interface NetworkService {

    //뉴스 목록을 서버에 요청
    @GET("/v2/everything")
    fun getList(
        @Query("q") q: String?,//제목 및 본문에서 검색할 키워드나 문구
        @Query("apiKey") apiKey: String?,//발급받은 apiKey
        @Query("page") page: Long,//페이지 수
        @Query("pageSize") pageSize: Int //한 페이지당 보여줄 기사의 수
    ): Call<PageListModel>
}