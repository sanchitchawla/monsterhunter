package io.muic.ooc.Command;

import io.muic.ooc.GameSession;
import io.muic.ooc.Player;

public class DropItemCommand implements Command{

    private Player player;

    public DropItemCommand(){
        this.player = GameSession.getInstanceOfPlayer();
    }


    @Override
    public void apply(String s){
        if(s.equals("")){
            System.out.println("Can't drop nothing");
        }
        else {
            player.getBag().dropItem(s);
        }

    }
}
