package pl.adamd.movement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveTest {

    @Test
    void ifStartingPointAndEndPointAreEqualShouldReturnZero() {
        //given
        Move movement = new Move(2,2, 2);
        //when
        int result = movement.moveForward(
                movement.getStartingPoint(),
                movement.getEndPoint(),
                movement.getLengthOfTheMovement());
        //then
        assertEquals(0, result);
    }
    @Test
    void ifEndPointIsBiggerThenStartingPointShouldReturnCountOfMovement(){
        //given
        Move movement = new Move(10,15,2);
        //when
        int result = movement.moveForward(
                movement.getStartingPoint(),
                movement.getEndPoint(),
                movement.getLengthOfTheMovement());
        //then
        assertEquals(3, result);
    }
    @Test
    void ifEndThenStartingPointIsBiggerThenEndPointShouldReturnZero(){
        //given
        Move movement = new Move(10,5,2);
        //when
        int result = movement.moveForward(
                movement.getStartingPoint(),
                movement.getEndPoint(),
                movement.getLengthOfTheMovement());
        //then
        assertEquals(0, result);
    }
    @Test
    void ifLengthOfTheMovementEqualsZeroShouldReturnZero(){
        //given
        Move movement = new Move(10,5,0);
        //when
        int result = movement.moveForward(
                movement.getStartingPoint(),
                movement.getEndPoint(),
                movement.getLengthOfTheMovement());
        //then
        assertEquals(0, result);
    }

}
