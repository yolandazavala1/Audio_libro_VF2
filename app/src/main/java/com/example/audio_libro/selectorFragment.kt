package com.example.audio_libro

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [selectorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class selectorFragment : Fragment() {
    var layoutManager: RecyclerView.LayoutManager? = null
    lateinit var vista: View
    lateinit var recyclerView: RecyclerView
    lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vista = inflater.inflate(
                com.example.audio_libro.R.layout.fragment_selector,
                container,
                false
        )
        recyclerView = vista.findViewById(com.example.audio_libro.R.id.recycle_elementos)
        layoutManager = GridLayoutManager(context, 2)
        recyclerView.layoutManager = layoutManager
        val adaptadorLibros = context?.let { LibroAdaptador(it, Libro().ejemploLibros()) }
        adaptadorLibros?.setOnclickListener { v1 ->
            Toast.makeText(getActivity(),
                    "Elemento seleccionado: "
                            + recyclerView.getChildAdapterPosition(v1),
                    Toast.LENGTH_LONG).show();
            mainActivity.mostrarDetalle(recyclerView.getChildAdapterPosition(v1))
        }
        recyclerView.adapter = adaptadorLibros

        return vista
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment libro_fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                selectorFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}