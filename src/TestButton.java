import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;


class TestButton extends JButton {

    private Color hoverBackgroundColor = new Color(234, 243, 255);
    private Color pressedBackgroundColor  = new Color(213, 232, 255);

    public TestButton() {
        this(null);
    }

    public TestButton(String text) {
        super(text);
        super.setContentAreaFilled(false);
        this.setRequestFocusEnabled(false);
        this.setFont(new Font("Segoe UI", Font.PLAIN, 11));
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(pressedBackgroundColor);
            this.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        } else if (getModel().isRollover()) {
            g.setColor(hoverBackgroundColor);
            this.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        } else {
            g.setColor(getBackground());
            this.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @Override
    public void setContentAreaFilled(boolean b) {
    }

    public Color getHoverBackgroundColor() {
        return hoverBackgroundColor;
    }

    public void setHoverBackgroundColor(Color hoverBackgroundColor) {
        this.hoverBackgroundColor = hoverBackgroundColor;
    }

    public Color getPressedBackgroundColor() {
        return pressedBackgroundColor;
    }

    public void setPressedBackgroundColor(Color pressedBackgroundColor) {
        this.pressedBackgroundColor = pressedBackgroundColor;
    }
}

