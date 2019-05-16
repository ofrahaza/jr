package com.javarush.task.task20.task2004;

import java.io.*;

/* 
Читаем и пишем в файл статики
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 3;
            classWithStatic.j = 4;
            classWithStatic.save(outputStream);
            outputStream.flush();

            ClassWithStatic loadedObject = new ClassWithStatic();
            loadedObject.staticString = "something";
            loadedObject.i = 6;
            loadedObject.j = 7;

            loadedObject.load(inputStream);
            //here check that the classWithStatic object is equal to the loadedObject object - проверьте тут, что classWithStatic и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class ClassWithStatic {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            /*PrintWriter writer = new PrintWriter(outputStream);

            writer.println(this.i);
            writer.println(this.j);
            writer.println(Solution.ClassWithStatic.staticString);*/

            PrintWriter writer = new PrintWriter(outputStream);

            writer.println(i + " " + j + " " + ClassWithStatic.staticString);
            writer.flush();
            writer.close();
        }


        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            /*BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            this.i = Integer.valueOf(br.readLine());
            this.j = Integer.valueOf(br.readLine());
            ClassWithStatic.staticString = br.readLine();*/

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String[] strArray = reader.readLine().split(" ");

            this.i = Integer.parseInt(strArray[0]);
            this.j = Integer.parseInt(strArray[1]);
            StringBuilder s = new StringBuilder();
            for (int i = 2; i < strArray.length; i++) {
                s.append(strArray[i]);
            }
            ClassWithStatic.staticString = s.toString();
        }


            @Override
            public boolean equals (Object o){
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                ClassWithStatic that = (ClassWithStatic) o;

                if (i != that.i) return false;
                return j == that.j;

            }

            @Override
            public int hashCode () {
                int result = i;
                result = 31 * result + j;
                return result;
            }
        }
    }


