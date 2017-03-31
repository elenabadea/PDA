package main;

import java.util.Random;

public class MatrixTest {

//Creating the matrix
static float[][] mat = new float[1000][1000];
static float[][] mat2 = new float[1000][1000];
static float[][] result = new float[1000][1000];
static int n=1000;

public static void main(String [] args){

    //Creating the object of random class
    Random r = new Random();


    //Filling first matrix with random values
    for (int i = 0; i < mat.length; i++) {
        for (int j = 0; j < mat[i].length; j++) {
            mat[i][j]=(int) ((r.nextInt((int)((0.99-0.10)*10+1))+0.10*10) / 1000.0);
        }
    }

    //Filling second matrix with random values
    for (int i = 0; i < mat2.length; i++) {
        for (int j = 0; j < mat2[i].length; j++) {
            mat2[i][j]=(int) ((r.nextInt((int)((0.99-0.10)*10+1))+0.10*10) / 1000.0);
        }
    }

    try{
        //Object of multiply Class
        Multiply multiply = new Multiply(n,n);

        //Threads
        MatrixMultiplier thread1 = new MatrixMultiplier(multiply);
        MatrixMultiplier thread2 = new MatrixMultiplier(multiply);
        MatrixMultiplier thread3 = new MatrixMultiplier(multiply);

        //Implementing threads
        Thread th1 = new Thread(thread1);
        Thread th2 = new Thread(thread2);
        Thread th3 = new Thread(thread3);

        //Starting threads
        th1.start();
        th2.start();
        th3.start();

        th1.join();
        th2.join();
        th3.join();

    }catch (Exception e) {
        e.printStackTrace();
    }

    //Printing the result
    System.out.println("\n\nResult:");
    for (int i = 0; i < result.length; i++) {
        for (int j = 0; j < result[i].length; j++) {
            System.out.print(result[i][j]+" ");
        }
        System.out.println();
    }
  }//End main

  }//End Class