package jp.ac.uryukyu.ie.e205719;

/**
 *  キャラクターのスーパークラス。
 *  String name; //名前
 *  int hitPoint; //HP
 *  int attack; //攻撃力
 *  boolean dead; //生死状態。true=死亡。
 *  Created by tnal on 2016/11/13.
 */
public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;
    private boolean opponentDead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name 名前
     * @param maximumHP HP
     * @param attack 攻撃力
     */
    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        opponentDead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * 攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、wounded()によりダメージ処理を実行。
     * @param e 攻撃対象
     */
    public boolean attack(LivingThing opponent){
        String opponentName = opponent.getName();
        int damage = (int)(Math.random() * attack);
        if(dead == false){
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", this.name, opponentName, damage);
            opponentDead = opponent.wounded(damage);
        }
        return opponentDead;
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public boolean wounded(int damage){
        hitPoint -= damage;
        if( hitPoint <= 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", this.name);
        }
        return dead;
    }

    public boolean isDead(){
        return dead;
    }

    public boolean isOpponentDead(){
        return opponentDead;
    }

    public String getName(){
        return this.name;
    }

    public int getHitPoint(){
        return hitPoint;
    }

}