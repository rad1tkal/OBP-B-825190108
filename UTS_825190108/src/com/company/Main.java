package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        String input;
        Scanner scan = new Scanner(System.in);
        User pemain = new User();
        while (true) {
            System.out.println("==========");
            System.out.println("   Menu   ");
            System.out.println("==========");
            System.out.println("[1] Create Player");
            System.out.println("[2] Battle");
            System.out.println("[3] Weapon Enhancement");
            System.out.println("[4] List Player");
            System.out.println("[0] Exit");
            System.out.print("pilih aksi : ");
            input = scan.nextLine();
            if (input.equalsIgnoreCase("1")) {
                pemain.create();
            }
            if (input.equalsIgnoreCase("2")) {
                pemain.battle();
            }
            if (input.equalsIgnoreCase("3")) {
                pemain.enhance();
            }
            if (input.equalsIgnoreCase("4")) {
                pemain.listPlayer();
            }
            if (input.equalsIgnoreCase("0")) {
                System.exit(0);
            }

        }
    }
}
