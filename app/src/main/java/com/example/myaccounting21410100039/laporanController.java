package com.example.myaccounting21410100039;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class laporanController extends AppCompatActivity implements View.OnClickListener {


    ArrayList<Transaksi> cloned = new ArrayList<>();

    Integer debit = 0, kredit = 0, total = 0;

    TextView txtKredit, txtDebet, saldo;
//    Transaksi transaksi = new Transaksi();

//    ArrayList<Transaksi> alTransaksi = new ArrayList<Transaksi>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laporan);
        Intent i = getIntent();
        txtKredit = (TextView) findViewById(R.id.txtKredit);
        txtDebet = (TextView) findViewById(R.id.txtDebet);
        saldo = (TextView) findViewById(R.id.saldo);



        ArrayList<Transaksi> alTransaksi = (ArrayList<Transaksi>) i.getSerializableExtra("key");

//        Collections.copy(alTransaksi,cloned);
//        cloneObject(alTransaksi);
        for(int xi = 0; xi < alTransaksi.size(); xi++){
            debit += alTransaksi.get(xi).getDebit();
            kredit += alTransaksi.get(xi).getKredit();
        }
        Log.d("Math", "math: " + Integer.toString(debit));
        Log.d("Math", "math: " + Integer.toString(kredit));

//        debit = Integer.valueOf(String.valueOf(txtDebet.getText()));
//        kredit = Integer.valueOf(String.valueOf(txtKredit.getText()));
        total = kredit - debit;

        txtKredit.setText(kredit.toString());
        txtDebet.setText(debit.toString());
        saldo.setText(total.toString());

//        math();
    }

//    public void cloneObject(ArrayList x){
//        cloned = x;
//    }

//    public void math(){
//        for(int i = 0; i < alTransaksi.size(); i++){
//            debit += alTransaksi.get(i).getDebit();
//            kredit += alTransaksi.get(i).getKredit();
//        }
//        Log.d("Math", "math: " + Integer.toString(debit));
//        Log.d("Math", "math: " + Integer.toString(kredit));
//    }


    @Override
    public void onClick(View v) {

    }


    public void back(View v){
        Intent i = new Intent(this, MainActivity.class);
//        Intent xi = getIntent();
//        ArrayList<Transaksi> ee = (ArrayList<Transaksi>) xi.getSerializableExtra("key");
//        i.putExtra("key1", cloned);
        startActivity(i);
    }
}
