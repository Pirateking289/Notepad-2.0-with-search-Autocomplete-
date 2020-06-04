/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplejavatexteditor;

import java.util.*;

/**
 *
 * @author Harshil Mehta
 */
class TrieNode {

    private final char nullValue = 0;
    char Value = nullValue;
    private Map<Character, TrieNode> children = new HashMap<>();

    TrieNode() {

    }
    TrieNode(char letter) {
        this.Value = letter;
    }

    void add(Queue<Character> letters) {

        if (letters.isEmpty()) {
            children.put(nullValue, new TrieNode());
            return;
        }
        char nextLetter = letters.remove();
        if (!children.containsKey(nextLetter)) {
            children.put(nextLetter, new TrieNode(nextLetter));
        }
        TrieNode nextNode = children.get(nextLetter);
        nextNode.add(letters);
    }

    public boolean hasAValue() {
        return (nullValue != Value);
    }

    public boolean isTheRoot() {
        return !hasAValue() && (children.size() > 0);
    }

    public boolean isALeaf() {
        return !hasAValue() && !isTheRoot();
    }

    public String toString(int level) {
        String output = "";
        for (int i = 0; i < level; i++) {
            output += "   ";
        }
        output += "!----";
        output += this.Value;
        output += System.lineSeparator();

        for (Map.Entry<Character, TrieNode> i : children.entrySet()) {
            output += i.getValue().toString(level + 1);
        }
        return output;
    }

    TrieNode getSubtree(Queue<Character> letters) {
        if (letters.isEmpty()) {
            return this;
        }
        char nextLetter = letters.remove();
        if (!children.containsKey(nextLetter)) {
            return null;
        }
        TrieNode nextNode = children.get(nextLetter);
        return nextNode.getSubtree(letters);
    }
    List<String> words = new ArrayList<>();
    List<String> getWords() {
        if (isALeaf()) {
            words.add("");
            return words;
        }
        for (TrieNode child : children.values()) {
            List<String> childWords = child.getWords();
            for (String childWord : childWords) {
                words.add(Value + childWord);
            }
        }
        return words;
    }

}
