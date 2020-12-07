import jp.ac.uryukyu.ie.e205719.*;

public class Main{
    public static void main(String[] args){
        
        LivingThing hero = new Hero("勇者",10 ,5);
        LivingThing enemy = new Enemy("スライム", 6, 5);

        String heroName = hero.getName();
        String enemyName = enemy.getName();
        boolean heroDead = hero.isDead();
        boolean enemyDead = enemy.isDead();

        System.out.printf("%s vs. %s\n", heroName, enemyName);

        int turn = 0;
        while((heroDead == false) && (enemyDead == false)){
            turn++;
            System.out.printf("%dターン目開始！\n", turn);
            if(heroDead == false){
                enemyDead =  hero.attack(enemy);
            }
            if(enemyDead == false){
                heroDead = enemy.attack(hero);
            }
            
            //heroDead = hero.isDead();
            //System.out.println(heroDead);
            //enemyDead = enemy.isDead();
            //System.out.println(enemyDead);
        }
        System.out.println("戦闘終了");
    }
}