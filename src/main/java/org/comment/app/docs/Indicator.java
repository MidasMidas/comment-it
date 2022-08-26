package org.comment.app.docs;


public class Indicator {
    private int line;
    private int letter;

    public boolean isAfter(Indicator indicator){
        if(this.line>indicator.line){
            return true;
        }
        if(this.line==indicator.line){
            return this.letter>indicator.letter;
        }
        return false;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getLetter() {
        return letter;
    }

    public void setLetter(int letter) {
        this.letter = letter;
    }
}
