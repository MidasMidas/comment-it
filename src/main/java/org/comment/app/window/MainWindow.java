package org.comment.app.window;

import javax.swing.*;

public final class MainWindow {

    private JFrame window;
    private final String appName;

    public MainWindow(String appName) {
        this.appName = appName;
    }

    public JFrame init(){
        this.window = new JFrame(appName);
        return this.window;
    }
}
