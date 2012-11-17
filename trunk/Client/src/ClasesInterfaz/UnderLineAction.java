package ClasesInterfaz;

import java.awt.event.ActionEvent;

import javax.swing.JEditorPane;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;

public class UnderLineAction extends StyledEditorKit.StyledTextAction{
    public UnderLineAction() {
        super("underline");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JEditorPane editor = getEditor(e);
        if (editor != null) {
            StyledEditorKit kit = getStyledEditorKit(editor);
            MutableAttributeSet attr = kit.getInputAttributes();
            boolean ul = (StyleConstants.isUnderline(attr)) ? false : true;
            SimpleAttributeSet sas = new SimpleAttributeSet();
            StyleConstants.setUnderline(sas, ul);
            setCharacterAttributes(editor, sas, false);
        }
    }
}
