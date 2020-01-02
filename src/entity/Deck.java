package entity;

import java.util.Objects;

/**
 * 扑克牌实体
 */
public class Deck {
    private String name;  //方块，梅花，红桃，黑桃
    private String num;   //A，2，3，4，5，6，7，8，9，10，J，Q, K

    public Deck(String name, String num) {
        this.name = name;
        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "name='" + name + '\'' +
                ", num='" + num + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deck deck = (Deck) o;
        return Objects.equals(name, deck.name) &&
                Objects.equals(num, deck.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, num);
    }
}
