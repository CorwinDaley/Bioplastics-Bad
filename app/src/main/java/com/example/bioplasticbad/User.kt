package com.example.bioplasticbad

import java.util.*

data class User(
    var username: String,
    var email: String,
    var blUserLocale: String,
    var password: String,
    var ownerId: String,
    var lastComposted: Date,
    var created: Date,
    var updated: Date
)
