/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.*;
/**
 *
 * @author Yousuf Khan
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner input = new Scanner(System.in);
        String[][] data = new String[6][3];
        double[] min_max_total_avg = {0,0,0,0};
                
        //loop 6 times
        for(int i=0; i<6; i++) {
            
            //Get Reg no
            System.out.println("Enter Student "+i+" Reg #");
            String regno_in;
            
            while(true) {
                try{
                    regno_in = input.nextLine();
                    double regno = Double.parseDouble(regno_in);
                    
                    //Check for duplicates
                    if(i>0) {
                        for(int j=0; j<i; j++) {
                            if(data[j][0].equals(regno_in)) {
                                throw new Exception("Duplicate");
                            }
                        }
                    }

                    break;
                }
                catch(Exception e) {
                    System.out.println("Enter VALID Student "+i+" Reg #");

                }
            }
            
            //Get name
            System.out.println("Enter Student "+i+" Name");
            String name = input.nextLine();

//            while(true) {
//                try{
//                    break;
//                } catch(Exception e) {
//                    System.out.println("Enter VALID Student "+i+" Name");
//                }
//            }
            
            //Get CGPA
            System.out.println("Enter Student "+i+" CGPA");
            String cgpa_in;
            
            while(true) {
                try{
                    cgpa_in = input.nextLine();
                    double cgpa = Double.parseDouble(cgpa_in);
                    if(cgpa > 4 || cgpa < 0) {
                        throw new Exception("Invalid CGPA");
                    }
                    
                    if(cgpa < min_max_total_avg[0]) min_max_total_avg[0] = cgpa;
                    else if(cgpa > min_max_total_avg[1]) min_max_total_avg[1] = cgpa; 
                    min_max_total_avg[2] += cgpa;
                    min_max_total_avg[3] = min_max_total_avg[2]/(i+1);
                            
                    break;
                } catch(Exception e) {
                    System.out.println("Enter VALID Student "+i+" CGPA");
                }
            }
            
            data[i][0] = regno_in;
            data[i][1] = name;
            data[i][2] = cgpa_in;
        }
        
        for (int i=0; i<6; i++) {
            if(Double.parseDouble(data[i][2]) < 2) {
                System.out.println("Student Name: "+data[i][0]+" with Gpa: "+data[i][2]);
            }
        }
  
        System.out.println("\n\nSearch for Student:");
        while(true) {
            System.out.println("Student Name:");
            String in = input.nextLine(); 
            
            try{
                boolean flag = false;
                for(int i=0; i<6; i++) {
                    if(data[i][1].equals(in)){
                        flag=true;
                        System.out.println("Student Found:\nCGPA: "+data[i][2]);
                    }
                }
                if(!flag) {
                    throw new Exception("Student Name not found");
                }
            } catch(Exception e) {
                System.out.println("Student Name not found in database.");
            }

            
        }
    }
    
}
