package org.comment.app.window;

import lombok.Data;

import javax.swing.*;

@Data
public class DocsViewer extends JScrollPane {

    private DocsPanel docsPane= new DocsPanel();

    public DocsViewer() {
        super();

        docsPane.setSize(600, 1000);
        docsPane.setVisible(true);
        this.setViewportView(docsPane);

        TextLineNumber textlineNumber = new TextLineNumber(docsPane);
        this.setRowHeaderView(textlineNumber);
    }

    public void setText(String text) {
        this.getDocsPane().setText(text);
    }
}
