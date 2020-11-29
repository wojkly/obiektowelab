package agh.cs.lab7;

public abstract class AbstractMapElement implements IMapElement{
    protected Vector2d position;

    @Override
    public Vector2d getPosition() {
        return position;
    }
}
