package io.muic.ooc;

import io.muic.ooc.Item.Item;
import io.muic.ooc.Item.Poison;
import io.muic.ooc.Item.Potion;
import io.muic.ooc.Weapons.BigSword;
import io.muic.ooc.Weapons.StarDestroyer;
import io.muic.ooc.Weapons.Sword;
import io.muic.ooc.Weapons.Weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bag {

    private int BAG_SIZE_WEAPONS = 2;

    private int BAG_SIZE_ITEMS = 3;

    List<Weapon> weapons = new ArrayList<>();

    List<Item> items = new ArrayList<>();

    private final static HashMap<String, Item> itemTranslator = new HashMap<String, Item>() {
        {
            put("potion", new Potion());
            put("poison", new Poison());

        }
    };

    public List<String> getWeapons() {
        List<String> weaponName = new ArrayList<>();
        for (Weapon weapon : weapons) {
            weaponName.add(weapon.getName());
        }
        return weaponName;
    }

    public void addWeapon(Weapon weapon) {
        if (weapons.size() < BAG_SIZE_WEAPONS){
            this.weapons.add(weapon);
        } else {
            System.out.println("Weapon bag is full!");
        }

    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        if (items.size() < BAG_SIZE_ITEMS){
            this.items.add(item);
        } else {
            System.out.println("Item bag is full!");
        }
    }

    public void addItem(String item) {
        if (items.size() < BAG_SIZE_ITEMS){
            this.items.add(itemTranslator.get(item));
        } else {
            System.out.println("Item bag is full!");
        }
    }

    public void dropItem(String item){
        this.items.remove(itemTranslator.get(item));
    }

    public boolean contains(String item){
        for (Item item1 : items) {
            if (item1.getName().equals(item)) {
                return true;
            }
        }
        return false;
    }

}
