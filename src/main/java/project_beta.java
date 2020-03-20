/*
this program accepts a number (0-127)
and gives the binary code of this number
*/

import java.util.Scanner;
import java.lang.String;

public class project_beta {

    public static Scanner scan = new Scanner(System.in);

    public static int code = 0,  number = 0;
    public static int zero = 1, one = 10, two = 100, three = 1000, four = 10000, five = 100000, six = 1000000;
    public static boolean perevirka_vnutrishnya,perevirka;
    public static byte select;

    public static void main(String[] args) {
        clonMain();
    }
    public static void clonMain(){
        perevirka = true;
        select=0;
        while (perevirka==true){
            recharge();
            perevirka = true;
            perevirka_vnutrishnya=true;
            while (perevirka_vnutrishnya==true){
                System.out.println("please press <<1>> if you want replay or <<0>> if you want end the perevirka");
                select= scan.nextByte();
                if (select==1){
                    perevirka_vnutrishnya = false;
                }
                else if(select==0){
                    perevirka = false;
                    System.out.println("gameover");
                    perevirka_vnutrishnya = false;
                }
                else {
                    perevirka_vnutrishnya = true;
                    System.out.println("error");
                }
            }
        }
    }
    public static void recharge(){
        perevirka = false;
        select = 0;
        while (perevirka==false){
            System.out.println("please select");
            System.out.println("1-is the creation of binary code");
            System.out.println("2-is the creation of number");
            select= scan.nextByte();
            if (select==1 || select==2 ) {
                perevirka = true;
            }
            else {
                System.out.println("error");
            }
        }
        if(select==1){
            catch_number();
            do_code();
            System.out.println("your binary code is " + code);
        }
        else if(select==2){
            catch_code();
            do_number();
            System.out.println("your number is " + number);
        }
    }

    public static void catch_number(){
        perevirka = false;
        while (perevirka==false){
            System.out.println("please write numbe from 0 to 127");
            number = scan.nextInt();
            if (number >=0 && number <=127){
                perevirka = true;
            }
            else {
                System.out.println("error");
            }
        }
    }
    public static void do_code(){
        code = 0;
        while (number != 0){
            if(number >= 64){
                number -= 64;
                code += six;
            }
            else if(number >= 32){
                number -= 32;
                code += five;
            }
            else if(number >= 16){
                number -= 16;
                code += four;
            }
            else if(number >= 8){
                number -= 8;
                code += three;
            }
            else if(number >= 4){
                number -= 4;
                code += two;
            }
            else if(number >= 2){
                number -= 2;
                code += one;
            }
            else if(number >= 1){
                number -= 1;
                code += zero;
            }
        }
    }
    public static void catch_code(){
        perevirka = false;
        while (!perevirka) {
            System.out.println("please write binary code");
            String binary = scan.next();
            String[] binar_char = binary.split("");
            perevirka_vnutrishnya = true;
            for (int x=0;x<binary.length();x++) {
                if (binar_char[x].equals("1") || binar_char[x].equals("0")){
                }
                else {
                    perevirka_vnutrishnya = false;
                }
            }
            if (perevirka_vnutrishnya) {
                perevirka = true;
                code = Integer.parseInt(binary);
            } else {
                System.out.println("error");
            }
        }
    }
    public static void do_number(){
        number = 0;
        while(code != 0){
            if (code >= six) {
                code -= six;
                number += 64;
            }
            else if (code >= five) {
                code -= five;
                number += 32;
            }
            else if (code >= four) {
                code -= four;
                number += 16;
            }
            else if (code >= three) {
                code -= three;
                number += 8;
            }
            else if (code >= two) {
                code -= two;
                number += 4;
            }
            else if (code >= one) {
                code -= one;
                number += 2;
            }
            else{
                code -= zero;
                number += 1;
            }
        }
    }

}
