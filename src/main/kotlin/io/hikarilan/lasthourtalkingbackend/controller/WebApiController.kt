package io.hikarilan.lasthourtalkingbackend.controller

import io.hikarilan.lasthourtalkingbackend.dao.MessageChain
import io.hikarilan.lasthourtalkingbackend.dao.MessageChainRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.time.Instant
import java.util.*

@RestController
@RequestMapping("/api")
class WebApiController {

    @Autowired
    private lateinit var messageChainRepository: MessageChainRepository

    @ResponseBody
    @GetMapping("/getRandomMessageChain")
    fun getRandomMessageChain(): MessageChain? {
        return messageChainRepository.findAll().filter {
            Calendar.getInstance().apply { time = it.firstTime }.get(Calendar.HOUR_OF_DAY) == Calendar.getInstance()
                .apply { time = Date.from(Instant.now()) }.get(Calendar.HOUR_OF_DAY) - 1
        }.randomOrNull()
//        return messageChainRepository.findByFirstTimeBetween(
//            Date.from(Instant.now().minusMillis(1000 * 60 * 60)),
//            Date.from(Instant.now())
//        ).randomOrNull()
    }

    @ResponseBody
    @PostMapping("/updateMessageChain")
    fun updateMessageChain(@RequestBody message: MessageChain): MessageChain {
        val find = messageChainRepository.findById(message.id)
        return if (find.isPresent) {
            messageChainRepository.save(find.get().apply { this.messages = message.messages })
        } else {
            messageChainRepository.save(message)
        }
    }

}