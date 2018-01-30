package io.muic.ooc.Command;

import io.muic.ooc.Boss.Boss;
import io.muic.ooc.GameSession;
import io.muic.ooc.Player;
import io.muic.ooc.Weapons.BigSword;
import io.muic.ooc.Weapons.StarDestroyer;
import io.muic.ooc.Weapons.Sword;
import io.muic.ooc.Weapons.Weapon;

import java.util.HashMap;
import java.util.Random;

// Have to change logic cos have to use weapons
public class AttackCommand implements Command{

    private Boss boss;
    private Player player;
    private double damage;

    private double criticalHitProbability = 0.7;

    private final static HashMap<String, Weapon> weapons = new HashMap<String, Weapon>() {
        {
            // commands are added here using lambdas. It is also possible to dynamically add commands without editing the code.
            put("sword", new Sword());
            put("bigsword", new BigSword());
            put("stardestroyer", new StarDestroyer());

        }
    };

    public void apply(String s) {
        // Decrease Boss Health
        boss = GameSession.getInstanceOfBoss();
        player = GameSession.getInstanceOfPlayer();

        // Get weapon
        Weapon weapon = weapons.get(s);


        if (player.getBag().getWeapons().contains(weapon)){
            damage = weapon.getDAMAGE();
        } else{
            System.out.println("You don't have this weapon");
            System.out.println("Please choose another weapon");
            return;
        }

        double rand = new Random().nextDouble();

        // 2x Damage
        if (rand > criticalHitProbability){
            damage *= 2.0;
        }

        double bossCurrentHealth = boss.getHealth();
        boss.setHealth(bossCurrentHealth - damage);

        // You won
        if (boss.getHealth() <= 0){
            System.out.println("You won!");
            System.exit(0);
        }
    }
}
