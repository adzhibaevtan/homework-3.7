package com.rick_and_morty.homework_37.utils

import android.os.Parcel

fun Parcel.write(value: Any?) {
    when (value) {
        is String -> writeString(value)
        is Int -> writeInt(value)
        is Long -> writeLong(value)
        is Double -> writeDouble(value)
        is Float -> writeFloat(value)
        is Boolean -> writeByte(value.toByte())
    }
}
fun Boolean.toByte() = (if (this) 1 else 0).toByte()