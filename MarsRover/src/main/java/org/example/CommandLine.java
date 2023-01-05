package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommandLine {

    public static final Position MAX_POSITION = new Position(4,4);
    private static final int TRAP_NUMBER = 5;

    private final Rover rover;
    private Map<Integer,String> map;
    private ArrayList<Position> traps;
    public CommandLine(){
        this.rover = new Rover(this);
        this.map = new HashMap<>();
        this.traps = new ArrayList<>();
    }

   public CommandLine(boolean trap){
       this.rover = new Rover(this);
       this.map = new HashMap<>();

       if (trap){
           this.traps = generateTraps();
       }else {
           this.traps = new ArrayList<>();
       }
   }

    public Map<Integer, String> getMap() {
        this.generateMap();
        return map;
    }

    public Rover getRover() {
        return rover;
    }

    public void generateMap(){
        for (int i= 0; i < 5;i++){
            String line = "_ _ _ _ _";
            this.map.put(i,line);
        }

        this.placeTraps();
        this.placeRobot();
    }

    public void printMap(){
        this.generateMap();
        for(int i= MAX_POSITION.getY(); i >= 0;i--){
            System.out.println(map.get(i));
        }
    }

    private void placeRobot(){
        placeObject(this.rover.getCurrentPosition(),this.rover.toChar());
    }

    private void placeTraps(){
        for (Position trap: this.traps) {
            placeObject(trap,'X');
        }
    }
    private void placeObject(Position position, char print){
        StringBuilder r = new StringBuilder(this.map.get(position.getY()));
        r.setCharAt(position.getX()*2,print);

        this.map.put(position.getY(),r.toString());
    }

    private ArrayList<Position> generateTraps(){
        ArrayList<Position> traps = new ArrayList<>();

        for (int i = 0; i < TRAP_NUMBER; i++){
            traps.add(new Position((int) Math.round(Math.random()* MAX_POSITION.getX()), (int) Math.round(Math.random()* MAX_POSITION.getY())));
        }

        return traps;
    }

    public boolean isTrapped(Position position){
        return this.traps.stream().anyMatch(trap -> (trap.getX() == position.getX() && trap.getY() == position.getY()));
    }
}
