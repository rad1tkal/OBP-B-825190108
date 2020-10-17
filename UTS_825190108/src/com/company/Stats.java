package com.company;

public abstract class Stats {
    protected int strength;
    protected int defense;
    protected int hp;

    public Stats(){
        this(1,1,1);
    }

    public Stats(int strength, int defense, int hp){
        this.strength = strength;
        this.defense = defense;
        this.hp = hp;
    }
    public Stats(int strength, int defense) {
        this.strength = strength;
        this.defense = defense;
    }
    public int getStrength(){
        return this.strength;
    }
    public int getDefense(){
        return this.defense;
    }
    public int getHp(){
        return this.hp;
    }

    public abstract void statsUp();
    public abstract void win();


}
