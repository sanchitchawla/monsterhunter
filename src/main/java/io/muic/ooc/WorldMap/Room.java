package io.muic.ooc.WorldMap;

import io.muic.ooc.Boss.Boss;
import io.muic.ooc.Item.Item;
import io.muic.ooc.Weapons.Weapon;
import java.util.HashMap;
import java.util.Map;

public class Room {

    private final static int MAX_ITEMS = 3;
    private final Item[] itemList = new Item[MAX_ITEMS];
    private final Weapon[] weaponList = new Weapon[MAX_ITEMS];
    private final Map<String,Room> neighbors = new HashMap<>();
    private Boss boss = null;

    public boolean canGo(String dir){
        return neighbors.containsKey(dir);
    }

    public void setBoss(Boss boss){
        this.boss = boss;
    }

    public Boss getBoss(){
        return this.boss;
    }

    public Item[] getItemList() {
        return itemList;
    }

    public Weapon[] getWeaponList() {
        return weaponList;
    }

    public Map<String, Room> getNeighbors() {
        return neighbors;
    }


    public boolean addItem(Item item) {
        for(int i = 0; i < MAX_ITEMS;i++){
            if(itemList[i] == null){
                itemList[i] = item;
                return true;
            }
        }
        return false;
    }

    public boolean addWeapon(Weapon weapon) {
        for(int i = 0; i < MAX_ITEMS;i++){
            if(weaponList[i] == null){
                weaponList[i] = weapon;
                return true;
            }
        }
        return false;
    }


    public void setExit(String dir, Room exitingRoom){
        switch (dir) {
            case "up":
            case "right":
            case "left":
            case "down":
                neighbors.put(dir,exitingRoom);

        }

    }

    public boolean canProceed(){
        return this.boss == null;
    }

}
