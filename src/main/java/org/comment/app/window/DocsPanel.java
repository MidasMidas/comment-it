package org.comment.app.window;

import javax.swing.*;
import javax.swing.text.Element;

public class DocsPanel extends JTextPane {


    /// old method, not good for use
    //    public int getCursorLineNumber() throws BadLocationException {
//        int caretPos = this.getCaretPosition();
//        int rowNum = (caretPos == 0) ? 1 : 0;
//        for (int offset = caretPos; offset > 0; ) {
//            offset = Utilities.getRowStart(this, offset) - 1;
//            rowNum++;
//        }
//        return rowNum;
//    }
    public int getCursorLineNumber() {
        int caretPosition = this.getCaretPosition();
        Element root = this.getDocument().getDefaultRootElement();
        int index = root.getElementIndex(caretPosition);
//        Element line = root.getElement( index );

        return index + 1;
    }
}
