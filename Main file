/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pairwiseTest;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

/**
 * @author Najib Ismail
 */
public class Main {

    private static ArrayList<ArrayList<Integer>> newTestCaseList = new ArrayList<ArrayList<Integer>>();
    private static ArrayList<ArrayList<Integer>> finalList = new ArrayList<ArrayList<Integer>>();
    private static ArrayList<ArrayList<Integer>> remainTestCaseList = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) {

        String[] intervals = {"First"};//, "Second"};

        Scanner sc = new Scanner(System.in);
        for (String interval : intervals) {
            try {
                ArrayList<Integer> noparalist = new ArrayList<Integer>();
                ArrayList<Integer> parameterval = new ArrayList<Integer>();
                ArrayList<Integer> Constraintsval = new ArrayList<Integer>();
                ArrayList<Integer> Seeding = new ArrayList<Integer>();

                ArrayList<Integer> constr_1 = new ArrayList<Integer>();
                ArrayList<Integer> constr_2 = new ArrayList<Integer>();

                ArrayList<Integer> iorpair = new ArrayList<Integer>();
                ArrayList<Integer> iorpair_second = new ArrayList<Integer>();
                
                ArrayList<Integer> seeding_1 = new ArrayList<Integer>();
                ArrayList<Integer> seeding_2 = new ArrayList<Integer>();

                ArrayList<Integer> interactionpairTemp = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> total_interactionpairTemp = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<ArrayList<Integer>>> total_interactionpairs_interval1Temp = new ArrayList<ArrayList<ArrayList<Integer>>>();
        ArrayList<ArrayList<Integer>> interactionListTemp = new ArrayList<ArrayList<Integer>>();
                int parameterno;
                int parameterValue;
                int t;
                int constraints;
                int seeding;
                interaction interact = new interaction();

                //First Interval Parameters (Edited Version)
                System.out.println("Enter number of Parameter for " + interval + " Interval: ");
                parameterno = Integer.parseInt(sc.nextLine());
                noparalist.add(parameterno);

                for (int i = 0; i < parameterno; i++) {   //First Interval Parameters Values (Edited Version)
                    System.out.println("Enter Parameter value " + i + ":");
                    parameterValue = Integer.parseInt(sc.nextLine());
                    parameterval.add(parameterValue);
                }

               
                //HOW TO MAKE CODE ACCPET BIGGER NUMBER OF STRENGTH
                System.out.println("\nEnter number of Strength for First Interval : ");

                t = Integer.parseInt(sc.nextLine());

                if (t == 2) {
                    interact.t2(parameterval, parameterno);
                } else if (t == 3) {
                    interact.t3(parameterval, parameterno);
                } else if (t == 4) {
                    interact.t4(parameterval, parameterno);
                } else {
                    System.out.println("\n!!!The interaction strength(t) that has been entered is not supported.!!!\n");
                    System.exit(0);
                }
                
                
                
        
                System.out.println("\nEnter number of Constraints");
                int noConstraints = Integer.parseInt(sc.nextLine());
                for (int k = 0; k < noConstraints; ++k) {
                    System.out.println("Enter constraint no " + new Integer(k + 1).toString() + " (in a:b form) ");
                    StringTokenizer st = new StringTokenizer(sc.nextLine(), ":");
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    constr_1.add(a);
                    constr_2.add(b);
                }

                
                
            System.out.println("\nEnter number of Seedings");
                int seedings = Integer.parseInt(sc.nextLine());
                for (int k = 0; k < seedings; ++k) {
                    System.out.println("Enter Seedings no " + new Integer(k + 1).toString() + " (in a:b form) ");
                    StringTokenizer st = new StringTokenizer(sc.nextLine(), ":");
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    seeding_1.add(a);
                    seeding_2.add(b);
                }
                
                System.out.println("\nEnter IOR parameters (in a:b (or a:b:c:.... form)");

           // for (int k = 0; k < 1; ++k) {
                 StringTokenizer st = new StringTokenizer(sc.nextLine(), ":");
                 while(st.hasMoreTokens()) {
                    int a = Integer.parseInt(st.nextToken());
                   // int b = Integer.parseInt(st.nextToken());
                    iorpair.add(a);
                  //  iorpair_2.add(b);
                 }
           // }

           for(int _i : iorpair) {
                ArrayList<Integer> ior1 = interact.parameterval.get(_i - 1);
                System.out.println("\nSymbolic Value for first parameter" + _i);
                for (int _ior1 : ior1) {
                    System.out.println(_ior1);
                }
           }
           
            System.out.println("\nInteraction pairs");
            System.out.print("[");
            ArrayList<Integer> ior1 = interact.parameterval.get(iorpair.get(0) - 1);
            for (int _ior1 : ior1) {
                for(int k = 1; k < iorpair.size(); ++k) {
                    ArrayList<Integer> ior2 = interact.parameterval.get(iorpair.get(k) - 1);
                for (int _ior2 : ior2) {
                    System.out.print("[" + _ior1 + "," + _ior2 + "]");
                   
                    interactionpairTemp.add(_ior1);
                    interactionpairTemp.add(_ior2);
                    total_interactionpairTemp.add(interactionpairTemp);
                }   
                }
                
                interactionListTemp.add(interactionpairTemp); 
            }
            total_interactionpairs_interval1Temp.add(total_interactionpairTemp);
            System.out.println("]");
                
                

                int a = 0;
                int sum = 0;

                Randomized ran;
                ran = new Randomized(parameterno, t, interact.parameterval, interact.total_interactionpairs_interval1, interact.interactionList);
                if (!interact.total_interactionpairs_interval1.isEmpty()) {
                    do {
                        ran = new Randomized(parameterno, t, interact.parameterval, interact.total_interactionpairs_interval1, interact.interactionList);
                        //random.randomPick();
                        ArrayList<Integer> b_arr = new ArrayList<>();
                        ArrayList<Integer> rand_arr = ran.randomPick();
                        for (Integer rand_b : rand_arr) {
                            b_arr.add(rand_b);   
                        }
                        newTestCaseList.add(a, b_arr);//[0] [2,3,6,8]

                        int x = ran.covered;

                        if (x == ran.MAX1) {
                            finalList.add(ran.AddFinalList());
                        } else {
                            remainTestCaseList.add(ran.AddFinalList());
                        }

                        sum += x;
                        a++;
                    } while (sum < interact.count);

                    for (int b = 0; b < newTestCaseList.size(); b++) //check for constraints
                    {
                        ArrayList<Integer> pairs = newTestCaseList.get(b);
                        int _a = pairs.get(0);
                        for(int j = 1; j < newTestCaseList.get(b).size(); ++j) {
                            int _b =pairs.get(j);
                            if(isConstraint(constr_1, constr_2, _a, _b)) {
                                System.out.println("Remove constraint ["+ _a + "," + _b + "]" );
                                newTestCaseList.get(b).remove(j);
                            }
                        }
                    }
                    
                    // anything from IOR pair we have to add?
                     //interact.interactionList
                   
                     for (int k = 0; k < seeding_1.size(); ++k) {
                        ArrayList<Integer> b_arr_ior = new ArrayList<>();
                        System.out.println("Add Seedings [" + seeding_1.get(k) + "," + seeding_2.get(k) + "]");
                        b_arr_ior.add(seeding_2.get(k));
                        newTestCaseList.add(seeding_1.get(k), b_arr_ior);//[0] [2,3,6,8]
                    }
                    
                     
                     
                     
                    for (int b = 0; b < newTestCaseList.size(); b++) //remove redundant data in newTestCaseList
                    {
                        for (int j = b + 1; j < newTestCaseList.size(); j++) {
                            if (newTestCaseList.get(b).equals(newTestCaseList.get(j))) {
                                newTestCaseList.remove(j--);
                            }
                        }
                    }

                    ArrayList<ArrayList<Integer>> rArrList = new ArrayList<ArrayList<Integer>>();
                    ArrayList<Integer> ra2 = new ArrayList<Integer>();

                    for (int num = 0; num < newTestCaseList.size(); num++) {
                        System.out.println("\nTEST CASES  " + (num + 1) + "  :  " + newTestCaseList.get(num));

                        String strTestCase = newTestCaseList.get(num).toString();  // array list convert to string

                        System.out.println(strTestCase);

                       
                    }

                }
                    
            } catch (Exception e) {
                System.out.println("Error");
            }

        }
    }

    public static boolean isConstraint(ArrayList<Integer> a_arr, ArrayList<Integer> b_arr, Integer a, Integer b) {
        boolean constraint = false;

        for (int i = 0; i < a_arr.size(); ++i) {
            if (a_arr.get(i) == a && b_arr.get(i) == b) {
                constraint = true;
            }
        }
        return constraint;
    }
}
