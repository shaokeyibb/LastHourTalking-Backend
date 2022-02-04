package io.hikarilan.lasthourtalkingbackend.dao

import java.util.*
import javax.persistence.*

@Entity
data class MessageChain internal constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    val firstTime: Date,
    @OneToMany(cascade = [CascadeType.ALL])
    var messages: List<Message>
)
