package com.example.brochures.brochuresfragment

import android.graphics.drawable.Drawable

data class BrochureItem(
    val name: String,
    val image: Drawable? = null,
    val additionalDescription: String = ""
)
