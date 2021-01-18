package com.edusoft.dam.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewCartel;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Hello Toast");

        textViewCartel = findViewById(R.id.cartel);
        textViewCartel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.cartel){
            String cuentaActual = textViewCartel.getText().toString();
            Toast.makeText(this, cuentaActual, Toast.LENGTH_LONG).show();
        }

    }
}