package ru.geekbrains.lesson8.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingExample extends JFrame {

    public DrawingExample() {
        super("Lines Drawing Demo");

        setSize(680, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("MousePos: " + e.getX() + " " + e.getY());
            }});
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        super.paint(g);
        simpleDrawLines(g);
    }

    private void simpleDrawLines(Graphics g2d) {
        g2d.drawLine(120, 50, 360, 50);
        g2d.setColor(Color.RED);
        g2d.drawRect(150, 150, 150, 150);

        g2d.setColor(Color.GREEN);
        g2d.fillPolygon(new int[] {400}, new int[] {400}, 1);
        g2d.fillRect(151, 151, 149, 75);

        g2d.drawOval(350, 150, 150, 150);
        g2d.setColor(Color.RED);
        g2d.fillOval(351, 151, 149, 149);
//        g2d.clearRect(350, 150, 75, 75);
    }

    public static void main(String[] args) {
        new DrawingExample().setVisible(true);
    }
}