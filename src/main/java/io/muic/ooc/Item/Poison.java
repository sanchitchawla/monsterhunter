package io.muic.ooc.Item;

import io.muic.ooc.GameSession;
import io.muic.ooc.Player;

public class Poison implements Item{

    private Player player;
    private int HEALTH_DECREASE = 10;
    private String name = "poison";

    public String getName() {
        return name;
    }

    public void apply() {
        player = GameSession.getInstanceOfPlayer();
        int currentHealth = player.getHP();

        // Since you die at 0 Health
        if (currentHealth > HEALTH_DECREASE){
            player.setHP(currentHealth - HEALTH_DECREASE);
        }
        else {
            player.setHP(0);
            player.setAlive(false);
        }

        player.removeItemFromInventory(this);
    }
}
