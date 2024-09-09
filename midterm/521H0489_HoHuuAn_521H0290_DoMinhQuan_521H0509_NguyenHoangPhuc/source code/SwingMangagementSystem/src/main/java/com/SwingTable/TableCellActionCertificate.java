package com.SwingTable;

import com.model.ModelActionCertificate;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class TableCellActionCertificate extends DefaultCellEditor {

    private ModelActionCertificate data;
    private boolean visible;

    public TableCellActionCertificate(boolean visible) {
        super(new JCheckBox());
        this.visible = visible;
    }

    @Override
    public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int i, int i1) {
        data = (ModelActionCertificate) o;
        
        Action cell = new Action(data);
        // set the visibility of the button 
        cell.setButtonVisibility(visible);
        cell.setBackground(new Color(30, 30, 30, 50));
        return cell;
    }

    // This method passes data to cell render when focus is lost in the cell
    @Override
    public Object getCellEditorValue() {
        return data;
    }
}
