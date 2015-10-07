import org.junit.Test;
import org.junit.runner.Result;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by WIT-PC on 5/10/2558.
 */
public class TreeCellTest {
    private TreeCell<Integer> createTree(){
        TreeCell<Integer> n1 = new TreeCell<Integer>(1);
        TreeCell<Integer> n2 = new TreeCell<Integer>(2);
        TreeCell<Integer> n3 = new TreeCell<Integer>(3);
        TreeCell<Integer> n4 = new TreeCell<Integer>(4);
        TreeCell<Integer> n5 = new TreeCell<Integer>(5);
        TreeCell<Integer> n6 = new TreeCell<Integer>(6);
        TreeCell<Integer> n7 = new TreeCell<Integer>(7);
        TreeCell<Integer> n8 = new TreeCell<Integer>(8);
        TreeCell<Integer> n9 = new TreeCell<Integer>(9);
        TreeCell<Integer> n10 = new TreeCell<Integer>(10);
        TreeCell<Integer> n11 = new TreeCell<Integer>(11);
        TreeCell<Integer> n12 = new TreeCell<Integer>(12);
        TreeCell<Integer> n13 = new TreeCell<Integer>(13);

        n7.setLeft(n3);
        n3.setLeft(n1);
        n1.setRight(n2);
        n3.setRight(n5);
        n5.setLeft(n4);
        n5.setRight(n6);

        n7.setRight(n10);
        n10.setLeft(n8);
        n8.setRight(n9);
        n10.setRight(n12);
        n12.setLeft(n11);
        n12.setRight(n13);
        return n7;
    }
    public static TreeCell insert(int x, TreeCell T) {
        if (T == null) return new TreeCell(x, null, null);
        else if (Integer.parseInt(T.getDatum().toString())>x)
            T.setLeft(insert(x, T.getLeft()));
        else
            T.setRight(insert(x, T.getRight()));
        return T;
    }

    public static TreeCell<Integer> createTree(Integer[] array){
        TreeCell root = new TreeCell(array[0]);
        TreeCell newRoot = root;
        for(Integer i:array){
            if(i!=array[0])
            newRoot = insert(i,newRoot);
        }
        return root;
    }
    private static Integer[] array1 = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13};
    public static String inorder(TreeCell root) {
        if (root == null) return new String();
            return inorder(root.getLeft())+root.getDatum()+" "+inorder(root.getRight());

    }
    public static void preorder(TreeCell root) {
        if (root != null) {
            System.out.print(root.getDatum() + " ");
            preorder(root.getLeft());
            preorder(root.getRight());
        }
    }
    public static String remove(Integer[] array, int x){
        List<Integer> list = Arrays.asList(array);
        Collections.sort(list);
        String s=new String();
        for(Integer i:list){
            if(!i.equals(x)) {
                s += i + " ";
            }
        }
        return s;
    }
    @Test
    public void delete1(){
        for(int i =1;i<=13;i++) {
            TreeCell treeCell = createTree();
            treeCell = TreeCell.delete(i, treeCell);
//            System.out.println(remove(array1,i));
            assertEquals(inorder(treeCell), remove(array1, i));
        }
    }
    @Test
    public void delete2(){
        Integer[] array = new Integer[]{2,3,4,5,9,7,8,11,15,16,84,13,85};
        for(int i =0;i<array.length;i++) {
            TreeCell treeCell = createTree(array);
//            System.out.println("test 2 =>"+inorder(treeCell));
//            System.out.println(array[i]);
            treeCell = TreeCell.delete(array[i], treeCell);

//            System.out.println(Arrays.toString(array));
//            System.out.println(remove(array, array[i]));
            assertEquals(inorder(treeCell), remove(array, array[i]));
        }
    }
    @Test
    public void delete3(){
        Integer[] array = new Integer[]{15,12,13,4,17,5,19,11};
        for(int i =0;i<array.length;i++) {
            TreeCell treeCell = createTree(array);
            System.out.println("test 3 =>"+inorder(treeCell));
            System.out.println(array[i]);
            treeCell = TreeCell.delete(array[i], treeCell);

            System.out.println(Arrays.toString(array));
//            System.out.println(remove(array, array[i]));
            assertEquals(inorder(treeCell), remove(array, array[i]));
        }
    }
    @Test
    public void delete4(){
        Integer[] array = new Integer[]{15,12,11,10,17,2,4,19,20};
        for(int i =0;i<array.length;i++) {
            TreeCell treeCell = createTree(array);
            System.out.println("test 3 =>"+inorder(treeCell));
            System.out.println(array[i]);
            treeCell = TreeCell.delete(array[i], treeCell);

            System.out.println(Arrays.toString(array));
            System.out.println(remove(array, array[i]));
            assertEquals(inorder(treeCell), remove(array, array[i]));
        }
    }

    public static void main(String[] args) {
        Class<?> testclass = TreeCellTest.class;
        Result result = org.junit.runner.JUnitCore.runClasses( testclass );
    }
}
