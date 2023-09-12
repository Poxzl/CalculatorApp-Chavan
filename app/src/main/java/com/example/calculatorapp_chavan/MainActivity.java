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
    //Used ChatGPT to use Handler.

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //handler.postDelayed(runnable, 1000);
    }
    public void clear1stInput(View v) {
        EditText firstNum = findViewById(R.id.firstInput);
        firstNum.getText().clear();
    }
    public void clear2ndInput(View v) {
        EditText secondNum = findViewById(R.id.secondInput);
        secondNum.getText().clear();
    }

    public void updateOutput(View view){
        EditText firstNum = findViewById(R.id.firstInput);
        EditText secondNum = findViewById(R.id.secondInput);
        TextView outputText = findViewById(R.id.outputText);

        int num1 = Integer.parseInt(firstNum.getText().toString());
        int num2 = Integer.parseInt(secondNum.getText().toString());

        Log.d("settingoutput", firstNum.getText().toString());

        int outputNum = num1 + num2;
        String outputNumString = "" + outputNum;
        outputText.setText("" + outputNum);
    }

    //public void changeTheme(){
        //code to change from light to dark and dark to light
    //}


    //@Override
    //Used ChatGPT. Destroys the handler after I shut the app down
   /*protected void onDestroy() {
        super.onDestroy();

        // Stop calling the function every second
        handler.removeCallbacks(runnable);
    }*/
}