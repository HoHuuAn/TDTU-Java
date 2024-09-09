package swing;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class CustomTextField extends JTextField {

    private String hint = "";
    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
        repaint();
    }


    @Override
    public void paint(Graphics g) {

        Graphics2D customGraphics2D = (Graphics2D) g.create();
        customGraphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        customGraphics2D.setColor(new Color(255, 255, 255, 200));
        customGraphics2D.drawLine(0, getHeight() - 3, getWidth(), getHeight() - 3);

        if (!hint.isEmpty()) {
            int customComponentHeight = getHeight();
            Insets customInsets = getInsets();
            FontMetrics customFontMetrics = g.getFontMetrics();

            customGraphics2D.setColor(new Color(232, 232, 232));
            customGraphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f - customAnimate));
            customGraphics2D.drawString(hint, customInsets.left + (customAnimate * 30), customComponentHeight / 2 + customFontMetrics.getAscent() / 2 - 1);
        }

        customGraphics2D.dispose();
        super.paint(g);
    }

    private final Animator customAnimator;
    private float customAnimate;
    private boolean customShow = true;

    public CustomTextField() {

        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!getText().equals("")) {
                    if (customShow) {
                        if (customAnimator.isRunning() == false) {
                            customStop();
                            customAnimator.start();
                        }
                    } else if (customAnimator.isRunning()) {
                        customStop();
                        customAnimator.start();
                    }
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (getText().equals("")) {
                    customStop();
                    customAnimator.start();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        customAnimator = new Animator(350, new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (customShow) {
                    customAnimate = fraction;
                } else {
                    customAnimate = 1f - fraction;
                }
                repaint();
            }

            @Override
            public void end() {
                customShow = !customShow;
                repaint();
            }

        });
        customAnimator.setResolution(0);
        customAnimator.setAcceleration(.5f);
        customAnimator.setDeceleration(.5f);
        setOpaque(false);
        setBorder(new EmptyBorder(9, 1, 9, 1));
        setBackground(new Color(0, 0, 0, 0));
        setForeground(new Color(255, 255, 255));
        setSelectionColor(new Color(200, 200, 200, 100));
    }

    private void customStop() {
        if (customAnimator.isRunning()) {
            float customFraction = customAnimator.getTimingFraction();
            customAnimator.stop();
            customAnimator.setStartFraction(1f - customFraction);
        } else {
            customAnimator.setStartFraction(0f);
        }
    }

}
