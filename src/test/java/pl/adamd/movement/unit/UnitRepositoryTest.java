package pl.adamd.movement.unit;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pl.adamd.movement.Coordinates;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;

@Tag("Cargo")
class UnitRepositoryTest {
    private final int maxFuel = 100;
    private final int maxCargoWeight = 100;

    UnitRepository unitRepository = new UnitRepository();
    Coordinates coordinates1 = new Coordinates(15, 20);
    Coordinates coordinates2 = new Coordinates(25, 30);
    Coordinates coordinates3 = new Coordinates(35, 40);
    Unit unit1 = new Unit(coordinates1, maxFuel, maxCargoWeight);
    Unit unit2 = new Unit(coordinates2, maxFuel, maxCargoWeight);
    Unit unit3 = new Unit(coordinates3, maxFuel, maxCargoWeight);

    @Test
    void shouldAddUnitToTheUnitRepository() {
        //when
        unitRepository.addUnit(unit1);
        //then
        assertAll(
                () -> assertThat(unitRepository.getUnits().size(), equalTo(1)),
                () -> assertThat(unitRepository.getUnits(), notNullValue())
        );
    }

    @Test
    void shouldRemoveIndicatedUnitFromRepositoryBy() {
        //given
        unitRepository.addUnit(unit1);
        unitRepository.addUnit(unit2);
        unitRepository.addUnit(unit3);
        //when
        unitRepository.removeUnit(unit1);
        //then
        assertAll(
                () -> assertThat(unitRepository.getUnits().size(), equalTo(2)),
                () -> assertThat(unitRepository.getUnits().containsValue(unit1), equalToObject(false))
        );
    }

    @Test
    void shouldRemoveTheUnitFromRepositoryByGivingTheCoordinates() {
        //given
        unitRepository.addUnit(unit1);
        unitRepository.addUnit(unit2);
        unitRepository.addUnit(unit3);
        //when
        unitRepository.removeUnit(coordinates2);
        unitRepository.removeUnit(coordinates3);
        //then
        assertAll(
                () -> assertThat(unitRepository.getUnits().size(), equalTo(1)),
                () -> assertThat(unitRepository.getUnits().containsValue(unit2), equalToObject(false)),
                () -> assertThat(unitRepository.getUnits().containsKey(coordinates2), equalToObject(false)),
                () -> assertThat(unitRepository.getUnits().containsValue(unit3), equalToObject(false)),
                () -> assertThat(unitRepository.getUnits().containsKey(coordinates3), equalToObject(false)),
                () -> assertThat(unitRepository.getUnitByCoordinates(coordinates1), equalToObject(unit1)),
                () -> assertThat(unitRepository.getUnitByCoordinates(coordinates2), nullValue()),
                () -> assertThat(unitRepository.getUnitByCoordinates(coordinates3), nullValue())
        );
    }

    @Test
    void shouldGetTheUnitFormTheRepositoryGivingTheCoordinates() {
        //given
        unitRepository.addUnit(unit1);
        unitRepository.addUnit(unit2);
        unitRepository.addUnit(unit3);
        //when
        //then
        assertAll(
                () -> assertThat(unitRepository.getUnits().size(), equalTo(3)),
                () -> assertThat(unitRepository.getUnitByCoordinates(coordinates1), equalToObject(unit1)),
                () -> assertThat(unitRepository.getUnitByCoordinates(coordinates2), equalToObject(unit2)),
                () -> assertThat(unitRepository.getUnitByCoordinates(coordinates3), equalToObject(unit3)),
                () -> assertThat(unitRepository.getUnitByCoordinates(coordinates1), not(equalToObject(unit3))),
                () -> assertThat(unitRepository.getUnitByCoordinates(coordinates2), not(equalToObject(unit1))),
                () -> assertThat(unitRepository.getUnitByCoordinates(coordinates3), not(equalToObject(unit2)))
        );
    }
}
