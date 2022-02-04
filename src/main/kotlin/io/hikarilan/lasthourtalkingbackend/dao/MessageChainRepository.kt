package io.hikarilan.lasthourtalkingbackend.dao

import org.springframework.data.repository.CrudRepository
import java.util.*

interface MessageChainRepository : CrudRepository<MessageChain, Long> {

    fun findByFirstTimeBetween(startDate: Date, endDate: Date): List<MessageChain>

}