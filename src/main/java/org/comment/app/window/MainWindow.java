package org.comment.app.window;

import javax.swing.*;
import java.awt.*;

public final class MainWindow extends JFrame {

//    private final String appName;

    public MainWindow(String appName) {
        super(appName);
//        this.appName = appName;
    }

    public void init() {
        String testString = " sflkdjasfhashfshfsfds\n" +
                " sdhfjashfiashfuisdafsadfsdf\n" +
                " \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "shdfjashfjksadhfkjhdsjkfhjksadhfjksadhjkfhsdadfgdgdgdgdjkfhsjdkahfksadfsafsafsfsfsdfasf\n" +
                "sfsahdfjhasjfhasjhfjsahdjkfhsajkdfsdfsf\n\n";
        this.setLayout(new FlowLayout());
        Container contentPane = this.getContentPane();
//        DocsPanel docsPane = new DocsPanel();
//        docsPane.setText(testString);
//        docsPane.setSize(600, 1000);
//        docsPane.setVisible(true);
//
//        JScrollPane docsViewer = new JScrollPane();
//        docsViewer.setViewportView(docsPane);
//        TextLineNumber textlineNumber = new TextLineNumber(docsPane);
//        docsViewer.setRowHeaderView(textlineNumber);
        DocsViewer docsViewer = new DocsViewer();
        docsViewer.setText(testString);
        contentPane.add(docsViewer);
        Button button = new Button();
        button.setLabel("check");
        button.setSize(40, 40);
        button.setVisible(true);

        contentPane.add(button);

        CommentViewer commentViewer = new CommentViewer();
        commentViewer.setSize(600, 600);
        commentViewer.setVisible(true);
        commentViewer.setEditable(false);
        contentPane.add(commentViewer);


        button.addActionListener(e -> {
            int selectionStart = docsViewer.getDocsPane().getSelectionStart();
            int selectionEnd = docsViewer.getDocsPane().getSelectionEnd();
            int caretPosition = docsViewer.getDocsPane().getCaretPosition();


            int rowNum = 0;
            try {
                rowNum = docsViewer.getDocsPane().getCursorLineNumber();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            commentViewer.setText(String.format("clicked, selectionStart:%d," +
                            "selectionEnd: %d " +
                            "caretPosition: %d " +

                            "\n",
                    selectionStart,
                    selectionEnd,
                    caretPosition
            ));
            commentViewer.append(String.format("rowNum:%d", rowNum));
        });
    }


}
