
package fbr;

public class FancyAnimation {

    private float[] start;
    private float[] end;

    public FancyAnimation(String start, String end) {
        setStart(new Border(start).toArray());
        setEnd(new Border(end).toArray());
    }

    public FancyAnimation start(String start) {
        setStart(new Border(start).toArray());
        return this;
    }

    public FancyAnimation end(String end) {
        setEnd(new Border(end).toArray());
        return this;
    }

    private void setStart(float[] start) {
        this.start = start;
    }

    private void setEnd(float[] end) {
        this.end = end;
    }

    public Border getAnimate(float f) {
        float[] animatedValues = new float[start.length];

        for (int i = 0; i < start.length; i++) {
            float t = end[i] - start[i];
            t = start[i] + t * f;
            animatedValues[i] = t;
        }

        Border border = new Border();
        border.setBorder(
                animatedValues[0], animatedValues[1], animatedValues[2], animatedValues[3],
                animatedValues[4], animatedValues[5], animatedValues[6], animatedValues[7]
        );

        return border;
    }
}
