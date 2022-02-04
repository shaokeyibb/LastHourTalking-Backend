package io.hikarilan.lasthourtalkingbackend.dao

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Message internal constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    val who: String,
    val text: String,
    val time: Date
)
