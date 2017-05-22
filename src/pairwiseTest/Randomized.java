/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pairwiseTest;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Najib Ismail
 */
public class Randomized {
    private ArrayList<ArrayList<Integer>>interactionList= new ArrayList<ArrayList<Integer>>();
    private ArrayList<ArrayList<ArrayList<Integer>>> totalinteractionpairsinterval1 = new ArrayList<ArrayList<ArrayList<Integer>>>();
    private ArrayList<ArrayList<ArrayList<Integer>>> totalinteractionpairsinterval2 = new ArrayList<ArrayList<ArrayList<Integer>>>();
    private ArrayList<ArrayList<Integer>> parameterVal=new ArrayList<ArrayList<Integer>>();
    int parameterNo1;
    int parameterNo2;
    int t1;
    int t2;
    int MAX1;
    int MAX2;
    //random
     private ArrayList<Integer> RandomTestCase = new ArrayList<Integer>();
     private ArrayList<Integer> tempTestCase;
     private ArrayList<String> randomTestCaseList = new ArrayList<String>();
     private ArrayList<ArrayList<Integer>> Total_TestCaseSplit = new ArrayList<ArrayList<Integer>>();
     private ArrayList<ArrayList<Integer>> tempTestCaseList= new ArrayList<ArrayList<Integer>>() ; 
     public ArrayList<ArrayList<Integer>> finalList = new  ArrayList<ArrayList<Integer>>();
     private ArrayList<ArrayList<Integer>> tempMatchInteraction = new ArrayList<ArrayList<Integer>>();
     public ArrayList<ArrayList<Integer>> remainTestCaseList = new ArrayList<ArrayList<Integer>>();
     
     int covered;
     int remain;
     int c;
     
   
    public Randomized(int Parameterno1,int T,ArrayList<ArrayList<Integer>> parameterva,ArrayList<ArrayList<ArrayList<Integer>>> total_interactionpairs_interval1, ArrayList<ArrayList<Integer>>Interactionlist)
    {
        
        for(int c =0; c < total_interactionpairs_interval1.size(); c++) {
          System.out.println(total_interactionpairs_interval1.get(c));
          System.out.println(total_interactionpairs_interval1.get(c).get(c));
          System.out.println("******");
        }
        this.parameterNo1=Parameterno1;
        this.t1=T;
        this.parameterVal=parameterva;
        this.totalinteractionpairsinterval1=total_interactionpairs_interval1;
        MAX1=total_interactionpairs_interval1.size();
        interactionList=Interactionlist;
    }
    
     public ArrayList randomPick() {
        
        int min = 0; 
        int max ;
        int choose = 0;


        
        for(int i=0;i<1;i++){
            String testcase=new String("");
          for (int a=0;a<parameterNo1;a++){
            Random r = new Random();
            min = parameterVal.get(a).get(0);
           // max = parameterVal.get(a).get(parameterVal.get(a).size() - 1);
            max = parameterVal.get(a).get(parameterVal.get(a).size() - 1);
            System.out.println("****"+ min);
             System.out.println("****"+ max);
            choose = r.nextInt((max+1) - min) + min;
            
            
       
            
          
            RandomTestCase.add(choose);
            if(a>0){
                testcase = testcase + " : " + choose;
            }else{
                 testcase = testcase + choose;
            }
           
        //}
          randomTestCaseList.add(testcase); 

         // System.out.println(testcase + "]"); 
        }
        tempTestCase = new ArrayList<Integer>(RandomTestCase);
        
        
        System.out.println("I am t1" + t1);
        
       

       
         if (t1 == 2) {
            for (int a = 0; a < RandomTestCase.size() -1; a++) {
                for (int b = a + 1; b < RandomTestCase.size(); b++) {
                    ArrayList<Integer> TestCaseSplit = new ArrayList<Integer>();
                     
                    
                        TestCaseSplit.add(tempTestCase.get(a));
                        TestCaseSplit.add(tempTestCase.get(b));
                    
                    Total_TestCaseSplit.add(TestCaseSplit);
                    tempTestCaseList.add(TestCaseSplit);
                }
            }
         }
          else if (t1 == 3) {
            for (int a = 0; a < RandomTestCase.size() - 2; a++) {
                for (int b = a + 1; b < RandomTestCase.size() - 1; b++) {
                    for (int c = b + 1; c < RandomTestCase.size(); c++) {
                        ArrayList<Integer> TestCaseSplit = new ArrayList<Integer>();
                      
                            TestCaseSplit.add(tempTestCase.get(a));
                            TestCaseSplit.add(tempTestCase.get(b));
                            TestCaseSplit.add(tempTestCase.get(c));
                        
                        Total_TestCaseSplit.add(TestCaseSplit);
                        tempTestCaseList.add(TestCaseSplit);
                    }
                }
            }
          }
         else if (t1 == 4) {
            for (int a = 0; a < RandomTestCase.size() - 3; a++) {
                for (int b = a + 1; b < RandomTestCase.size() - 2; b++) {
                    for (int c = b + 1; c < RandomTestCase.size() - 1; c++) {
                        for (int d = c + 1; d < RandomTestCase.size(); d++) {
                            ArrayList<Integer> TestCaseSplit = new ArrayList<Integer>();
                            
                                TestCaseSplit.add(tempTestCase.get(a));
                                TestCaseSplit.add(tempTestCase.get(b));
                                TestCaseSplit.add(tempTestCase.get(c));
                                TestCaseSplit.add(tempTestCase.get(d));
                            
                            Total_TestCaseSplit.add(TestCaseSplit);
                            tempTestCaseList.add(TestCaseSplit);
                        }
                    }
                }
            }
         }
          CheckCoverage();
                if (covered != 0 ){  
                System.out.println("\nRANDOMLY GENERATE  --  [" + testcase + "]"); 
                System.out.println("\nTEMPORARY TEST CASES : " );
                System.out.println(tempTestCaseList );
                System.out.println("\nTOTAL TEST CASES THAT HAVE BEEN COVERED (WEIGHTAGE) :  " +covered);
               }

                CheckMaxCoverage();
                AddFinalList(); 
                c=covered+covered;
        }

         return tempTestCase;
    }
     
