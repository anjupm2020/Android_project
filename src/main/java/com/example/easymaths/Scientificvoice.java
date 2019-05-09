package com.example.easymaths;



import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Scientificvoice extends AppCompatActivity implements TextToSpeech.OnInitListener{
    TextView firstNumTextView;
    TextView secondNumTextView;
    TextView operatorTextView;
    TextView resultTextView;
    Button goButton;

    TextToSpeech textToSpeech;

    int FIRST_NUMBER;
    int SECOND_NUMBER;
    String OPERATOR;
    int RESULT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientificvoice);

        textToSpeech = new TextToSpeech(this, this);
        firstNumTextView = findViewById(R.id.firstNumTextView);
        secondNumTextView = findViewById(R.id.secondNumTextView);
        operatorTextView = findViewById(R.id.operatorTextView);
        resultTextView = findViewById(R.id.resultTextView);
        goButton = findViewById(R.id.goButton);

        firstNumTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH);
                startActivityForResult(intent, 10);
            }
        });
        secondNumTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH);
                startActivityForResult(intent, 20);
            }
        });

        operatorTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH);
                startActivityForResult(intent, 30);
            }
        });
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RESULT = performCalculations();
                resultTextView.setText(String.valueOf(RESULT));
                textToSpeech.speak(String.valueOf(RESULT), TextToSpeech.QUEUE_ADD, null);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {
            switch (requestCode) {
                case 10:
                    int intFound = getNumberFromResult(data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS));
                    if (intFound != -1) {
                        FIRST_NUMBER = intFound;
                        firstNumTextView.setText(String.valueOf(intFound));
                    } else {
                        Toast.makeText(getApplicationContext(), "Sorry, I didn't catch that! Please try again", Toast.LENGTH_LONG).show();
                    }
                    break;
                case 20:
                    intFound = getNumberFromResult(data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS));
                    if (intFound != -1) {
                        SECOND_NUMBER = intFound;
                        secondNumTextView.setText(String.valueOf(intFound));
                    } else {
                        Toast.makeText(getApplicationContext(), "Sorry, I didn't catch that! Please try again", Toast.LENGTH_LONG).show();
                    }
                    break;
                case 30:
                    String operatorFound = getCharOperatorFromResult(data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS));
                    if (operatorFound != "0") {
                        OPERATOR = operatorFound;
                        operatorTextView.setText(String.valueOf(operatorFound));
                    } else {
                        Toast.makeText(getApplicationContext(), "Sorry, I didn't catch that! Please try again", Toast.LENGTH_LONG).show();
                    }
            }
        } else {
            Toast.makeText(getApplicationContext(), "Failed to recognize speech!", Toast.LENGTH_LONG).show();
        }
    }




    // method to loop through results trying to find a number
    private int getNumberFromResult(ArrayList<String> results) {
        for (String str : results) {
            if (getIntNumberFromText(str) != -1) {
                return getIntNumberFromText(str);
            }
        }
        return -1;
    }
    // method to loop through results trying to find an operator
    private String  getCharOperatorFromResult(ArrayList<String> results) {
        for (String str : results) {
            if (getCharOperatorFromText(str) != "0") {
                return getCharOperatorFromText(str);
            }
        }
        return "0";
    }
    private int getIntNumberFromText(String str) {

        str = str.replaceAll("zero", "0");
        str = str.replaceAll("one", "1");
        str = str.replaceAll("two", "2");
        str = str.replaceAll("three", "3");
        str = str.replaceAll("four", "4");
        str = str.replaceAll("five", "5");
        str = str.replaceAll("six", "6");
        str = str.replaceAll("seven", "7");
        str = str.replaceAll("eight", "8");
        str = str.replaceAll("nine", "9");


        str = str.replaceAll("times?", "x");
        str = str.replaceAll("multipl(y|ied)", "x");

        str = str.replaceAll("plus", "+");

        str = str.replaceAll("minus|negative", "-");

        str =  str.replaceAll("divid(ed)?", "/");
        str =  str.replaceAll("over", "/");

        str = str.replaceAll("power", "^");

        str = str.replaceAll("open(ed)? bracket(s)?", "(");
        str = str.replaceAll("close(d)? bracket(s)?", ")");

        str = str.replaceAll("[a-z]", "");


        return Integer.parseInt(str);




    }



    // method to convert string operator to char



    private String getCharOperatorFromText(String strOper) {
        switch (strOper) {
            case "sin":
                return "sin";
            case "cos":
                return "cos";
            case "tan":
                return "tan";
            case "sec":
                return "sec"; case "cosec":
                return "cosec";  case "cot":
                return "cot"; case "log":
                return "log";
            case "squaroot":
                return "squaroot";
            case "plus":
            case "add":
                return "+";
            case "minus":
            case "subtract":
                return "-";
            case "times":
            case "multiply":
                return "*";
            case "divided by":
            case "divide":
                return "/";
            case "power":
            case "raised to":
                return "/";
        }
        return "0";


    }

    private int performCalculations() {
        switch (OPERATOR) {
            case "+":
                return FIRST_NUMBER + SECOND_NUMBER;
            case "-":
                return FIRST_NUMBER - SECOND_NUMBER;
            case "*":
                return FIRST_NUMBER * SECOND_NUMBER;
            case "/":
                return FIRST_NUMBER / SECOND_NUMBER;
            case "^":
                return FIRST_NUMBER ^ SECOND_NUMBER;

            case "sin":

                double m=Math.sin(FIRST_NUMBER);
                return (int) m;

            case "cos":
                double c=Math.cos(FIRST_NUMBER);
                return (int) c;
            case "tan":
                double t=Math.tan(FIRST_NUMBER);
                return (int) t;

            case "squareoot":
                double s=Math.sqrt(FIRST_NUMBER);
                return (int) s;
            case "cube":
                double cb=FIRST_NUMBER*FIRST_NUMBER*FIRST_NUMBER;
                return (int) cb;
            case "exponent":
                double e=Math.exp(FIRST_NUMBER);
                return (int) e;
            case "raisedto":
            case "square":
                double r=FIRST_NUMBER *FIRST_NUMBER;
                return (int) r;

            case "log":
                double l=Math.log(FIRST_NUMBER);
                return (int) l;


        }
        return 0;
    }
    @Override
    public void onInit(int i) {

    }
}
