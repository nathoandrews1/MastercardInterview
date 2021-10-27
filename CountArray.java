/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MastercardApp;


/**
 *
 * @author Nathan
 */
public class CountArray {
    //Run method for test
    public static void main(String[] args)
    {
        int array[] = new int[]{1,0,0,1,0,1,3,3,4,2,0,3,1,3,4,4,4,2,2,2};
        
        System.out.println(listArray(array) + "\nThe array above is to be counted.\n");
        
        int arrayCounted[][] = Arrays2d.countArray(array);
        
        //Must be performed on a counted (countArray)
        Arrays2d.listMostFreq(arrayCounted);
    }
    
    //Quick function to list elements for better output reading.
    public static String listArray(int input[])
    {
        int end = input.length - 1;
        String stringedArr = "[";
        for(int i = 0; i<= end; i++)
        {
            if(i == end)
            {
                stringedArr += input[i] + "]";
            }
            else 
                stringedArr += input[i] + ", ";
        }
        return stringedArr;
    }
    /*
    public static void findAmountArrayList(ArrayList<Integer> input) {
        ArrayList<Integer> counted = new ArrayList<Integer>();
        ArrayList<Integer> sortedInput = new ArrayList<Integer>();

        int i = 0;
        int j = 0;
        int temp;
        int count = 0;
        int newIndex;

        while (i <= input.size() - 1) 
        {
            temp = input.get(i);
            count = 0;
            j = 0;
            while (j <= input.size() - 1) 
            {
                if (input.get(j).equals(temp)) 
                {
                    count++;
                }
                j++;
            }
            if( i == 0)
            {
                sortedInput.add(temp);
                counted.add(count);
            }
            else if(!sortedInput.contains(temp) && i > 0)
            {
                sortedInput.add(temp);
                counted.add(count);
            }
            i++;
        }
        
        System.out.println(input);
        System.out.println(sortedInput);
        System.out.println(counted);
    }
    */
}
