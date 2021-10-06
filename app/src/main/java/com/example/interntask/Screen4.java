package com.example.interntask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Screen4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen4);


        TextView trans = (TextView)findViewById(R.id.Transaction);
        TextView mess = (TextView)findViewById(R.id.Message);

        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Screen4.this, NameActivity.class);
                myIntent.putExtra("0","Transaction");
                startActivity(myIntent);
            }
        });

        mess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Screen4.this, NameActivity.class);
                myIntent.putExtra("0","Message");
                startActivity(myIntent);
            }
        });


    }

    public void jumpBackTo1(View view)
    {
        Intent intent = new Intent( Screen4.this, Screen1.class);
        startActivity(intent);
        overridePendingTransition( R.anim.slide_out_down, R.anim.slide_in_down );

    }

}