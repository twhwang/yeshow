package com.example.project_005;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("UI구현 평가5：YE-SHOW");

        Gallery tGallery = (Gallery) findViewById(R.id.themeGallery);
        themeGallery tg = new themeGallery(this);
        tGallery.setAdapter(tg);

        Button btnReservation = (Button) findViewById(R.id.btnReservation);
        btnReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loadRV = new Intent(getApplicationContext(), reservation.class);
                startActivity(loadRV);
            }
        });

        Button loadGridView = (Button) findViewById(R.id.loadGridView);
        loadGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loadGV = new Intent(getApplicationContext(), loadGridView.class);
                startActivity(loadGV);
            }
        });

    }
}