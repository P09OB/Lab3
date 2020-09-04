package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.BLUE;
import static android.graphics.Color.YELLOW;

public class resultado extends AppCompatActivity implements View.OnClickListener{

    private Button volverButton;
    private TextView resultadoTextView;
    private TextView nameTextView;
    private ConstraintLayout fondoLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        volverButton = findViewById(R.id.volverButton);
        resultadoTextView = findViewById(R.id.resultadoTextView);
        nameTextView = findViewById(R.id.nameTextView);
        fondoLayout = findViewById(R.id.cons);

        volverButton.setOnClickListener(this);


       String preferencesColor = getSharedPreferences("mandar",MODE_PRIVATE).getString("seleccion","NO USER");


        if(preferencesColor == "VIOLETA"){
            fondoLayout.setBackgroundColor(Color.rgb(92, 55, 76));
        } else if(preferencesColor == "YELLOW"){
            fondoLayout.setBackgroundColor(Color.rgb(252, 163, 28));
        } else if (preferencesColor == "ORANGE"){
            fondoLayout.setBackgroundColor(Color.rgb(255, 120, 71));
        }


    }

    @Override
    public void onClick(View view) {

        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = getSharedPreferences("name",MODE_PRIVATE);
        String username = preferences.getString("username","NO USER");
        nameTextView.setText("Hola,"+" "+username+"."+" "+"Tu nota final es de:");

        SharedPreferences preferencesNota = getSharedPreferences("resultado",MODE_PRIVATE);
        String notaFinal = preferencesNota.getString("total","No total");
        resultadoTextView.setText(notaFinal+"");


    }
}