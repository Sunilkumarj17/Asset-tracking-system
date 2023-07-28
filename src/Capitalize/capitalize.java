/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capitalize;

/**
 *
 * @author abaru
 */
public class capitalize {
    public static String capitalize(String str){
        if(str == null){return "";}
        else{
       char ch1[] = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && ch1[i] != ' ' ||
                ch1[i] != ' ' && ch1[i - 1] == ' ') {
                if (ch1[i] >= 'a' && ch1[i] <= 'z') {
                    ch1[i] = (char)(ch1[i] - 'a' + 'A');
                }
            }
            else if (ch1[i] >= 'A' && ch1[i] <= 'Z')
                ch1[i] = (char)(ch1[i] + 'a' - 'A');           
        }
        String st = new String(ch1);
        return st;
    }
        }
}
