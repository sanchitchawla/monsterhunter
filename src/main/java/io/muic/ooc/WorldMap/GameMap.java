package io.muic.ooc.WorldMap;

import java.util.HashMap;
import java.util.Map;

public class GameMap {

    public final Map<Integer,Room[][]> worldMap = new HashMap<>();
    private final Room[][] firstFloor = (new GenMap()).getFirstFloor();

    private final Room[][] secondFloor = (new GenMap()).getSecondFloor();

    private final Room[][] thirdFloor = (new GenMap()).getThirdFloor();

    {
        worldMap.put(1,firstFloor);
        worldMap.put(2,secondFloor);
        worldMap.put(3,thirdFloor);

    }

    public Room getFirstBossRoom(){
        return worldMap.get(1)[1][2];
    }

    public Room getSecondBossRoom(){
        return worldMap.get(2)[1][0];
    }

    public Room getFinalBossRoom(){
        return worldMap.get(3)[0][0];
    }
}
