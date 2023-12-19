package src.main.semesterprojektet;

public class    Bruger {
    private String brugernavn;
    private String kodeord;
    private String email;

    public Bruger() {
    }

    public Bruger(String brugernavn, String kodeord, String email) {
        this.brugernavn = brugernavn;
        this.kodeord = kodeord;
        this.email = email;
    }

    public String getBrugernavn() {
        return brugernavn;
    }

    public void setBrugernavn(String brugernavn) {
        this.brugernavn = brugernavn;
    }

    public String getKodeord() {
        return kodeord;
    }

    public void setKodeord(String kodeord) {
        this.kodeord = kodeord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
