/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTree;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author ebrar
 */
public class EbrarDerindagBST<T extends Comparable<T>> {

    EbrarDerindagNode<T> root;

    //BSTye eleman ekleme
    void insert(T data) {
        if (root == null) {
            root = new EbrarDerindagNode(data);
            root.count++;
        } else {
            EbrarDerindagNode<T> temp = root;
            while (temp != null) {
                if (data.compareTo(temp.data) > 0) {
                    if (temp.right == null) {
                        temp.right = new EbrarDerindagNode(data);
                        temp.right.count++;
                        return;
                    }
                    temp = temp.right;
                } else if (data.compareTo(temp.data) < 0) {
                    if (temp.left == null) {
                        temp.left = new EbrarDerindagNode(data);
                        temp.left.count++;
                        return;
                    }
                    temp = temp.left;
                } else {
                    temp.count++;
                    return;
                }
            }
        }
    }

    //Mainde çağırılan preorder fonksiyonu
    void preorder() throws IOException {
        System.out.println("Preorder dosyaya yazıldı. ");
        File file3 = new File("output.txt");
        FileWriter fwriter = new FileWriter(file3, false);
        preorder(root, fwriter);
        fwriter.close();

    }

    //BST'yi preordera çeviren fonksiyon
    void preorder(EbrarDerindagNode<T> temp, FileWriter fwriter) throws IOException {
        if (temp != null) {
            fwriter.append(temp.data + "," + temp.count + "\n");
            preorder(temp.left, fwriter);
            preorder(temp.right, fwriter);
        }
    }
}
