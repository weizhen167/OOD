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
public class NewOrderTableModel extends AbstractTableModel {

    /** row Names */
    public static List<List<Object>> list = new ArrayList<List<Object>>();

    /** columnNames */
    final String[] columnNames = { "ItemID", "Quantity" };

    /**
     * getColumnCount
     * 
     * @return int
     */
    public int getColumnCount() {
        return 2;
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
        try {
            Integer itemID = Integer.valueOf(obj.toString());
            if (OrderListModel.bakery.getInventory()
                    .contains(itemID.intValue())) {
                list.get(r).set(c, itemID);
                this.fireTableCellUpdated(r, c);
            } 
            else {
                new NoThatItem().setVisible(true);
            }
        } 
        catch (Exception e) {
            new CheckType().setVisible(true);
        }
    }

    /**
     * setEditable given point
     * 
     * @param r
     *            int
     * @param c
     *            int
     * @return Boolean
     */
    public boolean isCellEditable(int r, int c) {
        return true;
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