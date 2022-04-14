package com.example.offlinequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String selectTopicName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        final LinearLayout matematica = findViewById (R.id.matematica);
        final LinearLayout portugues = findViewById (R.id.portugues);
        final LinearLayout ciencias = findViewById (R.id.ciencias);
        final LinearLayout geografia = findViewById (R.id.geografia);

        final Button startBton = findViewById (R.id.startQuiz);

        matematica.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                selectTopicName = "matematica";

                matematica.setBackgroundResource (R.drawable.round_back_white_stroker10);
                portugues.setBackgroundResource (R.drawable.round_black_white);
                ciencias.setBackgroundResource (R.drawable.round_black_white);
                geografia.setBackgroundResource (R.drawable.round_black_white);
            }
        });

        portugues.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                selectTopicName = "portugues";

                portugues.setBackgroundResource (R.drawable.round_back_white_stroker10);
                matematica.setBackgroundResource (R.drawable.round_black_white);
                ciencias.setBackgroundResource (R.drawable.round_black_white);
                geografia.setBackgroundResource (R.drawable.round_black_white);
            }
        });

        ciencias.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                selectTopicName = "ciencias";

                ciencias.setBackgroundResource (R.drawable.round_back_white_stroker10);
                portugues.setBackgroundResource (R.drawable.round_black_white);
                matematica.setBackgroundResource (R.drawable.round_black_white);
                geografia.setBackgroundResource (R.drawable.round_black_white);
            }
        });

        geografia.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                selectTopicName = "geografia";

                geografia.setBackgroundResource (R.drawable.round_back_white_stroker10);
                portugues.setBackgroundResource (R.drawable.round_black_white);
                ciencias.setBackgroundResource (R.drawable.round_black_white);
                matematica.setBackgroundResource (R.drawable.round_black_white);
            }
        });

        startBton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                if (selectTopicName.isEmpty ()){
                    Toast.makeText (MainActivity.this, "selecione o topico", Toast.LENGTH_SHORT).show ();
                }
                else{
                    Intent intent = new Intent(MainActivity.this, QuizActivity.class );
                    intent.putExtra ("selectedTopic", selectTopicName);
                    startActivity (intent);
                }
            }
        });

    }
};