      public int CheckCoverage(){
        int weightage =0;
        System.out.println("got to check coverage ");
        for(int a=0; a < (totalinteractionpairsinterval1.size()) && ( a < (Total_TestCaseSplit.size())) ;a++)
        {
            for (int b=0;b < totalinteractionpairsinterval1.get(a).size();  b++){
                System.out.println("The values to check are "+ totalinteractionpairsinterval1.get(a).get(b));
                  System.out.println("against "+ Total_TestCaseSplit.get(a));
                
                if (totalinteractionpairsinterval1.get(a).get(b).equals(Total_TestCaseSplit.get(a))){
                    
                     weightage++;
                     break;   
                    }
            }
                            
       }
        covered = weightage;
        return weightage; 
     
    }
      public void CheckMaxCoverage (){

      for(int a=0; a < (totalinteractionpairsinterval1.size()) && ( a < (Total_TestCaseSplit.size())) ;a++)
        {
            for (int b=0;b<totalinteractionpairsinterval1.get(a).size();b++){
                
                if (totalinteractionpairsinterval1.get(a).get(b).equals(Total_TestCaseSplit.get(a))){
                    interactionList.remove(totalinteractionpairsinterval1.get(a).get(b));//original interaction pairs delete temp test case
                    tempMatchInteraction.add(totalinteractionpairsinterval1.get(a).get(b));//deleted items
                    totalinteractionpairsinterval1.get(a).remove(b);
                   
                     remain--; 
                    }
            }
            
       }
         if (!tempMatchInteraction.isEmpty()){
         //System.out.println("\nTEST CASES THAT MATCHED WITH INTERACTION PAIRS : ");
        //System.out.println(interaction_list);
         System.out.println("\nTEST CASES THAT WAS REMOVED : ");
         System.out.println(tempMatchInteraction);
         System.out.println("\nTHE INTERACTION PAIRS THAT HAVE LEFT : ");
         if (interactionList.isEmpty()){
             System.out.println("\nCOMPLETED / FULLY COVERED / NO MORE INTERACTION PAIRS WERE LEFT. ");
         }else{
          for (int i=0;i<interactionList.size();i++){
         System.out.println(interactionList.get(i));
         }//one sec please.....received a call...ok
         }
         System.out.println("-----------------------------------------------------------------------\n");
         }
         //interaction_list.removeAll(Collections.singleton(null));//Remove all null values ,left value
         //return remain;
    }
      public ArrayList<Integer> AddFinalList(){ //randomTestCase in ArrayList<Integer> variable
         if(covered==MAX1){
            finalList.add(RandomTestCase);
            
       }else{
           remainTestCaseList.add(RandomTestCase);
       }
        return RandomTestCase;
     }
    
}
