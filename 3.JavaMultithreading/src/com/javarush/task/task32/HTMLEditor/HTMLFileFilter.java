package com.javarush.task.task32.HTMLEditor;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class HTMLFileFilter extends FileFilter {

    @Override
    public boolean accept(File file) {
        if (file != null) {
            return file.isDirectory() || (file.getName().toLowerCase().endsWith(".html") || file.getName().toLowerCase().endsWith(".htm"));
        } else {
            return false;
        }
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
