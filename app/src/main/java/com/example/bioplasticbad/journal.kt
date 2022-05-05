package com.example.bioplasticbad

import java.util.*

data class journal(
    val plasticImage: String,
    val userNotes: String,
    var ownerId: String,
    var created: Date,
    var updated: Date
)