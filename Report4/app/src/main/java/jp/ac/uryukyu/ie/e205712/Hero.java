package jp.ac.uryukyu.ie.e205712;

/**
 * ヒーロークラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Hero {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * 自身の名前を返すゲッターメソッド。
     * @return 指定されたStringフィールドの値
     */
    public String getName(){
        return this.name;
    }

    /**
     * 自身のHPを返すゲッターメソッド。
     * @return 指定されたintフィールドの値
     */
    public int getHitPoint(){
        return this.hitPoint;
    }

    /**
     * 自身の攻撃力を返すゲッターメソッド。
     * @return 指定されたintフィールドの値
     */
    public int getAttack(){
        return this.attack;
    }

    /**
     * 自身の死亡判定を返すゲッターメソッド。
     * @return 指定されたbooleanフィールドの値
     */
    public boolean isDead(){
        return this.dead;
    }

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param _name ヒーロー名
     * @param _maximumHP ヒーローのHP
     * @param _attack ヒーローの攻撃力
     */
    public Hero (String _name, int _maximumHP, int _attack) {
        this.setName(_name);
        this.setHitPoint(_maximumHP);
        this.setAttack(_attack);
        this.dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", _name, _maximumHP, _attack);
    }

    /**
     * 自身の名前を設定するセッターメソッド。
     * @param _name String型変数nameに代入する値
     */    
    public void setName(String _name){
        this.name = _name;
    }

    /**
     * 自身のHPを設定するセッターメソッド。
     * @param _maximumHP int型変数hitPointに代入する値
     */    
    public void setHitPoint(int _maximumHP){
        this.hitPoint = _maximumHP;
    }

    /**
     * 自身の攻撃力を設定するセッターメソッド。
     * @param _attack int型変数attackに代入する値
     */
    public void setAttack(int _attack){
        this.attack = _attack;
    }


    /**
     * Enemyへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param e 攻撃対象
     */
    public void attack(Enemy e){
        int damage = (int)(Math.random() * this.getAttack());
        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", this.getName(), e.getName(), damage);
        e.wounded(damage);
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        this.hitPoint -= damage;
        if( this.hitPoint < 0 ) {
            this.dead = true;
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", getName());
        }
    }
}