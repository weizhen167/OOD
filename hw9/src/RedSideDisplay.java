
import java.util.ArrayList;
import java.util.Iterator;

public class RedSideDisplay implements ReadOnlyBoardViewModel {
    ArrayList<Draught.Box> Posboard;
    ArrayList<String> displayList;

    public RedSideDisplay(ArrayList<Draught.Box> Posboard,
            ArrayList<String> displayList) {
        this.displayList = displayList;
        this.Posboard = Posboard;
    }

    @Override
    public String get(int row, int column, int width) {
        int i = gethelper(7 - row, 7 - column);
        String s = this.displayList.get(i);
        return s;
    }

    int gethelper(int row, int column) {
        ArrayList<Draught.Box> l = new ArrayList<Draught.Box>(Posboard);
        int i = 0;
        while (i < l.size()) {
            if (l.get(i).getX() == row && l.get(i).getY() == column) {
                break;
            }
            i++;
        }
        return i;
    }

    @Override
    public Iterator<Integer> rows() {
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        l1.add(0);
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);
        l1.add(6);
        l1.add(7);
        Iterator<Integer> j = l1.iterator();
        return j;
    }

    @Override
    public Iterator<Integer> columns() {
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        l1.add(0);
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);
        l1.add(6);
        l1.add(7);
        Iterator<Integer> j = l1.iterator();
        return j;
    }

    @Override
    public boolean isValidPosition(int row, int column) {
        if (row % 2 != column % 2) {
            return true;
        }
        return false;
    }

}
