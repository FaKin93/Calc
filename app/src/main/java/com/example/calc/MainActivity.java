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
        }
        editText.setText(number);

    }
}