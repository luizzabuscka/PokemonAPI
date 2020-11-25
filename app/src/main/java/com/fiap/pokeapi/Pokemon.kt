package com.fiap.pokeapi

import com.google.gson.annotations.SerializedName

data class Pokemon(
    val id: Int,
    val name: String?,
    val sprites: Sprite
)

data class Sprite(
    @SerializedName("front_default") val image: String?
)