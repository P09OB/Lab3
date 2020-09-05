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
    }


    public void calcularNotas(){



    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.calcularbutton:


                String notaStrg1 = parcial1EditT.getText().toString();
                String notaStrg2 =  parcial2EditT.getText().toString();
                String notaStrg3 =  quizEditT.getText().toString();
                String notaStrg4 =  ejerciciosEditT.getText().toString();
                String notaStrg5 =  proyecto1EditT.getText().toString();
                String notaStrg6 =  proyecto2EditT.getText().toString();

                if(notaStrg1.trim().isEmpty() || notaStrg2.trim().isEmpty() || notaStrg3.trim().isEmpty()
                        || notaStrg4.trim().isEmpty() || notaStrg5.trim().isEmpty() || notaStrg6.trim().isEmpty()){
                    Toast.makeText(this,"Falta llenar los campos",Toast.LENGTH_LONG).show();

                    return;
                } else {


                    double notaDouble1 = Double.parseDouble(notaStrg1);
                    double notaDouble2 = Double.parseDouble(notaStrg2);
                    double notaDouble3 = Double.parseDouble(notaStrg3);
                    double notaDouble4 = Double.parseDouble(notaStrg4);
                    double notaDouble5 = Double.parseDouble(notaStrg5);
                    double notaDouble6 = Double.parseDouble(notaStrg6);

                    nota1 = (notaDouble1 * 0.15);
                    nota2 = (notaDouble2 * 0.15);
                    nota3 = (notaDouble3 * 0.15);
                    nota4 = (notaDouble4 * 0.05);
                    nota5 = (notaDouble5 * 0.25);
                    nota6 = (notaDouble6 * 0.25);

                    total = nota1 + nota2 + nota3 + nota4 + nota5 + nota6;
                    Intent i = new Intent(this, resultado.class);
                    startActivity(i);

                    SharedPreferences preferences = getSharedPreferences("resultado", MODE_PRIVATE);
                    resultado = String.valueOf(total);
                    preferences.edit().putString("total", resultado).apply();

                    finish();

                }

                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences colorPreferences = getSharedPreferences("mandar",MODE_PRIVATE);
        String seleccion= colorPreferences.getString("seleccion", "NO_COLOR");


        if(seleccion.equals("BLUE")){

            fondoLayout.setBackgroundColor(Color.rgb(45, 49, 69));

        }

        if(seleccion.equals("VIOLETA")){

            fondoLayout.setBackgroundColor(Color.rgb(92, 55, 76));

        }
        if(seleccion.equals("YELLOW")){
            fondoLayout.setBackgroundColor(Color.rgb(252, 163, 28));
        }
        if (seleccion.equals("ORANGE")){
            fondoLayout.setBackgroundColor(Color.rgb(255, 120, 71));
        }


    }


}