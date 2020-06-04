package simplejavatexteditor;

import javax.swing.JTextPane;

public class SimpleJavaTextEditor extends JTextPane {

    private static final long serialVersionUID = 1L;
    public final static String AUTHOR_EMAIL = "harshil.m1@ahduni.edu.in\nraj.m1@ahduni.edu.in";
    public final static String NAME = "TextEditor";
    public final static String EDITOR_EMAIL = "preet.r@ahduni.edu.in";
    public final static double VERSION = 2.0;
    /**
     * @param args
     */
    public static void main(String[] args) {
        new UI().setVisible(true);
    }

}
