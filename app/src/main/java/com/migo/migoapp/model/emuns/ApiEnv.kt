package com.migo.migoapp.model.emuns

import API_PRIVATE_HOST_URL
import API_PUBLIC_HOST_URL

enum class ApiEnv(val url: String) {
    PUBLIC(API_PUBLIC_HOST_URL),
    PRIVATE(API_PRIVATE_HOST_URL)
}