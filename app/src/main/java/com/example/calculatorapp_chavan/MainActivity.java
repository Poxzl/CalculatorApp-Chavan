package com.example.calculatorapp_chavan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final Handler handler = new Handler();
    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            updateOutput();

            // Post the Runnable again with a delay of 2000 milliseconds
            handler.postDelayed(this, 1000);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler.postDelayed(runnable, 1000);
    }
    public void clear1stInput(View v) {
        EditText firstNum = findViewById(R.id.firstInput);
        firstNum.getText().clear();
    }
    public void clear2ndInput(View v) {
        EditText secondNum = findViewById(R.id.secondInput);
        secondNum.getText().clear();
    }
    private void updateOutput(){
        EditText firstNum = findViewById(R.id.firstInput);
        TextView outputText = findViewById(R.id.outputText);
        Log.d("settingoutput", firstNum.getText().toString());
        outputText.setText(firstNum.getText().toString());
    }
    public void changeTheme(){
        //code to change from light to dark and dark to light
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Stop calling the function every second
        handler.removeCallbacks(runnable);
    }
}