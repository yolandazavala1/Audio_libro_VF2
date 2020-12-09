package com.example.audio_libro

import java.util.*

class Libro(var titulo: String, var autor: String, var recursoImagen: Int,
            var urlAudio: String, var genero: String,
            var novedad: Boolean, var leido: Boolean
) {
    constructor() : this("", "", 0, "", "", false, false) {}

    val G_TODOS: String = "Todos los géneros"
    val G_EPICO: String = "Poema épico"
    val G_S_XIX: String = "Literatura siglo XIX"

    val G_SUSPENSE = "Suspense"
    val G_ARRAY = arrayOf(G_TODOS, G_EPICO, G_S_XIX, G_SUSPENSE)

    fun ejemploLibros(): Vector<Libro> {
        val SERVIDOR = "http://www.dcomg.upv.es/~jtomas/android/audiolibros/"
        val libros = Vector<Libro>()
        libros.add(
                Libro(
                        "Kappa",
                        "Akutagawa",
                        com.example.audio_libro.R.drawable.kappa,
                        SERVIDOR + "kappa.mp3",
                        G_S_XIX,
                        false,
                        false
                )
        )
        libros.add(
                Libro(
                        "Avecilla",
                        "Alas Clarín, Leopoldo",
                        com.example.audio_libro.R.drawable.avecilla,
                        SERVIDOR + "avecilla.mp3",
                        G_S_XIX,
                        true,
                        false
                )
        )
        libros.add(
                Libro(
                        "Divina Comedia",
                        "Dante",
                        com.example.audio_libro.R.drawable.divina_comedia,
                        SERVIDOR + "divina_comedia.mp3",
                        G_EPICO,
                        true,
                        false
                )
        )
        libros.add(
                Libro(
                        "Viejo Pancho, El",
                        "Alonso y Trelles, José",
                        com.example.audio_libro.R.drawable.viejo_pancho,
                        SERVIDOR + "viejo_pancho.mp3",
                        G_S_XIX,
                        true,
                        true
                )
        )
        libros.add(
                Libro(
                        "Canción de Rolando",
                        "Anónimo",
                        com.example.audio_libro.R.drawable.cancion_rolando,
                        SERVIDOR + "cancion_rolando.mp3",
                        G_EPICO,
                        false,
                        true
                )
        )
        libros.add(
                Libro(
                        "Matrimonio de sabuesos",
                        "Agata Christie",
                        com.example.audio_libro.R.drawable.matrim_sabuesos,
                        SERVIDOR + "matrim_sabuesos.mp3",
                        G_SUSPENSE,
                        false,
                        true
                )
        )
        libros.add(
                Libro(
                        "La iliada",
                        "Homero",
                        com.example.audio_libro.R.drawable.la_iliada,
                        SERVIDOR + "la_iliada.mp3",
                        G_EPICO,
                        true,
                        false
                )
        )
        return libros
    }
}