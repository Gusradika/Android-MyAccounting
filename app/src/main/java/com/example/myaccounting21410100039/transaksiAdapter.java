package com.example.myaccounting21410100039;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class transaksiAdapter extends BaseAdapter {

    Context context;
    String curDate = "";
    ArrayList<String> idTransaksi = new ArrayList<>();
    ArrayList<String> keterangan = new ArrayList<>();
    ArrayList<Date> tanggal = new ArrayList<>();
    ArrayList<Integer> debit = new ArrayList<>();
    ArrayList<Integer> kredit = new ArrayList<>();
    ArrayList<Integer> logo = new ArrayList<>();

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    LayoutInflater inflater;

    public transaksiAdapter() {
    }

    public transaksiAdapter(Context context, ArrayList<Transaksi> listTransaksi) {
        for (int i = 0; i < listTransaksi.size(); i++) {
            idTransaksi.add(listTransaksi.get(i).getIdTransaksi());
            keterangan.add(listTransaksi.get(i).getUraian());
            tanggal.add(listTransaksi.get(i).getTanggalTransaksi());
            debit.add(listTransaksi.get(i).getDebit());
            kredit.add(listTransaksi.get(i).getKredit());
            logo.add(listTransaksi.get(i).getLogo());
        }
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return idTransaksi.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.layout_item, null);
        TextView tanggalView = (TextView) convertView.findViewById(R.id.txtTanggal);
        TextView keteranganView = (TextView) convertView.findViewById(R.id.txtKeterangan);
        TextView hargaView = (TextView) convertView.findViewById(R.id.txtHarga);
        ImageView logoView = (ImageView) convertView.findViewById(R.id.iconImage);
        curDate = sdf.format(tanggal.get(position));
//        tglTransaksi.setText();
        keteranganView.setText(keterangan.get(position).toString());
        tanggalView.setText(curDate);
        if(debit.get(position) != 0){
            hargaView.setText(debit.get(position).toString());
        }else{
            hargaView.setText(kredit.get(position).toString());
        }
//        hargaView.setText(harga.get(position).toString());
        logoView.setImageResource(logo.get(position));
//        if (debit.get(i) != 0) {
//            hrgTransaksi.setText(kredit.get(i));
//        } else {
//            hrgTransaksi.setText(debit.get(i));
//        }
        return convertView;
    }
}
