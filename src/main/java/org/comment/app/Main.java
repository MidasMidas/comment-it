package org.comment.app;

import org.comment.app.constant.Constant;
import org.comment.app.window.MainWindow;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static final String APP_NAME="comment-it";
    public static void main(String[] args) {

        MainWindow mainWindow=new MainWindow(APP_NAME);
        mainWindow.init();
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(new Dimension(1200,1000));
        mainWindow.setVisible(true);
//        mainWindow.getDocsViewer().setText(Constant.testString);
    }


}