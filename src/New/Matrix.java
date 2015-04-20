public class Matrix{
   private double[][] matrix = new double[3][3];
   
   public Matrix(double[][] mat){
      matrix = mat;
   }

   public double[][] getMatrix(){
      return matrix;
   }

   public double[][] multiply(Matrix mat){
      double [][] matrix1 = mat.getMatrix();
      double [][] ret = new double[matrix.length][matrix1[0].length];
      for (int i = 0; i < matrix.length; i++) { 
         for (int j = 0; j < matrix1[0].length; j++) { 
            for (int k = 0; k < matrix[0].length; k++) { 
               ret[i][j] += matrix[i][k] * matrix1[k][j];
            }
         }
      }
      return ret;
   }
   
   public double[][] multiply(double[][] matrix1){
      double [][] ret = new double[matrix.length][matrix1[0].length];
      for (int i = 0; i < matrix.length; i++) { 
         for (int j = 0; j < matrix1[0].length; j++) { 
            for (int k = 0; k < matrix[0].length; k++) { 
               ret[i][j] += matrix[i][k] * matrix1[k][j];
            }
         }
      }
      return ret;
   }
   
   public String toString(){
      return matrix.toString();
   }
}