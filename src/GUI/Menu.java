/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import java.util.Scanner;
@SuppressWarnings("resource")

/**
 *
 * @author duykhanh
 */
public class Menu {
    public static int getChoice(ArrayList<String> options){
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i+1) + " - " + options.get(i));
        }
        System.out.print("Choice 1.. " + options.size() + ": ");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }

    public static int getChoice(Object[] options){
        for (int i = 0; i < options.length; i++) {
            System.out.println((i+1) + " - " + options[i]);
        }
        System.out.print("Choice 1.. " + options.length + ": ");
        Scanner sc = new Scanner(System.in);
        boolean flag;
        int choice = 0;
        do {
            try {
                choice = Integer.parseInt(sc.nextLine());
                if(choice > options.length || choice < 1) throw new Exception();
                else flag = true;
            } catch (Exception e) {
                System.out.print("You must enter valid choice. Try again [1 - " + options.length + "]: ");
                flag = false;
            }
        } while (!flag);
        return choice;
    }
}
