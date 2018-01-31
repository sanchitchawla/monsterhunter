package io.muic.ooc.Weapons;


public class BigSword implements Weapon{

    private int DAMAGE = 20;

    private String name = "bigsword";

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
