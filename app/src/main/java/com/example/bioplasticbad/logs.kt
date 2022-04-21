package com.example.bioplasticbad

import java.util.*

data class logs(
    val plasticName: String,
    var journal: journal,
    var ownerId: String,
    var created: Date,
    var updated: Date
)