package pl.adamd.movement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {

    @Test
    void ifStartingPointAndEndPointAreEqualShouldReturnZero() {
        //given
        Move movement = new Move(2,2, 12);
        //when
        int result = movement.move(
                movement.getStartingPoint(),
                movement.getEndPoint(),
                movement.getLengthOfTheMovement());
        //then
        assertEquals(0, result);
    }
}
