/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTree;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ebrar
 */
public class EbrarDerindagMain {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("**********BST Preorder**********\n-File num(1-10) \n-Exit(e)");
        System.out.println("\nSeçenek:");
        String secenek = sc.next();

        //seçeneğin kontrolü için bir while döngüsü oluştudum. Yanlışsa her seferinde tekrar seçeneği talep ettim.
        while (!(((48 < secenek.charAt(0) && 60 > secenek.charAt(0)) || secenek.equals("e")) && (secenek.length() == 1 || secenek.equals("10")))) {
            System.out.println("Hata! Lütfen Tekrar Deneyiniz.");
            System.out.println("Seçenek:");
            secenek = sc.next();
        }
        menu(secenek);
    }

    static void menu(String secenek) throws IOException { //menu secenek kontrolü
        Scanner sc = new Scanner(System.in);

        while (!secenek.equals("e")) {
            if (secenek.equals("1")) {
                file("01");
            }
            if (secenek.equals("2")) {
                file("02");
            }

            if (secenek.equals("3")) {
                file("03");
            }
            if (secenek.equals("4")) {
                file("04");
            }
            if (secenek.equals("5")) {
                file("05");
            }
            if (secenek.equals("6")) {
                file("06");
            }
            if (secenek.equals("7")) {
                file("07");
            }
            if (secenek.equals("8")) {
                file("08");
            }
            if (secenek.equals("9")) {
                file("09");
            }
            if (secenek.equals("10")) {
                file("10");
            }

            System.out.println("\n\n\n**********BST Preorder**********\n-File num(1-10) \n-Exit(e)");
            System.out.println("\nSeçenek:");
            secenek = sc.next();

            while (!(((48 < secenek.charAt(0) && 60 > secenek.charAt(0)) || secenek.equals("e")) && (secenek.length() == 1 || secenek.equals("10")))) {
                System.out.println("Hata! Lütfen Tekrar Deneyiniz.");
                System.out.println("Seçenek:");
                secenek = sc.next();
            }
        }
        if (secenek.equals("e")) {
            System.out.println("İyi Günler...");
        }
    }

    static void file(String yol) throws IOException { //bütün dosyaları okuma işlemleri

        EbrarDerindagBST<String> tree = new EbrarDerindagBST<>();
        String line = null;
        ArrayList ignoreList = new ArrayList<String>();
        String specialCharacter = " ";

        //ignoreList dosyasını satır satır okuma
        File file = new File("ignoreList.txt");
        try (BufferedReader read = new BufferedReader(new FileReader(file))) {

            while ((line = read.readLine()) != null) {
                String[] values = line.split(specialCharacter);
                for (String value : values) {
                    ignoreList.add(value);
                }
            }
            read.close();
        }

        //verilen yolun dosyasını satır satır okuma       
        File file2 = new File("cse225" + yol + ".html");
        try (BufferedReader read2 = new BufferedReader(new FileReader(file2))) {
            int counter = 0;
            while ((line = read2.readLine()) != null) {
                String[] values = line.split(specialCharacter);

                for (String value : values) {
                    for (int j = 0; j < ignoreList.size(); j++) {
                        if (!(value.startsWith("<") || value.equals(".") || value.startsWith(",") || value.equals(""))) {
                            if (value.equals(ignoreList.get(j))) {
                                counter++;
                            } else if (counter == 0 && j == ignoreList.size() - 1) {
                                tree.insert(value);
                            }
                        }
                    }
                    counter = 0;
                }
            }
            read2.close();
        }
        tree.preorder();
    }

}
