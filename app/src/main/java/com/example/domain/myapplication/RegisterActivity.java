package com.example.domain.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;


public class RegisterActivity extends AppCompatActivity {

    Button b1,b2;
    EditText ed1, ed2, ed3, ed4;


    private  int isAllValid()
    {
        if (!isLoginValid())return 1;
        if (!isEmailValid())return 2;
        if (!isPasswordValid())return 3;
        return 0;
    }

    private String communicate(int val)
    {
        switch(val)
        {
            case 0: return "Rejestracja przebiegła poprawnie";
            case 1: return "Niepoprawny login";
            case 2: return "Niepoprawny email";
            case 3: return "Niepoprawne hasło";
            default: return "Nieznany błąd";
        }

    }

    private boolean isEmailValid() {
        String email = ed2.getText().toString();
        if(email.length()>0 && email.matches("\\w+@\\w+\\.\\w+")) return true;
        else return false;
    }

    private boolean isLoginValid() {
        String login = ed1.getText().toString();
        if(login.length()>0) return true;
        else return false;
    }

    private boolean isPasswordValid() {
        String h1 = ed3.getText().toString();
        String h2 = ed4.getText().toString();
        if(h1.equals(h2)&& h1.length() >= 8)
        {
            return true;
        }
        else return false;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        ed3 = (EditText) findViewById(R.id.editText3);
        ed4 = (EditText) findViewById(R.id.editText4);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getApplicationContext(), communicate(isAllValid()), Toast.LENGTH_SHORT).show();
                // dodawanie do plaintexta z hasłami poki nie ma laczenia z serwerem
                if (isAllValid()==0)
                {
                    String record = String.format("%s#%s\n",ed1.getText().toString(),ed3.getText().toString() );
                    FileOutputStream outputStream;

                    try {
                        outputStream = openFileOutput("passes.txt",MODE_APPEND);
                        outputStream.write(record.getBytes());
                        outputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            finish();

            }
        });



    }
}
