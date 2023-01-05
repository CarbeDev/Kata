package org.example;

public class Position {
    private int x;
    private int y;


    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveNorth(){
        if (this.y < CommandLine.MAX_POSITION.getY()) {
            this.y++;
        }else{
            this.y=0;
        }
    }

    public void moveEast(){
        if (this.x < CommandLine.MAX_POSITION.getX()){
            this.x++;
        } else {
            this.x = 0;
        }
    }

    public void moveSouth(){
        if (this.y > 0) {
            this.y--;
        }else{
            this.y =  CommandLine.MAX_POSITION.getY();
        }
    }

    public void moveWest(){
        if (this.x > 0){
            this.x--;
        }else {
            this.x = CommandLine.MAX_POSITION.getX();
        }
    }
}
