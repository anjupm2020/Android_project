package com.example.easymaths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Simple extends AppCompatActivity  {
    EditText e1;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, bs, bm, bp, be, bc, bd, b0, bpercent, bce;
    double V1 = 0.1, V2 = 0.0;
    boolean mAdd, mSub, mMulti, mDivi;
   // boolean solved = false;
    boolean solvedWithouEqu = false;
    String Sign;
    ImageButton bmic,bchange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        e1 = (EditText) findViewById(R.id.e1);
        b0 = (Button) findViewById(R.id.b0);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.btn3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);
        bs = (Button) findViewById(R.id.bminus);
        bm = (Button) findViewById(R.id.btimes);
        bp = (Button) findViewById(R.id.bplus);
        be = (Button) findViewById(R.id.bequal);
        bc = (Button) findViewById(R.id.bc);
        bd = (Button) findViewById(R.id.bdivide);
        bchange = (ImageButton) findViewById(R.id.bchange);
        bpercent = (Button) findViewById(R.id.bpercentage);
        bce = (Button) findViewById(R.id.bce);
        bmic=(ImageButton)findViewById(R.id.bmic);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "9");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "9");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(e1.getText() + "0");
            }
        });
        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(" ");
            }
        });
        bmic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Simple.this,simplevoice.class);
                startActivity(in);
            }
        });

        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1 == null) {
                    e1.setText("");
                } else {
                    V1 = Float.parseFloat(e1.getText() + "");
                    mSub = true;
                    e1.setText(null);
                }
            }
        });
        bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                V1 = Double.parseDouble(e1.getText() + "");
                mMulti = true;
                e1.setText(null);
            }
        });
        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1 == null) {
                    e1.setText("");
                } else {
                    V1 = Float.parseFloat(e1.getText() + "");
                    mDivi = true;
                    e1.setText(null);
                }
            }
        });
        bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1 == null) {
                    e1.setText("");
                } else {
                    V1 = Float.parseFloat(e1.getText() + "");
                    mAdd = true;
                    e1.setText(null);
                }
            }
        });
        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                V2 = Float.parseFloat(e1.getText() + "");
                if (mAdd == true) {
                    e1.setText(V1 + V2 + "");
                    mAdd = false;
                }
                if (mSub == true) {
                    e1.setText(V1 - V2 + "");
                    mSub = false;
                }
                if (mMulti == true) {
                    e1.setText(V1 * V2 + "");
                    mMulti = false;
                }
                if (mDivi == true) {
                    e1.setText(V1 / V2 + "");
                    mDivi = false;
                }
            }
        });
        bpercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (V1 == 0.0) {
                        V1 = Double.parseDouble(e1.getText().toString());
                        e1.setText("");
                        Sign = "%";
                        V2 = Double.parseDouble("1");
                    } else {
                        Double V3 = V1 * (Double.parseDouble(e1.getText().toString()) / 100);
                        e1.setText(V3.toString());
                        Sign = "%";
                        solvedWithouEqu = true;
                    }
                } catch (Exception ex) {
                    e1.setText("0");
                } finally {

                }
            }
        });
        bce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int i = e1.getText().length();
                    e1.setText(e1.getText().subSequence(0, i - 1));
                    if (e1.getText() == null) {
                        V1 = 0.0;
                    }
                } catch (Exception ex) {
                    e1.setText("");
                } finally {

                }
            }
        });
        bchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Simple.this,Scientific.class);
                startActivity(in);
            }
        });
    }
}
