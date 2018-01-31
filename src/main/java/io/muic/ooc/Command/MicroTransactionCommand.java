package io.muic.ooc.Command;

import io.muic.ooc.GameSession;
import io.muic.ooc.Player;

public class MicroTransactionCommand implements Command{

    private Player player;

    public void apply(String s) {
        System.out.println("Payment of $" + s + "  received");
        player = GameSession.getInstanceOfPlayer();

        player.setAttackPower(player.getAttackPower() * (Integer.parseInt(s)));
        player.setDefendPower(player.getDefendPower() * (Integer.parseInt(s)));
        player.setMAX_HP(1000);
    }
}
