package com.example.practica_2_conversor_unidades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button btn_longitud, btn_peso, btn_volumen, btn_temperatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_longitud = (Button) findViewById(R.id.btn_longitud);
        btn_peso = (Button) findViewById(R.id.btn_peso);
        btn_volumen = (Button) findViewById(R.id.btn_volumen);
        btn_temperatura = (Button) findViewById(R.id.btn_temperatura);

        btn_longitud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirLongitud();
            }
        });


        btn_peso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirPeso();
            }
        });


        btn_volumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirVolumen();
            }
        });


        btn_temperatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTemperatura();
            }
        });
    }

    public void abrirLongitud(){
        Intent intent = new Intent(this, activity_conversor.class);
        intent.putExtra("tipo_conversion", "longitud");
        startActivity(intent);
    }

    public void abrirPeso(){
        Intent intent = new Intent(this, activity_conversor.class);
        intent.putExtra("tipo_conversion", "peso");
        startActivity(intent);
    }

    public void abrirVolumen(){
        Intent intent = new Intent(this, activity_conversor.class);
        intent.putExtra("tipo_conversion", "volumen");
        startActivity(intent);
    }

    public void abrirTemperatura(){
        Intent intent = new Intent(this, activity_conversor.class);
        intent.putExtra("tipo_conversion", "temperatura");
        startActivity(intent);
    }
}