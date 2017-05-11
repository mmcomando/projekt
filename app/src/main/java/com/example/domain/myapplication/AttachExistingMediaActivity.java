package com.example.domain.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class AttachExistingMediaActivity extends AppCompatActivity {

    private String tripId;
    private String pointId;
    private String mediaExtension;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        this.tripId = intent.getStringExtra("tripId");
        this.pointId = intent.getStringExtra("pointId");
        this.mediaExtension = intent.getStringExtra("mediaExtension");
        setContentView(R.layout.activity_attach_existing_media);
        addItemsToSpinner();
    }

    private void addItemsToSpinner() {
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("trip 1");
        list.add("trip 2");
        list.add("trip 3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }
}
