package main;

import java.util.Random;

public class Matrix {
	
	public static void main(String args[]){
		
		//generate two matrices using random numbers
	    double matrix1 [][] = matrixGenerator();
	    double matrix2 [][] = matrixGenerator();
	    
	  //get the number of rows from the first matrix
	    int m1rows = matrix1.length;
	    //get the number of columns from the first matrix
	    int m1cols = matrix1[0].length;
	    //get the number of columns from the second matrix
	    int m2cols = matrix2[0].length;

	    //multiply the matrices and put the result in an array
	    double[][] result = new double[m1rows][m2cols];
	        for (int i=0; i< m1rows; i++){
	           for (int j=0; j< m2cols; j++){
	              for (int k=0; k< m1cols; k++){
	                 result[i][j] += matrix1[i][k] * matrix2[k][j];
	              }
	           }
	        }
	        
	        showResult(result);
	        
	        
	}
	
	
	 public static double[][] matrixGenerator(){
	     //create an array
	    double matrix [][] = new double[550][550];
	    //create a random generator
	    //and fill it with random numbers
	    Random r = new Random( );
	    for(int i=0; i < matrix.length; i++){
	        for(int j=0; j < matrix[i].length; j++){
	            matrix[i][j] =  (r.nextInt((int)((0.99-0.10)*10+1))+0.10*10) / 10000.0;
	        }
	    }
	    return matrix;
	}
	 
	 public static void showResult(double matrix[][]){
		 
		 for(int i=0; i < matrix.length; i++){
		        for(int j=0; j < matrix[i].length; j++){
		            System.out.print(matrix[i][i] + " ");
		        }
		        System.out.println();
		 }
	 }	 
}
