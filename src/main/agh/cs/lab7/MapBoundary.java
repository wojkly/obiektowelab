package agh.cs.lab7;

import java.util.Comparator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;


public class MapBoundary implements IPositionChangeObserver {
    private final SortedSet<Vector2d> xSet;
    private final SortedSet<Vector2d> ySet;

    public MapBoundary() {
        xSet = new TreeSet<>((e1, e2) -> {
            if (e1.getX() != e2.getX())
                return Integer.compare(e1.getX(), e2.getX());
            else if (e1.getY() != e2.getY())
                return Integer.compare(e1.getY(), e2.getY());
            else
                return 0;
        });
        ySet = new TreeSet<>((e1, e2) -> {
            if (e1.getY() != e2.getY())
                return Integer.compare(e1.getY(), e2.getY());
            else if (e1.getX() != e2.getX())
                return Integer.compare(e1.getX(), e2.getX());
            else
                return 0;
        });
    }

    public void addElement(Vector2d element) {
        xSet.add(element);
        ySet.add(element);
    }
    public void removeElement(Vector2d element) {
        xSet.remove(element);
        ySet.remove(element);
    }


    @Override
    public void positionChanged(IMapElement element, Vector2d oldPosition, Vector2d newPosition) {
        removeElement(oldPosition);
        addElement(newPosition);
    }

    public Vector2d[] getBoundary() {
        return new Vector2d[]{new Vector2d(xSet.first().getX(), ySet.first().getY()),
                                 new Vector2d(xSet.last().getX(), ySet.last().getY()) };
    }

}
