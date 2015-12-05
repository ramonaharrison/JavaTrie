package nyc.c4q.ramonaharrison;

import java.util.ArrayList;

/**
 * Access Code 2.1
 * Ramona Harrison
 * Node.java
 */

public class Node {

    private byte isWord; // true = 1; false = 0;
    private ArrayList<Node> children;

    private static final int ASCII_OFFSET = 65;

    public Node() {
        this.isWord = 0;
        this.children = new ArrayList<Node>(26);
        for (int i = 0; i < 26; i++) {
            children.add(null);
        }
    }

    public Node(byte isWord) {
        this.isWord = isWord;
        this.children = new ArrayList<Node>(26);
        for (int i = 0; i < 26; i++) {
            children.add(null);
        }
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public Node setChild(char character) {
        this.children.set(character - ASCII_OFFSET, new Node((byte) 0));
        return getChild(character);
    }

    public Node getChild(char character) {
        return this.children.get(character - ASCII_OFFSET);
    }

    public byte getIsWord() {
        return isWord;
    }

    public void setIsWord(byte isWord) {
        this.isWord = isWord;
    }
}
