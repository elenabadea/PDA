package main;

class MatrixProduct extends Thread {
      private float[][] A;
      private float[][] B;
      private float[][] C;
      private int rig,col;
      private int dim;

      public MatrixProduct(float[][] A, float[][] B, float[][] C,int rig, int col,int dim_com)
      {
         this.A=A;    
         this.B=B;
         this.C=C;
         this.rig=rig;    
         this.col=col; 
         this.dim=dim_com;     
      }

     /*public MatrixProduct1(float[][] a2, float[][] b2, float[][] c2, int i, int j, int cA) {
		// TODO Auto-generated constructor stub
	}*/

	public void run()
     {
         for(int i=0;i<dim;i++){
               C[rig][col]+=A[rig][i]*B[i][col];        
         }      
          System.out.println("Thread "+rig+","+col+" complete.");        
     }          
 }
