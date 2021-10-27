/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//No libraries used only what I have created
package MastercardApp;

/**
 *
 * @author Nathan
 */
final class Arrays2d {
    
    private Arrays2d()
    {
        //For creating static class in java.
    }
    
    public static void listMostFreq(int input[][]){
        int count = findHighestCount(input); //Use private method to find highest count
        int arrSize = sortHighestCount(input); //Call function to determine the amount of numbers found with the same highest occurance
        int sortedFreq[][] = new int[arrSize][arrSize]; 
        int singleNum = 0;
        int countedSingle = 0;
        
        int startIndex = 0;   //Creating another indexer incase needed;
        
        //try and catch index out of bounds
        try 
        {
            for(int i = 0; i <= input.length - 1; i++)
            {
                if(input[1][i] == count)
                {
                    if(arrSize == 1)
                    {
                        singleNum = input[0][i];
                        countedSingle = input[1][i];
                        break;
                    }
                    else
                    {
                        sortedFreq[0][startIndex] = input[0][i];
                        sortedFreq[1][startIndex] = input[1][i];
                        startIndex++;
                    }
                }
                //precatuion incase of error to break
                else if( i > input.length || i < 0)
                {
                    break;
                }
            }
            System.out.println("The most frequent number/s are ");        
            for(int i = 0; i <= sortedFreq.length - 1; i++)
            {
                if(arrSize == 1) 
                {
                    System.out.println("Number " + singleNum + " counted " + countedSingle + " times");
                }
                else
                System.out.println("Number/s " + sortedFreq[0][i] + " counted " + sortedFreq[1][i] + " times");
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Index out of bounds in listFreq method " + e);
            e.printStackTrace();
        }
    }
    
    private static int findHighestCount(int input[][]){
        int highestCount = 0;
        for(int i = 0; i <= input.length - 1;i++)
        {
            //traverse the array to find the highest count easier for list most freq method
            if (highestCount < input[1][i])
            {
                highestCount = input[1][i];
            }
            //Safety measure to break incase i goes out of bounds
            if(i < 0 || i > input.length)
            {
                break;
            }
        }
        return highestCount;
    }
    
    private static int sortHighestCount(int input[][]){
        int highestCount = findHighestCount(input);
        int size = 0;
        for(int i = 0; i <= input.length - 1;i++)
        {
            if(highestCount == input[1][i])
            {
                size++; 
            }
        }
        return size;
    }
    
    //Find amount of occurances function
    public static int[][] countArray(int input[])
    {
        //Adding below a new array to sort the list
        int sortedInput[] = new int[input.length];
        //Also adding a counter array to add the counted values
        int counted[] = new int[input.length];
        
        //Creating a 2D array to return and save the counted values.
        int totalCount[][] = new int[input.length][input.length];
        
        //Filling the array with false values. There is easier ways to do this but the assignment specifically asked,
        //No use of existing libraries.
        boolean visited[] = new boolean[input.length];
        for(int i = 0; i <= visited.length - 1; i++)
        {
            visited[i] = false;
        }
        
        int newIndex = 0; //new index for adding to new arrays below.
        int temp = input[0]; //Grab first element
        int count = 0; //inintalize as 0, we will increment first occurance in the loop.
        
        //End of Variables
        
        
        
        //First for loop to find elements.
        for(int i = 0; i<= input.length - 1; i++)
        {
            //We add a second for loop inside to add the values of visited to this array,
           //Then continue will ignore that case.
            if(visited[i] == true)
            {
                continue;
            }
            
            //If visited is false, we then add the new element. As it was not previously counted.
            else 
            {
                temp = input[i];
                sortedInput[i] = temp;
            }
            
            //2nd for loop, this loop is running before i increments, so it searches the list again everytime i++
           //This is where that if continue; comes in very handy, So this searches the list from the start. 
          //Then it will remember indexs by adding them to visited[j] <-- Important j as stated above.
         //because the continue statement is there, this only searches when visited index == false.
        //   
       //Example Array = [10, 5, 10, 4, 3, ,3, 10]; We start at element[0] = 10
      //      Visitied = [true, false, true, false, false, false, true]; 
       
            for(int j = 0; j<=input.length - 1;j++)
            {
                if(input[j] == temp)
                {
                    count++;
                    visited[j] = true;
                }
            }
            sortedInput[newIndex] = temp;
            counted[newIndex] = count;
            System.out.println("Number " + sortedInput[newIndex] + " Counted " + counted[newIndex] + " times");
            count = 0;
            
            newIndex++; //Increment the new index to keep the order for sorting later to remove null or 0 values
        }
        
        //End of loop adding to 2D Array and returning it;
        totalCount[0] = sortedInput;
        totalCount[1] = counted;
        return clean2dArray(totalCount);  //return while also cleaning, removing excess values from declaration size.
    }
    
    
    //Functions that where created for cleaning and removing excess values from array
   //As existing libraries are not able to be used so I am creating my own.
    private static int[][] clean2dArray(int inputArray[][])
    {
        int arrSize = findSizeOf2D(inputArray);
        int newArr[][] = new int[arrSize][arrSize];
        
        for(int i = 0; i <= newArr.length - 1; i++)
        {
            newArr[0][i] = inputArray[0][i];
            newArr[1][i] = inputArray[1][i];
        }
        
        return newArr;
    }
    
    //Method for use of above
    private static int findSizeOf2D(int input[][])
    {
        int count = 0;
        //Loop over the input array and filter by null or 0 value counts, meaning a number was couned 0 times
        for(int i = 0; i <= input.length - 1; i++)
        {
            if(input[1][i] == 0)
            {
                break;
            }
            count++;
        }
        return count;
    
    }
}
