package io.muic.ooc.Weapons;

import io.muic.ooc.Item.Item;

public class BigSword implements Weapon{

    private int DAMAGE = 20;

    public int getDAMAGE() {
        return DAMAGE;
    }

    public void setDAMAGE(int DAMAGE) {
        this.DAMAGE = DAMAGE;
    }
}
