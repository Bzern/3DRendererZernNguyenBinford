import java.util.*;
import java.io.*;
public class ScanFiles {
   public static void main(String[]args) throws Exception{
      final File folder = new File(System.getProperty("user.dir"));
      System.out.println("\n\n" + countLines(folder));
   /*   Scanner scan = new Scanner(System.in);
      System.out.println("Enter word or phrase to search for, use \"_\" for space");
      String word = scan.next();
      if(word.contains("_"))
         word = word.replace("_", " ");
      System.out.println(word);
      findWord(word, folder);
   */}
   
   public static void findWord(String word, final File folder) throws Exception{
      for (final File fileEntry : folder.listFiles()) {
         String extension = "";
         int i = fileEntry.getName().lastIndexOf('.');
         if (i > 0) {
         extension = fileEntry.getName().substring(i+1);
         }
         if(extension.equals("java"))
         {
            Scanner fScan = new Scanner(fileEntry);
            System.out.println("\n\n"+fileEntry.getName()+":");
            while(fScan.hasNextLine())
            {
               String line = fScan.nextLine();
               if(line.contains(word)) {
                 System.out.println("\n"+line);
               }
            }
         }
      }
   }

   public static int countLines (final File folder) throws Exception {
      int count = 0;
      for (final File fileEntry : folder.listFiles()) {
         int fileCount = 0;
         String extension = "";
         int i = fileEntry.getName().lastIndexOf('.');
         if (i > 0) {
            extension = fileEntry.getName().substring(i+1);
         }
         if(extension.equals("java"))// && !fileEntry.getName().equals("ScanFiles.java"))
         {
            Scanner fScan = new Scanner(fileEntry);
            while(fScan.hasNextLine())
            {
               fileCount++;
               System.out.println(fileCount);
            }
         }
         System.out.println(fileEntry.getName()+" : " + fileCount);
         count+= fileCount;
      }
      return count;
   }
}