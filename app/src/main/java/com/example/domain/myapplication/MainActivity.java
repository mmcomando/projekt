package com.example.domain.myapplication;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Intent goToNextActivity = new Intent(getApplicationContext(), LoginActivity.class);
        //Intent goToNextActivity = new Intent(getApplicationContext(), MapsActivity.class);
        //Intent goToNextActivity = new Intent(getApplicationContext(), DisplayImageActivity.class);
        //startActivity(goToNextActivity);
    }

    public void addMediaOnClick(View view) {
        Intent intent = new Intent(this, AddMediaActivity.class);
        intent.putExtra("tripId", (String)null);
        intent.putExtra("pointId", (String)null);
        startActivity(intent);
    }

    public void mapsOnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        intent.putExtra("tripId", (String)null);
        startActivity(intent);
    }
    public void loginOnClick(View view) {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }
}
