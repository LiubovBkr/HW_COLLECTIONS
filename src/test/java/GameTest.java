import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    @Test
    public void testWhenFirstPlayerWins() {
        Player anya = new Player(1, "Аня", 120);
        Player jana = new Player(2, "Яна", 100);
        Game game = new Game();

        game.register(anya);
        game.register(jana);
        int actual = game.round("Аня", "Яна");
        int expected = 1;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testWhenSecondPlayerWins() {
        Player anya = new Player(1, "Аня", 100);
        Player jana = new Player(2, "Яна", 120);
        Game game = new Game();

        game.register(anya);
        game.register(jana);
        int actual = game.round("Аня", "Яна");
        int expected = 2;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testWhenStrengthsEqual() {
        Player anya = new Player(1, "Аня", 100);
        Player jana = new Player(2, "Яна", 100);
        Game game = new Game();

        game.register(anya);
        game.register(jana);
        int actual = game.round("Аня", "Яна");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testFirstPlayerNotRegistered() {

        Player anya = new Player(1, "Аня", 10);
        Player jana = new Player(1, "Яна", 120);
        Game game = new Game();
        game.register(anya);
        game.register(jana);

        assertThrows(NotRegisteredException.class,
                () -> game.round("Оля", "Яна")
        );
    }

    @Test
    public void testSecondPlayerNotRegistered() {

        Player anya = new Player(1, "Аня", 10);
        Player jana = new Player(1, "Яна", 120);
        Game game = new Game();
        game.register(anya);
        game.register(jana);

        assertThrows(NotRegisteredException.class,
                () -> game.round("Аня", "Оля")
        );
    }
}