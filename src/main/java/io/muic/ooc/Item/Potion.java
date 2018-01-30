package io.muic.ooc.Item;

import io.muic.ooc.GameSession;
import io.muic.ooc.Player;


public class Potion implements Item{

    private Player player;
    private int HEALTH_INCREASE = 10;
    private String name = "potion";

    public String getName() {
        return name;
    }

    public void apply() {
//        player = GameSession.getInstanceOfPlayer();
//        int currentHealth = player.getHP();
//
//        if (player.getMAX_HP() - currentHealth >= HEALTH_INCREASE){
//
//            player.setHP(currentHealth + HEALTH_INCREASE);
//        }
//        else if (currentHealth != player.getMAX_HP()){
//
//            player.setHP(player.getMAX_HP());
//        }
//
//        // Remove potion from inventory
//        player.removeItemFromInventory(this);
    }
}
