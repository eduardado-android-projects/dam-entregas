package com.edusoft.dam.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //debug
    private static final String TAG = "MainActivity";
    //
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

    private void loadSavedNumber() {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.contador), MODE_PRIVATE);
        Integer valorGuardado = sharedPreferences.getInt(VALOR_CUENTA_ACTUAL, 0);
        textViewCartel.setText(valorGuardado.toString());
    }

    private void saveNumber(Integer number){
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.contador), MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(VALOR_CUENTA_ACTUAL, number);
        editor.apply();
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
            //todo probar en onStop()
        }else if(v.getId() == R.id.btn_reset){
            Integer valorReset = 0;
            textViewCartel.setText(valorReset.toString());
            saveNumber(0);
        }
    }


}