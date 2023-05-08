package com.example.myaccounting21410100039;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.sql.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public DatePickerDialog datePickerDialog;
    public Button dateButton, btnLaporan, btnTambah;
    public TextView txtDate2;

    public EditText txtTransaksi, txtKeterangan, txtDebet, txtKredit;

    public View viewLayout;

//    Object with Class
    Transaksi transaksi = new Transaksi();

//  Stored in Arraylist
    ArrayList<Transaksi> alTransaksi = new ArrayList<Transaksi>();

    String idTransaksi, keterangan;

    Integer debit = 0, kredit = 0, logo;

    public transaksiAdapter cTransaksiAdapter = new transaksiAdapter();
    public transaksiAdapter xTransaksiAdapter = new transaksiAdapter();

    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    ListView listView;
    Date tanggal;


    public void getValues(){
        idTransaksi = String.valueOf(txtTransaksi.getText().toString());
        Log.d("TEST", "idTransaksi: " + idTransaksi);

        keterangan = String.valueOf(txtKeterangan.getText().toString());
        Log.d("TEST", "Keterangan: " + keterangan);
        try {
            Log.d("TEST", "MASUK SINIIIIIIIIIIIIII ");
            if(!txtDate2.getText().toString().isEmpty()){
                Log.d("TEST", "Tanggal Sebelum: " + tanggal);
                tanggal = sdf.parse(txtDate2.getText().toString());
                Log.d("TEST", "Tanggal: " + tanggal);
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        if(debit > kredit){
            logo = R.drawable.debet;
            kredit = 0;
        }else if(debit < kredit){
            logo = R.drawable.kredit;
            debit = 0;
        }
        Log.d("TEST", "logo: " + logo);
        Log.d("TEST", "kredit: " + kredit);
        Log.d("TEST", "debit: " + debit);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if(getIntent() != null){
//            Log.d("SDSDSDDS", "SDSDSDSDSDDS!!!!!!!!");
//            Intent i = getIntent();
//            ArrayList<Transaksi> oTransaksi = (ArrayList<Transaksi>) i.getSerializableExtra("key1");
//
////            Log.d("SDSDSD")
//            xTransaksiAdapter = new transaksiAdapter(getApplicationContext(), oTransaksi);
//            listView.setAdapter(xTransaksiAdapter);
//        }

        Context context = getApplicationContext();
//        Context context;
//        Button
        dateButton = findViewById(R.id.btnDatePicker);
        txtDate2 = findViewById(R.id.txtDate2);
        btnLaporan = findViewById(R.id.btnLaporan);
        btnTambah = findViewById(R.id.btnTambah);
        listView = findViewById(R.id.listView);

//        TextView
       txtTransaksi = findViewById(R.id.txtTransaksi);
       txtKeterangan = findViewById(R.id.txtKeterangan);
       txtDebet = (EditText) findViewById(R.id.txtDebet);
       txtKredit = (EditText) findViewById(R.id.txtKredit);





//

        btnTambah.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {




                if(!txtDebet.getText().toString().isEmpty()){
                    debit = Integer.valueOf(String.valueOf(txtDebet.getText()));
                }
                if(!txtKredit.getText().toString().isEmpty()){
                    kredit = Integer.valueOf(String.valueOf(txtKredit.getText()));
                }
                getValues();

                Log.d("Console", String.valueOf(debit));
                Log.d("Console", String.valueOf(kredit));
                Log.d("Console", "test");
                if(debit == kredit){
                    Log.d("Console", "Masuk Debet & Kredit");
                    Toast toast = Toast.makeText(context, "Error!, Kredit dan Debet tidak boleh sama", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    transaksi = new Transaksi(idTransaksi, keterangan, tanggal, debit, kredit, logo);
                    alTransaksi.add(transaksi);

                    cTransaksiAdapter = new transaksiAdapter(getApplicationContext(), alTransaksi);
                    listView.setAdapter(cTransaksiAdapter);

                    for(int i = 0; i < alTransaksi.size(); i++){
                        Log.d("S", "$$$$$$$$$$$$$$$$$ : ");
                        Log.d("S", "idTrans : " + alTransaksi.get(i).getIdTransaksi());
                        Log.d("S", "uraian : " + alTransaksi.get(i).getUraian());
                        Log.d("S", "debit : " + alTransaksi.get(i).getDebit());
                        Log.d("S", "kredit : " + alTransaksi.get(i).getKredit());
                        Log.d("S", "tgl : " + alTransaksi.get(i).getTanggalTransaksi());
                        Log.d("S", "logo : " + alTransaksi.get(i).getLogo());
                    }

                }
            }
        });


        btnLaporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), laporanController.class);
                i.putExtra("key", alTransaksi);
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
                        txtDate2.setText(dayOfMonth + "-" + (month + 1) +  "-" + year);
                    }
                },year, month, day);

                datePickerDialog.show();
            }
        });
    }

//    Intent




}