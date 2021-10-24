package pl.adamd.movement;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Tag("Cargo")
class CoordinatesTest {
    @Test
    void exceptionShouldBeThrownIfAnyPositionPointIsLessThenZero() {
        assertAll("Position can not be less than 0 - throws exception",
                () -> assertThrows(IllegalArgumentException.class, () -> new Coordinates(0, -1)),
                () -> assertThrows(IllegalArgumentException.class, () -> new Coordinates(-1, -1)),
                () -> assertThrows(IllegalArgumentException.class, () -> new Coordinates(-1, 1))
        );
    }

    @Test
    void exceptionShouldBeThrownIfAnyPositionPointIsMoreThen100() {
        assertAll("Position can not be more than 100 - throws exception",
                () -> assertThrows(IllegalArgumentException.class, () -> new Coordinates(101, 1)),
                () -> assertThrows(IllegalArgumentException.class, () -> new Coordinates(1, 101)),
                () -> assertThrows(IllegalArgumentException.class, () -> new Coordinates(101, 111))
        );
    }

    @Test
    void shouldReturnsNewCoordinatesIncreasedByTheGivenValues() {
        //given
        Coordinates coordinates = new Coordinates(15, 25);
        int x = 5;
        int y = 10;
        //when
        //then
        assertThat(Coordinates.copy(coordinates, x, y).getX(), equalTo(20));
        assertThat(Coordinates.copy(coordinates, x, y).getY(), equalTo(35));
        assertThat(Coordinates.copy(coordinates, x, y), is(not(coordinates)));
    }
}
