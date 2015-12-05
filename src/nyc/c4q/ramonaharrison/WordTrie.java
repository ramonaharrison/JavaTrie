package nyc.c4q.ramonaharrison;

/**
 * Access Code 2.1
 * Ramona Harrison
 * WordTrie.java
 */

import java.util.ArrayList;
import java.util.List;

public class WordTrie {
    private Node rootNode;
    private static final int ASCII_OFFSET = 65;

    public WordTrie() {
        this.rootNode = new RootNode();
    }

    public void add(String word) {
        Node letter = rootNode;
        Node nextLetter;

        for (int i = 0; i < word.length(); i++) {
            nextLetter = letter.getChild(word.charAt(i));
            if (nextLetter == null) {
                nextLetter = letter.setChild(word.charAt(i));
            }
            letter = nextLetter;
        }
        letter.setIsWord((byte)1);
    }

    public boolean contains(String word) {
        Node letter = rootNode;
        Node nextLetter;

        for (int i = 0; i < word.length(); i++) {
            nextLetter = letter.getChild(word.charAt(i));
            if (nextLetter == null) {
                return false;
            }
            letter = nextLetter;
        }
        if (letter.getIsWord() == 0) {
            return false;
        }
        return true;
    }

    public List<String> toList() {
        List<String> words = new ArrayList<String>();
        walkTree(rootNode, words, "");
        return words;
    }

    public void walkTree(Node parentNode, List<String> words, String word) {
        String newWord;
        for (int i = 0; i < parentNode.getChildren().size(); i++) {
            Node node = parentNode.getChild((char)(i + ASCII_OFFSET));
            if (node != null) {
                newWord = word + (char) (i + ASCII_OFFSET);
                if (this.contains(newWord) && !words.contains(newWord)) {
                    words.add(newWord);
                    System.out.println(newWord);
                }
                walkTree(node, words, newWord);
            }
        }
    }
}