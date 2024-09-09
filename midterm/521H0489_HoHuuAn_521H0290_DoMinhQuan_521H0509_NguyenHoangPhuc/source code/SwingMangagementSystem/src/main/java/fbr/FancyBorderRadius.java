

package fbr;

import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

public class FancyBorderRadius {

    private double width;
    private double height;
    private Border border;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Border getBorder() {
        return border;
    }

    public void setBorder(Border border) {
        this.border = border;
    }

    public FancyBorderRadius(double width, double height, Border border) {
        this.width = width;
        this.height = height;
        this.border = border;
    }

    public FancyBorderRadius(double width, double height, String border) {
        this(width, height, new Border(border));
    }

    public FancyBorderRadius() {
    }

    public Shape getShape() {
        Area area = new Area(new Rectangle2D.Double(0, 0, width, height));
        area.intersect(new Area(createPath(1, border.getTop().getRight(), border.getRight().getRight())));
        area.intersect(new Area(createPath(2, border.getTop().getLeft(), border.getLeft().getRight())));
        area.intersect(new Area(createPath(3, border.getBottom().getLeft(), border.getLeft().getLeft())));
        area.intersect(new Area(createPath(4, border.getBottom().getRight(), border.getRight().getLeft())));
        return area;
    }

    private Shape createPath(int index, double w, double h) {
        Path2D path = new Path2D.Double();

        switch (index) {
            case 1:
                path.moveTo(width - w, 0);
                path.lineTo(0, 0);
                path.lineTo(0, height);
                path.lineTo(width, height);
                path.lineTo(width, h);
                path.append(new Ellipse2D.Double(width - w * 2, 0, w * 2, h * 2), true);
                break;
            case 2:
                path.moveTo(0, h);
                path.lineTo(0, height);
                path.lineTo(width, height);
                path.lineTo(width, 0);
                path.lineTo(w, 0);
                path.append(new Ellipse2D.Double(0, 0, w * 2, h * 2), true);
                break;
            case 3:
                path.moveTo(w, height);
                path.lineTo(width, height);
                path.lineTo(width, 0);
                path.lineTo(0, 0);
                path.lineTo(0, height - h);
                path.append(new Ellipse2D.Double(0, height - h * 2, w * 2, h * 2), true);
                break;
            case 4:
                path.moveTo(width, height - h);
                path.lineTo(width, 0);
                path.lineTo(0, 0);
                path.lineTo(0, height);
                path.lineTo(width - w, height);
                path.append(new Ellipse2D.Double(width - w * 2, height - h * 2, w * 2, h * 2), true);
                break;
        }

        return path;
    }

    public void setBorder(float tl, float tr, float br, float bl, float lr, float rr, float rl, float ll) {
        border.setBorder(tl, tr, br, bl, lr, rr, rl, ll);
    }

    public void setBorder(String text) {
        border.setBorder(text);
    }
}

