package com.example.newsapp.model

//뉴스 기사의 항목
class ItemModel {
    var id: Long = 0 //출처의 식별자 ID
    var author: String? = null//저자
    var title: String? = null//제목
    var description: String? = null//발췌문
    var urlToImage: String? = null//이미지 URL
    var publishedAt: String? = null//게시 날짜 및 시간
}