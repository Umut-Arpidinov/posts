package com.example.sultanposts.data.datasource.mappers

import com.example.sultanposts.data.datasource.remote.model.AddressResponse
import com.example.sultanposts.data.datasource.remote.model.CompanyResponse
import com.example.sultanposts.data.datasource.remote.model.GeoResponse
import com.example.sultanposts.data.datasource.remote.model.UserResponse
import com.example.sultanposts.domain.enitity.Address
import com.example.sultanposts.domain.enitity.Company
import com.example.sultanposts.domain.enitity.Geo
import com.example.sultanposts.domain.enitity.User


fun GeoResponse.toDomain() = Geo(
    lat, lng
)

fun AddressResponse.toDomain() = Address(
    city, geo.toDomain(), street, suite, zipcode
)

fun CompanyResponse.toDomain() = Company(
    bs, catchPhrase, name
)

fun UserResponse.toDomain() = User(
    address.toDomain(), company.toDomain(), email, id, name, phone, username, website
)

