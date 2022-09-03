package org.comment.app.window;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;

public class DocsPanel extends JTextPane {


    public int getCursorLineNumber() throws BadLocationException {
        int caretPos = this.getCaretPosition();
        int rowNum = (caretPos == 0) ? 1 : 0;
        for (int offset = caretPos; offset > 0; ) {
            offset = Utilities.getRowStart(this, offset) - 1;
            rowNum++;
        }
        return rowNum;
    }
}
