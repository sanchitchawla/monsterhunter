package io.muic.ooc.Boss;

import io.muic.ooc.GameSession;
import io.muic.ooc.Player;

public class FinalBoss implements Boss{
    private Player player;

    private int DAMAGE = 30;

    private double health = 100;

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }


    // Decrease player health by amount of DAMAGE
    public void attack() {
        player = GameSession.getInstanceOfPlayer();
        Integer currentHealth = player.getHP();

        if (currentHealth <= DAMAGE){
            System.out.println("Final Boss kicked your ass");
            System.out.println("You lose");
            player.setHP(0);
            player.setAlive(false);

        }
        player.setHP(currentHealth - DAMAGE);

    }
}
