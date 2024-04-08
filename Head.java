import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Head extends JPanel {

    private boolean mouseInside;

    public Head() {
        setPreferredSize(new Dimension(500, 500));

        // Add MouseListener to this component
        MyMouseListener mouseListener = new MyMouseListener();
        addMouseListener(mouseListener);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawHead(g);
    }

    private void drawHead(Graphics g) {
        int headWidth = getWidth() - 20;
        int headHeight = getHeight() - 20;
        int eyeSize = 50;
        int eyeX = (headWidth - eyeSize * 2 + 20) / 2; // Adjusted eyeX to move the eyes apart
        int eyeY = headHeight / 3;
        int mouthX = eyeX + 30;
        int mouthY = headHeight / 2 + 30;
        int mouthWidth = eyeSize * 2 - 40;
        int mouthHeight = 60;

        // Head
        g.setColor(new Color(255, 228, 196));
        g.fillOval(10, 10, headWidth, headHeight);

        // Eyes
        if (mouseInside) {
            g.setColor(Color.BLACK);
            g.fillOval(eyeX, eyeY, eyeSize, eyeSize);
            g.fillOval(eyeX + eyeSize + 40, eyeY, eyeSize, eyeSize); // Adjusted eyeX for the second eye
        } else {
            g.setColor(Color.BLUE);
            g.fillRect(eyeX, eyeY, eyeSize, eyeSize);
            g.fillRect(eyeX + eyeSize + 40, eyeY, eyeSize, eyeSize); // Adjusted eyeX for the second eye
        }

        // Smile
        g.setColor(Color.RED);
        if (mouseInside) {
            g.drawArc(mouthX, mouthY, mouthWidth, mouthHeight, 0, -180);
        } else {
            g.drawArc(mouthX, mouthY + 20, mouthWidth, mouthHeight, 0, 180);
        }
    }

    private class MyMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {
            mouseInside = true;
            repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            mouseInside = false;
            repaint();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Four Heads");
        frame.setLayout(new GridLayout(2, 2));

        frame.add(new Head());
        frame.add(new Head());
        frame.add(new Head());
        frame.add(new Head());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
