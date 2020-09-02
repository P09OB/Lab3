package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class configuracion extends AppCompatActivity implements View.OnClickListener{


    private Button colo1but;
    private Button colo2but;
    private Button colo3but;
    private ConstraintLayout fondoLayout;
    private String color;

    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);


        colo1but = findViewById(R.id.color1but);
        colo2but = findViewById(R.id.color2but);
        colo3but = findViewById(R.id.color3but);
        fondoLayout = findViewById(R.id.fondoConstranintLayout);



        colo1but.setOnClickListener(this);
        colo2but.setOnClickListener(this);
        colo3but.setOnClickListener(this);

        i = new Intent(this,MainActivity.class);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.color1but:

                color = "YELLOW";

                startActivity(i);
                fondoLayout.setBackgroundColor(Color.rgb(252, 163, 28));


                break;

            case R.id.color2but:

                color = "ORANGE";
                startActivity(i);
                fondoLayout.setBackgroundColor(Color.rgb(255, 120, 71));


                break;

            case R.id.color3but:

                color = "VIOLETA";

                startActivity(i);
                fondoLayout.setBackgroundColor(Color.rgb(92, 55, 76));



                break;




        }

        SharedPreferences preferences = getSharedPreferences("mandar",MODE_PRIVATE);
        preferences.edit().putString("seleccion",color).apply();

    }


}