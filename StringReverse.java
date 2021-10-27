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
public class StringReverse {
    public static void main(String[] args){
        String message = "Mastercard";
        
        String reversed = Strings.reverseString(message);
        System.out.println(message + " reversed without recurssion: " + reversed);
        
        String recursiveReverse = Strings.recursiveReverse(message);
        System.out.println("\nThis is the same String but done recurssively: " + recursiveReverse);
    }
}
