package com.company;

public class Player extends Stats {
    private String playerName;
    private int playerLevel;
    private Weapon weapon;
    private int playerXp;
    private int maxXp;
    private boolean block = false;
    public int tempHp;
    private boolean power=false;

    public String getPlayerName(){
        return this.playerName;
    }
    public int getPlayerLevel(){
        return this.playerLevel;
    }

    public int getWeaponStrength(){
        return weapon.strength;
    }
    public int getWeaponDefense(){
        return weapon.defense;
    }


    public Player(String playerName, int strength,int defense,int hp){
        super(strength,defense,hp);
        this.playerName = playerName;
        this.playerLevel = 1;
        this.playerXp=0;
        this.maxXp=30;
    }

    @Override
    public void statsUp(){
        this.playerLevel += 1;
        this.strength +=3;
        this.defense+=3;
        this.hp+=3;
        this.maxXp =this.maxXp * 2;
        this.playerXp =0;

    }
    @Override
    public void win(){
        this.playerXp += 30;
        weapon.win();
    }
    public void levelUp(){
        if(playerXp == maxXp){
            statsUp();
            System.out.println("LEVEL UP!!");
        }

    }
    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public void attack(Player otherPlayer){
        if(this.power==true ){
            otherPlayer.block = false;
            otherPlayer.tempHp -= ((this.strength + this.weapon.strength)/((otherPlayer.defense+otherPlayer.weapon.defense)/4));
        }
        else if(otherPlayer.block == false){
            otherPlayer.tempHp -= ((this.strength + this.weapon.strength)/((otherPlayer.defense+otherPlayer.weapon.defense)/2));
        }
        else if(otherPlayer.block == true){
            otherPlayer.tempHp -= ((this.strength + weapon.strength)/((otherPlayer.defense+otherPlayer.weapon.defense)));
        }

    }

    public void block(){
        this.block = true;
    }
    public void resetBlock(){
        this.block = false;
    }
    public void powerUp(){
        this.power = true;
        System.out.println("POWER UP!");
    }
    public void resetPower(){
        this.power = false;
    }

}
