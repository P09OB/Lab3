package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.BLUE;
import static android.graphics.Color.YELLOW;

public class notas extends AppCompatActivity implements View.OnClickListener{

    private Button calcularbutton;
    private EditText parcial1EditT;
    private EditText parcial2EditT;
    private EditText quizEditT;
    private EditText ejerciciosEditT;
    private EditText proyecto1EditT;
    private EditText proyecto2EditT;
    private double nota1, nota2, nota3,nota4,nota5,nota6,total;
    private String resultado;
    private ConstraintLayout fondoLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);

        calcularbutton = findViewById(R.id.calcularbutton);
        parcial1EditT =findViewById(R.id.parcial1EditT);
        parcial2EditT =findViewById(R.id.parcial2EditT);
        quizEditT =findViewById(R.id.quizEditT);
        ejerciciosEditT =findViewById(R.id.ejerciciosEditT);
        proyecto1EditT =findViewById(R.id.proyecto1EditT);
        proyecto2EditT =findViewById(R.id.proyecto2EditT);
        fondoLayout = findViewById(R.id.cons);

        calcularbutton.setOnClickListener(this);


       String seleccion = getSharedPreferences("mandar",MODE_PRIVATE).getString("seleccion","NO USER");


        if(seleccion == "VIOLETA"){

            fondoLayout.setBackgroundColor(Color.rgb(92, 55, 76));

        } else if(seleccion == "YELLOW"){

            fondoLayout.setBackgroundColor(Color.rgb(252, 163, 28));

        } else if (seleccion == "ORANGE"){

            fondoLayout.setBackgroundColor(Color.rgb(255, 120, 71));

        }

    }


    public void calcularNotas(){

        String notaStrg1 = parcial1EditT.getText().toString();
        String notaStrg2 =  parcial2EditT.getText().toString();
        String notaStrg3 =  quizEditT.getText().toString();
        String notaStrg4 =  ejerciciosEditT.getText().toString();
        String notaStrg5 =  proyecto1EditT.getText().toString();
        String notaStrg6 =  proyecto2EditT.getText().toString();

        double notaDouble1 = Double.parseDouble(notaStrg1);
        double notaDouble2 = Double.parseDouble(notaStrg2);
        double notaDouble3 = Double.parseDouble(notaStrg3);
        double notaDouble4 = Double.parseDouble(notaStrg4);
        double notaDouble5 = Double.parseDouble(notaStrg5);
        double notaDouble6 = Double.parseDouble(notaStrg6);


        nota1 = (notaDouble1*0.15);
        nota2 = (notaDouble2*0.15);
        nota3 = (notaDouble3*0.15);
        nota4 = (notaDouble4*0.05);
        nota5 = (notaDouble5*0.25);
        nota6 = (notaDouble6*0.25);

        total = nota1+nota2+nota3+nota4+nota5+nota6;

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.calcularbutton:


                    calcularNotas();
                    Intent i = new Intent(this,resultado.class);
                    startActivity(i);

                    SharedPreferences preferences = getSharedPreferences("resultado",MODE_PRIVATE);
                    resultado =  String.valueOf(total);
                    preferences.edit().putString("total", resultado).apply();

                    finish();

                break;
        }
    }


}