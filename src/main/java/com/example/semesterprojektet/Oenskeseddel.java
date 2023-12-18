package com.example.semesterprojektet;

public class Oenskeseddel {
    private int Id;
    private int oenskelistenr;
    private String Navn;


    public Oenskeseddel() {
    }

    public Oenskeseddel(int id, int oenskelistenr, String navn) {
        Id = id;
        this.oenskelistenr = oenskelistenr;
        Navn = navn;

    }
    public int getId() {return Id;}
    public void setId(int id) {        Id = id;    }

    public int getOenskelistenr() {        return oenskelistenr;    }

    public void setOenskelistenr(int oenskelistenr) {        this.oenskelistenr = oenskelistenr;    }

    public String getNavn() {        return Navn;    }

    public void setNavn(String navn) {        Navn = navn;    }
}
