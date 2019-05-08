package com.javarush.task.task19.task1918;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            FileReader file1 = new FileReader(reader.readLine());
            BufferedReader bufferedReader = new BufferedReader(file1);

            String all_file = "";
            String line;
            while((line = bufferedReader.readLine()) != null) {
                all_file = all_file + line;
            }

            Document document = Jsoup.parse(all_file,  "", Parser.xmlParser());
            //Elements elem = document.body().getElementsByTag(args[0]);
            Elements elem = document.select(args[0]);
            for (Element element : elem) {
                System.out.println(element.outerHtml());
            }

            reader.close();
            bufferedReader.close();
            file1.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
