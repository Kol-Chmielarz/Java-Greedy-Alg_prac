
/* Kol Chmielarz
   Dr. Steinberg
   COP3503 Fall 2022
   Programming Assignment 
*/


import java.util.*;
import java.io.File; 
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileNotFoundException; 


public class Cookies{
  int cooks=0;
  int m, n;
  int studs=0;
  int happy=0;
  int angry=0;
  String fname1;
  String fname2;
  ArrayList<Integer> cook = new ArrayList<>();//cookie array list
  ArrayList<Integer> studnts = new ArrayList<>();//campers array list
  //vars needed
 
 
 

  public Cookies(int m, int n, String fname1, String fname2){
    this.m=m;
    this.n=n;
    this.fname1=fname1;
    this.fname2=fname2; 
    read(fname1, fname2);
   
  }

  
   public void readcookies(String fname){//fnctn read cookies and get in array
     
  int[] csize =new int[m];
      try {
      File myObj = new File(fname);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        
       String data = myReader.nextLine();
        csize[cooks]=Integer.parseInt(data);
         cooks++;
          }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

      for(int i=0;i<m;i++){
      cook.add(csize[i]);
       
    }

  }

     public void readstudents(String fname){//fnctn read campers and get in array
        int[] greedyArray= new int[n];

      try {
      File myObj = new File(fname);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
       
       String data = myReader.nextLine(); 
        greedyArray[studs]=Integer.parseInt(data);
        studs++;
          }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

      for(int i=0;i<n;i++){
      studnts.add(greedyArray[i]);
    }
     }

       public void read(String fname1,String fname2){
         readcookies(fname2);
         readstudents(fname1);
       }

  public void passCookies(){
    int tracker=0;

    Collections.sort(cook);//sort array list
    Collections.sort(studnts);//sort array list
   
     // System.out.println(studnts);
     // System.out.println(cook);

    //greedy alg is put least greedy students to lowest size cookie that satisifies them so works until we have cookies that dont satisfy the campers left 

    for(int i=0;i<n;i++){
      if(tracker<m&&cook.get(tracker)>=studnts.get(i)){//if cookie satisifes pass and move to next cookie
       
        happy++;
        tracker++;
      }
      else if(tracker<m&&cook.get(tracker)<studnts.get(i)){//if doesnt satisfy but still larger cookies available keep parsing cookies till have cookie that satisfies
        while(cook.get(tracker)<studnts.get(i)&&tracker<m)
        tracker++;
        if(cook.get(tracker)>=studnts.get(i)){
       
        happy++;
        tracker++;
      }
        if(tracker>=m){angry++;}//if none satisfy we have an angry camper
        
      }
      else{angry++;}//if we are out of cookies that would satisfy they are angry        
    }
    }

  

  public void display(){
     System.out.println("There are "+happy+" happy campers.");
      System.out.println("There are "+angry+" angry campers.");
  }

       

     
  






















}