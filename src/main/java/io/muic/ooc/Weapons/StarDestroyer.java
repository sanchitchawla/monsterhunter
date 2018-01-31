package io.muic.ooc.Weapons;

public class StarDestroyer implements Weapon{

    private int DAMAGE = 100;

    private String name = "stardestroyer";

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
