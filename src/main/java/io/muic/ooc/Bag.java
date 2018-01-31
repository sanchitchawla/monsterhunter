package io.muic.ooc;

import io.muic.ooc.Item.Item;
import io.muic.ooc.Weapons.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Bag {

    private int BAG_SIZE_WEAPONS = 2;

    private int BAG_SIZE_ITEMS = 3;

    List<Weapon> weapons = new ArrayList<Weapon>();

    List<Item> items = new ArrayList<Item>();

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        if (weapons.size() < BAG_SIZE_WEAPONS){
            this.weapons = weapons;
        } else {
            System.out.println("Weapon bag is full!");
        }

    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        if (items.size() < BAG_SIZE_ITEMS){
            this.items = items;
        } else {
            System.out.println("Item bag is full!");
        }

    }
}
