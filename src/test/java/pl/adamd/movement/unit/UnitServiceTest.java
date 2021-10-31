package pl.adamd.movement.unit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.adamd.movement.Coordinates;
import pl.adamd.movement.cargo.CargoRepository;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class UnitServiceTest {

    @InjectMocks
    private UnitService unitService;

    @Mock
    private CargoRepository cargoRepository;

    @Mock
    private Coordinates coordinates;


    @Test
    void shouldThrowExceptionWhenCargoDoesntExists() {
        //given
        Unit unit = new Unit(coordinates, 10, 100);
        //when
        //then
        assertThrows(NoSuchElementException.class, () -> unitService.addCargoByName(unit, "Cargo"));
    }
}
