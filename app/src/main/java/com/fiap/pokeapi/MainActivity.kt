package com.fiap.pokeapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btSearch.setOnClickListener {
            if (etId.text.toString().isEmpty()) {
                return@setOnClickListener
            }

            val id = etId.text.toString().toInt()
            getPokemon(id)
        }
    }

    fun getPokemon(id: Int) {

        WebService().getService().getPokemon(id).enqueue(object: Callback<Pokemon> {

            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                // DEU ERRO!
                Toast.makeText(this@MainActivity, "Falha ao buscar", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                // DEU TUDO CERTO!
                val pokemon = response.body()
                tvId.text = "ID: ${pokemon?.id}"
                tvName.text = "Name: ${pokemon?.name}"
                tvImage.text = "Image: ${pokemon?.sprites?.image}"

                Glide
                    .with(this@MainActivity)
                    .load(pokemon?.sprites?.image)
                    .into(ivPokemon)
            }


        })

    }
}