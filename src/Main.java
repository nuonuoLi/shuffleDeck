import entity.Deck;
import shuffleDeck.FisherYates;
import shuffleDeck.Shuffle;

public class Main {

    public static void main(String[] args) {
        String[] name={"方块","梅花","红桃","黑桃"};
        String[] num={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        Shuffle sh=new FisherYates();
        Deck[] arr=new Deck[52];
        for(int i=0;i<name.length;i++){
            for(int j=0;j<num.length;j++){
                arr[i*num.length+j]=new Deck(name[i],num[j]);
            }
        }
        for(Deck a:arr){
            System.out.print(a);
        }
        System.out.println();
        sh.shuffle(arr);
        for(Deck a:arr){
            System.out.print(a);
        }
    }
}
