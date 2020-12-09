package com.example.audio_libro

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class LibroAdaptador(var contexto: Context, var vectorLibro: Vector<Libro>) :
    RecyclerView.Adapter<LibroAdaptador.ViewHolder>() {




    lateinit var onClickListener: View.OnClickListener
    lateinit var onLongclickListener: View.OnLongClickListener

    public fun setOnclickListener(onclickListener: View.OnClickListener) {
        this.onClickListener = onclickListener
    }

    fun setOnlongclickListener(onlongclickListener: View.OnLongClickListener) {
        this.onLongclickListener = onlongclickListener
    }

    var inflador: LayoutInflater =
        contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var portada: ImageView
        var titulo: TextView

        init {
            portada = itemView.findViewById<View>(R.id.portada) as ImageView
            portada.scaleType = ImageView.ScaleType.CENTER_INSIDE
            titulo = itemView.findViewById<View>(R.id.titulo) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = inflador.inflate(R.layout.elemento_selector, null)
        view.setOnClickListener(this.onClickListener);
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val libro: Libro = vectorLibro[position]
        holder.portada.setImageResource(libro.recursoImagen)
        holder.titulo.text = libro.titulo
    }

    override fun getItemCount(): Int {
        return vectorLibro.size
    }
}