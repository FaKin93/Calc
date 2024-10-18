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
    String operator;

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
        if (isNew)
        {
            editText.setText("");
        }
        isNew = false;
        String number = editText.getText().toString();
        if(view.getId() == R.id.button0)
        {
            number += "0";
        }else if(view.getId() == R.id.button1)
        {
            number += "1";
        }else if(view.getId() == R.id.button2)
        {
            number += "2";
        }else if(view.getId() == R.id.button3)
        {
            number += "3";
        }else if(view.getId() == R.id.button4)
        {
            number += "4";
        }else if(view.getId() == R.id.button5)
        {
            number += "5";
        }else if(view.getId() == R.id.button6)
        {
            number += "6";
        } else if(view.getId() == R.id.button7)
        {
            number += "7";
        } else if (view.getId() == R.id.button8)
        {
            number += "8";
        }else if (view.getId() == R.id.button9)
        {
            number += "9";
        }else if (view.getId() == R.id.buttonPoint)
        {
            number += ".";
        }else if (view.getId() == R.id.buttonPlusMinus)
        {
            number = "-" + number;
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
        if (!operator.isEmpty())
        {
        if(operator == "-")
        {
            result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
        }else if(operator == "+")
        {
            result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
        }else if(operator == "*")
        {
            result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
        }else if(operator == "/")
        {
            result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
        }
        editText.setText(result + "");
        }else
        {
            editText.setText(oldNumber);
        }
    }

    public void acClick(View view) {
        editText.setText("0");
        isNew = true;
    }
}