package com.husseinelfeky.session2.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var name: String = "",
    var age: Int? = null,
    var profession: String = "",
    var imageUrl: String = ""
) : Parcelable
