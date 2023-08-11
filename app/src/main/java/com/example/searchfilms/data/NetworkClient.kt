package com.example.searchfilms.data

import com.example.searchfilms.data.dto.Response

interface NetworkClient {
    fun doRequest(dto: Any): Response

}