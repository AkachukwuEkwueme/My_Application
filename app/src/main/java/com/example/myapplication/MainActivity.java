package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    double firstNum;
    String operation;
    TextView screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setButtonClickListeners();
    }

    private void initializeViews() {
        screen = findViewById(R.id.screen);
    }

    private void setButtonClickListeners() {
        Button num0 = findViewById(R.id.num0);
        Button num1 = findViewById(R.id.num1);
        Button num2 = findViewById(R.id.num2);
        Button num3 = findViewById(R.id.num3);
        Button num4 = findViewById(R.id.num4);
        Button num5 = findViewById(R.id.num5);
        Button num6 = findViewById(R.id.num6);
        Button num7 = findViewById(R.id.num7);
        Button num8 = findViewById(R.id.num8);
        Button num9 = findViewById(R.id.num9);

        Button ac = findViewById(R.id.ac);
        Button del = findViewById(R.id.del);
        Button div = findViewById(R.id.div);
        Button times = findViewById(R.id.times);
        Button plus = findViewById(R.id.plus);
        Button min = findViewById(R.id.min);
        Button equal = findViewById(R.id.equal);
        Button point = findViewById(R.id.point);

        ac.setOnClickListener(view -> clearScreen());
        del.setOnClickListener(view -> deleteFromScreen());
        point.setOnClickListener(view -> addDecimalPoint());

        ArrayList<Button> nums = new ArrayList<>();
        nums.add(num0);
        nums.add(num1);
        nums.add(num2);
        nums.add(num3);
        nums.add(num4);
        nums.add(num5);
        nums.add(num6);
        nums.add(num7);
        nums.add(num8);
        nums.add(num9);

        for (Button b : nums) {
            b.setOnClickListener(view -> addToScreen(b.getText().toString()));
        }

        ArrayList<Button> opers = new ArrayList<>();
        opers.add(div);
        opers.add(times);
        opers.add(plus);
        opers.add(min);

        for (Button b : opers){
            b.setOnClickListener(view -> {
                setOperation(b.getText().toString());
            });
        }

        equal.setOnClickListener(view -> performCalculation());
    }

    private void addToScreen(String value) {
        String currentText = screen.getText().toString();
        if (currentText.equals("0")) {
            screen.setText(value);
        } else {
            screen.setText(currentText + value);
        }
    }

    private void clearScreen() {
        screen.setText("0");
    }

    private void deleteFromScreen() {
        String num = screen.getText().toString();
        if (num.length() > 1) {
            screen.setText(num.substring(0, num.length() - 1));
        } else if (num.length() == 1) {
            screen.setText("0");
        }
    }

    private void addDecimalPoint() {
        if (!screen.getText().toString().contains(".")) {
            screen.setText(screen.getText().toString() + ".");
        }
    }

    private void setOperation(String oper) {
        firstNum = Double.parseDouble(screen.getText().toString());
        operation = oper;
        screen.setText("0");
    }

    private void performCalculation() {
        double secondNum = Double.parseDouble(screen.getText().toString());
        double result;
        switch (operation){
            case "/":
                result = firstNum / secondNum;
                break;
            case "X":
                result = firstNum * secondNum;
                break;
            case "+":
                result = firstNum + secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
            default:
                result = firstNum + secondNum;
        }
        screen.setText(String.valueOf(result));
        firstNum = result;
    }
}
