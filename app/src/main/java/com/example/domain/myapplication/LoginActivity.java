package com.example.domain.myapplication;


import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    Button b1, b2;
    EditText ed1, ed2;

    TextView tx1;

    private boolean validate_login(String login, String pass) {
        String result = "";
        HashMap<String, String> credentials = new HashMap<String, String>();
        FileInputStream inputStream;

        try {
            inputStream = openFileInput("passes.txt");
            BufferedReader myReader = new BufferedReader(new InputStreamReader(inputStream));
            String aDataRow = "";
            while ((aDataRow = myReader.readLine()) != null) {
                result = aDataRow;

                Matcher m = Pattern.compile("(.+)#(.+)").matcher(result);
                if (m.find()) {
                    credentials.put(m.group(1), m.group(2));

                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (credentials.get(login) != null) {
            if (credentials.get(login).equals(pass)) {
                Toast.makeText(getApplicationContext(), "Access granted", Toast.LENGTH_SHORT).show();
                return true;
            }
        }



    return false;

}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        b1 = (Button) findViewById(R.id.button);
        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);

        b2 = (Button) findViewById(R.id.button2);
        tx1 = (TextView) findViewById(R.id.textView3);
        tx1.setVisibility(View.VISIBLE);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate_login(ed1.getText().toString(), ed2.getText().toString())) {
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Niepoprawne hasło lub nazwa użytkownika", Toast.LENGTH_SHORT).show();

                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToNextActivity = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(goToNextActivity);


            }
        });


    }

}
