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
public class interaction {
    ArrayList<Integer>paraval= new ArrayList<Integer>();
    ArrayList<Integer> parametervalueSymbolic = new ArrayList<Integer>();
    ArrayList<ArrayList<Integer>> parameterval = new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Integer>> interactionList = new ArrayList<ArrayList<Integer>>();
     ArrayList<ArrayList<ArrayList<Integer>>> total_interactionpairs_interval1 = new ArrayList<ArrayList<ArrayList<Integer>>>();
     ArrayList<ArrayList<ArrayList<Integer>>> total_interactionpairs_interval2 = new ArrayList<ArrayList<ArrayList<Integer>>>();
    int parameterNo1;
    int parameterNo2;
    int count;
    int total;
    
     public void t2(ArrayList<Integer>Paraval,int parameterno)
     {
         
        paraval=Paraval;
       // constraint=Constraint;
        parameterNo1=parameterno;
        parameterNo2=parameterno;
        
        int symbolicNumber = 0;
        System.out.println("\n");
        
        for (int row = 0; row < paraval.size(); row++) {
            ArrayList<Integer> rowvalue = new ArrayList<Integer>();
            System.out.println("SymbolicValue for "+(paraval.get(row))+" Values of Parameter " + (row + 1) + " is ");
            for (int column = 0; column < paraval.get(row); column++) {
                rowvalue.add(symbolicNumber);
                parametervalueSymbolic.add(symbolicNumber);
                System.out.println(rowvalue.get(column));
                symbolicNumber++;
            }
            parameterval.add(rowvalue);
        }
        
        
        int number = 1;

        ///System.out.println("Parameter Values Pair");
        for (int w = 0; w < parameterval.size() - 1; w++) {
            for (int x = w + 1; x <parameterval.size(); x++) {
                  ArrayList<ArrayList<Integer>> total_interactionpair = new ArrayList<ArrayList<Integer>>();
                for (int y = 0; y < parameterval.get(w).size(); y++) {
                    for (int z = 0; z < parameterval.get(x).size(); z++) {      
                   ArrayList<Integer> interactionpair = new ArrayList<Integer>();
                       //System.out.println("ParameterValue Interaction Pair " + number + " : " + parameterval.get(w).get(y) + " , " + parameterval.get(x).get(z));
                        number++;
                        count += 1;
                        for (int i = 0; i < 1; i++) {

                             interactionpair.add(parameterval.get(w).get(y));
                             interactionpair.add(parameterval.get(x).get(z));     
                        }
                        total_interactionpair.add(interactionpair);
                        interactionList.add(interactionpair);
                         
                    }
                    
                }
                total_interactionpairs_interval1.add(total_interactionpair);
               //System.out.println("Interaction: "+total_interactionpair_each_parameter);
            }
        }
        
        total = count;
        System.out.println("\nTotal Interaction Pairs Generated:"+count);
        if(count!=0)
        {
            System.out.println("\nInteraction pairs");
            for(int i=0;i<total_interactionpairs_interval1.size();i++)
            {
                 System.out.println(total_interactionpairs_interval1.get(i));
            }
        } else{}
        

     }
     public void t3(ArrayList<Integer>Paraval,int parameterno)
     {
          int symbolicNumber = 0;
        System.out.println("\n");
        for (int row = 0; row < paraval.size(); row++) {
            ArrayList<Integer> rowvalue = new ArrayList<Integer>();
            //System.out.println("SymbolicValue for "+(paraval.get(row))+" Values of Parameter " + (row + 1) + " is ");
            for (int column = 0; column < paraval.get(row); column++) {
                rowvalue.add(symbolicNumber);
                parametervalueSymbolic.add(symbolicNumber);
                System.out.println(rowvalue.get(column));
                symbolicNumber++;
            }
            parameterval.add(rowvalue);
            
             int number = 1;
        ///System.out.println("Parameter Values Pair");
        for (int a = 0; a < parameterval.size() - 3; a++) {
            for (int b = a + 1; b < parameterval.size() - 2; b++) {
                for (int c = b + 1; c < parameterval.size() - 1; c++) {
                    for (int d = c + 1; d < parameterval.size(); d++) {
                        ArrayList<ArrayList<Integer>> total_interactionpair = new ArrayList<ArrayList<Integer>>();
                        for (int e = 0; e < parameterval.get(a).size(); e++) {
                            for (int f = 0; f < parameterval.get(b).size(); f++) {
                                for (int g = 0; g < parameterval.get(c).size(); g++) {
                                    for (int h = 0; h < parameterval.get(d).size(); h++) {
                                        ArrayList<Integer> interactionpair = new ArrayList<Integer>();
                                        ///System.out.println("ParameterValue Interaction Pair " + number + " : " + parametervalue.get(a).get(e) + " , " + parametervalue.get(b).get(f) + " , " + parametervalue.get(c).get(g) + " , " + parametervalue.get(d).get(h));
                                        number++;
                                        count += 1;
                                        for (int i = 0; i < 1; i++) {
                                            interactionpair.add(parameterval.get(a).get(e));
                                            interactionpair.add(parameterval.get(b).get(f));
                                            interactionpair.add(parameterval.get(c).get(g));
                                            interactionpair.add(parameterval.get(d).get(h));
                                        }
                                        total_interactionpair.add(interactionpair);
                                        interactionList.add(interactionpair);
                                    }
                                }

                            }
                        }
                        total_interactionpairs_interval1.add(total_interactionpair);
                    }
                }
            }
        }
        
        total = count;
        System.out.println("\nTotal Interaction Pairs Generated :"+count);
        if(count!=0)
        {
            System.out.println("\nInteraction pairs");
            for(int i=0;i<total_interactionpairs_interval1.size();i++)
            {
                 System.out.println(total_interactionpairs_interval1.get(i));
            }
        } else{}
        
        }
     }
     public void t4(ArrayList<Integer>Paraval,int parameterno)
     {
         int symbolicNumber = 0;
        System.out.println("\n");
        for (int row = 0; row < paraval.size(); row++) {
            ArrayList<Integer> rowvalue = new ArrayList<Integer>();
            System.out.println("SymbolicValue for "+(paraval.get(row))+" Values of Parameter " + (row + 1) + " is ");
            for (int column = 0; column < paraval.get(row); column++) {
                rowvalue.add(symbolicNumber);
                parametervalueSymbolic.add(symbolicNumber);
                System.out.println(rowvalue.get(column));
                symbolicNumber++;
            }
            parameterval.add(rowvalue);
            
             int number = 1;
        ///System.out.println("Parameter Values Pair");
        for (int a = 0; a < parameterval.size() - 3; a++) {
            for (int b = a + 1; b < parameterval.size() - 2; b++) {
                for (int c = b + 1; c < parameterval.size() - 1; c++) {
                    for (int d = c + 1; d < parameterval.size(); d++) {
                        ArrayList<ArrayList<Integer>> total_interactionpair = new ArrayList<ArrayList<Integer>>();
                        for (int e = 0; e < parameterval.get(a).size(); e++) {
                            for (int f = 0; f < parameterval.get(b).size(); f++) {
                                for (int g = 0; g < parameterval.get(c).size(); g++) {
                                    for (int h = 0; h < parameterval.get(d).size(); h++) {
                                        ArrayList<Integer> interactionpair = new ArrayList<Integer>();
                                        ///System.out.println("ParameterValue Interaction Pair " + number + " : " + parametervalue.get(a).get(e) + " , " + parametervalue.get(b).get(f) + " , " + parametervalue.get(c).get(g) + " , " + parametervalue.get(d).get(h));
                                        number++;
                                        count += 1;
                                        for (int i = 0; i < 1; i++) {
                                            interactionpair.add(parameterval.get(a).get(e));
                                            interactionpair.add(parameterval.get(b).get(f));
                                            interactionpair.add(parameterval.get(c).get(g));
                                            interactionpair.add(parameterval.get(d).get(h));
                                        }
                                        total_interactionpair.add(interactionpair);
                                        interactionList.add(interactionpair);
                                    }
                                }

                            }
                        }
                        total_interactionpairs_interval1.add(total_interactionpair);
                    }
                }
            }
        }
        
        total = count;
        System.out.println("\nTotal Interaction Pairs Generated :"+count);
        if(count!=0)
        {
            System.out.println("\nInteraction pairs");
            for(int i=0;i<total_interactionpairs_interval1.size();i++)
            {
                 System.out.println(total_interactionpairs_interval1.get(i));
            }
        } else{}
        }
     }
        
    
     public ArrayList<ArrayList<Integer>> getParametervalue(){
        return parameterval;
    }
    
    public  ArrayList<ArrayList<ArrayList<Integer>>> getTotal_interactionpair_interval1(){
        return total_interactionpairs_interval1;
    }
    
     public  ArrayList<ArrayList<ArrayList<Integer>>> getTotal_interactionpair_interval2(){
        return total_interactionpairs_interval2;
    }
    
    public ArrayList<ArrayList<Integer>> getInteractionList() {
            return interactionList;
    }
    
    public int getCount() {
            return count;
    }
    


}
