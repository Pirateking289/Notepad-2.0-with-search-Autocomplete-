/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplejavatexteditor;

import java.util.*;

/**
 *
 * @author Harshil Mehta , Preet Rajpara , Raj Mehta
 */
class Trie{

    TrieNode root = new TrieNode();

    void add(String word) {
        word = word.toLowerCase();
        Queue<Character> letters = toCharacterQueue(word);
        root.add(letters);
    }
    
    private Queue<Character> toCharacterQueue(String word)
    {
        Queue<Character> queue = new LinkedList() ;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i );
            queue.add(letter);
        }
        return queue ;
    }
    @Override
    public String toString()
    {
        return root.toString(0);
    }

    TrieNode getSubtree(String prefix) {
        prefix = prefix.toLowerCase();
        Queue<Character> letters = toCharacterQueue(prefix);
        TrieNode subtree = root.getSubtree(letters);
        return subtree ;
    }

    List<String> getMatches(String prefix) {
        TrieNode subtreeRoot = getSubtree(prefix) ;
        List<String> matches = subtreeRoot.getWords() ;
        prefix = prefix.substring(0,prefix.length()-1) ;
        for (int i = 0; i < matches.size(); i++) {
            String suffix = matches.get(i);
            matches.set(i, prefix + suffix) ;
        }
        return matches ;
    }

}

