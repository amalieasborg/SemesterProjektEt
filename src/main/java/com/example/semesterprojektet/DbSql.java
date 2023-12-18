package com.example.semesterprojektet;
import java.sql.*;
import java.util.ArrayList;
public class DbSql {
    private Connection connection;
    private Statement stmt;
    private Statement stmt1;

    DbSql() {
        connection = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:C:/Users/nd070/OneDrive/Dokumenter/1.Semesterprojekt-samsung.db/";
            connection = DriverManager.getConnection(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Oenske> AlleOensker(int brugerId) {
        ArrayList<Oenske> oenskeliste = new ArrayList<>();
        try {
            String sql = "select * from Oenske where brugerId=" + String.valueOf(brugerId);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Oenske o = new Oenske();
                o.setId(rs.getInt("Id"));
                o.setNavn(rs.getString("navn"));
                o.setPris(rs.getInt("pris"));
                o.setBeskrivelse(rs.getString("beskrivelse"));
                o.setLink(rs.getString("link"));
                o.setReserveret(rs.getInt("reserveret"));
                oenskeliste.add(o);
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return oenskeliste;
    }

    public void opretOenskeseddel(Oenskeseddel s) {
        try {
            String sql = "insert into Oenskeseddel(Id,oenskelistenr,navn)";
            sql += " values (" + String.valueOf(s.getId()) + "," + String.valueOf(s.getOenskelistenr()) + ",'" + s.getNavn() + "')";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void opretBruger(Bruger b) {
        try {
            String sql = "insert into Bruger(brugernavn,kodeord,email)";
            sql += " values ('" + b.getBrugernavn() + "','" + b.getKodeord() + "','" + b.getEmail() + "')";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void opretOenske(Oenske o) {
        try {
            String sql = "insert into Oenske(brugerId,oenskelistenr,navn,pris,beskrivelse,link,reserveret)";
            sql += " values (" + String.valueOf(o.getBrugerId()) + "," + String.valueOf(o.getOenskelistenr()) + ",'" + o.getNavn() + "'," + String.valueOf(o.getPris()) + ",'" + o.getBeskrivelse() + "','" + o.getLink() + "'," + String.valueOf(0) + ")";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void sletOenske(Integer id) {
        try {
            String sql = "DELETE FROM Oenske WHERE id=" + String.valueOf(id);
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void sletOenskeseddel(Integer id, Integer oenskelistenr) {
        try {
            String sql = "DELETE FROM Oenskeseddel WHERE id=" + String.valueOf(id);
            sql += " and oenskelistenr =" + String.valueOf(oenskelistenr);
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void reserverGave(int Id) {
        try {

            String sql = "select * from Oenske where Id = " + String.valueOf(Id);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.getInt("reserveret") == 0) {
                sql = "update Oenske set reserveret =1 where Id = " + String.valueOf(Id);
                stmt = connection.createStatement();
                stmt.execute(sql);
                System.out.println("Connection to SQLite has been established.");
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void afReserverGave(int Id) {
        try {

            String sql = "select * from Oenske where Id = " + String.valueOf(Id);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.getInt("reserveret") == 1) {
                sql = "update Oenske set reserveret =0 where Id = " + String.valueOf(Id);
                stmt = connection.createStatement();
                stmt.execute(sql);
                System.out.println("Connection to SQLite has been established.");
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Oenske> specifikOenskeliste(int brugernavn, int oenskelistenr) {
        ArrayList<Oenske> oenskeliste = new ArrayList<>();
        try {
            String sql = "select * from Oenske where brugernavn=" + (brugernavn);
            sql += " and oenskelistenr =" + String.valueOf(oenskelistenr);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Oenske o = new Oenske();
                o.setBrugerId(rs.getInt("brugerId"));
                o.setOenskelistenr(rs.getInt("oenskelistenr"));
                o.setNavn(rs.getString("navn"));
                o.setPris(rs.getInt("pris"));
                o.setBeskrivelse(rs.getString("beskrivelse"));
                o.setLink(rs.getString("link"));
                o.setReserveret(rs.getInt("reserveret"));
                oenskeliste.add(o);
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return oenskeliste;
    }

    public ArrayList<Oenske> seAlleReserveredeOensker(int reserveret) {
        ArrayList<Oenske> oenskeliste = new ArrayList<>();
        try {
            String sql = "select * from Oenske where reserveret=" + (reserveret);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Oenske o = new Oenske();
                o.setBrugerId(rs.getInt("brugerId"));
                o.setOenskelistenr(rs.getInt("oenskelistenr"));
                o.setNavn(rs.getString("navn"));
                o.setPris(rs.getInt("pris"));
                o.setBeskrivelse(rs.getString("beskrivelse"));
                o.setLink(rs.getString("link"));
                o.setReserveret(rs.getInt("reserveret"));
                oenskeliste.add(o);
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return oenskeliste;
    }
    public ArrayList<Oenske> seAlleOenskerFraAllePersoner() {
        ArrayList<Oenske> oenskeliste = new ArrayList<>();
        try {
            String sql = "select * from Oenske";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Oenske o = new Oenske();
                o.setBrugerId(rs.getInt("brugerId"));
                o.setOenskelistenr(rs.getInt("oenskelistenr"));
                o.setNavn(rs.getString("navn"));
                o.setPris(rs.getInt("pris"));
                o.setBeskrivelse(rs.getString("beskrivelse"));
                o.setLink(rs.getString("link"));
                o.setReserveret(rs.getInt("reserveret"));
                oenskeliste.add(o);
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return oenskeliste;
    }
}
