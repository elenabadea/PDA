package main;

import java.util.Random;
import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args)
   {      
       Scanner In=new    Scanner(System.in); 

       System.out.print("Row of Matrix A: ");     
       int rA=In.nextInt();
       System.out.print("Column of Matrix A: ");
       int cA=In.nextInt();
       System.out.print("Row of Matrix B: ");     
       int rB=In.nextInt();
       System.out.print("Column of Matrix B: ");
       int cB=In.nextInt();
       System.out.println();

       if(cA!=rB)
       {
            System.out.println("We can't do the matrix product!");
            System.exit(-1);
       }
      System.out.println("The matrix result from product will be "+rA+" x "+cB);
    System.out.println();
    float[][] A= matrixGenerator();
    float[][] B= matrixGenerator();
    float[][] C= matrixGenerator();
    MatrixProduct[][] thrd= new MatrixProduct[rA][cB];

    
       System.out.println();

     for(int i=0;i<rA;i++)
     {
      for(int j=0;j<cB;j++)
       {
         thrd[i][j]=new MatrixProduct(A,B,C,i,j,cA);
         thrd[i][j].start();
       }
     }

     for(int i=0;i<rA;i++)
     {
         for(int j=0;j<cB;j++)
         {
             try{
                 thrd[i][j].join();
             }
         catch(InterruptedException e){}
         }
     }        

     System.out.println();
     System.out.println("Result");
     System.out.println();
     for(int i=0;i<rA;i++)
     {
         for(int j=0;j<cB;j++)
         {
             System.out.print(C[i][j]+" ");
         }    
         System.out.println();            
     }       
}  
    public static float[][] matrixGenerator(){
        //create an array
       float[][] matrix = new float[550][550];
       //create a random generator
       //and fill it with random numbers
       Random r = new Random( );
       for(int i=0; i < matrix.length; i++){
           for(int j=0; j < matrix[i].length; j++){
               matrix[i][j] = (int) ((r.nextInt((int)((0.99-0.10)*10+1))+0.10*10) / 1000.0);
           }
       }
       return matrix;
   }
}