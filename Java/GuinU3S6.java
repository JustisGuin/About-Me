import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class GuinU3S6{  
    public static void main(String[] args) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        int[] numberlist = new int[10];
        //evenOddChecker(numberlist);

        System.out.println("Enter list1 size : ");
        int size1= sc.nextInt();
        int[] list1 = new int[size1]; 
       

        System.out.println("Enter Contents ");
        for(int i=0;i<list1.length;i++){
            int contents1= sc.nextInt();
            list1[i] =  contents1;
        }

        System.out.println("Enter list2 size : ");
        int size2= sc.nextInt();
        int[] list2 = new int[size2]; 

        //ERROR It won't allow you to ask for a higher number than the first one
        System.out.println("Enter Contents ");
        for(int i=0;i<list2.length;i++){
            int contents2= sc.nextInt();
            list2[i] =  contents2;
        }
        

        printArray(list1);
        printArray(list2);
        merge(list1, list2);

        
        

       
        
        
    }
    private static void printArray(int[] listy){
        for(int i=0;i<listy.length;i++){
            System.out.print(listy[i]+" ");
        }

     }
     
    
    public static ArrayList<Integer> evenOddChecker(int[] listy){
        ArrayList<Integer> oddandEven = new ArrayList<Integer>();
        //Kai helped me this for statement 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 10 numbers: ");
        for(int i=0;i<10;i++){
            int nums = sc.nextInt();
            listy[i] =nums;
        }
        int even=0;
        int odd = 0;
        //took from other assignment 
        for (int i=0;i<listy.length;i++){
            if (i%2==0){
                even+=1;
                
            }
            
            else{
                odd +=1;
            }
            
        }
        System.out.printf("\nThe number of odd numbers: %d",even);
        System.out.printf("\nThe number of even %d",odd);
        return oddandEven;
        

    }

                //kai helped me with this  
    public static void merge(int[] list1, int[] list2){
        int l1 = list1.length;
        int l2 = list2.length;

         // does not like this :( int[] mergeList= l1 + l2;
         int list3 = l1 + l2;
         int[] mergeList = new int[list3];
        
        for(int i=0;i<l1;i++){
            mergeList[i] = list1[i];

        }
        for(int i=0;i<l2;i++){
            mergeList[i+l1] = list2[i]; // fixed needs to be i+l1 so it doesn't output on top if eachother
        }

        Arrays.sort(mergeList);
        //System.out.printf("\nMerged List: %d",mergeList); does not work with mergeList 
        System.out.println("\nMerged List: ");
        printArray(mergeList);
    

    }
            
    

  
}