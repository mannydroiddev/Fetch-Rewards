package com.josedavila.fetchrewards.mappers

interface ResponseMapper<in Response, out Model> {

    fun mapFromResponse(response: Response): Model
}
