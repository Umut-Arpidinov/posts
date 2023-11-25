package com.example.sultanposts.data.datasource.remote.model

data class HistoryResponse(
    var id : String?=null,
    var user : String?=null,
    var address : ArrayList<Address>?= arrayListOf(),
    var service : String?=null,
    var subservice : String?=null,
    var day : String?=null,
    var time : String?=null,
    var status : String?=null
)

data class Address(
    var address : String?=null
)
