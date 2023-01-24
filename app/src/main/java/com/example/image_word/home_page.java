package com.example.image_word;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.Instant;

public class home_page extends AppCompatActivity {

    Button play;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        play = findViewById(R.id.play);
        textView = findViewById(R.id.level);
        sharedPreferences = getSharedPreferences("memory",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        if(!sharedPreferences.contains("score"))
        {
            System.out.println("not available");
            editor.putInt("score",200);
            editor.commit();
        }
        else {
            System.out.println("score available");
        }

        int level = sharedPreferences.getInt("level",0);
        System.out.println("current level = "+level);
        if(level==0)
        {
            textView.setText(""+(level+1));
        }
        else {
            textView.setText(""+(level+2));
        }

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home_page.this,lavel_1.class);
                if(level==0)
                {
                    intent.putExtra("pos",level);
                }
                else
                {
                    intent.putExtra("pos",level+1);
                }
                startActivity(intent);
            }
        });
    }
}