package curso.rob.proyectoandroidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Objects;

public class ActividadFormulario extends AppCompatActivity {

    //1 definir los elementos visuales en la clase

    private EditText editTextNombre;
    private EditText editTextEdad;
    private RadioButton radioButtonHombre;
    private RadioButton radioButtonMujer;
    private CheckBox checkBoxMayorEdad;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_formulario);
        //2 asociar los atributos de la clase con los controles de la clase
        initActivity();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void limpiarFormulario(){
        this.editTextNombre.setText("");
        this.editTextEdad.setText("");
        this.radioButtonHombre.setChecked(false);
        this.radioButtonMujer.setChecked(false);
        this.checkBoxMayorEdad.setChecked(false);
        Log.d(MainActivity.ETIQUETA_LOG, "formulario limpio");

        Toast toast = Toast.makeText(this, "Formulario Limpio", Toast.LENGTH_LONG);
        toast.show();

    }

    private void salir(){
        Log.d(MainActivity.ETIQUETA_LOG, "saliendo....");
        //this.finish();

        AlertDialog ad = new AlertDialog.Builder(this).create();
        //this es el contexto
        ad.setTitle("Salir"); //definimos el titulo
        ad.setMessage("Desea Salir ?"); //y el mensaje de aviso
        //los botones con las opciones programadas
        ad.setButton(AlertDialog.BUTTON_NEGATIVE, "NO",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        ad.setButton(AlertDialog.BUTTON_POSITIVE, "SI",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ActividadFormulario.this.finish();
                    }
                });

        ad.show(); //finalmente lo mostramos.

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d(MainActivity.ETIQUETA_LOG, "se ha tocado el menu");

        switch (item.getItemId()){
            case R.id.opcionborrar:
                limpiarFormulario();
                Log.d(MainActivity.ETIQUETA_LOG, "Se ha tocado la opcion borar");
                break;
            case R.id.opcionsalir:
                salir();
                Log.d(MainActivity.ETIQUETA_LOG, "se ha tocado la opcion salir");
                break;

            case android.R.id.home:
                salir();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("RestrictedApi")
    private void initActivity(){

        this.editTextNombre = findViewById(R.id.editTextTextPersonName);
        this.editTextEdad = findViewById(R.id.editTextNumber);
        this.radioButtonHombre = findViewById(R.id.radioButtonHombre);
        this.radioButtonMujer = findViewById(R.id.radioButtonMujer);
        this.checkBoxMayorEdad = findViewById(R.id.checkBoxMayorEdad);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    //3 detectar el evento.
    /**
     * @param view el boton pulsado (el control que recibe la acción)
     */

    public void botonAceptar(View view){
        Log.d(MainActivity.ETIQUETA_LOG, "Boton Aceptar Pulsado");
        mostrarDatosFormlario();
        //ir a la pantalla de Bienvenida
        Intent intent_bienvenida = new Intent(this, ActividadBienvenida.class);

        String nombre_usuario = this.editTextNombre.getText().toString();
        intent_bienvenida.putExtra("NOMBRE_USUARIO", nombre_usuario);
        startActivity(intent_bienvenida);
    }

        private void mostrarDatosFormlario(){
            Log.d(MainActivity.ETIQUETA_LOG, "El dato nombre es: " + this.editTextNombre.getText().toString());
            Log.d(MainActivity.ETIQUETA_LOG, "El dato edad es: " + this.editTextEdad.getText().toString());
            Log.d(MainActivity.ETIQUETA_LOG, "Radio Button hombre marcado " + this.radioButtonHombre.isChecked());
            Log.d(MainActivity.ETIQUETA_LOG, "Radio Button mujer marcado " + this.radioButtonMujer.isChecked());
            Log.d(MainActivity.ETIQUETA_LOG, "Radio Button hombre marcado " + this.checkBoxMayorEdad.isChecked());
        }

}