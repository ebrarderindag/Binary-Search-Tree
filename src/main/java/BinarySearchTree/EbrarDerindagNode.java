/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTree;

/**
 *
 * @author ebrar
 */
public class EbrarDerindagNode<T extends Comparable<T>> {

    T data;
    EbrarDerindagNode<T> right;
    EbrarDerindagNode<T> left;
    int count;

    public EbrarDerindagNode(T data) {
        this.data = data;
        count = 0;
    }

}
