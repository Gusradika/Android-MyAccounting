package com.example.myaccounting21410100039;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private Button dateButton, btnLaporan;
    private TextView txtDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateButton = findViewById(R.id.btnDatePicker);
        txtDate = findViewById(R.id.txtDate);
        btnLaporan = findViewById(R.id.btnLaporan);


        btnLaporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), laporanController.class);
                startActivity(i);
            }
        });



        dateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(

                        MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Log.d("TANGGAL", year + " " + month + " " + dayOfMonth);
                        txtDate.setText(dayOfMonth + "-" + (month + 1) +  "-" + year);
                    }
                },year, month, day);

                datePickerDialog.show();
            }
        });
    }

//    Intent




}