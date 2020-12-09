package com.example.audio_libro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectorFragment selectorFragment = new selectorFragment();
        if (findViewById(R.id.contenedor_pequeño) != null && getSupportFragmentManager().findFragmentById(R.id.contenedor_pequeño) == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.contenedor_pequeño, selectorFragment).commit();
        }
    }

    /**
     * Metodo para determinar la horientacion de la pantalla
     * @param index
     */
    public void mostrarDetalle(int index) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.findFragmentById(R.id.detalle_fragment) != null) {

            detalle_fragment fragment = (detalle_fragment) fragmentManager.findFragmentById(R.id.detalle_fragment);

            assert fragment != null;
            fragment.pinInfoLibro(index);
        } else {
            detalle_fragment detalleFragment =
                    new detalle_fragment();

            Bundle bundle = new Bundle();
            bundle.putInt(detalleFragment.getARG_ID_LIBRO(), index);

            detalleFragment.setArguments(bundle);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentManager.beginTransaction().replace(R.id.contenedor_pequeño
                    , detalleFragment).addToBackStack(null).commit();
        }
    }
}