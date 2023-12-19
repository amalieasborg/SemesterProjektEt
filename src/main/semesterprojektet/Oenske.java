package src.main.semesterprojektet;

public class Oenske {
    private int Id;
    private int brugerId;
    private int oenskelistenr;
    private String navn;
    private int pris;
    private String beskrivelse;
    private String link;
    private int reserveret;

    public Oenske() {
    }

    public Oenske(int brugerId, int oenskelistenr, String navn, int pris, String beskrivelse, String link, int reserveret) {
        this.brugerId = brugerId;
        this.oenskelistenr = oenskelistenr;
        this.navn = navn;
        this.pris = pris;
        this.beskrivelse = beskrivelse;
        this.link = link;
        this.reserveret = reserveret;
    }

    public int getId() {return Id;}
    public void setId(int id) {Id = id;}

    public int getBrugerId() {return brugerId;}

    public void setBrugerId(int brugerId) {this.brugerId = brugerId;}

    public int getOenskelistenr() {return oenskelistenr;}

    public void setOenskelistenr(int oenskelistenr) {this.oenskelistenr = oenskelistenr;}

    public String getNavn() {return navn;}

    public void setNavn(String navn) {this.navn = navn;}

    public int getPris() {return pris;}

    public void setPris(int pris) {this.pris = pris;}

    public String getBeskrivelse() {return beskrivelse;}

    public void setBeskrivelse(String beskrivelse) {this.beskrivelse = beskrivelse;}

    public String getLink() {return link;}

    public void setLink(String link) {this.link = link;}

    public int getReserveret() {return reserveret;}

    public void setReserveret(int reserveret) {this.reserveret = reserveret;}

    @Override
    public String toString() {
        return "Oenske{" +
                "Id=" + Id +
                ", brugerId=" + brugerId +
                ", oenskelistenr=" + oenskelistenr +
                ", navn='" + navn + '\'' +
                ", pris=" + pris +
                "kr , beskrivelse='" + beskrivelse + '\'' +
                ", link='" + link + '\'' +
                ", reserveret=" + reserveret +
                '}';
    }
}
