package com.example.domain.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
       // Intent goToNextActivity = new Intent(getApplicationContext(), LoginActivity.class);
        Intent goToNextActivity = new Intent(getApplicationContext(), MapsActivity.class);
       // Intent goToNextActivity = new Intent(getApplicationContext(), DisplayImageActivity.class);
        startActivity(goToNextActivity);
    }
}
