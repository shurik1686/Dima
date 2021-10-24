package com.example.dima;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GameActivity  extends Activity {


    ImageView sun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.menu_main);
        sun = findViewById(R.id.imageView4);

        sun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sun.setImageResource(R.drawable.moon);
            }
        });

        Button exit = findViewById(R.id.button);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
