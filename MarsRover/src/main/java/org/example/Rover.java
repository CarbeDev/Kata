package org.example;


public class Rover {

    private Position currentPosition;

    private Direction direction;
    private final CommandLine cli;
    public Rover(CommandLine commandLine){
        this.currentPosition = new Position(0,0);
        this.direction = Direction.NORTH;
        this.cli = commandLine;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void moveForward() {
        Position nextPosition = null;

        switch (this.direction){
            case NORTH -> nextPosition = new Position(this.currentPosition.getX(),this.currentPosition.getY() +1);
            case EAST -> nextPosition = new Position(this.currentPosition.getX() +1,this.currentPosition.getY());
            case SOUTH -> nextPosition = new Position(this.currentPosition.getX(),this.currentPosition.getY() -1);
            case WEST -> nextPosition = new Position(this.currentPosition.getX()-1,this.currentPosition.getY());
        }

        if (cli.isTrapped(nextPosition)){
            System.out.println("Deplacement impossible, position bloqué");
        }
        else if (nextPosition.getX() > CommandLine.MAX_POSITION.getX() ||
                nextPosition.getX() < 0 ||
                nextPosition.getY() > CommandLine.MAX_POSITION.getY() ||
                nextPosition.getY() < 0){
            System.out.println("Deplacement impossible, vous allez en dehors de la carte");
        } else {
            System.out.println("triu");
            this.currentPosition = nextPosition;
        }

        cli.generateMap();
    }


    public void turnRight() {
        switch (this.direction){
            case NORTH -> this.direction = Direction.EAST;
            case EAST -> this.direction = Direction.SOUTH;
            case SOUTH -> this.direction = Direction.WEST;
            case WEST -> this.direction = Direction.NORTH;
        }

        cli.generateMap();
    }

    public void turnLeft(){
        switch (this.direction){
            case NORTH -> this.direction = Direction.WEST;
            case EAST -> this.direction = Direction.NORTH;
            case SOUTH -> this.direction = Direction.EAST;
            case WEST -> this.direction = Direction.SOUTH;
        }

        cli.generateMap();
    }

    public char toChar(){
        switch (this.direction){
            case NORTH -> {return '^';}
            case EAST -> {return '>';}
            case SOUTH -> {return 'v';}
            case WEST -> {return '<';}
            default -> throw new NullPointerException("Direction doesn't exist");
        }
    }
}
