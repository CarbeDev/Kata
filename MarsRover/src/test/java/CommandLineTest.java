import org.example.CommandLine;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CommandLineTest {

    @Test
    public void AtTheBeginningTheRoverShouldBeAt0x0FacingNorth(){
        CommandLine cli = new CommandLine();

        Map<Integer,String> expected = new HashMap<>();
        expected.put(0, "^ _ _ _ _");
        for (int i = 1; i <= CommandLine.MAX_POSITION.getY(); i++) {
            expected.put(i,"_ _ _ _ _");
        }

        assertEquals(expected,cli.getMap());
    }

    @Test
    public void whenRoverFacingNorthTurnRightOnceShouldBeFacingEast(){
        CommandLine cli = new CommandLine();

        Map<Integer,String> expected = new HashMap<>();
        expected.put(0, "> _ _ _ _");
        for (int i = 1; i <= CommandLine.MAX_POSITION.getY(); i++) {
            expected.put(i,"_ _ _ _ _");
        }

        cli.getRover().turnRight();

        assertEquals(expected,cli.getMap());
    }


    @Test
    public void whenRoverFacingNorthTurnRightTwiceShouldBeFacingSouth(){
        CommandLine cli = new CommandLine();

        Map<Integer,String> expected = new HashMap<>();
        expected.put(0, "v _ _ _ _");
        for (int i = 1; i <= CommandLine.MAX_POSITION.getY(); i++) {
            expected.put(i,"_ _ _ _ _");
        }

        cli.getRover().turnRight();
        cli.getRover().turnRight();

        assertEquals(expected,cli.getMap());
    }

    @Test
    public void whenRoverFacingNorthTurnRightThreeTimesShouldBeFacingWest(){
        CommandLine cli = new CommandLine();

        Map<Integer,String> expected = new HashMap<>();
        expected.put(0, "< _ _ _ _");
        for (int i = 1; i <= CommandLine.MAX_POSITION.getY(); i++) {
            expected.put(i,"_ _ _ _ _");
        }

        cli.getRover().turnRight();
        cli.getRover().turnRight();
        cli.getRover().turnRight();


        assertEquals(expected,cli.getMap());
    }

    @Test
    public void whenRoverFacingNorthTurnRightFourTimeShouldBeFacingNorth(){
        CommandLine cli = new CommandLine();

        Map<Integer,String> expected = new HashMap<>();
        expected.put(0, "^ _ _ _ _");
        for (int i = 1; i <= CommandLine.MAX_POSITION.getY(); i++) {
            expected.put(i,"_ _ _ _ _");
        }

        for (int i = 0; i < 4; i++) {
            cli.getRover().turnRight();
        }

        assertEquals(expected,cli.getMap());
    }
    @Test
    public void whenRoverFacingNorthTurnLeftOnceShouldBeAt0x0FacingWest(){
        CommandLine cli = new CommandLine();

        Map<Integer,String> expected = new HashMap<>();
        expected.put(0, "< _ _ _ _");
        for (int i = 1; i <= CommandLine.MAX_POSITION.getY(); i++) {
            expected.put(i,"_ _ _ _ _");
        }

        cli.getRover().turnLeft();

        assertEquals(expected,cli.getMap());
    }

    @Test
    public void whenRoverFacingNorthTurnLeftTwiceShouldBeFacingSouth(){
        CommandLine cli = new CommandLine();

        Map<Integer,String> expected = new HashMap<>();
        expected.put(0, "v _ _ _ _");
        for (int i = 1; i <= CommandLine.MAX_POSITION.getY(); i++) {
            expected.put(i,"_ _ _ _ _");
        }

        cli.getRover().turnLeft();
        cli.getRover().turnLeft();

        assertEquals(expected,cli.getMap());
    }

    @Test
    public void whenRoverFacingNorthTurnLeftThreeTimesShouldBeFacingEast(){
        CommandLine cli = new CommandLine();

        Map<Integer,String> expected = new HashMap<>();
        expected.put(0, "> _ _ _ _");
        for (int i = 1; i <= CommandLine.MAX_POSITION.getY(); i++) {
            expected.put(i,"_ _ _ _ _");
        }

        cli.getRover().turnLeft();
        cli.getRover().turnLeft();
        cli.getRover().turnLeft();

        assertEquals(expected,cli.getMap());
    }

    @Test
    public void whenRoverFacingNorthTurnLeftFourTimesShouldBeFacingNorth(){
        CommandLine cli = new CommandLine();

        Map<Integer,String> expected = new HashMap<>();
        expected.put(0, "^ _ _ _ _");
        for (int i = 1; i <= CommandLine.MAX_POSITION.getY(); i++) {
            expected.put(i,"_ _ _ _ _");
        }

        for (int i = 0; i < 4; i++) {
            cli.getRover().turnLeft();
        }
        assertEquals(expected,cli.getMap());
    }

    @Test
    public void WhenRoverFacingNorthAndMoveForwardShouldBeAt0x1FacingNorth(){
        CommandLine cli = new CommandLine();

        Map<Integer,String> expected = new HashMap<>();
        expected.put(1,"^ _ _ _ _");

        int[] normalLines = {0,2,3,4};

        for (int line : normalLines){
            expected.put(line, "_ _ _ _ _");
        }

        cli.getRover().moveForward();

        assertEquals(expected,cli.getMap());

    }

    @Test
    public void whenRoverGoingOnTheSouthBorderShouldNotMove(){
        CommandLine cli = new CommandLine();

        Map<Integer,String> expected = new HashMap<>();
        expected.put(0, "v _ _ _ _");
        for (int i = 1; i <= CommandLine.MAX_POSITION.getY(); i++) {
            expected.put(i,"_ _ _ _ _");
        }

        cli.getRover().turnRight();
        cli.getRover().turnRight();
        cli.getRover().moveForward();

        assertEquals(expected,cli.getMap());
    }

    @Test
    public void whenRoverGoingOnTheWestBorderShouldNotMove(){
        CommandLine cli = new CommandLine();

        Map<Integer,String> expected = new HashMap<>();
        expected.put(0, "< _ _ _ _");
        for (int i = 1; i <= CommandLine.MAX_POSITION.getY(); i++) {
            expected.put(i,"_ _ _ _ _");
        }

        cli.getRover().turnLeft();
        cli.getRover().moveForward();

        assertEquals(expected,cli.getMap());
    }

    @Test
    public void whenRoverGoingOnTheNorthBorderShouldNotMove(){
        CommandLine cli = new CommandLine();

        Map<Integer,String> expected = new HashMap<>();
        expected.put(CommandLine.MAX_POSITION.getY(), "^ _ _ _ _");

        for (int i = 0; i < CommandLine.MAX_POSITION.getY(); i++) {
            expected.put(i,"_ _ _ _ _");
        }

        for (int i = 0; i < CommandLine.MAX_POSITION.getY(); i++) {
            cli.getRover().moveForward();
        }

        assertEquals(expected,cli.getMap());
    }
}
