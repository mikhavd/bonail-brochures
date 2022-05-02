package com.example.brochures.recycler

import android.graphics.drawable.Drawable

data class DisplayableBrochureItem(
    val name: String,
    val image: Drawable? = null,
    val additionalDescription: String = ""
)
