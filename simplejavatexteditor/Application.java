package simplejavatexteditor;

import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Harshil Mehta 
 * AU1841010
 */
public class Application {
    public String myString ;

    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }
    public Application(String demo){
        this.myString = demo ;
    } 

    public static void main(String[] args) throws IOException {
        try {
            String data = readFileAsString("C:\\Users\\Harshil Mehta\\Documents\\NetBeansProjects\\Simple-Java-Text-Editor-master\\data.txt");
            String allWords[] = data.split(", ");
            Application app = new Application(UI.main_str);
            
            app.run(allWords);
        } catch (Exception ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<String> run(String[] allWords) {
        Trie autoComDict = getExampleTreeAnt(allWords);
        String lastWord = myString.substring(myString.lastIndexOf(" ") + 1);
        //System.out.println("Last Word->" + lastWord);
        try {
            TrieNode subtreeRoot = autoComDict.getSubtree(lastWord);
            //System.out.println("subtree = " + subtreeRoot.Value);

        } catch (Exception e) {
            System.out.println("No Words such as this Found");
        }
        ArrayList<String> matches = (ArrayList<String>) autoComDict.getMatches(lastWord);
        matches.forEach((match) -> {
            System.out.println(match);
        });
        return matches ;
    }

    private Trie getExampleTreeAnt(String[] allWords) {
        Trie trie = new Trie();
        trie.add("aardvark");
        trie.add("Ant");
        trie.add("AnTEaster");
        trie.add("angel");
        trie.add("anchovy");
        trie.add("anthony");
        trie.add("baylor");
        trie.add("queue");
        trie.add("dog");
        trie.add("himeshBhikho");
        trie.add("yashil");
        trie.add("raj");
        trie.add("Harshil");
        trie.add("Hiral Vegda");
        trie.add("Harsh");
        trie.add("shoot");
        trie.add("Preet");
        trie.add("Hello");
        for (String allWord : allWords) {
            trie.add(allWord);
        }
        return trie;
    }

}
