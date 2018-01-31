package io.muic.ooc.Command;

import io.muic.ooc.GameSession;
import io.muic.ooc.Player;

/**
 * Created by sanch on 31-Jan-18.
 */
public class MoveCommand implements Command{

    private Player player;

    public MoveCommand(){
        this.player = GameSession.getInstanceOfPlayer();
    }

    public void apply(String s) {

        if(player.isBattle){
            System.out.println("Can't move. You are in the battle");
        }
        else {
            int status = player.move(s);
            if (status == -1) {
                System.out.println("You can't move that way!");
            }
            else if(status==-2){
                System.out.println("Defeat the boss before you proceed!");
            }
            else {
                System.out.println("Moving " + s + ".....");
                new LookAroundCommand().apply(s);
            }
        }

    }
}
