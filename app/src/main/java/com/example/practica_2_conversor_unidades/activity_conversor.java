package com.example.practica_2_conversor_unidades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class activity_conversor extends AppCompatActivity implements  AdapterView.OnItemSelectedListener{

    String[] unidades;
    private Spinner unidades1;
    private Spinner unidades2;
    private EditText et_unidad_entrada;
    private TextView et_unidad_salida;
    private String tipo_conversion = "";
    private Button btn_calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor);
        Intent intent  = getIntent();
        tipo_conversion = intent.getStringExtra("tipo_conversion");


        et_unidad_entrada = (EditText) findViewById(R.id.et_unidad_entrada);
        et_unidad_salida = (TextView) findViewById(R.id.et_unidad_salida);
        btn_calcular = (Button) findViewById(R.id.btn_calcular);

        cargarUnidadesInterfaz();

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(et_unidad_entrada.getText().length() == 0){
                    msg();
                }else{

                    switch (tipo_conversion){
                        case "longitud":
                            ConvesionLongitud();
                            break;

                        case "peso":
                            ConvesionPeso();
                            break;

                        case "volumen":
                            ConvesionVolumen();
                            break;

                        case "temperatura":
                            ConvesionTemperatura();
                            break;
                    }

                }
            }
        });
    }

    public void msg(){
        Toast.makeText(this, "Falta Ingresar el Valor a Convertir", Toast.LENGTH_SHORT).show();
    }

    public void cargarUnidadesInterfaz(){
        switch (tipo_conversion){
            case "longitud":
                unidades =  new String[]{"Kilometro", "Metro", "Centimetro", "Pulgada"};
                cargarUnidades();
                break;

            case "peso":
                unidades =  new String[]{"Tonelada", "Kilogramo", "Gramo"};
                cargarUnidades();
                break;

            case "volumen":
                unidades = new String[]{"Litro", "Mililitro", "Metro Cubico"};
                cargarUnidades();
                break;

            case "temperatura":
                unidades = new String[]{"Celsius", "Fahrenheit", "Kelvin"};
                cargarUnidades();

                break;
        }
    }


    public void cargarUnidades(){
        unidades1 = (Spinner)findViewById(R.id.spinner_unidades);
        unidades2 = (Spinner)findViewById(R.id.spinner_unidad_convertir);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity_conversor.this,
                android.R.layout.simple_spinner_item,unidades);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        unidades1.setAdapter(adapter);
        unidades1.setOnItemSelectedListener(this);

        unidades2.setAdapter(adapter);
        unidades2.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {}

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}

    public void ConvesionLongitud(){
        double conversion = 0;
        double et_unidad_entrada_float = Double.parseDouble(et_unidad_entrada.getText().toString());

        String uni1 = unidades1.getSelectedItem().toString();
        String uni2 = unidades2.getSelectedItem().toString();


        switch (uni1.concat(uni2)){

            case "KilometroKilometro":
                conversion = et_unidad_entrada_float;
                break;

            case "KilometroMetro":
                conversion = et_unidad_entrada_float * 1000;
                break;

            case "KilometroCentimetro":
                conversion = et_unidad_entrada_float * 100000;
                break;

            case "KilometroPulgada":
                conversion = et_unidad_entrada_float * 39370;
                break;

            case "MetroKilometro":
                conversion = et_unidad_entrada_float / 1000;
                break;

            case "MetroCentimetro":
                conversion = et_unidad_entrada_float * 100;
                break;

            case "MetroPulgada":
                conversion = et_unidad_entrada_float * 39.37;
                break;

            case "MetroMetro":
                conversion = et_unidad_entrada_float;
                break;

            case "CentimetroKilometro":
                conversion = et_unidad_entrada_float / 100000;
                break;

            case "CentimetroMetro":
                conversion = et_unidad_entrada_float / 100;
                break;

            case "CentimetroCentimetro":
                conversion = et_unidad_entrada_float;
                break;

            case "CentimetroPulgada":
                conversion = et_unidad_entrada_float / 2.54;
                break;

            case "PulgadaKilometro":
                conversion = et_unidad_entrada_float / 39370;
                break;

            case "PulgadaMetro":
                conversion = et_unidad_entrada_float / 39.37;
                break;

            case "PulgadaCentimetro":
                conversion = et_unidad_entrada_float * 2.54;
                break;

            case "PulgadaPulgada":
                conversion = et_unidad_entrada_float;
                break;
        }


        String conversion_string = Double.toString(conversion);
        et_unidad_salida.setText(conversion_string);
    }

    public void ConvesionVolumen(){
        double conversion = 0;
        double et_unidad_entrada_float = Double.parseDouble(et_unidad_entrada.getText().toString());

        String uni1 = unidades1.getSelectedItem().toString();
        String uni2 = unidades2.getSelectedItem().toString();


        switch (uni1.concat(uni2)){

            case "LitroLitro":
                conversion = et_unidad_entrada_float;
                break;

            case "LitroMililitro":
                conversion = et_unidad_entrada_float * 1000;
                break;

            case "LitroMetro Cubico":
                conversion = et_unidad_entrada_float / 1000;
                break;

            case "MililitroMililitro":
                conversion = et_unidad_entrada_float;
                break;

            case "MililitroLitro":
                conversion = et_unidad_entrada_float / 1000;
                break;

            case "MililitroMetro Cubico":
                conversion = et_unidad_entrada_float * 1000000;
                break;

            case "Metro CubicoMetro Cubico":
                conversion = et_unidad_entrada_float;
                break;

            case "Metro CubicoLitro":
                conversion = et_unidad_entrada_float * 1000;
                break;

            case "Metro CubicoMililitro":
                conversion = et_unidad_entrada_float * 1000000;
                break;
        }


        String conversion_string = Double.toString(conversion);
        et_unidad_salida.setText(conversion_string);
    }

    public void ConvesionPeso(){
        double conversion = 0;
        double et_unidad_entrada_float = Double.parseDouble(et_unidad_entrada.getText().toString());

        String uni1 = unidades1.getSelectedItem().toString();
        String uni2 = unidades2.getSelectedItem().toString();


        switch (uni1.concat(uni2)){

            case "ToneladaTonelada":
                conversion = et_unidad_entrada_float;
                break;

            case "ToneladaKilogramo":
                conversion = et_unidad_entrada_float * 1000;
                break;

            case "ToneladaGramo":
                conversion = et_unidad_entrada_float * 1000000;
                break;

            case "KilogramoTonelada":
                conversion = et_unidad_entrada_float / 1000;
                break;

            case "KilogramoKilogramo":
                conversion = et_unidad_entrada_float;
                break;

            case "KilogramoGramo":
                conversion = et_unidad_entrada_float * 1000;
                break;

            case "GramoTonelada":
                conversion = et_unidad_entrada_float / 1000000;
                break;

            case "GramoGramo":
                conversion = et_unidad_entrada_float;
                break;

            case "GramoKilogramo":
                conversion = et_unidad_entrada_float / 1000;
                break;
        }


        String conversion_string = Double.toString(conversion);
        et_unidad_salida.setText(conversion_string);
    }

    public void ConvesionTemperatura(){
        double conversion = 0;
        double et_unidad_entrada_float = Double.parseDouble(et_unidad_entrada.getText().toString());

        String uni1 = unidades1.getSelectedItem().toString();
        String uni2 = unidades2.getSelectedItem().toString();


        switch (uni1.concat(uni2)){

            case "CelsiusFahrenheit":
                conversion = (et_unidad_entrada_float * (9/5)) + 32;
                break;

            case "CelsiusCelsius":
                conversion = et_unidad_entrada_float;
                break;

            case "CelsiusKelvin":
                conversion = (et_unidad_entrada_float + 273.15);
                break;

            case "FahrenheitFahrenheit":
                conversion = et_unidad_entrada_float;
                break;

            case "FahrenheitCelsius":
                conversion = (et_unidad_entrada_float - 32) * 5/9;
                break;

            case "FahrenheitKelvin":
                conversion = (et_unidad_entrada_float - 32) * 5/9 + 273.15;
                break;

            case "KelvinKelvin":
                conversion = et_unidad_entrada_float;
                break;

            case "KelvinCelsius":
                conversion = et_unidad_entrada_float - 273.15;
                break;

            case "KelvinFahrenheit":
                conversion = (et_unidad_entrada_float - 273.15) * 9/5 + 32;
                break;
        }


        String conversion_string = Double.toString(conversion);
        et_unidad_salida.setText(conversion_string);
    }
}