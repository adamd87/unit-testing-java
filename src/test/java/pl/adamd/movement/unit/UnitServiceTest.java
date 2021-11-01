package pl.adamd.movement.unit;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pl.adamd.movement.Coordinates;
import pl.adamd.movement.cargo.Cargo;
import pl.adamd.movement.cargo.CargoRepository;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Tag("Cargo")
class UnitServiceTest {

    private final int maxFuel = 100;
    private final int maxCargoWeight = 100;

    UnitRepository unitRepository = new UnitRepository();
    Coordinates coordinates1 = new Coordinates(15, 20);
    Coordinates coordinates2 = new Coordinates(25, 30);
    Coordinates coordinates3 = new Coordinates(35, 40);
    Unit unit1 = new Unit(coordinates1, maxFuel, maxCargoWeight);
    Unit unit2 = new Unit(coordinates2, maxFuel, maxCargoWeight);
    Unit unit3 = new Unit(coordinates3, maxFuel, maxCargoWeight);

    CargoRepository cargoRepository = new CargoRepository();
    Cargo cargo = new Cargo("Cargo", 10);
    Cargo carbon = new Cargo("Carbon", 10);
    Cargo silver = new Cargo("Silver", 10);

    UnitService unitService = new UnitService(cargoRepository, unitRepository);

    @Test
    void shouldAddCargoToUnitIfExistsInCargoRepository() {
        //given
        unitRepository.addUnit(unit1);
        unitRepository.addUnit(unit2);
        unitRepository.addUnit(unit3);
        cargoRepository.addCargo(cargo);
        cargoRepository.addCargo(carbon);
        cargoRepository.addCargo(silver);
        //when
        unitService.addCargoByName(unit1, "Cargo");
        unitService.addCargoByName(unit1, "Carbon");
        unitService.addCargoByName(unit3, "Silver");
        //then
        assertAll(
                () -> assertThat(unit1.getCargo(), hasSize(2)),
                () -> assertThat(unit1.getCargo(), containsInAnyOrder(carbon, cargo)),
                () -> assertThat(unit1.getLoad(), equalTo(20)),
                () -> assertThat(unit3.getCargo(), contains(silver)),
                () -> assertThat(unit3.getLoad(), equalTo(10)),
                () -> assertThat(unit2.getCargo(), empty())
        );
    }

    @Test
    void shouldThrowExceptionIfCargoIsNotExistsInCargoRepository() {
        //given
        unitRepository.addUnit(unit1);
        cargoRepository.addCargo(silver);
        //when
        //then
        assertThrows(NoSuchElementException.class, () -> unitService.addCargoByName(unit1, "Wood"));
    }

    @Test
    void shouldReturnUnitGivingTheCoordinates(){
        //given
        unitRepository.addUnit(unit1);
        cargoRepository.addCargo(cargo);
        unitService.addCargoByName(unit1, "Cargo");
        //when
        Unit result = unitService.getUnitOn(coordinates1);
        //then
        assertAll(
                () -> assertThat(result, equalTo(unit1)),
                () -> assertThat(result.getCargo(), contains(cargo)),
                () -> assertThat(result.getLoad(), equalTo(10))
        );
    }

    @Test
    void shouldThrowExceptionWhenUnitSearchingByGivenCoordinatesEqualsNull(){
        //given
        Coordinates unassignedCoordinates = new Coordinates(55,55);
        //when
        //then
        assertThrows(NoSuchElementException.class, () -> unitService.getUnitOn(unassignedCoordinates));
    }
}
