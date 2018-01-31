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

        Room[][] result = new Room[3][4];


        Room room20 = new Room();

        Room room10 = new Room();
        room10.addItem(new Potion());

        Room room11 = new Room();

        Room room01 = new Room();

        Room room12 = new Room();
        room12.addItem(new Potion());

        Room room13 = new Room();
        room13.setBoss(new BossLevelOne());

        Room room03 = new Room();

        Room room23 = new Room();


        room20.setExit("up",room10);

        room10.setExit("down",room20);
        room10.setExit("right",room11);

        room11.setExit("left",room10);
        room11.setExit("up",room01);
        room11.setExit("right",room12);

        room12.setExit("left",room11);
        room12.setExit("right",room13);

        room13.setExit("up",room03);
        room13.setExit("left",room12);
        room13.setExit("down",room23);

        room01.setExit("down",room11);

        room03.setExit("down",room13);

        room23.setExit("up",room13);

        result[0][1] = room01;
        result[0][3] = room03;
        result[1][0] = room10;
        result[1][1] = room11;
        result[1][2] = room12;
        result[1][3] = room13;
        result[2][0] = room20;
        result[2][3] = room23;

        return result;

    }

    public Room[][] getSecondFloor(){
        Room[][] result = new Room[3][3];

        Room room00 = new Room();

        Room room01 = new Room();

        Room room02 = new Room();

        Room room10 = new Room();
        room10.addWeapon(new BigSword());

        Room room11 = new Room();

        Room room12 = new Room();
        room12.addItem(new Poison());

        Room room20 = new Room();
        room20.addWeapon((new StarDestroyer()));

        Room room21 = new Room();
        room21.setBoss(new BossLevelTwo());

        Room room22 = new Room();

        room00.setExit("right",room01);
        room00.setExit("down",room10);

        room01.setExit("left",room00);
        room01.setExit("right",room02);
        room01.setExit("down",room11);

        room02.setExit("left",room01);
        room02.setExit("down",room12);

        room10.setExit("up",room00);
        room10.setExit("down",room20);
        room10.setExit("right",room11);

        room11.setExit("up",room01);
        room11.setExit("right",room12);
        room11.setExit("left",room10);
        room11.setExit("down",room21);

        room12.setExit("up",room02);
        room12.setExit("left",room11);
        room12.setExit("down",room22);

        room20.setExit("right",room21);
        room20.setExit("up",room10);

        room21.setExit("left",room20);
        room21.setExit("right",room22);
        room21.setExit("up",room11);

        room22.setExit("left",room21);
        room22.setExit("up",room12);

        result[0][0] = room00;
        result[0][1] = room01;
        result[0][2] = room02;

        result[1][0] = room10;
        result[1][1] = room11;
        result[1][2] = room12;

        result[2][0] = room20;
        result[2][1] = room21;
        result[2][2] = room22;

        return result;
    }

    public Room[][] getThirdFloor(){
        Room[][] result = new Room[2][1];

        Room room10 = new Room();
        room10.addItem(new Potion());

        Room room00 = new Room();
        room00.setBoss(new FinalBoss());

        room10.setExit("up",room00);

        result[0][0] = room00;
        result[1][0] = room10;
        return result;

    }

}
