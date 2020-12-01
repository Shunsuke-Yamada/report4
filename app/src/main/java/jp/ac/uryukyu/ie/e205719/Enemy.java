package jp.ac.uryukyu.ie.e205719;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name モンスター名
     * @param maximumHP モンスターのHP
     * @param attack モンスターの攻撃力
     */
    public Enemy (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * Heroへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param hero 攻撃対象
     */
    public void attack(Hero hero){
        String hero_name = hero.getName_Hero();
        int damage = (int)(Math.random() * attack);
        if(dead == false){   
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, hero_name, damage);
            hero.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("モンスター%sは倒れた。\n", name);
        }
    }
    /**
     * 敵クラス,privat nameにクラス外からでもアクセスする為のメソッド。
     * クラス外からpuivatメソッドにアクセスできないが、このメソッドを経由することで利用することができる。
     * @param _name 敵の名前
     */
    public void setName_Enemy(String _name){
        this.name = _name; 
    }

    /**
     * 敵クラス,privat nameにクラス外からでも受け取る為のメソッド。
     * クラス外からpuivatメソッドにアクセスできないが、このメソッドを経由することで利用することができる。
     * @return　Enemyクラスのname
     */
    public String getName_Enemy(){
        return this.name;
    }

    /**
     * 敵クラス,privat hitPointにクラス外からでも受け取る為のメソッド。
     * クラス外からpuivatメソッドにアクセスできないが、このメソッドを経由することで利用することができる。
     * @return EnemyクラスのhitPoint
     */
    public int getHitPoint_Enemy(){
        return hitPoint;
    }

    /**
     * 敵クラス,privat deadにクラス外からでも受け取る為のメソッド。
     * クラス外からpuivatメソッドにアクセスできないが、このメソッドを経由することで利用することができる。
     * @return Enemyクラスのdead
     */
    public boolean getDead_Enemy(){
        return dead;
    }
}