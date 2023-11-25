package com.example.sultanposts.data.datasource.remote.model

data class BookRequest(
    var user : String?=null,
    var address : String?=null,
    var service : String?=null,
    var subservice : String?=null,
    var day : String?=null,
    var time : String?=null
)
