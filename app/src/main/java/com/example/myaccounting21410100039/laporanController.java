package com.example.myaccounting21410100039;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class laporanController extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laporan);

    }

    @Override
    public void onClick(View v) {

    }


    public void back(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
