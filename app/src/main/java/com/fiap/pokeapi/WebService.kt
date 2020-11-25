package com.fiap.pokeapi

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface PokemonAPI {

    @GET("pokemon/{id}")
    fun getPokemon(@Path("id") id: Int) : Call<Pokemon>

}

class WebService {

    fun getService() : PokemonAPI {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(PokemonAPI::class.java)
    }

}