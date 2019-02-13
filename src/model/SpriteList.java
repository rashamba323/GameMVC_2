package model;

import java.util.ArrayList;

public class SpriteList {

    ArrayList<String> listKaktusRight = new ArrayList<>();
    ArrayList<String> listKaktusLeft = new ArrayList<>();
    ArrayList<String> listKaktusRight2 = new ArrayList<>();
    ArrayList<String> listKaktusLeft2 = new ArrayList<>();

    ArrayList<String> listBirdLeft = new ArrayList<>();
    ArrayList<String> listBirdRight = new ArrayList<>();

    public int i_animL;
    public int i_animR;
    public String sr;
    public String sl;

    public int i_animL2;
    public int i_animR2;
    public String sr2;
    public String sl2;

    public int i_animLG;
    public int i_animRG;
    public String srG;
    public String slG;

    Sprite sprite = new Sprite();



    public void setLits(){
        listKaktusLeft.add("Kaktus.png");
        listKaktusLeft.add("Kaktus2.png");

        listKaktusRight.add("KaktusRight.png");
        listKaktusRight.add("KaktusRight2.png");

        listKaktusLeft2.add("KaktusBanditLeft.png");
        listKaktusLeft2.add("KaktusBanditLeft2.png");

        listKaktusRight2.add("KaktusBanditRight.png");
        listKaktusRight2.add("KaktusBanditRight2.png");

        listBirdLeft.add("GolubLeft.png");
        listBirdLeft.add("GolubLeft2.png");

        listBirdRight.add("GolubRight.png");
        listBirdRight.add("GolubRight2.png");
    }

    public Sprite animateLeft(Sprite hero){
        i_animL++;
        if (i_animL>=listKaktusLeft.size()) i_animL =0;
        sl = listKaktusLeft.get(i_animL);
        return hero = sprite.getSprite(sl);
    }

    public Sprite animateRight(Sprite hero){
        i_animR++;
        if (i_animR>=listKaktusRight.size()) i_animR =0;
        sr = listKaktusRight.get(i_animR);
        return hero = sprite.getSprite(sr);
    }
    public Sprite animateLeft2(Sprite hero2){
        i_animL2++;
        if (i_animL2>=listKaktusLeft2.size()) i_animL2 =0;
        sl2 = listKaktusLeft2.get(i_animL2);
        return hero2 = sprite.getSprite(sl2);
    }

    public Sprite animateRight2(Sprite hero2){
        i_animR2++;
        if (i_animR2>=listKaktusRight2.size()) i_animR2 =0;
        sr2 = listKaktusRight2.get(i_animR2);
        return hero2 = sprite.getSprite(sr2);
    }

    public Sprite animateRightGolub(Sprite sprite){
        i_animRG++;
        if (i_animRG>=listBirdRight.size()) i_animRG =0;
        srG = listBirdRight.get(i_animRG);
        return sprite = sprite.getSprite(srG);
    }

    public Sprite animateLeftGolub(Sprite sprite){
        i_animLG++;
        if (i_animLG>=listBirdLeft.size()) i_animLG =0;
        slG = listBirdLeft.get(i_animLG);
        return sprite = sprite.getSprite(slG);
    }
}
