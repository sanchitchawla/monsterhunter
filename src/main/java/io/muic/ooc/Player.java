package io.muic.ooc;

import io.muic.ooc.Item.Item;
import io.muic.ooc.Weapons.Sword;
import io.muic.ooc.WorldMap.GameMap;
import io.muic.ooc.WorldMap.Room;

import java.util.HashMap;
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

    public boolean isBattle = false;

    // List of items in bag, length should be <= BAG_SIZE
    private Bag bag = new Bag();

    private boolean isAlive;

    private GameMap map = new GameMap();

    private int x = 2;
    private int y = 0;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

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
        Map<String, String> stats = new HashMap<>();
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

    private boolean isRoomValidMove(String dir){
        Room currentRoom = this.map.worldMap.get(level)[x][y];
        System.out.println();
        System.out.println(x + "" + y);
        return currentRoom.canGo(dir);
    }

    public Room getCurrentRoom(){
        return this.map.worldMap.get(level)[x][y];
    }

    public int move(String dir){
        if (!isBattle){
            if (!getCurrentRoom().canProceed())
                return -2;
            dir = dir.toLowerCase();
            if (isRoomValidMove(dir)){

                switch (dir) {
                    case "up":
                        this.x -= 1;
                        break;
                    case "right":
                        this.y += 1;
                        break;
                    case "left":
                        this.y -= 1;
                        break;
                    case "down":
                        this.x += 1;
                        break;
                }

                return 1;
            }
            return -1;
        }
        return 0;
    }

    public int[] checkPos(){
        return new int[]{this.x,this.y};
    }

    public boolean canGoSecondFloor(){
        Room finalRoom = this.map.getFirstBossRoom();
        return finalRoom.getBoss()==null;
    }

    public void goSecondFloor(){
        this.level = 2;
        this.x = 1;
        this.y = 1;
        this.attackPower += 0.1;
        this.defendPower += 0.1;
    }

    public boolean isDead() {
        return this.HP <= 0;
    }

    public void goThirdFloor() {
        this.level = 3;
        this.x = 1;
        this.y = 0;
        this.attackPower += 0.1;
        this.defendPower += 0.1;
    }

    public boolean clearFinalBoss() {
        Room lastRoom = this.map.getFinalBossRoom();
        return lastRoom.getBoss()==null;
    }

    private int isValidCollect(String item){
        Room currentRoom = this.map.worldMap.get(level)[x][y];
        Item[] allItem = currentRoom.getItemList();
        for(int i = 0;i<allItem.length;i++){
            Item currentItem = allItem[i];
            if(currentItem!=null && item.equals(currentItem.getName())){
                return i;
            }
        }

        return -1;
    }

    public int collect(String item){
        int targetSlot = isValidCollect(item);

        if (targetSlot > -1) {
            Item[] roomItem = getCurrentRoom().getItemList();

            if(item.contains("potion") || item.contains("poison")) {
                bag.addItem(roomItem[targetSlot]);
                roomItem[targetSlot] = null;
                return 1;
            }
            else {
                bag.addItem(item);
                roomItem[targetSlot] = null;

                return 0;
            }

        }
        else {
            return -1;
        }
    }

}
