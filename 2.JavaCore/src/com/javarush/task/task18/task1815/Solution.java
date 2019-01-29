package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface {
        TableInterface t;
        TableInterfaceWrapper(TableInterface t) {
            this.t = t;
        }
        
        public void setModel(List rows) {
            System.out.println(rows.size());
            t.setModel(rows);
        }

        public String getHeaderText() {
            return  t.getHeaderText().toUpperCase();
        }

        public void setHeaderText(String newHeaderText) {
         t.setHeaderText(newHeaderText);
        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}