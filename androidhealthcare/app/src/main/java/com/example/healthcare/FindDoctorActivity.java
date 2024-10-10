package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        CardView exit = findViewById(R.id.cardFDBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindDoctorActivity.this,HomeActivity.class));
            }
        });

        CardView primary_care_providers = findViewById(R.id.cardFDFamilyPhysician);
        primary_care_providers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Primary_care_providers");
                startActivity(it);
            }
        });

        CardView liver = findViewById(R.id.cardFDDietician);
      liver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","liver");
                startActivity(it);
            }
        });
        CardView kidney = findViewById(R.id.cardFDDentist);
        kidney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","kidney");
                startActivity(it);
            }
        });
        CardView cardiologists = findViewById(R.id.cardFDSurgeon);
        cardiologists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","cardiologists");
                startActivity(it);
            }
        });
        CardView neurologists = findViewById(R.id.cardFDCardiologists);
      neurologists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","neurologists");
                startActivity(it);
            }
        });
    }
}