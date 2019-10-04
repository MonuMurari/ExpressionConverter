package com.expressionconverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class convertInfixToPostfix {

    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        
        List<String> values=new ArrayList<>();
        List<String> operator=new ArrayList<>();
        
        System.out.println("Enter any expression in Infix form : ");
        String exp=sc.next();
        
        int countOp=0;
        
        for(int i=0;i<exp.length();i++)
        {
            String ch=Character.toString(exp.charAt(i));
         
            if(ch.matches("[0-9]") || ch.equals("."))
            {
                if(countOp!=0)
                {
                    String prev=values.remove(values.size()-1);
                    String curr=prev+ch;
                    values.add(curr);
                    countOp++;
                }
                else
                {
                    values.add(ch);
                    countOp++;
                }
            }
            else
            {
                int count=0;
                switch(ch)
                {
                    case "+":
                            
                    case "-":
                            countOp=0;
                            if(operator.size()>0)
                            {
                                for(int j=operator.size()-1;j>=0;j--)
                                {
                                    String data=operator.get(j);
                                    if(data.matches("[+*/^\\-]") && count==0)
                                    {
                                        values.add(data);
                                        operator.remove(j);
                                    }
                                    else
                                    {
                                        count--;
                                    }
                                }
                            }
                                operator.add(ch);
                                break;
                    case "*":
                            
                    case "/":
                            countOp=0;
                            if(operator.size()>0)
                            {
                                for(int j=operator.size()-1;j>=0;j--)
                                {
                                    String data=operator.get(j);
                                    if(data.matches("[*/^]") && count==0)
                                    {
                                        values.add(data);
                                        operator.remove(j);
                                    }
                                    else
                                    {
                                        count--;
                                    }
                                }
                             
                            }
                            operator.add(ch);
                                break;
                    case "^":
                            countOp=0;
                            operator.add(ch);
                                break;
                }
            }
        }
        
        for(int i=operator.size()-1;i>=0;i--)
            values.add(operator.get(i));
        
        System.out.println("Converted Infix expression is : ");
        for(String d:values)
        {
            System.out.println(" "+d);
        }
        sc.close();
    }
}