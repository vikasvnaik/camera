package com.mvvm.domain.entity.models

data class Photos (
    var path: String,
    var timestamp: String,
    var desc: String
)

data class Album (
    var photos: List<Photos>,
    var timestamp: String,
    var desc: String
)