package io.muic.ooc;

import io.muic.ooc.Boss.Boss;
import io.muic.ooc.Boss.BossLevelOne;
import io.muic.ooc.Command.*;
import io.muic.ooc.Weapons.Sword;
import io.muic.ooc.Weapons.Weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class GameSession {

    private static Player player = new Player();
    private static Boss boss;

    private final static HashMap<String, Command> commands = new HashMap<String, Command>() {
        {
            // commands are added here using lambdas. It is also possible to dynamically add commands without editing the code.
            put("attack", new AttackCommand());
            put("exit", new ExitCommand());
            put("paytowin", new MicroTransactionCommand());
            put("heal", new HealCommand());
            put("go", new MoveCommand());
            put("take", new TakeCommand());
            put("drop", new DropItemCommand());

        }
    };

    public static Player getInstanceOfPlayer(){
        if (player == null){
            player = new Player();
        }
        return player;
    }

    public static Boss getInstanceOfBoss(){
        if (boss == null){
            boss = new BossLevelOne();
        }
        return boss;
    }

    private static Command getCommand(String name) {
        return commands.get(name);
    }

    static void run(){
        Scanner scanner = new Scanner(System.in);
        player.setAlive(true);

        player.getBag().addWeapon(new Sword());
        System.out.println("Hi, welcome to Monster Hunter World: CLI Edition");
        System.out.println(player.getCurrentRoom().getInfo());
        while (player.isAlive()){
            System.out.print("You: ");
            String[] commandLine = scanner.nextLine().split("\\s+");
            Command command = getCommand(commandLine[0]);

            if (command == null){
                System.out.println("Unknown Command, try 'help'");
            }
            else {
                // Change this
                command.apply(commandLine[1]);
            }
        }

    }


}
