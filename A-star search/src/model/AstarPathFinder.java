package model;

import java.util.ArrayList;
import java.util.List;

public class AstarPathFinder {

    // open list
    private List<Location> openList;
    // close list
    private List<Location> closeList;

    public AstarPathFinder() {
        openList = new ArrayList<Location>();
        closeList = new ArrayList<Location>();
    }

    public List<Location> findPath(Location start, Location dest, int[][] map) {
        List<Location> path = new ArrayList<Location>();
        openList.add(start);
        Location current = null;
        do {
            current = getLowestFscoreLocation(openList);
            closeList.add(current);
            openList.remove(current);
            if (closeList.contains(dest)) {
                break;
            }
            List<Location> adjacentLocations = getWalkableAdjacentLocations(
                    current, map);
            for (Location lo : adjacentLocations) {
                if (closeList.contains(lo)) {
                    continue;
                }
                if (!openList.contains(lo)) {
                    lo.setMovedSteps(current.getMovedSteps() + 1);
                    lo.setEvalRemainSteps(evalRemainSteps(current, dest));
                    lo.setTotalEvalSteps(evalRemainSteps(current, dest)
                            + lo.getMovedSteps());
                    openList.add(lo);
                } else {
                    if (current.getMovedSteps() + 1 < lo.getMovedSteps()) {
                        lo.setMovedSteps(current.getMovedSteps() + 1);
                        lo.setPrevious(current);
                    }
                }
            }

        } while (!openList.isEmpty());
        Location destination = null;
        if (closeList.contains(dest)) {
            destination = current;

            path.add(destination);
            while (destination.getPrevious() != null) {
                destination = destination.getPrevious();
                path.add(destination);
            }
        }

        return path;
    }

    private Boolean in(int[] ll, int i) {
        boolean result = false;
        int acc = 0;
        while (acc < ll.length) {
            if (ll[acc] == i) {
                result = true;
                break;
            }
            acc = acc + 1;
        }
        return result;
    }

    private List<Location> getWalkableAdjacentLocations(Location current,
            int[][] map) {
        int[] ll = { 0, 1, 7 };
        int x = current.getX();
        int y = current.getY();
        List<Location> walkableLos = new ArrayList<Location>();
        Location lo = null;
        if (x + 1 < map[0].length && in(ll, map[y][x + 1])) {
            lo = new Location(x + 1, y);
            lo.setPrevious(current);
            walkableLos.add(lo);
        }
        if (x - 1 >= 0 && in(ll, map[y][x - 1])) {
            lo = new Location(x - 1, y);
            lo.setPrevious(current);
            walkableLos.add(lo);
        }
        if (y + 1 < map.length && in(ll, map[y + 1][x])) {
            lo = new Location(x, y + 1);
            lo.setPrevious(current);
            walkableLos.add(lo);
        }
        if (y - 1 >= 0 && in(ll, map[y - 1][x])) {
            lo = new Location(x, y - 1);
            lo.setPrevious(current);
            walkableLos.add(lo);
        }
        return walkableLos;
    }

    /**
     * Find Location
     * 
     * @param openList
     * @return
     */
    private Location getLowestFscoreLocation(List<Location> openList) {
        if (openList == null || openList.size() == 0) {
            return null;
        }
        int minSteps = openList.get(0).getTotalEvalSteps();
        int tmpSteps = 0;
        Location lowestFlocation = openList.get(0);
        for (Location lo : openList) {
            tmpSteps = lo.getTotalEvalSteps();
            if (tmpSteps < minSteps) {
                minSteps = tmpSteps;
                lowestFlocation = lo;
            }
        }
        return lowestFlocation;
    }

    /**
     * get H value
     * 
     * @param current
     * @param dest
     * @return
     */
    private int evalRemainSteps(Location current, Location dest) {
        int distanceX = dest.getX() - current.getX();
        int distanceY = dest.getY() - current.getY();
        if (distanceX < 0) {
            distanceX = distanceX * -1;
        }
        if (distanceY < 0) {
            distanceY = distanceY * -1;
        }
        return distanceX + distanceY;
    }
}
