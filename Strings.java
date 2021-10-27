/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//As can see no libraries are imported just default java.
package MastercardApp;

/**
 *
 * @author Nathan
 */
final class Strings {
    private Strings(){
        //static class for java, declare class as final and make constructor private.
    }
    
    //Reversing an array starting at the end of the string to the start
    //Adding each character of the string to a char array
    public static String reverseString(String input)
    {
        char[] charArray = new char[input.length()];
        String reversed = "";
        
        for(int i = input.length() - 1; i >= 0; i--)
        {
            charArray[i] = input.charAt(i);
            reversed += charArray[i];
        }
        return reversed;
    }
    
    //I had learnt this method a long time ago in 2nd year.
    //we use substring to remove the first element
    //we use charAt to add the first element also at  the end of the string
    //So we remove the first element and add it at the back at the same time
    public static String recursiveReverse(String input){
        //When we have reached only the last element 1, we return the new input
        if(input.length() <= 1)
        {
            return input;
        }
        //Recursive/self call of method
        return recursiveReverse(input.substring(1)) + input.charAt(0);
    }
}
