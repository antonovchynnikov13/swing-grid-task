package test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
// Swing Program Template
@SuppressWarnings("serial")
public class SwingTemplate extends JFrame implements KeyListener {
    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 600; //константи
    MyContainer container;

    /**
     * Constructor to setup the UI components
     */
    public SwingTemplate() {
        Container cp = this.getContentPane();   //контейнер для компонентів

        // Content-pane sets layout
        // cp.setLayout(new ....Layout());

        // Allocate the UI components
        // .....

        // Content-pane adds components
        container = new MyContainer(WINDOW_WIDTH, WINDOW_HEIGHT, this); //новий JPanel
        cp.add(container); //додаємо нашу панель у content pane
        addKeyListener(this); //реєcструємо фрейм як обробник клави

        // Source object adds listener
        // .....

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setVisible(true);

    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
            container.keyLeft();
        } else if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
            container.keyRight();
        } else if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
            if (container.getSelectionMode() == SelectionMode.HOVER) {
                container.setSelectionMode(SelectionMode.CLICK);
            } else {
                container.setSelectionMode(SelectionMode.HOVER);
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

}