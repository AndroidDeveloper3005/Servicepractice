package com.example.himel.servicepractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name;
    Button service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.nameET);
        service= (Button) findViewById(R.id.servicebtn);
        service.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (service.getId() == view.getId()){
            Intent services = new Intent(this,MyService.class);
            startService(services);
        }

    }
}
