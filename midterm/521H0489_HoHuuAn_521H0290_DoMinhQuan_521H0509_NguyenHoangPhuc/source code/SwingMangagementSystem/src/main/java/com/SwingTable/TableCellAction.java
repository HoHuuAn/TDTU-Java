package com.SwingTable;


import com.model.ModelActionUser;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableCellAction extends DefaultCellEditor {

    private ModelActionUser data;
    private boolean Visable =true  ; 
    public TableCellAction(boolean  visable) {
        super(new JCheckBox());
        Visable =visable ; 
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int i, int i1) {
        data = (ModelActionUser) o;
          
        Action cell = new Action(data);
        // set the visablity of the button 
          cell.setButtonVisibility(Visable);
        cell.setBackground(new Color(30, 30, 30, 50));
        return cell;
    }

    //  This method to pass data to cell render when focus lose in cell
    @Override
    public Object getCellEditorValue() {
        return data;
    }
}
