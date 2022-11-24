package com.rick_and_morty.homework_37.ui.model

import android.os.Parcel
import android.os.Parcelable
import com.rick_and_morty.homework_37.utils.write

data class RickAndMortyCharacter(
    val avatar: Int,
    val status: String?,
    val name: String?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.apply {
            write(avatar)
            write(status)
            write(name)
        }
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<RickAndMortyCharacter> {
        override fun createFromParcel(parcel: Parcel): RickAndMortyCharacter {
            return RickAndMortyCharacter(parcel)
        }

        override fun newArray(size: Int): Array<RickAndMortyCharacter?> {
            return arrayOfNulls(size)
        }
    }
}