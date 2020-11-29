package agh.cs.lab7;

import java.util.HashMap;
import java.util.Map;

abstract public class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d,Animal> animals = new HashMap<>();
    protected MapBoundary mapBoundary;

    public String toString() {
        Vector2d[] bounds = mapBoundary.getBoundary();
        return new MapVisualizer(this).draw( bounds[0], bounds[1]);
    }


    @Override
    public void positionChanged(IMapElement element, Vector2d oldPosition, Vector2d newPosition) {
        Object object = objectAt(oldPosition);

        if (object instanceof Animal) {
            animals.remove(oldPosition);
            animals.put(newPosition, (Animal) object);
            mapBoundary.positionChanged(element, oldPosition, newPosition);
        }
    }

    @Override
    abstract public boolean canMoveTo(Vector2d position);

    @Override
    public boolean place(Animal animal) {
        if( !animalOccupied( animal.getPosition() ) ){
            animals.put( animal.getPosition(), animal);
            animal.addObserver(this);
            mapBoundary.addElement(new Vector2d( animal.getPosition().getX(), animal.getPosition().getY()));
            return true;
        }
        throw new IllegalArgumentException("cant put an animal at place:" + animal.getPosition().toString());
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
