package com.tablesdemo.service

import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.security.SecureRandom

@Service
class PasswordService {

    val random = SecureRandom()
    val encoder: PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
    val randomAllowedEntries =
            arrayListOf('1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'A', 'a',
                    'B', 'b', 'C', 'c', 'D', 'd', 'E', 'e', 'F', 'f', 'g', 'h', 'i', 'j',
                    'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                    'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                    'X', 'Y', 'Z')

    /**
     * Changed to return a pair of string since the bcrypt cannot be decrypted. The first value in the pair is the
     * generated password and the second is the encoded password
     */
    fun createPassword(): Pair<String, String> {
        val builder = StringBuilder(13)
        val size = random.nextInt(randomAllowedEntries.size) - 1

        while (builder.length < builder.capacity()) {
            builder.append(randomAllowedEntries[random.nextInt(size)])
        }
        val pass = builder.toString()
        return Pair(pass, encoder.encode(pass))
//        return encoder.encode(builder.toString())
    }

}