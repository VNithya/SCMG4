/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pairwiseTest;

import java.util.ArrayList;

/**
 *
 * @author Najib Ismail
 */
public class Seeding {
    private ArrayList<ArrayList<Integer>> NewTestCaseList = new ArrayList<ArrayList<Integer>>();
    private ArrayList<ArrayList<Integer>>FinalTestCase=new ArrayList<ArrayList<Integer>>();
    
    //String Seed="1,3,5";
   
    
    public void seed(ArrayList<ArrayList<Integer>> newTestCaseList,int t)
    {
        int in = 0;
        ArrayList<Integer> Aseed = new ArrayList<Integer>();
        Aseed.add(1);
        Aseed.add(3);
        Aseed.add(5);
        while(in<Aseed.size())
        {
            System.out.println(Aseed.get(in));
            in++;
        }
        
        NewTestCaseList=newTestCaseList;
        int i=0;
        while(i<NewTestCaseList.size())
        {
            if(NewTestCaseList.get(i).equals(Aseed))
            {
                System.out.println("seeding");
                System.exit(0);
            }
            else
            {
          //      NewTestCaseList.add(Seed);
                System.out.println("seeding");
            }
           i++; 
        }
    }
    
    
    
}
