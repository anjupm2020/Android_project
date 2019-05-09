package com.example.easymaths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    Button bsimple,bscientific,bnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bsimple=(Button)findViewById(R.id.bsimple);
        bscientific=(Button)findViewById(R.id.bscientific);
        bnumber=(Button)findViewById(R.id.bnumber);
        bsimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Home.this,Simple.class);
                startActivity(in);
            }
        });
        bscientific.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Home.this,Scientific.class);
                startActivity(in);
            }
        });
        bnumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Home.this,Number.class);
                startActivity(in);
            }
        });
    }
}
