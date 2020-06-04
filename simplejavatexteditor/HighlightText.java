package simplejavatexteditor;

import javax.swing.text.*;
import java.awt.*;

public class HighlightText extends DefaultHighlighter.DefaultHighlightPainter{

    public HighlightText(Color color) {
        super(color);
    }

    public void highLight(JTextComponent textComp, String[] pattern) {
        removeHighlights(textComp);

        try {
            Highlighter hilite = textComp.getHighlighter();
            Document doc = textComp.getDocument();
            String text = doc.getText(0, doc.getLength());
            for (String pattern1 : pattern) {
                int pos = 0;
                while ((pos = text.indexOf(pattern1, pos)) >= 0) {
                    hilite.addHighlight(pos, pos + pattern1.length(), this);
                    pos += pattern1.length();
                }
            }
        } catch (BadLocationException e) {}

    }

    public void removeHighlights(JTextComponent textComp) {

        Highlighter hilite = textComp.getHighlighter();
        Highlighter.Highlight[] hilites = hilite.getHighlights();

        for (Highlighter.Highlight hilite1 : hilites) {
            if (hilite1.getPainter() instanceof HighlightText) {
                hilite.removeHighlight(hilite1);
            }
        }
    }
}
