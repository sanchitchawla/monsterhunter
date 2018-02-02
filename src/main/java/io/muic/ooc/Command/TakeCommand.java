package io.muic.ooc.Command;

import io.muic.ooc.GameSession;
import io.muic.ooc.Player;
import io.muic.ooc.Weapons.BigSword;
import io.muic.ooc.Weapons.StarDestroyer;
import io.muic.ooc.Weapons.Sword;
import io.muic.ooc.Weapons.Weapon;

import java.util.HashMap;


public class TakeCommand implements Command {

    private Player player;

    private final static HashMap<String, Weapon> weapons = new HashMap<String, Weapon>() {
        {
            // commands are added here using lambdas. It is also possible to dynamically add commands without editing the code.
            put("sword", new Sword());
            put("bigsword", new BigSword());
            put("stardestroyer", new StarDestroyer());

        }
    };

    public TakeCommand(){
        player = GameSession.getInstanceOfPlayer();
    }

    public void apply(String s) {

        if (player.collect(s) == 1){
            System.out.println("Item " +s + " in bag");
        }
        else if (s.equals("bigsword") || s.equals("stardestroyer")){
            player.getBag().addWeapon(weapons.get(s));
            System.out.println("Weapon " + s + " in bag");
        }
        else {
            System.out.println("Room doesn't contain " + s);
        }

    }
}
