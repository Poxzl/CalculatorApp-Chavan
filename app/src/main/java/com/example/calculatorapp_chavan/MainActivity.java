package com.example.calculatorapp_chavan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Initializes variables for the current button and the output.
    String selectedButton = "PLUS";
    double outputNum = 0;

    //Used stackoverflow to find how to automatically call a function
    //https://stackoverflow.com/questions/3072173/how-to-call-a-method-after-a-delay-in-android
    //A handler is used to do this.
    //The handler is first created.
    private final Handler handler = new Handler();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button plusButton = findViewById(R.id.plusButton);
        plusButton.setBackgroundColor(Color.parseColor("#B80365"));
        //The handler creates the delay to call the function, I chose every second.
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
    //The runnable function is called every second to call the updateOutput function.
    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //calls the updateOutput function.
            updateOutput();

            // created the delay between each period of calling the function.
            handler.postDelayed(this, 1000);
        }
    };


    public void setPlus(View view) {
        selectedButton = "PLUS";
        Button plusButton = findViewById(R.id.plusButton);
        plusButton.setBackgroundColor(Color.parseColor("#B80365"));
        Button minusButton = findViewById(R.id.minusButton);
        minusButton.setBackgroundColor(Color.parseColor("#006973"));
        Button timesButton = findViewById(R.id.timesButton);
        timesButton.setBackgroundColor(Color.parseColor("#006973"));
        Button divideButton = findViewById(R.id.divideButton);
        divideButton.setBackgroundColor(Color.parseColor("#006973"));
    }
    public void setMinus(View view) {
        selectedButton = "MINUS";
        Button plusButton = findViewById(R.id.plusButton);
        plusButton.setBackgroundColor(Color.parseColor("#006973"));
        Button minusButton = findViewById(R.id.minusButton);
        minusButton.setBackgroundColor(Color.parseColor("#B80365"));
        Button timesButton = findViewById(R.id.timesButton);
        timesButton.setBackgroundColor(Color.parseColor("#006973"));
        Button divideButton = findViewById(R.id.divideButton);
        divideButton.setBackgroundColor(Color.parseColor("#006973"));
    }
    public void setTimes(View view) {
        selectedButton = "TIMES";
        Button plusButton = findViewById(R.id.plusButton);
        plusButton.setBackgroundColor(Color.parseColor("#006973"));
        Button minusButton = findViewById(R.id.minusButton);
        minusButton.setBackgroundColor(Color.parseColor("#006973"));
        Button timesButton = findViewById(R.id.timesButton);
        timesButton.setBackgroundColor(Color.parseColor("#B80365"));
        Button divideButton = findViewById(R.id.divideButton);
        divideButton.setBackgroundColor(Color.parseColor("#006973"));
    }
    public void setDivide(View view) {
        selectedButton = "DIVIDE";
        Button plusButton = findViewById(R.id.plusButton);
        plusButton.setBackgroundColor(Color.parseColor("#006973"));
        Button minusButton = findViewById(R.id.minusButton);
        minusButton.setBackgroundColor(Color.parseColor("#006973"));
        Button timesButton = findViewById(R.id.timesButton);
        timesButton.setBackgroundColor(Color.parseColor("#006973"));
        Button divideButton = findViewById(R.id.divideButton);
        divideButton.setBackgroundColor(Color.parseColor("#B80365"));
    }

    public void updateOutput(){
        EditText firstNum = findViewById(R.id.firstInput);
        EditText secondNum = findViewById(R.id.secondInput);
        TextView outputText = findViewById(R.id.outputText);
        double num1;
        double num2;

        //used stackOverflow to find how to check if the two inputs are empty
        //https://stackoverflow.com/questions/6290531/how-do-i-check-if-my-edittext-fields-are-empty
        //this code gets the string, then deletes all the spaces,
        // then gets the final length and checks if its more than 0.
        if (firstNum.getText().toString().trim().length() > 0){
            num1 = Double.parseDouble(firstNum.getText().toString());
        } else{
            num1 = 0;
        }

        if (secondNum.getText().toString().trim().length() > 0){
            num2 = Double.parseDouble(secondNum.getText().toString());
        } else{
            num2 = 0;
        }

        //Log.d("settingoutput", firstNum.getText().toString());
        if(selectedButton == "PLUS"){
            outputNum = num1 + num2;
        } else if(selectedButton == "MINUS"){
            outputNum = num1 - num2;
        } else if(selectedButton == "TIMES"){
            outputNum = num1 * num2;
        } else if(selectedButton == "DIVIDE") {
            outputNum = num1 / num2;
        }
        outputText.setText("" + outputNum);
    }
    //Destroys the handler timer after the app ends so it doesnt continue after closing.
    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Stop calling the function every second
        handler.removeCallbacks(runnable);
    }

    //public void changeTheme(){
        //code to change from light to dark and dark to light
    //}

}