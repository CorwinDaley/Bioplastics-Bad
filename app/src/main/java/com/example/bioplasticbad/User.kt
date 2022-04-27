package com.example.bioplasticbad

import java.util.*

data class User(
    var email: String,
    var blUserLocale: String,
    var password: String,
    var ownerId: String,
    var created: Date,
    var updated: Date
)
