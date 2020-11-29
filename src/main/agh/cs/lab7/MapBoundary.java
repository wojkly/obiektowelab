package agh.cs.lab7;

import java.util.Comparator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;


public class MapBoundary implements IPositionChangeObserver {
    private final SortedSet<Vector2d> xSet;
    private final SortedSet<Vector2d> ySet;
    private IWorldMap map;

//    public MapBoundary() {
//        xSet = new TreeSet<>((e1, e2) -> {
//            if (e1.getPosition().getX() != e2.getPosition().getX())
//                return Integer.compare(e1.getPosition().getX(), e2.getPosition().getX());
//            else if (e1.getPosition().getY() != e2.getPosition().getY())
//                return Integer.compare(e1.getPosition().getY(), e2.getPosition().getY());
//            else if (e1 instanceof Animal)
//                return 1;
//            else
//                return -1;
//        });
//        ySet = new TreeSet<>((e1, e2) -> {
//            if (e1.getPosition().getY() != e2.getPosition().getY())
//                return Integer.compare(e1.getPosition().getY(), e2.getPosition().getY());
//            else if (e1.getPosition().getX() != e2.getPosition().getX())
//                return Integer.compare(e1.getPosition().getX(), e2.getPosition().getX());
//            else if (e1 instanceof Animal)
//                return 1;
//            else
//                return -1;
//        });
//    }
//    public void addElement(IMapElement element) {
//        xSet.add(element);
//        ySet.add(element);
//    }
//    public void removeElement(IMapElement element) {
//        xSet.remove(element);
//        ySet.remove(element);
//    }
//
//
//    @Override
//    public void positionChanged(IMapElement element, Vector2d oldPosition, Vector2d newPosition) {
//        IMapElement g = new Grass(oldPosition);
//        removeElement(g);
//        addElement(element);
//    }
//
//    public Vector2d[] getBoundary() {
//        return new Vector2d[]{new Vector2d(xSet.first().getPosition().getX(), ySet.first().getPosition().getY()),
//                new Vector2d(xSet.last().getPosition().getX(), ySet.last().getPosition().getY()) };
//    }

    public MapBoundary(IWorldMap map) {
        this.map = map;
        xSet = new TreeSet<>((e1, e2) -> {
            if (e1.getX() != e2.getX())
                return Integer.compare(e1.getX(), e2.getX());
            else if (e1.getY() != e2.getY())
                return Integer.compare(e1.getY(), e2.getY());
            else if (this.map.objectAt(e1) instanceof Animal)
                return 1;
            else
                return -1;
        });
        ySet = new TreeSet<>((e1, e2) -> {
            if (e1.getY() != e2.getY())
                return Integer.compare(e1.getY(), e2.getY());
            else if (e1.getX() != e2.getX())
                return Integer.compare(e1.getX(), e2.getX());
            else if (this.map.objectAt(e1) instanceof Animal)
                return 1;
            else
                return -1;
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
