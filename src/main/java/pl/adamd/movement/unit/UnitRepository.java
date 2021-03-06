package pl.adamd.movement.unit;

import pl.adamd.movement.Coordinates;

import java.util.HashMap;
import java.util.Map;

public class UnitRepository {
    private Map<Coordinates, Unit> units;

    UnitRepository(){
        units = new HashMap<>();
    }

    void addUnit(Unit unit){
        units.put(unit.getCoordinates(), unit);
    }

    void removeUnit(Unit unit){
        units.remove(unit.getCoordinates());
    }

    void removeUnit(Coordinates coordinates){
        units.remove(coordinates);
    }

    Unit getUnitByCoordinates(Coordinates coordinates){
        return units.get(coordinates);
    }

    public Map<Coordinates, Unit> getUnits() {
        return units;
    }
}
