package ClasesInterfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;


public class RichTextBox{

    private JTextPane textPane = new JTextPane();
    private   JScrollPane scrollPane = new JScrollPane(textPane);

    private  JPanel north = new JPanel();
    private JMenuBar menu = new JMenuBar();
    private JMenu boldMenu = new JMenu();
  public void setelementos(){
      textPane.setSize(350, 270);
      scrollPane.setSize(350, 270);
    boldMenu.setText("B");

    JMenu italicMenu = new JMenu();
    italicMenu.setText("I");
      
    JMenu lineMenu = new JMenu();
    lineMenu.setText("U");

    JMenu fontMenu = new JMenu();
    fontMenu.setText("F");

    JMenu colorMenu = new JMenu();
    colorMenu.setText("A");

    Action boldAction = new BoldAction();
    boldMenu.add(boldAction);

    Action italicAction = new ItalicAction();
    italicMenu.add(italicAction);

    Action uAction = new UnderLineAction();
    lineMenu.add(uAction);

    Action foregroundAction = new ForegroundAction();
    colorMenu.add(foregroundAction);

    Action formatTextAction = new FontAction();
    fontMenu.add(formatTextAction);

    menu.add(boldMenu);
    menu.add(italicMenu);
    menu.add(lineMenu);
    menu.add(fontMenu);
    menu.add(colorMenu);
    north.add(menu);
  }
  public JTextPane textPane(){
      return textPane;
      }
  public JScrollPane getJScrollPane(){return scrollPane;}
  public JPanel getJPanel(){return north;}
    

    public class UnderLineAction extends StyledEditorKit.StyledTextAction {
        public UnderLineAction() {
            super("underline");
        }

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

    public class ItalicAction extends StyledEditorKit.StyledTextAction {
        public ItalicAction() {
            super("font-italic");
        }

        public void actionPerformed(ActionEvent e) {
            JEditorPane editor = getEditor(e);
            if (editor != null) {
                StyledEditorKit kit = getStyledEditorKit(editor);
                MutableAttributeSet attr = kit.getInputAttributes();
                boolean italic = (StyleConstants.isItalic(attr)) ? false : true;
                SimpleAttributeSet sas = new SimpleAttributeSet();
                StyleConstants.setItalic(sas, italic);
                setCharacterAttributes(editor, sas, false);
            }
        }
    }

    public class ForegroundAction extends StyledEditorKit.StyledTextAction {
        JColorChooser colorChooser = new JColorChooser();
        JDialog dialog = new JDialog();
        boolean noChange = false;
        boolean cancelled = false;

        public ForegroundAction() {
            super("foreground");
        }

        public void actionPerformed(ActionEvent e) {
            JTextPane editor = (JTextPane)getEditor(e);
            int p0 = editor.getSelectionStart();
            StyledDocument doc = getStyledDocument(editor);
            Element paragraph = doc.getCharacterElement(p0);
            AttributeSet as = paragraph.getAttributes();
            fg = StyleConstants.getForeground(as);
            if (fg == null) {
                fg = Color.BLACK;
            }
            colorChooser.setColor(fg);
            JButton accept = new JButton("OK");
            accept.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        fg = colorChooser.getColor();
                        dialog.dispose();
                    }
                });
            JPanel buttons = new JPanel();
            buttons.add(accept);
            dialog.getContentPane().setLayout(new BorderLayout());
            dialog.getContentPane().add(colorChooser, BorderLayout.CENTER);
            dialog.getContentPane().add(buttons, BorderLayout.SOUTH);
            dialog.setModal(true);
            dialog.pack();
            dialog.setVisible(true);
            if (!cancelled) {
                MutableAttributeSet attr = null;
                if (editor != null) {
                    if (fg != null && !noChange) {
                        attr = new SimpleAttributeSet();
                        StyleConstants.setForeground(attr, fg);
                        setCharacterAttributes(editor, attr, false);
                    }
                }
            }
            noChange = false;
            cancelled = false;
        }
        private Color fg;
    }

    public class FontAction extends StyledEditorKit.StyledTextAction {
        private String family;
        private float fontSize;
        JDialog formatText;
        private boolean accept = false;
        JComboBox fontFamilyChooser;
        JComboBox fontSizeChooser;

        public FontAction() {
            super("Font");
        }

        public void actionPerformed(ActionEvent e) {
            JTextPane editor = (JTextPane)getEditor(e);
            int p0 = editor.getSelectionStart();
            StyledDocument doc = getStyledDocument(editor);
            Element paragraph = doc.getCharacterElement(p0);
            AttributeSet as = paragraph.getAttributes();

            family = StyleConstants.getFontFamily(as);
            fontSize = StyleConstants.getFontSize(as);

            formatText = new JDialog(new JFrame(), "Font", true);
            formatText.getContentPane().setLayout(new BorderLayout());

            JPanel choosers = new JPanel();
            choosers.setLayout(new GridLayout(2, 1));

            JPanel fontFamilyPanel = new JPanel();
            fontFamilyPanel.add(new JLabel("Font"));

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            String[] fontNames = ge.getAvailableFontFamilyNames();

            fontFamilyChooser = new JComboBox();
            for (int i = 0; i < fontNames.length; i++) {
                fontFamilyChooser.addItem(fontNames[i]);
            }
            fontFamilyChooser.setSelectedItem(family);
            fontFamilyPanel.add(fontFamilyChooser);
            choosers.add(fontFamilyPanel);
            JButton ok = new JButton("OK");
            ok.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        accept = true;
                        formatText.dispose();
                        family = (String)fontFamilyChooser.getSelectedItem();
                    }
                });
            JPanel buttons = new JPanel();
            buttons.add(ok);
            formatText.getContentPane().add(choosers, BorderLayout.CENTER);
            formatText.getContentPane().add(buttons, BorderLayout.SOUTH);
            formatText.pack();
            formatText.setVisible(true);

            MutableAttributeSet attr = null;
            if (editor != null && accept) {
                attr = new SimpleAttributeSet();
                StyleConstants.setFontFamily(attr, family);
                StyleConstants.setFontSize(attr, (int)fontSize);
                setCharacterAttributes(editor, attr, false);
            }
        }
    }
}
