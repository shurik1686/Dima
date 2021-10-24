package com.example.dima;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class LegoActivity extends AppCompatActivity {

    private TextView message;
    private int counter = 0;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.textView);
        ImageView droid = findViewById(R.id.imageView2);
        ImageView startButton = findViewById(R.id.imageView5);


        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTaskListActivity();
            }
        });



        //Define and attach click listener
        droid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tapDroid();
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });
    }

    private void goToTaskListActivity() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    private void tapDroidOld() {
        counter++;
        String countAsText;

        switch (counter) {
            case 1:
                countAsText = "однин раз";
                break;
            case 2:
                countAsText = "два раза";
                break;
            default:
                countAsText = String.format("%d раз", counter);
        }
        message.setText(String.format("Вы %s нажали на экран.", countAsText));
    }

    private void tapDroid() {
        ImageView movingPart = findViewById(R.id.imageView);
        counter++;
        String countAsText;

        switch (counter % 2) {
            case 0:
                countAsText = String.format("четное число раз (%s)", counter);
                movingPart.setImageResource(R.drawable.imagelego4);
                movingPart.setScaleX(0.5f);
                movingPart.setScaleY(0.5f);
                break;
            case 1:
                countAsText = String.format("нечетное число раз (%s)", counter);
                movingPart.setImageResource(R.drawable.imagelego5);
                movingPart.setScaleX(0.5f);
                movingPart.setScaleY(0.5f);
                break;
            default:
                countAsText = String.format("Так не должно быть :thinking:", counter);
        }
        message.setText(String.format("Вы %s нажали на экран.", countAsText));
    }

    private void startGame() {
        message.setText("Игра началась!");
        ImageView movingPart = findViewById(R.id.imageView);
        movingPart.setImageResource(R.drawable.back0);
        counter = 0;
    }
}