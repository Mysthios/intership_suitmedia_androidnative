package com.example.intershipsuitmediaandroidnative.data.repository

import com.example.intershipsuitmediaandroidnative.data.model.UserResponse
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class UserRepository {
    private val gson = Gson()

    suspend fun getUsers(page: Int, perPage: Int): UserResponse {
        return withContext(Dispatchers.IO) {
            val url = URL("https://reqres.in/api/users?page=$page&per_page=$perPage")
            val connection = url.openConnection() as HttpURLConnection

            try {
                connection.requestMethod = "GET"
                connection.connectTimeout = 10000
                connection.readTimeout = 10000

                val reader = BufferedReader(InputStreamReader(connection.inputStream))
                val response = reader.readText()
                reader.close()

                gson.fromJson(response, UserResponse::class.java)
            } finally {
                connection.disconnect()
            }
        }
    }
}