
package swing;

import fbr.FancyBorderRadius;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class CustomButton extends JButton {

    private Shape customShape;
    private final RippleEffect customRippleEffect;

    public CustomButton() {
        customRippleEffect = new RippleEffect(this);
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(8, 5, 8, 5));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D customGraphics2D = (Graphics2D) graphics.create();
        customGraphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        customGraphics2D.setColor(new Color(100, 255, 255, 80));
        customGraphics2D.fill(customShape);
        customRippleEffect.reder(customGraphics2D, customShape);
        customGraphics2D.dispose();
        super.paintComponent(graphics);
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        customShape = new FancyBorderRadius(getWidth(), getHeight(), "50% 50% 50% 50% / 50% 50% 50% 50%").getShape();
    }
}
