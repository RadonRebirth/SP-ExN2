package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        int[] Arr = { 1,3,4,5 };
        int[] Arr2 = { 2,5,6,7 };
        int Arr3[] = { 4,7,6,8 };

        SaveAsThread t = new SaveAsThread(Arr, "Arr.txt");
        t.start();
        SaveAsThread t2 = new SaveAsThread(Arr2, "Arr2.txt");
        t2.start();
        SaveAsThread t3 = new SaveAsThread(Arr3, "Arr3.txt");
        t3.start();
    }
}
class SaveAsThread implements Runnable{

    private int[] Arr;
    private String file;
    private Thread t;

    public SaveAsThread(int[] Arr, String file){
        this.Arr = Arr;
        this.file = file;
        t = new Thread(this,"SaveAsThread");
    }
    public void start(){
        t.start();
    }
    @Override
    public void run(){
            try{
                FileOutputStream fO = new FileOutputStream(file);
                PrintStream pS = new PrintStream(fO);
                pS.println("Размерность массива: \n " + Arr.length);
                pS.println("Элементы массива:");
                for (int i=0; i<Arr.length; i++) {
                    pS.print(" "+ Arr[i]);
                }
                fO.close();
                pS.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
    }
}