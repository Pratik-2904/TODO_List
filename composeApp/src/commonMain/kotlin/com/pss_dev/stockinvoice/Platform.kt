package com.pss_dev.stockinvoice

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform