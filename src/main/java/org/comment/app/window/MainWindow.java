package org.comment.app.window;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.comment.app.docs.CommentFile;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.io.*;

@Data
public final class MainWindow extends JFrame {

    //    private final String appName;
    private DocsViewer docsViewer;
    private CommentFile commentFile;

    public MainWindow(String appName) {
        super(appName);
//        this.appName = appName;
    }

    public void init() {

//        this.setLayout(new FlowLayout());
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
        docsViewer = new DocsViewer();
        docsViewer.setSize(new Dimension(600,600));
        this.add(docsViewer,BorderLayout.CENTER);
//        contentPane.add(docsViewer);


        Button checkButton = new Button();
        checkButton.setLabel("check");
        checkButton.setSize(40, 40);
        checkButton.setVisible(true);

//        contentPane.add(checkButton);
        this.add(checkButton,BorderLayout.SOUTH);
        Button openButton = new Button();
        openButton.setLabel("open");
        openButton.setSize(40, 40);
        openButton.setVisible(true);
        this.add(openButton,BorderLayout.NORTH);
//        contentPane.add(openButton);

        CommentViewer commentViewer = new CommentViewer();
        commentViewer.setSize(600, 600);
        commentViewer.setVisible(true);
        commentViewer.setEditable(false);
//        contentPane.add(commentViewer);
        this.add(commentViewer,BorderLayout.EAST);

        checkButton.addActionListener(e -> {
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
        openButton.addActionListener(e -> {
            FileDialog chooseFile = new FileDialog(this, "choose file", FileDialog.LOAD);
            chooseFile.setVisible(true);
            if (null != chooseFile.getDirectory()) {
                docsViewer.setText("");
                String filePath = chooseFile.getDirectory() + chooseFile.getFile();
                String line = null;
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    while ((line = reader.readLine()) != null) {
                        docsViewer.appendText(line);
                        docsViewer.appendText("\n");
                    }
                } catch (IOException | BadLocationException ex) {
                    ex.printStackTrace();
                }
                String commentFilePath=filePath+".cmt";
                ObjectMapper mapper= new ObjectMapper();
                try {
                    commentFile  = mapper.readValue(new File(commentFilePath), CommentFile.class);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }


}
