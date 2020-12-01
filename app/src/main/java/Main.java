import jp.ac.uryukyu.ie.e205719.*;

public class Main{
    public static void main(String[] args){
        
        Hero hero = new Hero("勇者", 10, 5);
        Enemy enemy = new Enemy("スライム", 6, 3);
        
        hero.setName_Hero("勇者");
        String hero_name = hero.getName_Hero();
        enemy.setName_Enemy("スライム");
        String enemy_name = enemy.getName_Enemy();
        boolean hero_dead = hero.getDead_Hero();
        boolean enemy_dead = enemy.getDead_Enemy();

        System.out.printf("%s vs. %s\n", hero_name, enemy_name);

        int turn = 0;
        while( hero_dead == false && enemy_dead == false ){
            turn++;
            System.out.printf("%dターン目開始！\n", turn);
            hero.attack(enemy);
            enemy.attack(hero);
            hero_dead = hero.getDead_Hero();
            enemy_dead = enemy.getDead_Enemy();    
        }
        System.out.println("戦闘終了");
    }
}