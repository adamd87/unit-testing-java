package pl.adamd.movement.unit;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pl.adamd.movement.cargo.Cargo;
import pl.adamd.movement.Coordinates;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
@Tag("Cargo")
class UnitTest {

    @Test
    void shouldThrowExceptionIfSumOfTwoCoordinatePointsIsMoreThenValueOfFuel() {
        //given
        Coordinates coordinates = new Coordinates(30, 80);
        Unit unit = new Unit(coordinates, 100, 100);
        int pointX = 40;
        int pointY = 70;
        //when
        //then
        assertThrows(IllegalStateException.class, () -> unit.move(pointX, pointY));
    }

    @Test
    void returnsCoordinatesIncreasedByTheGivenPointsValuesAndFuelDropsBySumOfThesePoints() {
        //given
        int maxFuel = 100;
        Coordinates coordinates = new Coordinates(10, 10);
        Unit unit = new Unit(coordinates, maxFuel, 100);

        int pointX = 20;
        int pointY = 15;

        //when
        unit.move(pointX, pointY);

        //then
        assertThat(Coordinates.copy(coordinates, pointX, pointY), equalTo(new Coordinates(30, 25)));
        assertThat(unit.getFuel(), is(equalTo(maxFuel - (pointX + pointY))));
    }

    @Test
    void afterTankUpFuelShouldBeGreaterThanAfterMoveAndLessThanOrEqualToMaxFuel() {
        //given
        int maxFuel = 100;
        Coordinates coordinates = new Coordinates(10, 10);
        Unit unit = new Unit(coordinates, maxFuel, 100);
        int pointX = 20;
        int pointY = 15;
        unit.move(pointX, pointY);

        //when
        unit.tankUp();

        //then
        assertThat(unit.getFuel(), is(greaterThan(maxFuel - (pointX + pointY))));
        assertThat(unit.getFuel(), lessThanOrEqualTo(maxFuel));
    }

    @Test
    void shouldThrowIllegalStateExceptionIfCargoWeightIsGreaterThenMaxCargoWeight() {
        //given
        int maxCargoWeight = 100;
        int cargoWeight = 101;
        Cargo cargo = new Cargo("Carbon", cargoWeight);
        Unit unit = new Unit(new Coordinates(10, 10), 100, maxCargoWeight);
        //when
        //then
        assertThrows(IllegalStateException.class, () -> unit.loadCargo(cargo));
        assertThat(unit.getLoad(), equalTo(0));
    }

    @Test
    void shouldAddCargoWeightToCurrentCargoWeightInUnit() {
        //given
        int maxCargoWeight = 100;
        int cargoWeight = 80;
        Cargo cargo = new Cargo("Carbon", cargoWeight);
        Unit unit = new Unit(new Coordinates(10, 10), 100, maxCargoWeight);
        //when
        unit.loadCargo(cargo);
        //then
        assertThat(unit.getLoad(), equalTo(cargoWeight));
        assertThat(unit.getLoad(), lessThanOrEqualTo(maxCargoWeight));

    }
    @Test
    void currentCargoWeightShouldBeReducedByUnloadedCargo() {
        //given
        int carbonWeight = 80;
        int silverWeight = 20;
        Cargo carbonCargo = new Cargo("Carbon", carbonWeight);
        Cargo silverCargo = new Cargo("Silver", silverWeight);
        Unit unit = new Unit(new Coordinates(10, 10), 100, 100);
        unit.loadCargo(carbonCargo);
        unit.loadCargo(silverCargo);
        //when
        unit.unloadCargo(carbonCargo);
        //then
        assertThat(unit.getLoad(), equalTo(silverWeight));
    }

    @Test
    void afterUnloadAllCargoCurrentCargoWeightShouldBeReducedToZero() {
        //given
        int carbonWeight = 80;
        int silverWeight = 20;
        Cargo carbonCargo = new Cargo("Carbon", carbonWeight);
        Cargo silverCargo = new Cargo("Silver", silverWeight);
        Unit unit = new Unit(new Coordinates(10, 10), 100, 100);
        unit.loadCargo(carbonCargo);
        unit.loadCargo(silverCargo);
        //when
        unit.unloadAllCargo();
        //then
        assertThat(unit.getLoad(), equalTo(0));
    }
}
