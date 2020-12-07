package jp.ac.uryukyu.ie.e205719;

public class Enemy extends LivingThing{

    public Enemy(String name, int maximumHP, int attack){
        super(name, maximumHP, attack);
    }

    int hitPoint = getHitPoint();
    boolean dead = isDead();

    @Override
    public boolean wounded(int damage){
        hitPoint -= damage;
        if( hitPoint <= 0 ) {
            dead = true;
            System.out.printf("モンスター%sは倒れた。\n", getName());
        }
        return dead;
    }
}