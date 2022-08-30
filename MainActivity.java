package com.example.romanconvertor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText et_input;
    EditText et_input_1;
    Button b_go;
    Button b_go_1;
    TextView tv_result;
    TextView tv_result_1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_input = (EditText) findViewById(R.id.et_input);
        b_go = (Button) findViewById(R.id.b_go);
        tv_result = (TextView) findViewById(R.id.tv_result);
        et_input_1 = (EditText) findViewById(R.id.et_input_1);
        b_go_1 = (Button) findViewById(R.id.b_go_1);
        tv_result_1 = (TextView) findViewById(R.id.tv_result_1);


        b_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_result.setText(integerToRomanConvert(Integer.parseInt(et_input.getText().toString())));
            }
        });
        b_go_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_result_1.setText(RomanToIntegerConvert(et_input_1.getText().toString()));
            }
        });

    }

    public String integerToRomanConvert(int input) {
        if(input < 1 || input > 10000) {
            return "Invalid Number";
        }
        String s = "";
        while(input >= 1000) {
            s += "M";
            input -= 1000;
        }
        while(input >= 900) {
            s += "CM";
            input -= 900;
        }
        while(input >= 500) {
            s += "D";
            input -= 500;
        }
        while(input >= 400) {
            s += "CD";
            input -= 400;
        }
        while(input >= 100) {
            s += "C";
            input -= 100;
        }
        while(input >= 90) {
            s += "XC";
            input -= 90;
        }
        while(input >= 50) {
            s += "L";
            input -= 50;
        }
        while(input >= 40) {
            s += "XL";
            input -= 40;
        }
        while(input >= 10) {
            s += "X";
            input -= 10;
        }
        while(input >= 9) {
            s += "IX";
            input -= 9;
        }
        while(input >= 5) {
            s += "V";
            input -= 5;
        }
        while(input >= 4) {
            s += "IV";
            input -= 4;
        }
        while(input >= 1) {
            s += "I";
            input -= 1;
        }
        return s;
    }
    public int vlaue(char r){
            if (r == 'I')
                return 1;
            if (r == 'V')
                return 5;
            if (r == 'X')
                return 10;
            if (r == 'L')
                return 50;
            if (r == 'C')
                return 100;
            if (r == 'D')
                return 500;
            if (r == 'M')
                return 1000;
            return -1;
        }
    public String RomanToIntegerConvert(String str){
        int res = 0;
        str = str.toUpperCase();

        for (int i = 0; i < str.length(); i++) {
            // Getting value of symbol s[i]
            int s1 = value(str.charAt(i));

            // Getting value of symbol s[i+1]
            if (i + 1 < str.length()) {
                int s2 = value(str.charAt(i + 1));

                // Comparing both values
                if (s1 >= s2) {
                    // Value of current symbol
                    // is greater or equalto
                    // the next symbol
                    res = res + s1;
                }
                else {
                    // Value of current symbol is
                    // less than the next symbol
                    res = res + s2 - s1;
                    i++;
                }
            }
            else {
                res = res + s1;
            }
        }

        return String.valueOf(res);
    }

    private int value(char r) {
            if (r == 'I')
                return 1;
            if (r == 'V')
                return 5;
            if (r == 'X')
                return 10;
            if (r == 'L')
                return 50;
            if (r == 'C')
                return 100;
            if (r == 'D')
                return 500;
            if (r == 'M')
                return 1000;
            return -1;
        }

}