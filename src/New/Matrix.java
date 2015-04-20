public class Matrix{
   private double[][] matrix = new double[3][3];
   
   public Matrix(double[][] mat){
      matrix = mat;
   }
 /* 
  * public static void main(String[] args)
  * {
  *    double arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
  *    double arr2[][] = {{9,8,7},{6,5,4},{3,2,1}};
  *    Matrix mat = new Matrix(arr);
  *    Matrix mat2 = new Matrix(arr2);
  *    System.out.println(mat+"\n");
  *    System.out.println(mat2+"\n");
  *    System.out.println(mat.multiply(mat2)+"\n");
  * }
  */ 
   public double[][] getMatrix(){
      return matrix;
   }

   public Matrix multiply(Matrix mat){
      double [][] matrix1 = mat.getMatrix();
      double [][] ret = new double[matrix.length][matrix1[0].length];
      for (int i = 0; i < matrix.length; i++) { 
         for (int j = 0; j < matrix1[0].length; j++) { 
            for (int k = 0; k < matrix[0].length; k++) { 
               ret[i][j] += matrix[i][k] * matrix1[k][j];
            }
         }
      }
      return new Matrix(ret);
   }
   
   public Matrix multiply(double[][] matrix1){
      double [][] ret = new double[matrix.length][matrix1[0].length];
      for (int i = 0; i < matrix.length; i++) { 
         for (int j = 0; j < matrix1[0].length; j++) { 
            for (int k = 0; k < matrix[0].length; k++) { 
               ret[i][j] += matrix[i][k] * matrix1[k][j];
            }
         }
      }
      return new Matrix(ret);
   }
   
   public String toString(){
      String ret = "";
      for(int r = 0; r < matrix.length; r++)
      {
         if(r>0)
            ret+= "\n";
         ret+="[";
         for(int c = 0; c < matrix[r].length; c++)
         {
            ret += (" "+matrix[r][c]);
         }
         ret+= " ]";
      }

      return ret;
   }
}