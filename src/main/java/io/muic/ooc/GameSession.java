package io.muic.ooc;

import io.muic.ooc.Boss.Boss;
import io.muic.ooc.Boss.BossLevelOne;
import io.muic.ooc.Command.*;

import java.util.HashMap;
import java.util.Scanner;


public class GameSession {

    private static Player player = new Player();
    private static Boss boss;

    private final static HashMap<String, Command> commands = new HashMap<String, Command>() {
        {
            // commands are added here using lambdas. It is also possible to dynamically add commands without editing the code.
            put("attack", new AttackCommand());
            put("exit", new ExitCommand());
            put("paytowin", new MicrotransactionCommand());
            put("heal", new HealCommand());

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
