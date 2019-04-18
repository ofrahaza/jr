package com.javarush.task.task18.task1813;

import java.io.*;
import java.nio.channels.FileChannel;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    FileOutputStream file;

    public AmigoOutputStream(FileOutputStream file) throws FileNotFoundException {
        super(fileName);
        this.file = file;
    }
    public void close() throws IOException {
        this.file.flush();
    //String data = "JavaRush © All rights reserved.";
    //InputStream is = new ByteArrayInputStream(data.getBytes());
    //byte[] buffer = new byte[is.available()];
    //is.read(buffer);
    this.file.write("JavaRush © All rights reserved.".getBytes());
    //is.close();
    this.file.close();
    }

    public void flush() throws IOException {
        file.flush();
    }

    public void write(byte[] b) throws IOException {
        file.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException {
        file.write(b, off, len);
    }

    public void write(int b) throws IOException {
        file.write(b);
    }


    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
