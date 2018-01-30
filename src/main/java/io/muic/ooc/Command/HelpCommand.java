package io.muic.ooc.Command;

public class HelpCommand implements Command{
    public void apply(String s) {
        System.out.println("You can use the following commands");
        System.out.println("- attack with _ and choose your weapon");
        System.out.println("- heal, to heal yourself if you have a potion in your inventory");
        System.out.println("- info, to get stats about the current game");
        System.out.println("- paytowin, to give us money and become OP");

    }
}
