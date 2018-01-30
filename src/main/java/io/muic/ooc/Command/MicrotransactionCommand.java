package io.muic.ooc.Command;

import io.muic.ooc.GameSession;
import io.muic.ooc.Player;

public class MicrotransactionCommand implements Command{

    private Player player;

    public void apply(String s) {
        System.out.println("Payment of " + s + "  received");
        player = GameSession.getInstanceOfPlayer();

        player.setAttackPower(1.2);
        player.setDefendPower(1.2);
        player.setMAX_HP(1000);
    }
}
