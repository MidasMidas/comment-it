package org.comment.app.window;

import javax.swing.*;
import java.awt.*;

public final class MainWindow extends JFrame{

//    private final String appName;

    public MainWindow(String appName) {
        super(appName);
//        this.appName = appName;
    }

    public void init(){
        this.setLayout(new FlowLayout());
        Container contentPane = this.getContentPane();
        DocsViewer docsViewer = new DocsViewer();
        docsViewer.setSize(600,1000);
        docsViewer.setVisible(true);
        contentPane.add(docsViewer);
        Button button = new Button();
        button.setLabel("check");
        button.setSize(40,40);
        button.setVisible(true);

        contentPane.add(button);

        CommentViewer commentViewer = new CommentViewer();
        commentViewer.setSize(600,600);
        commentViewer.setVisible(true);
        commentViewer.setEditable(false);
        contentPane.add(commentViewer);


        button.addActionListener(e -> {
            int selectionStart = docsViewer.getSelectionStart();
            int selectionEnd = docsViewer.getSelectionEnd();
            commentViewer.setText(String.format("clicked, selectionStart:%d,selectionEnd: %d \n",selectionStart,selectionEnd));
        });
    }


}
