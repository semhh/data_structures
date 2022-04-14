/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordcounter;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author Semih KARACAOĞLU 
 * Student Number : 17050111008
 * CENG202 Homework 2
 */

public class Word_Counter {
   
    
    
    public static String WordCounterMethod(String fileName){
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a value for "+fileName+" (The program will show words that repeat more than this value in the book):");
            int num = scan.nextInt();
    try{
            BufferedReader bufReader = new BufferedReader(new java.io.FileReader("commonwords.txt")); 
            ArrayList<String> listOfLines = new ArrayList<>();
            HashSet<String> set = new HashSet<String>();
            String line = bufReader.readLine(); 
            while (line != null) { 
                listOfLines.add(line);
                line = bufReader.readLine(); 
            } 
            bufReader.close();
            
            for(int i=0; i <listOfLines.size();i++){
            set.add(listOfLines.get(i));
            }
        
            BufferedReader br=new BufferedReader(new java.io.FileReader(fileName));
            String str="";
            String st;
        while((st=br.readLine())!=null){
            str+=st+" ";
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
     
            str = str.toLowerCase();
            
                int count = -1;
                for (int i = 0; i < str.length(); i++) { 
                   if ((!Character.isLetter(str.charAt(i))) || (i + 1 == str.length())) { 
                            if (i - count > 1) { 
                            if (Character.isLetter(str.charAt(i))) 
                                i++;
                            String word = str.substring(count + 1, i);
                            if (map.containsKey(word)) { 
                            map.put(word, map.get(word) + 1);
                            }
                            else { 
                            map.put(word, 1);
                            } 
                        } 
                        count = i;
                    } 
                } 
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.addAll(map.values());
        Collections.sort(list, Collections.reverseOrder());
        int last = -1;
        
        System.out.println(fileName+" Counter Results");
        for (Integer i : list) { 
            if (last == i) 
                continue;
            last = i;
            
           /* System.out.println("Enter a value (The program will show words that repeat more than this value in the book.):");
            int num = scan.nextInt();*/
            for (String s : map.keySet()) { 
                if (map.get(s) == i&&!set.contains(s)&&i>=num&&s.length()>1){
                    s.split("[^a-zA-Z]+");
                    System.out.println(s + ":" + i);
                }
            } 
        }
        System.out.println("\n"+fileName+" word counting has finished.");
        System.out.println("*****************************************");
        System.out.println("\n");
}
        catch(Exception e){
        System.out.println(e);
}
        return null;
}    
    public static void main(String args[]){
        WordCounterMethod("tomsawyer.txt");
        WordCounterMethod("dyssy10.txt");
        WordCounterMethod("totc.txt");
        
    }
}
