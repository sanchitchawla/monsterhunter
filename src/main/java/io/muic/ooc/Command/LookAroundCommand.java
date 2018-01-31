package io.muic.ooc.Command;

import io.muic.ooc.GameSession;
import io.muic.ooc.Player;
import io.muic.ooc.WorldMap.Room;

/**
 * Created by sanch on 31-Jan-18.
 */
public class LookAroundCommand implements Command{
    private Player player;

    public LookAroundCommand(){
        this.player = GameSession.getInstanceOfPlayer();
    }

    @Override
    public void apply(String s) {
        Room room = player.getCurrentRoom();
        System.out.println(room.getInfo());
    }
}
