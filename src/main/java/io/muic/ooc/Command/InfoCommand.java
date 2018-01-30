package io.muic.ooc.Command;

import io.muic.ooc.GameSession;
import io.muic.ooc.Player;

public class InfoCommand implements Command{

    private Player player;

    public void apply(String s) {
        player = GameSession.getInstanceOfPlayer();
        System.out.println(player.getStats());
    }
}
