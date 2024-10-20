package com.example.calc;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Boolean isNew = true;
    String oldNumber = "0";
    String operator = "is";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editText = findViewById(R.id.editText);
    }

    public void clickNumber(View view) {
        String number = editText.getText().toString();
        if (isNew)
        {
            if(view.getId() == R.id.button0)
            {
                number = "0";
            }else if(view.getId() == R.id.button1)
            {
                number = "1";
            }else if(view.getId() == R.id.button2)
            {
                number = "2";
            }else if(view.getId() == R.id.button3)
            {
                number = "3";
            }else if(view.getId() == R.id.button4)
            {
                number = "4";
            }else if(view.getId() == R.id.button5)
            {
                number = "5";
            }else if(view.getId() == R.id.button6)
            {
                number = "6";
            } else if(view.getId() == R.id.button7)
            {
                number = "7";
            } else if (view.getId() == R.id.button8)
            {
                number = "8";
            }else if (view.getId() == R.id.button9)
            {
                number = "9";
            }
            isNew = false;
        }else {
            if (view.getId() == R.id.button0) {
                number += "0";
            } else if (view.getId() == R.id.button1) {
                number += "1";
            } else if (view.getId() == R.id.button2) {
                number += "2";
            } else if (view.getId() == R.id.button3) {
                number += "3";
            } else if (view.getId() == R.id.button4) {
                number += "4";
            } else if (view.getId() == R.id.button5) {
                number += "5";
            } else if (view.getId() == R.id.button6) {
                number += "6";
            } else if (view.getId() == R.id.button7) {
                number += "7";
            } else if (view.getId() == R.id.button8) {
                number += "8";
            } else if (view.getId() == R.id.button9) {
                number += "9";
            } else if (view.getId() == R.id.buttonPoint) {
                if (dotIsPoint(number) && isNew) {
                    number += "0.";
                } else if (dotIsPoint(number)) {
                    number += ".";
                }
            } else if (view.getId() == R.id.buttonPlusMinus) {
                if (!minusIsPoint(number) && !isNew) {
                    number = "-" + number;
                } else {
                    number = number.substring(1);
                }
            }
        }
        editText.setText(number);

    }

    public void Operation(View view) {
        isNew = true;
        oldNumber = editText.getText().toString();
        if(view.getId() == R.id.buttonDivide)
        {
            operator = "/";
        }else if(view.getId() == R.id.buttonMinus)
        {
            operator = "-";
        }else if(view.getId() == R.id.buttonPlus)
        {
            operator = "+";
        }else if(view.getId() == R.id.buttonMultiply)
        {
            operator = "*";
        }

    }

    public void clickEqual(View view) {
        String newNumber = editText.getText().toString();
        double result = 0.0;
        if (operator != "is") {
            if (operator == "-") {
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
            } else if (operator == "+") {
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
            } else if (operator == "*") {
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
            } else if (operator == "/") {
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
            }
            editText.setText(result + "");
        }else
        {
            editText.setText("0");
            isNew = true;
        }

    }

    public void acClick(View view) {
        editText.setText("0");
        isNew = true;
    }

    public boolean dotIsPoint(String number)
    {
        int index = number.indexOf(".");
        if(index == -1)
        {
            return true;
        }else
        {
            return false;
        }
    }
    public boolean minusIsPoint(String number)
    {
        if(number.charAt(0) == '-')
        {
            return true;
        }else
        {
            return false;
        }
    }

    public void clickProcent(View view) {

    }
}