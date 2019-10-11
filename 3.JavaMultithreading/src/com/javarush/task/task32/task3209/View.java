package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();

    public UndoListener getUndoListener() {
        return undoListener;
    }

    private UndoListener undoListener = new UndoListener(undoManager);

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void init() {
        initGui();
        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);
        setVisible(true);
    }

    public void initMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        MenuHelper menuHelper = new MenuHelper();
        menuHelper.initFileMenu(this, jMenuBar);
        menuHelper.initEditMenu(this, jMenuBar);
        menuHelper.initStyleMenu(this, jMenuBar);
        menuHelper.initAlignMenu(this, jMenuBar);
        menuHelper.initColorMenu(this, jMenuBar);
        menuHelper.initFontMenu(this, jMenuBar);
        menuHelper.initHelpMenu(this, jMenuBar);
        this.getContentPane().add(jMenuBar, BorderLayout.NORTH);

    }

    public void initEditor() {
        htmlTextPane.setContentType("text/html");
        JScrollPane jScrollPaneText = new JScrollPane(htmlTextPane);
        JScrollPane jScrollPanePlane = new JScrollPane(plainTextPane);
        tabbedPane.addTab("HTML", jScrollPaneText);
        tabbedPane.addTab("Текст", jScrollPanePlane);
        tabbedPane.setPreferredSize(new Dimension(1000, 1000));
        TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tabbedPaneChangeListener);
        this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    public void undo() {
        try {
            undoManager.undo();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void redo() {
        try {
            undoManager.redo();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public boolean canUndo() {
        if (undoManager.canUndo()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean canRedo() {
        if (undoManager.canRedo()) {
            return true;
        } else {
            return false;
        }
    }

    public void resetUndo() {
        undoManager.discardAllEdits();
    }

    public void exit() {
        controller.exit();
    }

    public void selectedTabChanged() {
    }
}
