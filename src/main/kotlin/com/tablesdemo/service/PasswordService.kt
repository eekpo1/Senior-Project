package com.tablesdemo.service

import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.concurrent.ThreadLocalRandom

@Service
class PasswordService {
    val lengthRule = 12

    val random = ThreadLocalRandom.current()
    val encoder: PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
    val randomAllowedEntries =
            arrayListOf<Char>('1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'A', 'a',
                    'B', 'b', 'C', 'c', 'D', 'd', 'E', 'e', 'F', 'f', 'g', 'h', 'i', 'j',
                    'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                    'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                    'X', 'Y', 'Z')

    fun createPassword(): String {
        val builder = StringBuilder(16)
        var size = random.nextInt(12, 15)

        while (builder.length < builder.capacity()) {
            builder.append(randomAllowedEntries[random.nextInt(randomAllowedEntries.size)])
        }

        return encoder.encode(builder.toString())
    }

}