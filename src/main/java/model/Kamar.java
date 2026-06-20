/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ikhramfahrezi
 */
public class Kamar {
    private String noKamar;
    private String tipeKamar;
    private String namaTamu;
    private int durasiInap;
    private String status; 

    public Kamar(String noKamar, String tipeKamar, String namaTamu, int durasiInap, String status) {
        this.noKamar = noKamar;
        this.tipeKamar = tipeKamar;
        this.namaTamu = namaTamu;
        this.durasiInap = durasiInap;
        this.status = status;
    }

    public String getNoKamar() { return noKamar; }
    public void setNoKamar(String noKamar) { this.noKamar = noKamar; }

    public String getTipeKamar() { return tipeKamar; }
    public void setTipeKamar(String tipeKamar) { this.tipeKamar = tipeKamar; }

    public String getNamaTamu() { return namaTamu; }
    public void setNamaTamu(String namaTamu) { this.namaTamu = namaTamu; }

    public int getDurasiInap() { return durasiInap; }
    public void setDurasiInap(int durasiInap) { this.durasiInap = durasiInap; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
