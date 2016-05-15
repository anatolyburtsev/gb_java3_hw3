package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by onotole on 14.05.16.
 */
public class PaintFrame extends JFrame {
    Color color = Color.black;
    List<ColoredLine> lines = new ArrayList<>();
    DrawPanel panel;
    Point lastPoint;

    class DrawPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(color);
            for (ColoredLine line: lines) {
                g2d.setColor(line.color);
                g2d.draw(line.line);
            }
            g2d.setColor(color);
        }
    }

    class ColoredLine {
        Line2D.Float line;
        Color color;

        public ColoredLine(Line2D.Float line, Color color) {
            this.line = line;
            this.color = color;
        }
    }

    class ButtonPanel extends JPanel implements ActionListener {
        public static final String RED = "red";
        public static final String GREEN = "green";
        public static final String BLUE = "blue";
        public static final String BLACK = "black";
        public static final String YELLOW = "yellow";
        public static final String WHITE = "white";
        public static final String MAGENTA = "magenta";
        public static final String CYAN = "cyan";
        JButton btnRed;
        JButton btnGreen;
        JButton btnBlue;
        JButton btnBlack;
        JButton btnYellow;
        JButton btnWhite;
        JButton btnMagenta;
        JButton btnCyan;
        Map<String, Color> colors = new HashMap<>();


        public ButtonPanel() {
            addGeneratedButton(btnRed, RED, Color.red);
            addGeneratedButton(btnGreen, GREEN, Color.green);
            addGeneratedButton(btnBlue, BLUE, Color.blue);
            addGeneratedButton(btnBlack, BLACK, Color.black);
            addGeneratedButton(btnYellow, YELLOW, Color.yellow);
            addGeneratedButton(btnWhite, WHITE, Color.white);
            addGeneratedButton(btnMagenta, MAGENTA, Color.magenta);
            addGeneratedButton(btnCyan, CYAN, Color.cyan);
            initColorsMap();
        }

        private void initColorsMap() {
            colors.put(RED, Color.red);
            colors.put(GREEN, Color.green);
            colors.put(BLUE, Color.blue);
            colors.put(BLACK, Color.black);
            colors.put(YELLOW, Color.yellow);
            colors.put(WHITE, Color.white);
            colors.put(MAGENTA, Color.magenta);
            colors.put(CYAN, Color.cyan);
        }

        private void addGeneratedButton(JButton button, String name, Color color) {
            button = new JButton(name);
            button.setBackground(color);
            if (name.equals(BLACK) || name.equals(BLUE)) {
                button.setForeground(Color.white);
            }
//            button.setForeground(color);
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.setActionCommand(name);
            button.addActionListener(this);
            add(button);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            color = colors.get(e.getActionCommand());
        }
    }


    class DrawListener extends MouseAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            super.mouseDragged(e);
            Point point = e.getPoint();
            if (lastPoint == null) {
                lastPoint = point;
                return;
            }
            lines.add(new ColoredLine(new Line2D.Float(lastPoint, point), color));
            lastPoint = point;
            panel.repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            lastPoint = null;
        }
    }

    public PaintFrame(String title) throws HeadlessException {
        super(title);
        setSize(700, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setLayout(new BorderLayout());
        panel = new DrawPanel();
        DrawListener drawListener = new DrawListener();
        panel.addMouseMotionListener(drawListener);
        panel.addMouseListener(drawListener);
        add(panel);
        add(new ButtonPanel(), BorderLayout.NORTH);
    }


    public static void main(String[] args) {
        PaintFrame paintFrame = new PaintFrame("Super Paint!");
        paintFrame.setVisible(true);
    }
}
