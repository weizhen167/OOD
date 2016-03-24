package gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author ZHEN Wei / ZhenHuan Wu
 * @version 2014.6.18
 * 
 */
public class ItemListModel extends AbstractTableModel {
    /** row names */
    private static List<List<Object>> list = new ArrayList<List<Object>>();

    /**
     * refresh data
     */
    public static void setFile() {
        list = OrderListModel.bakery.exportInventoryToJTable();
    }

    /** columnNames */
    final String[] columnNames = { "BakeryItemID", "BakeryItemName",
        "Category", "Price" };

    /**
     * getColumnCount
     * 
     * @return int
     */
    public int getColumnCount() {
        return 4;
    }

    /**
     * getRowCount()
     * 
     * @return int
     */
    public int getRowCount() {
        return list.size();
    }

    /**
     * getValueAt given point
     * 
     * @param r
     *            int
     * @param c
     *            int
     * @return Object
     */
    public Object getValueAt(int r, int c) {
        return list.get(r).get(c);
    }

    /**
     * getColumnName given point
     * 
     * @param c
     *            int
     * @return String
     */
    public String getColumnName(int c) {
        return (String) columnNames[c];
    }

    /**
     * getValueAt given point
     * 
     * @param r
     *            int
     * @param c
     *            int
     * @param obj Object           
     */
    public void setValueAt(Object obj, int r, int c) {
        list.get(r).set(c, obj);
        this.fireTableCellUpdated(r, c);
    }

    /**
     * setEditable given point
     * 
     * @param r
     *            int
     * @param c
     *            int
     * @return boolean
     */
    public boolean isCellEditable(int r, int c) {
        return false;
    }

    /**
     * addrow to the list
     * 
     * @param ob
     *            Object[]
     */
    public void addrow(Object[] ob) {
        list.add(Arrays.asList(ob));
        this.fireTableRowsInserted(list.size(), list.size());
    }
}