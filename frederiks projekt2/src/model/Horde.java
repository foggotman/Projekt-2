package model;

import java.util.ArrayList;

public class Horde {
    //Field Variables
    private ArrayList<Team> horde = new ArrayList<>();

    // Constructor
    public Horde() {
        this.horde = new ArrayList<>();
    }
    // Simpel add metode
    public void addHorde (Team team) {
        horde.add(team);
    }

    public ArrayList<Team> getHorde() {
        return horde;
    }
}