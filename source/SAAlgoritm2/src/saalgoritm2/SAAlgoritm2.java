/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saalgoritm2;

import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.Random;
//comment1

/**
 *
 * @author Farzaneh
 */
public class SAAlgoritm2 {
static int n=0;
ArrayList<Integer> array;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SAAlgoritm2 sa= new SAAlgoritm2();
          int a[][]=new int[4][4];
        for (int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                a[j][i]=i+1;
            }
        }
        
        a=sa.GenerateRndomChildren(a);
      //  sa.print(a);
      // System.out.println("row0 number3:   "+sa.checkRow2(a,0, 3) ); 
   
        int x0=sa.EvaluatinFunction(a);
       // System.out.println("x0 = "+x0);
          a=sa.GenerateRndomChildren(a);
          int x2=sa.EvaluatinFunction(a);
          // System.out.println("x2 = "+x2);
          double r2=sa.exponentionalFunction(x2, x0);
         // System.out.println("r = "+r2);
          while(x0>2){
          
            a=sa.GenerateRndomChildren(a);
            int x1=sa.EvaluatinFunction(a);
            if(x1<x0){
                 n++;
              //  System.out.println("x behtar");
               x0=x1;
            }
            if(x1>x0){
                
                double r=sa.exponentionalFunction(x1, x0);
                // System.out.println("r"+r);
                double rnd=Math.random();
               //  System.out.println("rnd"+rnd);
                if(0.8<r){
                    // System.out.println("smaall");
                    x0=x1;
                }
                else{
                  //  System.out.println("ghable continu");
                    continue;
                }
            }
        }
          
  sa.print(a);
          
     
    }
    
    
    public int[][] GenerateRndomChildren(int [][]a){

        
        int  randnum1=(int) (Math.random() * ( 4));
     int randnum2=(int) (Math.random() * ( 4));
     int randnum3=(int) (Math.random() * ( 4));
      int randnum4=(int) (Math.random() * ( 4));
       int number1= a[randnum1][randnum2];
       int number2=a[randnum3][randnum4];
       a[randnum1][randnum2]=number2;
       a[randnum3][randnum4]=number1;
       
           return a;
    }
    
    
        public void print(int [][]a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                System.out.print(" "+a[i][j]);
            }
            System.out.println();
        }
    }
    public int EvaluatinFunction(int a[][]){
        int sum1=checkcloums(a);
        int sum2=checkSquars(a);
        int sum3=checkRows(a);
        int sum=sum1+sum2+sum3; 
        return sum;
    }
    
    
     public int checkcloum(int number,int j,int a[][]){
        int counter=0;
        
       for(int i=0;i<4;i++){
           if(a[i][j]==number){
               counter++;
               
           }  
       }
       if(counter==1){
           counter=0;
       }
       else if(counter>1){
           counter=counter;
       }
  
       return counter;
    }
     
     public int checkcloums(int a[][]){
         int sum=0;
        int counter;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                int temp=a[j][i];
               counter= checkcloum(temp,j,a);
               sum=sum+counter;
            }
        }
        return sum;
     }
     
     
     public int checksquar(int number,int i,int j,int a[][]){
        int counter=0;
       
          i = (i / 2) * 2 ;
          j = (j / 2) * 2 ;

      for( int r = 0; r < 2; r++ )
         for( int c = 0; c < 2; c++ )
         if( a[i+r][j+c] == number ){
             counter++;
         }
         
         if(counter==1){
             counter=0;
         }
         else if(counter>1){
             counter=counter;
         }
         return counter;
    }
     
     public int checkSquars(int a[][]){
        int sum=0;
        int counter;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){   
                int temp=a[i][j];
               counter= checksquar(temp, i, j, a);
               sum=sum+counter;
            }
        }
        return sum/2;
     }
     
     public int checkRow(int number, int i, int j,int [][]a){
          int counter=0;   
        
          for(int p=j;p<a.length;p++){
             if(a[i][p]==number){
                 counter++;
             }
         }
          if(counter==1){
             counter=0;
         }
         else if(counter>1){
             counter=counter;
         }
    //   System.out.println("number"+number       +"counter          "+counter);
         
         return  counter;
     }
     
     public int checkRows(int[][]a){
         int sum=0;
         array = new ArrayList<Integer>();
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                int temp=a[i][j];
                if(checkArray(array, temp)==true){
                    continue;
                }
                else{
               int counter= checkRow(temp, i,j, a);
               array.add(temp);
               sum=sum+counter;
                }
               
            }
            array.clear();
        }

        return sum;
     }
     
     public double exponentionalFunction(int f1, int f0){
         
         int x=f1-f0;
        double a= -0.7;
         double y=(a*x)*n;
         double r=pow(2.7,y);
         return r;
     }
     
     public boolean checkArray(ArrayList<Integer> array,int number){
         boolean state=false;
         for(int i=0;i<array.size();i++){
             if(number==array.get(i)){
                 state=true;
             }
         }
         return state;
     }
     
     
     public int checkFullcolum(int [][]a, int j,int number){
          int sum=0; 
             for(int i=0;i<a.length;i++){
                 int counter=checkcloum(number, j, a);
                 sum+=counter;
             }
             if(sum==1){
                 sum=sum+1;
             }
         return sum;
     }
     
     public int checkRow2(int [][]a, int i, int number){
        int counter=0;
        for(int p=0;p<a.length;p++){
            if(a[i][p]==number){
                counter++;
            }
        }
        return counter;
     }
         
     public int checkFarzand(int [][]a, int i, int j, int number){
         int sum=0;
         int []arrayRow=new int[4];

         arrayRow[0]=checkRow2(a, i, 1);
         arrayRow[1]=checkRow2(a, i, 2);
         arrayRow[2]=checkRow2(a, i, 3);
         arrayRow[3]=checkRow2(a, i, 4);
         int min=500;
         for(int p=0;p<a.length;p++){
             if(arrayRow[p]<min){
                 min= arrayRow[p];
             }
         }
         if(checkRow2(a, i, number)>=2){
             a[i][j]=min;   
         }
       
         return min;
     }
     
}
