package io.muic.ooc.Command;

public class ExitCommand implements Command{

    public void apply(String s) {
        System.out.println("Exit");
        System.exit(0);
    }
}
