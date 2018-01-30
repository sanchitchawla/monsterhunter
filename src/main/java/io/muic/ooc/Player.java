package io.muic.ooc;

import io.muic.ooc.Item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

    // Max can be + 10 because of potions and moving to the next room
    private int MAX_HP = 110;

    // Health starts at 100
    private int HP = 100;

    // Since we have three levels we can start them at 0.7 and progress on
    private double attackPower = 0.7;
    private double defendPower = 0.7;

    // Start at level one
    private int level = 1;

    // List of items in bag, length should be <= BAG_SIZE
    private Bag bag = new Bag();

    private boolean isAlive;

    public int getMAX_HP() {
        return MAX_HP;
    }

    public void setMAX_HP(int MAX_HP) {
        this.MAX_HP = MAX_HP;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public double getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(double attackPower) {
        this.attackPower = attackPower;
    }

    public double getDefendPower() {
        return defendPower;
    }

    public void setDefendPower(double defendPower) {
        this.defendPower = defendPower;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void removeItemFromInventory(Item item){
        for (Item eachItem : bag.getItems()){
            if (eachItem.getName().equals(item.getName())){
                // Consult with aj
                bag.items.remove(eachItem);
                // break so we remove only one
                break;
            }
            else {
                System.out.println("Item doesn't exist");
            }
        }
    }

    public Map<String, String> getStats(){
        Map<String, String> stats = new HashMap<String, String>();
        stats.put("Current HP",Integer.toString(getHP()));
        stats.put("Current room", Integer.toString(getLevel()));
        stats.put("Attack Power", Double.toString(getAttackPower()));

        for(int i = 0; i < bag.items.size(); i++){
            stats.put("Item " + (i + 1), bag.items.get(i).toString());
        }

        for(int i = 0; i < bag.weapons.size(); i++){
            stats.put("Weapon " + (i + 1), bag.weapons.get(i).toString());
        }
        return stats;
    }



}
