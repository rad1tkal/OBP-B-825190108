package com.company;

public class Weapon extends Stats {
    private String weaponName;
    private int weaponEv;
    public Weapon(String weaponName,int strength, int defense){
        super(strength, defense);
        this.weaponName = weaponName;
        this.weaponEv= 0;
    }
    public String getWeaponName(){
        return this.weaponName;
    }
    public int getWeaponEv(){
        return this.weaponEv;
    }


    @Override
    public void statsUp(){
        this.weaponEv -= 15;
        this.strength += 2;
        this.defense += 2;
    }
    @Override
    public void win(){
        this.weaponEv += 15;
    }





}


