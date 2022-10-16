package org.comment.app.window;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.comment.app.docs.Comment;
import org.comment.app.docs.CommentFile;
import org.comment.app.dto.CommentDTO;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Data
public final class MainWindow extends JFrame {

    //    private final String appName;
    private DocsViewer docsViewer;
    private CommentFile commentFile = new CommentFile();

    private JLabel cursorPosition;

    private String orgFile;
    private String cmtFile;

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
        docsViewer.setSize(new Dimension(600, 600));
        this.add(docsViewer, BorderLayout.CENTER);
//        contentPane.add(docsViewer);


        Button commentButton = new Button();
        commentButton.setLabel("comment");
        commentButton.setSize(40, 40);
        commentButton.setVisible(true);


        Button openButton = new Button();
        openButton.setLabel("open");
        openButton.setSize(40, 40);
        openButton.setVisible(true);

        Button saveButton = new Button();
        saveButton.setLabel("save");
        saveButton.setSize(40, 40);
        saveButton.setVisible(true);

        CommentViewer commentViewer = new CommentViewer();
        commentViewer.setSize(600, 600);
        commentViewer.setVisible(true);
        commentViewer.setEditable(false);
        commentViewer.setLineWrap(true);
        this.add(commentViewer, BorderLayout.EAST);

        cursorPosition = new JLabel();
        cursorPosition.setText("0");
        cursorPosition.setVisible(true);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setVisible(true);
        buttonPanel.add(cursorPosition);
        buttonPanel.add(openButton);
        buttonPanel.add(commentButton);
        buttonPanel.add(saveButton);

        this.add(buttonPanel, BorderLayout.SOUTH);
        docsViewer.getDocsPane().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int caretPosition = docsViewer.getDocsPane().getCaretPosition();
                CommentDTO comments = new CommentDTO();
                for (Comment cmt : commentFile.getCommentList()) {
                    if (caretPosition > cmt.getRange().getFrom() && caretPosition < cmt.getRange().getTo()) {
                        comments.addComment(cmt);
                    }
                }

                cursorPosition.setText(String.valueOf(caretPosition));
                commentViewer.setText(comments.getCommentString() + "\n");
            }
        });
        commentButton.addActionListener(e -> {
            int selectionStart = docsViewer.getDocsPane().getSelectionStart();
            int selectionEnd = docsViewer.getDocsPane().getSelectionEnd();
            int caretPosition = docsViewer.getDocsPane().getCaretPosition();
            new CommentDialog(commentFile, selectionStart, selectionEnd);

            CommentDTO comments = new CommentDTO();
            for (Comment cmt : commentFile.getCommentList()) {
                if (caretPosition > cmt.getRange().getFrom() && caretPosition < cmt.getRange().getTo()) {
                    comments.addComment(cmt);
                }
            }

            commentViewer.setText(comments.getCommentString() + "\n");
            commentViewer.append(String.format("clicked, selectionStart:%d," +
                            "selectionEnd: %d " +
                            "caretPosition: %d " +
                            "\n",
                    selectionStart,
                    selectionEnd,
                    caretPosition
            ));
        });
        openButton.addActionListener(e -> {
            FileDialog chooseFile = new FileDialog(this, "choose file", FileDialog.LOAD);
            chooseFile.setVisible(true);
            if (null != chooseFile.getDirectory()) {
                docsViewer.setText("");
                String filePath = chooseFile.getDirectory() + chooseFile.getFile();
                orgFile = filePath;
                String line;
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    while ((line = reader.readLine()) != null) {
                        docsViewer.appendText(line);
                        docsViewer.appendText("\n");
                    }
                } catch (IOException | BadLocationException ex) {
                    ex.printStackTrace();
                }
                String commentFilePath = filePath + ".cmt";
                cmtFile = commentFilePath;
                ObjectMapper mapper = new ObjectMapper();
                try {
                    commentFile = mapper.readValue(new File(commentFilePath), CommentFile.class);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        saveButton.addActionListener(e -> {
            ObjectMapper mapper = new ObjectMapper();
            try {
                mapper.writeValue(new File(cmtFile), commentFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }


}
