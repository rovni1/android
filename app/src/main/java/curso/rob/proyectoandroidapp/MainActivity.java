package curso.rob.proyectoandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public final static String ETIQUETA_LOG = "AppEjemplos";

    public String nombre_version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(ETIQUETA_LOG, "Estoy entrando en Oncreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //carga la apariencia de la pantalla
        nombre_version= obtenerVersionAndroid();
        Log.d(ETIQUETA_LOG, "la version Android es: " + nombre_version);


    }




    private String obtenerVersionAndroid(){
        String nombre_version = null;

        switch (Build.VERSION.SDK_INT)
        {
            case Build.VERSION_CODES.Q:
                nombre_version ="Android Q -10";
                break;
            case Build.VERSION_CODES.R:
                nombre_version = "Android R - 11";
                break;
            default:
                nombre_version = "version anterior a 10";
        }

        return nombre_version;
    }
}