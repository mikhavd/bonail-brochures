package com.example.brochures.recycler

import android.graphics.drawable.Drawable

data class BrochureItem(
    val name: String,
    val image: Drawable?, //todo RecyclerView with Image in Android Studio https://www.youtube.com/watch?v=x-2qtxmxYE8
    val retailerName: String
)
