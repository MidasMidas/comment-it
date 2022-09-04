package org.comment.app.window;

import lombok.Data;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;

@Data
public class DocsViewer extends JScrollPane {

    private DocsPanel docsPane= new DocsPanel();

    public DocsViewer() {
        super();

        docsPane.setMinimumSize(new Dimension(600, 600));
        docsPane.setVisible(true);
        this.setViewportView(docsPane);

        TextLineNumber textlineNumber = new TextLineNumber(docsPane);
        this.setRowHeaderView(textlineNumber);
    }

    public void setText(String text) {
        this.getDocsPane().setText(text);
    }
    public void appendText(String text) throws BadLocationException {
        Document document = this.getDocsPane().getDocument();
        document.insertString(document.getLength(),text,null);
    }
}
