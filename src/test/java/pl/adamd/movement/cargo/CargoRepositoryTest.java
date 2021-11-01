package pl.adamd.movement.cargo;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;

@Tag("Cargo")
class CargoRepositoryTest {

    CargoRepository cargoRepository = new CargoRepository();
    Cargo cargo = new Cargo("Cargo", 10);
    Cargo carbon = new Cargo("Carbon", 10);
    Cargo silver = new Cargo("Silver", 10);

    @Test
    void shouldAddCargoToCargoRepository() {
        //given
        //when
        cargoRepository.addCargo(cargo);
        //then
        assertThat(cargoRepository.getCargoList(), hasSize(1));
    }


    @Test
    void shouldRemoveCargoFromCargoRepository() {
        //given
        cargoRepository.addCargo(cargo);
        //when
        cargoRepository.removeCargo(cargo);
        //then
        assertThat(cargoRepository.getCargoList(), hasSize(0));
    }

    @Test
    void shouldFindExistingCargoByNameInRepository() {
        //given
        cargoRepository.addCargo(cargo);
        cargoRepository.addCargo(carbon);
        cargoRepository.addCargo(silver);
        //when
        //then
        assertAll(
                () -> assertThat(cargoRepository.findCargoByName("Gold").isEmpty(), equalToObject(true)),
                () -> assertThat(cargoRepository.findCargoByName("Wood").isEmpty(), equalToObject(true)),
                () -> assertThat(cargoRepository.findCargoByName("Cargo").isPresent(), equalToObject(true)),
                () -> assertThat(cargoRepository.findCargoByName("Silver").isPresent(), equalToObject(true)),
                () -> assertThat(cargoRepository.findCargoByName("Carbon").isPresent(), equalToObject(true))
        );
    }
}
