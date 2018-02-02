package io.muic.ooc.Command;

import io.muic.ooc.GameSession;
import io.muic.ooc.Item.Potion;
import io.muic.ooc.Player;

public class HealCommand implements Command{

    private Player player;
    private int HEALTH_INCREASE = 10;

    public void apply(String s) {
        player = GameSession.getInstanceOfPlayer();

        // if does not contain
        if (!player.getBag().contains("potion")){
            System.out.println("You don't have any potion!");
            return;
        }

        player = GameSession.getInstanceOfPlayer();
        int currentHealth = player.getHP();

        if (player.getMAX_HP() - currentHealth >= HEALTH_INCREASE){
            player.setHP(currentHealth + HEALTH_INCREASE);
        }
        else if (currentHealth != player.getMAX_HP()){
            // If health is almost full
            player.setHP(player.getMAX_HP());
        }
        else if (currentHealth == player.getMAX_HP()){
            System.out.println("Your health is already full!");
        }

        System.out.println("Potion applied");
        System.out.println("HP " + player.getHP());

        // Remove potion from inventory
        player.removeItemFromInventory(new Potion());
    }
}
