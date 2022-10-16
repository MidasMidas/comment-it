package org.comment.app.window;

import lombok.Data;
import org.comment.app.docs.Comment;
import org.comment.app.docs.CommentFile;
import org.comment.app.util.AppUtil;

import javax.swing.*;
import java.awt.*;

@Data
public class CommentDialog extends JDialog {
    private JTextArea commentArea;
    private String commentText;
    private Button confirmButton;
    private Button cancelButton;
    private int startIndex;
    private int endIndex;

    public CommentDialog(CommentFile commentFile, int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;

        commentArea = new JTextArea();
        commentArea.setVisible(true);
        commentArea.setText("");
        this.add(commentArea, BorderLayout.CENTER);
        this.setVisible(true);
        this.setBounds(500, 100, 500, 500);

        confirmButton = new Button("confirm");
        confirmButton.setVisible(true);

        cancelButton = new Button("cancel");
        cancelButton.setVisible(true);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setVisible(true);
        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);
        this.add(buttonPanel, BorderLayout.SOUTH);

        confirmButton.addActionListener(e -> {
            commentText = commentArea.getText();
            commentFile.addComment(startIndex, endIndex, commentText);
            this.dispose();
        });
        cancelButton.addActionListener(e -> {
            this.dispose();
        });
    }

}
