package com.example.easymaths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Scientific extends AppCompatActivity {
    EditText txtAnswer;
    Button btn1, btn2,btn3, btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnStop,btnTanh,btnCosh,btnCoth,btnSqr;
    Button btnAdd, btnSubt,btnMult,btnEquals,btnSin,btnCos,btnTan,btnCe,btnC,btnDiv,btnPerc,btnLog,btnReg, btnDeg,btnExp;
    Double Answer; Double Val2 =0.0; Double Val1 =0.1;
    String Sign; boolean solved = false; boolean solvedWithouEqu = false,add,mul,sub,div;
    double n,m;
    ImageButton im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific3);
        im=(ImageButton)findViewById(R.id.im);
        txtAnswer = (EditText) findViewById(R.id.editText);
        btn0=(Button)findViewById(R.id.btn0);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        btn3=(Button)findViewById(R.id.btn3);
        btn4=(Button)findViewById(R.id.btn4);
        btn5=(Button)findViewById(R.id.btn5);
        btn6=(Button)findViewById(R.id.btn6);
        btn7=(Button)findViewById(R.id.btn7);
        btn9=(Button)findViewById(R.id.btn9);
        btn8=(Button)findViewById(R.id.btn8);
        btnC=(Button)findViewById(R.id.C);
        btnCe=(Button)findViewById(R.id.Ce);
        btnCos=(Button)findViewById(R.id.cos);
        btnTan=(Button)findViewById(R.id.tan);
        btnEquals=(Button)findViewById(R.id.equals);
        btnPerc=(Button)findViewById(R.id.perc);
        btnDiv=(Button)findViewById(R.id.div);
        btnAdd=(Button)findViewById(R.id.add);
        btnSubt=(Button)findViewById(R.id.subt);
        btnLog=(Button)findViewById(R.id.log);
        btnStop=(Button)findViewById(R.id.dot);btnMult=(Button)findViewById(R.id.mult);
        btnTanh=(Button)findViewById(R.id.tanh);btnCoth=(Button)findViewById(R.id.sinh);
        btnCosh=(Button)findViewById(R.id.cosh);btnSqr=(Button)findViewById(R.id.sqrt);
        btnSin=(Button)findViewById(R.id.sin);btnExp=(Button)findViewById(R.id.exp);
        btnDeg=(Button)findViewById(R.id.deg);btnReg=(Button)findViewById(R.id.rad);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtAnswer.setText(txtAnswer.getText()+ "0");

            }
        });

    }
}
