package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{
    private int updateCount = 0;
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        updateCount++;
        System.out.println("Id of map: " + worldMap.getId());
        System.out.println(message);
        System.out.println(worldMap.toString());
        System.out.println("updates: " + updateCount);
    }
}
