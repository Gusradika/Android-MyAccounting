package com.example.myaccounting21410100039;

import java.io.Serializable;
import java.util.Date;

public class Transaksi implements Serializable {

    String idTransaksi, uraian;

    Date tanggalTransaksi;

    Integer debit,kredit, logo;

    public Transaksi(){

    }

    public Transaksi(String idTransaksi, String uraian, Date tanggalTransaksi, Integer debit, Integer kredit, Integer logo){
        this.idTransaksi = idTransaksi;
        this.uraian = uraian;
        this.tanggalTransaksi = tanggalTransaksi;
        this.debit = debit;
        this.kredit = kredit;
        this.logo = logo;
    }

    public String getIdTransaksi(){
        return idTransaksi;
    }

    public String getUraian(){
        return uraian;
    }

    public Date getTanggalTransaksi(){
        return tanggalTransaksi;
    }

    public Integer getDebit(){
        return debit;
    }

    public Integer getKredit(){
        return kredit;
    }

    public Integer getLogo(){
        return logo;
    }

}
