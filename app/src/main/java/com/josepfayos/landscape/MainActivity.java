package com.josepfayos.landscape;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private String[] preguntas = {"Pikachu es el pokemon num 1","La torre Eiffel hace 300 metros", "S1mple está roto", "El nombre del creador es Manolo"};
    private Boolean[] correctas = {false,true,true,false};
    public int i=0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView)findViewById(R.id.pregunta);
        TextView textView2 = (TextView)findViewById(R.id.TextoResultado);
        textView.setText(preguntas[i]);

        View myView = findViewById(R.id.next);
        myView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                textView2.setText("");
                int action = event.getAction();
                switch (action) {
                    case (MotionEvent.ACTION_DOWN):
                        if (i<preguntas.length-1) {
                            i++;
                        } else {
                            i = 0;
                        }
                        textView.setText(preguntas[i]);
                        return true;
                    default:
                        return true;
                }

            }
        });

        View myView2 = findViewById(R.id.previous);
        myView2.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                textView2.setText("");
                int action = event.getAction();
                switch (action) {
                    case (MotionEvent.ACTION_DOWN):
                        if (i>0){
                            i--;
                        } else {
                            i = preguntas.length-1;
                        }
                        textView.setText(preguntas[i]);
                        return true;
                    default:
                        return true;
                }

            }
        });

        View myView3 = findViewById(R.id.verdadero);
        myView3.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case (MotionEvent.ACTION_DOWN):
                        if (correctas[i] == true){
                            textView2.setText("HAS ACERTADO");
                            textView2.setTextColor(Color.rgb(50,205,50));
                        } else {
                            textView2.setText("HAS FALLADO");
                            textView2.setTextColor(Color.rgb(255,0,0));
                        }
                        return true;
                    default:
                        return true;
                }

            }
        });

        View myView4 = findViewById(R.id.falso);
        myView4.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case (MotionEvent.ACTION_DOWN):
                        if (correctas[i] == false){
                            textView2.setText("HAS ACERTADO");
                            textView2.setTextColor(Color.rgb(50,205,50));
                        } else {
                            textView2.setText("HAS FALLADO");
                            textView2.setTextColor(Color.rgb(255,0,0));
                        }
                        return true;
                    default:
                        return true;
                }

            }
        });
    }

};
