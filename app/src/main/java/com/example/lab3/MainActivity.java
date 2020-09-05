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
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameText;
    private Button nextBut;
    private Button confiButt;
    private ConstraintLayout fondoConstranintLayout;
    private Intent i;
    private String seleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.nameText);
        nextBut = findViewById(R.id.nextBut);
        confiButt = findViewById(R.id.confiButt);
        fondoConstranintLayout = findViewById(R.id.fondoConstranintLayout);

        nextBut.setOnClickListener(this);
        confiButt.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

       switch(view.getId()){

           case R.id.nextBut:

               String nameUser = nameText.getText().toString();
               if(nameUser.trim().isEmpty()){
                   Toast.makeText(this,"Falta ingresar el nombre",Toast.LENGTH_LONG).show();

               } else {

                   i = new Intent(this,notas.class);
                   startActivity(i);
                   SharedPreferences preferences = getSharedPreferences("name",MODE_PRIVATE);
                   preferences.edit().putString("username",nameUser).apply();
               }

               break;

           case R.id.confiButt:

               Intent n = new Intent(this,configuracion.class);
               startActivity(n);
               break;
       }
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences colorPreferences = getSharedPreferences("mandar",MODE_PRIVATE);
        seleccion= colorPreferences.getString("seleccion", "NO_COLOR");


        if(seleccion.equals("BLUE")){
            fondoConstranintLayout.setBackgroundColor(Color.rgb(45, 49, 69));
        }
        if(seleccion.equals("VIOLETA")){

            fondoConstranintLayout.setBackgroundColor(Color.rgb(92, 55, 76));
        }
        if(seleccion.equals("YELLOW")){
            fondoConstranintLayout.setBackgroundColor(Color.rgb(252, 163, 28));
        }
        if (seleccion.equals("ORANGE")){
            fondoConstranintLayout.setBackgroundColor(Color.rgb(255, 120, 71));
        }


    }
}