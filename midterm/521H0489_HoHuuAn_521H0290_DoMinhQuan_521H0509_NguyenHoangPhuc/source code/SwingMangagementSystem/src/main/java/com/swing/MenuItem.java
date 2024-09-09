package com.swing;


//import com.raven.event.EventMenu;
//import com.raven.event.EventMenuSelected;
import com.model.ModelMenu;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;
import com.EventInterface.EventMenuItemSelected;

public class MenuItem extends javax.swing.JPanel {

    public ModelMenu getMenu() {
        return menu;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

//    public EventMenuSelected getEventSelected() {
//        return eventSelected;
//    }
//
//    public void setEventSelected(EventMenuSelected eventSelected) {
//        this.eventSelected = eventSelected;
//    }

    public int getIndex() {
        return index;
    }

    private float alpha;
    private ModelMenu menu;
    private boolean open; 
    private int index;
    
//    @Override
//    public Dimension getPreferredSize() {
//        // Set the preferred width and height here
//        int preferredWidth = 400; // Your preferred width
//        int preferredHeight = 500; // Set the desired preferred height
//
//        return new Dimension(preferredWidth, preferredHeight);
//    }
    public MenuItem(ModelMenu menu, int index, EventMenuItemSelected eventSelected) {
        initComponents();
        this.menu = menu;
//        this.eventSelected = eventSelected;
        this.index = index;
        setOpaque(false);
        // modify this so that you can adjust the model button height and width 
        setLayout(new MigLayout("wrap, fillx, insets 0", "[fill]", "[fill, 60!]0[fill, 60!]"));
        MenuButton firstItem = new MenuButton(menu.getIcon(), "     " + menu.getMenuName());
        firstItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                if (menu.getSubMenu().length > 0) {
//                    if (event.menuPressed(MenuItem.this, !open)) {
//                        open = !open;
//                    }
//                }

                eventSelected.menuSelected(index);
            }
        });
        add(firstItem);
//        int subMenuIndex = -1;
//        for (String st : menu.getSubMenu()) {
//            MenuButton item = new MenuButton(st);
//            item.setIndex(++subMenuIndex);
//            item.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent ae) {
//                    eventSelected.menuSelected(index, item.getIndex());
//                }
//            });
//            add(item);
//        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout) ; 
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>                        

    @Override
    protected void paintComponent(Graphics grphcs) {
        int width = getWidth();
        int height = getPreferredSize().height;
//        System.err.println(width+" " + height);
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(0, 0, 0));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha * 0.5f));
        g2.fillRect(0, 0, width, 40);
        g2.setComposite(AlphaComposite.SrcOver);
        g2.setColor(new Color( 0, 0, 0));
//        g2.drawLine(30, 40, 30, height - 17);
        // this code is for the creation of the arrow button 
//        for (int i = 0; i < menu.getSubMenu().length; i++) {
//            int y = ((i + 1) * 35 + 40) - 17;
//            g2.drawLine(30, y, 38, y);
//        }
//        if (menu.getSubMenu().length > 0) {
//            createArrowButton(g2);
//        }
        super.paintComponent(grphcs);
    }
   

    private void createArrowButton(Graphics2D g2) {
        int size = 4;
        int y = 19;
        int x = 205;
        g2.setColor(new Color(60, 60, 60));
        float ay = alpha * size;
        float ay1 = (1f - alpha) * size;
        g2.drawLine(x, (int) (y + ay), x + 4, (int) (y + ay1));
        g2.drawLine(x + 4, (int) (y + ay1), x + 8, (int) (y + ay));
    }

    // Variables declaration - do not modify                     
    // End of variables declaration                   
}
