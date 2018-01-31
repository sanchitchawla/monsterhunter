package io.muic.ooc.Weapons;

public class Sword implements Weapon{

    private int DAMAGE = 10;

    private String name = "sword";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDAMAGE() {
        return DAMAGE;
    }

    public void setDAMAGE(int DAMAGE) {
        this.DAMAGE = DAMAGE;
    }
}
