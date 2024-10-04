package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewResult;
    private String currentInput = "";
    private String operator = "";
    private double firstValue = Double.NaN;
    private double secondValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);

        // Attach click listeners to buttons
        findViewById(R.id.btn0).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);

        findViewById(R.id.btnAdd).setOnClickListener(this);
        findViewById(R.id.btnSubtract).setOnClickListener(this);
        findViewById(R.id.btnMultiply).setOnClickListener(this);
        findViewById(R.id.btnDivide).setOnClickListener(this);
        findViewById(R.id.btnEqual).setOnClickListener(this);
        findViewById(R.id.btnClear).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;

        switch (button.getId()) {
            case R.id.btnClear:
                currentInput = "";
                operator = "";
                firstValue = Double.NaN;
                secondValue = Double.NaN;
                textViewResult.setText("0");
                break;

            case R.id.btnEqual:
                calculate();
                operator = "";
                break;

            case R.id.btnAdd:
            case R.id.btnSubtract:
            case R.id.btnMultiply:
            case R.id.btnDivide:
                operator = button.getText().toString();
                firstValue = Double.parseDouble(currentInput);
                currentInput = "";
                break;

            default:
                currentInput += button.getText().toString();
                textViewResult.setText(currentInput);
                break;
        }
    }

    private void calculate() {
        if (!Double.isNaN(firstValue)) {
            secondValue = Double.parseDouble(currentInput);
            switch (operator) {
                case "+":
                    firstValue += secondValue;
                    break;
                case "-":
                    firstValue -= secondValue;
                    break;
                case "*":
                    firstValue *= secondValue;
                    break;
                case "/":
                    if (secondValue != 0) {
                        firstValue /= secondValue;
                    } else {
                        textViewResult.setText("Error");
                        return;
                    }
                    break;
            }
            textViewResult.setText(String.valueOf(firstValue));
            currentInput = String.valueOf(firstValue);
        }
    }
}
