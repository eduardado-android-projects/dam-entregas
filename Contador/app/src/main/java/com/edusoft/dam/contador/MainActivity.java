package com.edusoft.dam.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //debug
    private static final String TAG = "MainActivity";
    //cte para SharedPreferences
    public static final String VALOR_CUENTA_ACTUAL = "valorCuentaActual";
    //gui components
    private TextView textViewCartel;
    private Button btnToast;
    private Button btnCount;
    private Button btnReset;
    //variables globales




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Hello Eduardo");

        textViewCartel = findViewById(R.id.cartel);
        btnCount = findViewById(R.id.btnCount);
        btnToast = findViewById(R.id.btnToast);
        btnReset = findViewById(R.id.btn_reset);
        btnCount.setOnClickListener(this);
        btnToast.setOnClickListener(this);
        btnReset.setOnClickListener(this);

        loadSavedNumber();

    }

    /** Guarda en la vista el número guardado previamente en preferencias
     *
     */
    private void loadSavedNumber() {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.contador), MODE_PRIVATE);
        Integer valorGuardado = sharedPreferences.getInt(VALOR_CUENTA_ACTUAL, 0);
        textViewCartel.setText(valorGuardado.toString());
    }

    /** Guarda el número en preferencias
     *
     * @param number
     */
    private void saveNumber(Integer number){
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.contador), MODE_PRIVATE); //carga objeto SharedPreferencces
        SharedPreferences.Editor editor = sharedPreferences.edit(); //Abre fichero de preferencias .xml en modo edición
        editor.putInt(VALOR_CUENTA_ACTUAL, number); //guarda en el editor el valor pasado como parámetro
        editor.apply(); //guarda el valor almacenado en el editor en el archivo de preferencias
    }

    private void premio(){
        Toast.makeText(this, "¡PREMIO!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        Integer valorActual = Integer.parseInt(String.valueOf(textViewCartel.getText()));

        if(v.getId() == R.id.btnToast){
            Toast.makeText(this, valorActual.toString(), Toast.LENGTH_LONG).show();
        }else if(v.getId() == R.id.btnCount){
            Integer valorIncrementado = valorActual + 1;

            textViewCartel.setText(valorIncrementado.toString());
            saveNumber(valorIncrementado); //Guarda en memoria permanente de manera inmediata
            if(valorIncrementado == 5){
                premio();
            }
        }else if(v.getId() == R.id.btn_reset){
            Integer valorReset = 0;
            textViewCartel.setText(valorReset.toString());
            saveNumber(0);
        }
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "onResume: ");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "onStart: ");
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        super.onDestroy();
    }
}