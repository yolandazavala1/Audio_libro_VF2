package com.example.audio_libro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [detalle_fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class detalle_fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    val ARG_ID_LIBRO: String = "id_libro"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_detalle_fragment, container, false)
        val args: Bundle? = arguments
        if(args != null){
            val position: Int = args.getInt(ARG_ID_LIBRO)
            ponInfoLibro(position,view)
        }
        else{
            ponInfoLibro(0,view)
        }
        return view
    }

    fun pinInfoLibro(id: Int){
        view?.let { ponInfoLibro(id, it) }
    }

    private fun ponInfoLibro(id: Int, vista: View){
        val libro: Libro = Libro().ejemploLibros()[id]
        ( (vista.findViewById<View>(R.id.titulo)) as TextView).text = libro.titulo
        ( (vista.findViewById<View>(R.id.autor)) as TextView).text = libro.autor
        ( (vista.findViewById<View>(R.id.portada)) as ImageView).setImageResource(libro.recursoImagen)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment detalle_fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                detalle_fragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}