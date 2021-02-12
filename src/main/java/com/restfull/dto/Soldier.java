package com.restfull.dto;

public class Soldier {
    private int id;
    private String name;
    private String family;
    private String weapon;

    public Soldier(int id, String name, String family, String weapon) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.weapon = weapon;
    }

    public Soldier() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
}
