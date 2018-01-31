package io.muic.ooc.Command;

import io.muic.ooc.GameSession;
import io.muic.ooc.Player;


public class TakeCommand implements Command {

    private Player player;

    public TakeCommand(){
        player = GameSession.getInstanceOfPlayer();
    }

    public void apply(String s) {

        if (player.collect(s) == 1){
            System.out.println("Item " +s + " in bag");
        }
        else {
            System.out.println("Room doesn't contain " + s);
        }

    }
}
