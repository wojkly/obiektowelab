package agh.cs.lab6;

import java.util.HashMap;
import java.util.Map;

abstract public class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d,Animal> animals = new HashMap<>();

    public String toString() {
        return new MapVisualizer(this).draw( getLLlimit(), getURlimit() );
    }

    abstract public Vector2d getLLlimit();
    abstract public Vector2d getURlimit();

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Object object = objectAt(oldPosition);

        if (object instanceof Animal) {
            animals.remove(oldPosition);
            animals.put(newPosition, (Animal) object);
        }
    }

    @Override
    abstract public boolean canMoveTo(Vector2d position);

    @Override
    public boolean place(Animal animal) {
        if( !animalOccupied( animal.getPosition() ) ){
            animals.put( animal.getPosition(), animal);
            animal.addObserver(this);
            return true;
        }
        return false;
    }
    public boolean animalOccupied(Vector2d position) {
        if(animals.containsKey(position)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if(objectAt(position) == null) return false;
        return true;
    }

    @Override
    abstract public Object objectAt(Vector2d position);

}
