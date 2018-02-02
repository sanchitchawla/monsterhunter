package io.muic.ooc.Command;

import io.muic.ooc.Boss.Boss;
import io.muic.ooc.Boss.BossLevelOne;
import io.muic.ooc.Boss.BossLevelTwo;
import io.muic.ooc.Boss.FinalBoss;
import io.muic.ooc.GameSession;
import io.muic.ooc.Player;
import io.muic.ooc.Weapons.BigSword;
import io.muic.ooc.Weapons.StarDestroyer;
import io.muic.ooc.Weapons.Sword;
import io.muic.ooc.Weapons.Weapon;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

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

        if (player.getBag().getWeapons().contains(weapon.getName())){
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
        System.out.println("Boss Health Left: " + boss.getHealth());

        /*
        This is where the boss attacks
         */
        boss.attack();
        System.out.println("Player Health Left: " + player.getHP());

        // You won
        if (boss.getHealth() <= 0){
            System.out.println("You defeated the floors boss!");

            if (Objects.equals(boss.getName(), "BossOne")){
                // Change boss
                System.out.println("Going to the second floor! Wohooo");
                player.goSecondFloor();
            }
            else if (Objects.equals(boss.getName(), "BossTwo")){
                // change boss
                System.out.println("Going to the third floor yassssssss");
                player.goThirdFloor();
            }
        }
    }
}
