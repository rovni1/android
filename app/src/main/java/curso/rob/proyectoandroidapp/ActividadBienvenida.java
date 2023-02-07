package curso.rob.proyectoandroidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Objects;

public class ActividadBienvenida extends AppCompatActivity {

    private TextView textView;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_bienvenida);

        this.textView = findViewById(R.id.textViewBienvenido);

        String nombre_usuario = getIntent().getStringExtra("NOMBRE_USUARIO");
        this.textView.setText("Bienvenido.. " + nombre_usuario);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }

    private void volver(){
        this.finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                volver();
                break;

        }
        return super.onOptionsItemSelected(item);
    }


}