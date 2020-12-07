package jp.ac.uryukyu.ie.e205719;

public class Hero extends LivingThing{

    public Hero(String name, int maximumHP, int attack){
        super(name, maximumHP, attack);
    }

    int hitPoint = getHitPoint();
    boolean dead = isDead();

    @Override
    public boolean wounded(int damage){
        hitPoint -= damage;
        if( hitPoint <= 0 ) {
            dead = true;
            System.out.printf("%sは道半ばで力尽きてしまった。\n", getName());
        }
        return dead;
    }
}