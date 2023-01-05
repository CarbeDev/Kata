import static org.junit.jupiter.api.Assertions.*;

import org.example.CommandLine;
import org.example.Rover;
import org.junit.jupiter.api.Test;


public class RoverTest {

    @Test
    public void ShouldMoveInNorthDirection(){
        //Given
        Rover r = new Rover(new CommandLine());
        //When
        r.moveForward();
        //Then
        assertEquals(0,r.getCurrentPosition().getX());
        assertEquals(1,r.getCurrentPosition().getY());

    }

    @Test
    public void ShouldMoveInEastDirection(){
        Rover r = new Rover(new CommandLine());

        r.turnRight();
        r.moveForward();

        assertEquals(1,r.getCurrentPosition().getX());
        assertEquals(0,r.getCurrentPosition().getY());
    }

    @Test
    public void ShouldMoveInWestDirection(){
        Rover r = new Rover(new CommandLine());

        r.turnLeft();
        r.moveForward();

        assertEquals(CommandLine.MAX_POSITION.getX(),r.getCurrentPosition().getX());
        assertEquals(0,r.getCurrentPosition().getY());
    }

    @Test
    public void ShouldMoveInSouthDirection(){
        Rover r = new Rover(new CommandLine());

        r.turnRight();
        r.turnRight();
        r.moveForward();

        assertEquals(0,r.getCurrentPosition().getX());
        assertEquals(CommandLine.MAX_POSITION.getY(),r.getCurrentPosition().getY());
    }
}
