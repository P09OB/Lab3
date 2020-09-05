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

public class configuracion extends AppCompatActivity implements View.OnClickListener{


    private Button colo1but;
    private Button colo2but;
    private Button colo3but;
    private ConstraintLayout fondoLayout;
    private String color, color2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);


        colo1but = findViewById(R.id.color1but);
        colo2but = findViewById(R.id.color2but);
        colo3but = findViewById(R.id.color3but);
        fondoLayout = findViewById(R.id.fondoConstranintLayout);

        SharedPreferences colorPreferences = getSharedPreferences("mandar",MODE_PRIVATE);
        color2= colorPreferences.getString("seleccion", "NO_COLOR");
        color();

        colo1but.setOnClickListener(this);
        colo2but.setOnClickListener(this);
        colo3but.setOnClickListener(this);

    }

    public void color(){

        if(color2.equals("BLUE")){
            fondoLayout.setBackgroundColor(Color.rgb(45, 49, 69));
        }

        if(color2.equals("VIOLETA")){
            fondoLayout.setBackgroundColor(Color.rgb(92, 55, 76));
        }
        if(color2.equals("YELLOW")){
            fondoLayout.setBackgroundColor(Color.rgb(252, 163, 28));
        }
        if (color2.equals("ORANGE")){
            fondoLayout.setBackgroundColor(Color.rgb(255, 120, 71));
        }
    }

    @Override
    public void onClick(View view) {

        Intent  i = new Intent(this,MainActivity.class);


        switch (view.getId()){

            case R.id.color1but:

                color = "YELLOW";
                color();
                startActivity(i);

                break;

            case R.id.color2but:

                color = "ORANGE";
                startActivity(i);
                color();

                break;

            case R.id.color3but:

                color = "VIOLETA";

                startActivity(i);
                color();

                break;

        }

        SharedPreferences preferences = getSharedPreferences("mandar",MODE_PRIVATE);
        preferences.edit().putString("seleccion",color).apply();


    }

}