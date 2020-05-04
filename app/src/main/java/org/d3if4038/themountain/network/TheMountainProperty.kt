package org.d3if4038.themountain.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TheMountainProperty (
    val id : String,
    val judul : String,
    val ketinggian : String,
    val keterangan : String,
    @Json(name = "imgURL")
    val imgSrcUrl : String): Parcelable {

}