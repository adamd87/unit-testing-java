package pl.adamd.movement.unit;

import pl.adamd.movement.cargo.Cargo;
import pl.adamd.movement.cargo.CargoRepository;
import pl.adamd.movement.Coordinates;

import java.util.NoSuchElementException;
import java.util.Optional;

public class UnitService {

    private final CargoRepository cargoRepository ;
    private final UnitRepository unitRepository ;

    public UnitService(CargoRepository cargoRepository, UnitRepository unitRepository) {
        this.cargoRepository = cargoRepository;
        this.unitRepository = unitRepository;
    }

    void addCargoByName(Unit unit, String name) {
        Optional<Cargo> cargo = cargoRepository.findCargoByName(name);

        if (cargo.isPresent()) {
            unit.loadCargo(cargo.get());
        } else {
            throw new NoSuchElementException("Unable to find cargo");
        }
    }

    Unit getUnitOn(Coordinates coordinates) {
        Unit unit = unitRepository.getUnitByCoordinates(coordinates);

        if (unit == null) {
            throw new NoSuchElementException("Unable to find any unit");
        } else {
            return unit;
        }
    }

}

