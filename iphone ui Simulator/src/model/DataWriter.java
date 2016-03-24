package model;

import java.io.File;
import java.util.ArrayList;

import ui.Failed;
import ui.Thanks;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class DataWriter {

    private String database = "";
    private ArrayList<String> data = new ArrayList<String>();

    public DataWriter(String database, ArrayList<String> data) {
        this.database = database;
        this.data = data;
    }

    public void writeData() {
        try {
            // Excel获得文件
            Workbook wb = Workbook.getWorkbook(new File(this.database));
            // 打开一个文件的副本，并且指定数据写回到原文件
            WritableWorkbook book = Workbook.createWorkbook(new File(
                    this.database), wb);
            WritableSheet sheet = book.getSheet(0);
            int row = sheet.getRows();

            int racc = row;
            int cacc = 0;
            // System.out.println(input);
            while (racc < row + 20) {
                sheet.addCell(new Label(cacc, racc, this.data.get(0)));
                this.data.remove(0);
                // System.out.println(input);
                cacc++;
                if (cacc == 5) {
                    racc++;
                    cacc = 0;
                }
            }
            book.write();
            book.close();
            Thanks frame = new Thanks();
            frame.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
            Failed frame1 = new Failed();
            frame1.setVisible(true);
        }
    }
}
