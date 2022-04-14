
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Semih KARACAOÄ?LU
 * Student Number : 17050111008
 * CENG202 Homework 1, Question 2
 */

public class PalindromeFinder 
{ 
    // To check sentence is palindrome or not 
    static boolean PalindromeFinder(String str) 
    {     
        int l = 0; 
        int h = str.length()-1; 
          
        // Lowercase string 
        str = str.toLowerCase(); 
          
        // Compares character until they are equal 
        while(l <= h) 
        { 
              
            char getAtl = str.charAt(l); 
            char getAth = str.charAt(h); 
              
            // If there is another symbol in left 
            // of sentence 
            if (!(getAtl >= 'a' && getAtl <= 'z')) 
                l++; 
              
            // If there is another symbol in right  
            // of sentence 
            else if(!(getAth >= 'a' && getAth <= 'z')) 
                h--; 
              
            // If characters are equal 
            else if( getAtl == getAth) 
            { 
                l++; 
                h--; 
            } 
              
            // If characters are not equal then 
            // sentence is not palindrome 
            else 
                return false; 
        } 
          
        // Returns true if sentence is palindrome 
        return true;     
    } 
        
    public static void FileReader(String fileName) throws FileNotFoundException, IOException{
        //Reading .txt file and writing into arraylist
        BufferedReader bufReader = new BufferedReader(new java.io.FileReader(fileName)); 
            ArrayList<String> listOfLines = new ArrayList<>();
            String line = bufReader.readLine(); 
            
            while (line!=null ) { 
                listOfLines.add(line);
                line = bufReader.readLine();
            } 
                bufReader.close();
                System.out.println("java Palindrome Finder "+fileName);
        //Printing whether the sentences are palindromes or not        
            for( int x = 1 ; x < listOfLines.size() ; x++ ){
                if( PalindromeFinder(listOfLines.get(x))) 
                    System.out.println("<"+listOfLines.get(x)+">"+" is a palindrome"); 
                else
                    System.out.println("<"+listOfLines.get(x)+">"+" is not a palindrome");
            }
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {  
        FileReader("palindromes.txt");   
    } 
} 
  