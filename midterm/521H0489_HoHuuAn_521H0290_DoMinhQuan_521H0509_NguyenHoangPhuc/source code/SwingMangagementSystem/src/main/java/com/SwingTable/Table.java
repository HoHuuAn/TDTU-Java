package com.SwingTable;

//import com.raven.swing.scrollbar.ScrollBarCustom;
import com.model.ModelActionCertificate;
import com.model.ModelActionStudent;
import com.model.ModelProfile;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import com.model.ModelActionUser;

import javax.swing.SwingConstants;

public class Table extends JTable {
        private boolean  visable =true;
        public Table() {
        setOpaque(false);
        getTableHeader().setBackground(new Color(255, 255, 255));
        setBackground(new Color(0, 0, 0, 0));
        setShowHorizontalLines(true);
        setGridColor(new Color(30, 30, 30, 50));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                
                    header.setHorizontalAlignment(JLabel.CENTER);
                
                return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean focus, int i, int i1) {
                if (o instanceof ModelProfile) {
                    ModelProfile data = (ModelProfile) o;
                    Profile cell = new Profile(data);
//                   cell.setLayout(new FlowLayout(FlowLayout.CENTER));
                    if (selected) {
                        cell.setBackground(new Color(239, 244, 255));
                    } else {
                        cell.setBackground(Color.WHITE);
                    }
                    return cell;

                } else if (o instanceof ModelActionUser) {
                    ModelActionUser data = (ModelActionUser) o;
                    Action cell = new Action(data);
                    if (selected) {
                        cell.setBackground(new Color(239, 244, 255));
                    } else {
                        cell.setBackground(Color.WHITE);
                    }
                    // set the visibility of the button 
                    cell.setButtonVisibility(visable);
                    return cell;
                } 
                else if (o instanceof ModelActionStudent) {
                    ModelActionStudent data = (ModelActionStudent) o;
                    Action cell = new Action(data);
                    if (selected) {
                        cell.setBackground(new Color(239, 244, 255));
                    } else {
                        cell.setBackground(Color.WHITE);
                    }
                    cell.setButtonVisibility(visable);
                    return cell;
                } 
                else if (o instanceof ModelActionCertificate) {
                    ModelActionCertificate data = (ModelActionCertificate) o;
                    Action cell = new Action(data);
                    if (selected) {
                        cell.setBackground(new Color(239, 244, 255));
                    } else {
                        cell.setBackground(Color.WHITE);
                    }
                    cell.setButtonVisibility(visable);
                    return cell;
                }
                else {
                    Component com = super.getTableCellRendererComponent(jtable, o, selected, focus, i, i1);
                    setBorder(DefaultTableCellRenderer.noFocusBorder);
                    com.setForeground(new Color(0, 0, 0, 0));
                    JLabel label = new JLabel(o + "");
                    label.setForeground(new Color(102, 102, 102));
                    label.setHorizontalAlignment(SwingConstants.CENTER);
                    
                    return label;
                }
            }
        });
    }
    
    public void setTableVisible( boolean  visable  )
    {
        this.visable = visable ; 
    }


    @Override
    public TableCellEditor getCellEditor(int row, int col) {
            switch (col) {
                case 5:
                    return new TableCellActionCertificate(visable);
                case 6:
                    return new TableCellAction(visable);
                case 7:
                    return new TableCellActionStudent(visable);
                default:
                    return super.getCellEditor(row, col);
            }
    }

    public void addRow(Object[] row) {
        
        DefaultTableModel mod = (DefaultTableModel) getModel();

        mod.addRow(row);
    }
    public void removeLastColumn() {
    DefaultTableModel tableModel = (DefaultTableModel) getModel();
    
    int lastColumnIndex = getColumnCount() - 1;
    
    // Check if there is at least one column in the table
    if (lastColumnIndex >= 0) {
        // Remove the last column from the table model
        tableModel.addColumn(getColumnName(lastColumnIndex), new Object[0]);
        tableModel.setColumnCount(lastColumnIndex);
    }
}

     public void ClearTable() {
        DefaultTableModel mod = (DefaultTableModel) getModel();
    while (mod.getRowCount() > 0) {
        mod.removeRow(0);
    }
    // Notify the table that the data has changed
    mod.fireTableDataChanged();
    }
}

//    public void fixTable(JScrollPane scroll) {
//        scroll.getViewport().setOpaque(false);
//        scroll.setViewportBorder(null);
//        scroll.setVerticalScrollBar(new ScrollBarCustom());
//        JPanel p = new JPanel();
//        p.setOpaque(false);
//        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
//        scroll.setBorder(new EmptyBorder(5, 10, 5, 10));
//    }

