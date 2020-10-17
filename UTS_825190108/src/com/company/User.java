package com.company;
import java.util.Scanner;
public class User implements Menu{
    String nama,namaWeapon;
    int strength, defense, hp;
    int index1,index2,index, i = 0;
    int aksi;
    Player[] p = new Player[10];
    Weapon[] w = new Weapon[10];
    Scanner sc = new Scanner(System.in);
    Scanner scan = new Scanner(System.in);
    @Override
    public void create(){
        System.out.println("Masukan Nama Player: ");
        nama = sc.nextLine();
        System.out.println("Masukan nama weapon : ");
        namaWeapon = sc.nextLine();
        System.out.println("Masukan Stats Player(max 15) : ");
        System.out.println("Masukan Strength: ");
        strength = scan.nextInt();
        System.out.println("Masukan Defense: ");
        defense = scan.nextInt();
        System.out.println("Masukan Health points: ");
        hp = scan.nextInt();
        if ((strength + defense + hp) > 15) {
            System.out.println("Stats melebihi limit");
        }
        else if(hp<=0){
            System.out.println("HP tidak boleh 0");
        }
        else {
            i++;
            p[i] = new Player(nama, strength, defense, hp);
            w[i] = new Weapon(namaWeapon,3,3);
            p[i].setWeapon(w[i]);
        }
    }

    @Override
    public void battle(){
        if (i==0){
            System.out.println("Harap membuat player terlebih dahulu.");
        }
        else {
            System.out.println("pilih player 1: ");
            for(int n=1; n<=i;n++){
                System.out.println("["+n+"]"+p[n].getPlayerName()+ " Lv:"+p[n].getPlayerLevel());
            }
            index1 = sc.nextInt();
            System.out.println("pilih player 2: ");
            for(int n=1; n<=i;n++){
                System.out.println("["+n+"]"+p[n].getPlayerName()+ " Lv:"+p[n].getPlayerLevel());
            }
            index2 = sc.nextInt();
            p[index1].tempHp = p[index1].getHp();
            p[index2].tempHp = p[index2].getHp();

            while(p[index1].tempHp>0 && p[index2].tempHp>0) {
                System.out.println("Player 1's turn: ");
                System.out.println(p[index1].getPlayerName() + " Lv:" + p[index1].getPlayerLevel() + " HP:" + p[index1].tempHp);
                System.out.println("[1] Attack");
                System.out.println("[2] Block");
                System.out.println("[3] Power Up");
                System.out.println("[4] Heal");
                System.out.println("Action : ");
                aksi = sc.nextInt();
                if (aksi == 1) {
                    p[index1].attack(p[index2]);
                    p[index1].resetPower();
                } else if (aksi == 2) {
                    p[index1].block();
                }
                else if (aksi == 3) {
                    p[index1].powerUp();
                }
                else if (aksi == 4) {
                    p[index1].tempHp+=2;
                }
                p[index2].resetBlock();
                if (p[index2].tempHp<=0){
                    System.out.println(p[index1].getPlayerName()+" WIN!");
                    p[index1].win();
                    p[index1].levelUp();
                    break;
                }
                System.out.println("Player 2's turn: ");
                System.out.println(p[index2].getPlayerName() + " Lv:" + p[index2].getPlayerLevel() + " HP:" + p[index2].tempHp);
                System.out.println("[1] Attack");
                System.out.println("[2] Block");
                System.out.println("[3] Power Up");
                System.out.println("[4] Heal");
                System.out.println("Action : ");
                aksi = sc.nextInt();
                if (aksi == 1) {
                    p[index2].attack(p[index1]);
                    p[index2].resetPower();
                } else if (aksi == 2) {
                    p[index2].block();
                }
                else if (aksi == 3) {
                    p[index2].powerUp();
                }
                else if (aksi == 4) {
                    p[index2].tempHp+=2;
                }
                p[index1].resetBlock();
                if (p[index1].tempHp<=0){
                    System.out.println(p[index2].getPlayerName()+" WIN!");
                    p[index2].win();
                    p[index2].levelUp();
                    break;
                }
            }
        }
    }

    @Override
    public void enhance(){
        if (i==0){
            System.out.println("Harap membuat player terlebih dahulu.");
        }
        else {
            System.out.println("pilih player : ");
            for (int n = 1; n <= i; n++) {
                System.out.println("[" + n + "]" + p[n].getPlayerName() + " Lv:" + p[n].getPlayerLevel());
            }
            index = sc.nextInt();
            if(w[index].getWeaponEv()<15){
                System.out.println("Effort value tidak mencukupi!");
            }
            else {
                w[index].statsUp();
                System.out.println("Enhance Successful!");
            }
        }
    }

    @Override
    public void listPlayer(){
        if (i==0){
            System.out.println("Harap membuat player terlebih dahulu.");
        }
        else {
            for (int n = 1; n <= i; n++) {
                System.out.println("[" + n + "]" + p[n].getPlayerName() + " Lv:" + p[n].getPlayerLevel());
                System.out.println("Weapon : " + w[n].getWeaponName() + ", Weapon STR: " + p[n].getWeaponStrength() + ", Weapon DEF: " + p[n].getWeaponDefense());
                System.out.println("Strength : " + p[n].getStrength());
                System.out.println("Defense : " + p[n].getDefense());
                System.out.println("HP : " + p[n].getHp());
            }
        }
    }




}
