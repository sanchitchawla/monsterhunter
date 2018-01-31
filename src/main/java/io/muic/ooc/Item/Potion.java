package io.muic.ooc.Item;

import io.muic.ooc.Player;


public class Potion implements Item{

    private Player player;
    private int HEALTH_INCREASE = 10;
    private String name = "potion";

    public String getName() {
        return name;
    }

    public void apply() {

    }
}
