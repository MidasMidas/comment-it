package org.comment.app;

import org.comment.app.window.MainWindow;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static final String APP_NAME="comment-it";
    public static void main(String[] args) {
        System.out.println("Hello world!");
        JFrame mainWindow=new MainWindow(APP_NAME).init();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(new Dimension(600,800));
        mainWindow.setVisible(true);

    }


}