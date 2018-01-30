package io.muic.ooc.WorldMap;

import io.muic.ooc.Boss.BossLevelOne;
import io.muic.ooc.Boss.BossLevelTwo;
import io.muic.ooc.Boss.FinalBoss;
import io.muic.ooc.Item.Poison;
import io.muic.ooc.Item.Potion;
import io.muic.ooc.Weapons.BigSword;
import io.muic.ooc.Weapons.StarDestroyer;

public class GenMap {

    public Room[][] getFirstFloor(){
        Room[][] floor = new Room[2][2];

        Room room00 = new Room();

        Room room01 = new Room();
        room01.addItem(new Potion());

        Room room10 = new Room();

        Room room11 = new Room();
        room11.setBoss(new BossLevelOne());

        room00.setExit("right",room01);
        room00.setExit("down",room10);

        room01.setExit("up", room11);
        room01.setExit("left", room00);
        room01.setExit("right", room10);

        room10.setExit("left", room00);
        room10.setExit("right", room11);

        room11.setExit("up", room10);

        floor[0][0] = room00;
        floor[0][1] = room01;
        floor[1][0] = room10;
        floor[1][1] = room11;

        return floor;
    }

    public Room[][] getSecondFloor(){
        Room[][] floor = new Room[2][2];

        Room room00 = new Room();

        Room room01 = new Room();
        room01.addWeapon(new BigSword());

        Room room10 = new Room();
        room10.addItem(new Poison());

        Room room11 = new Room();
        room11.setBoss(new BossLevelTwo());

        room00.setExit("right",room01);
        room00.setExit("down",room10);

        room01.setExit("up", room11);
        room01.setExit("left", room00);
        room01.setExit("right", room10);

        room10.setExit("left", room00);
        room10.setExit("up", room11);

        room11.setExit("down", room10);

        floor[0][0] = room00;
        floor[0][1] = room01;
        floor[1][0] = room10;
        floor[1][1] = room11;

        return floor;
    }

    public Room[][] getThirdFloor(){
        // Change this
        Room[][] floor = new Room[1][3];

        Room room00 = new Room();

        Room room01 = new Room();
        room01.addWeapon(new StarDestroyer());

        Room room02 = new Room();
        room02.setBoss(new FinalBoss());

        room00.setExit("up", room01);
        room00.setExit("right", room02);

        room01.setExit("right", room02);

        floor[0][0] = room00;
        floor[0][1] = room01;
        floor[0][2] = room02;

        return floor;
    }

}
