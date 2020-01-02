import entity.Deck;
import shuffleDeck.FisherYates;
import shuffleDeck.Shuffle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Deck,Integer> map=new HashMap<>();
        Deck[] arr=new Deck[54];
        Shuffle sh=new FisherYates();
        //产生顺序的52张牌
        chushi(arr,map);

        System.out.println("洗牌前：");
        show(arr);

        //洗牌
        sh.shuffle(arr);

        System.out.println("洗牌后:");
        show(arr);

        Deck[] p1=new Deck[17];
        Deck[] p2=new Deck[17];
        Deck[] p3=new Deck[17];
        Deck[] p=new Deck[3];
        //发牌
        diviceDeck2(arr,p1,p2,p3,p);

        System.out.println("排序前");
        show(p1);
        show(p2);
        show(p3);
        show(p);
        //排序
        sortDeck(p1,map);
        sortDeck(p2,map);
        sortDeck(p3,map);
        sortDeck(p,map);
        System.out.println("排序后");
        show(p1);
        show(p2);
        show(p3);
        show(p);

    }
    //初始化54张牌
    public static void chushi(Deck[] arr,Map<Deck,Integer> map){
        String[] name={"方块","梅花","红桃","黑桃"};
        String[] num={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        for(int i=0;i<name.length;i++){
            for(int j=0;j<num.length;j++){
                arr[i*num.length+j]=new Deck(name[i],num[j]);
            }
        }
        arr[52]=new Deck("大","王");
        arr[53]=new Deck("小","王");
        int index=1;
        map.put(arr[52],index++);
        map.put(arr[53],index++);
        for(int i=1;i>=0;i--){
            for(int j=3;j>=0;j--){
                map.put(arr[i+13*j],index++);
            }
        }
        for(int i=12;i>=2;i--){
            for(int j=3;j>=0;j--){
                map.put(arr[i+13*j],index++);
            }
        }

    }
    //打印牌
    public static void show(Deck[] arr){
        for(Deck a:arr){
            System.out.print(a.getName()+a.getNum()+" ");
        }
        System.out.println();
    }
    //发牌
    public static void diviceDeck(Deck[] arr,Deck[] p1,Deck[] p2,Deck[] p3,Deck[] p){
        for(int i=0;i<17;i++){
            p1[i]=arr[i*3];
            p2[i]=arr[i*3+1];
            p3[i]=arr[i*3+2];
        }
        p[0]=arr[51];
        p[1]=arr[52];
        p[2]=arr[53];
    }
    //第二种发牌方式，2，5，5，5
    public static void diviceDeck2(Deck[] arr,Deck[] p1,Deck[] p2,Deck[] p3,Deck[] p){
        int index=0,index1=0,index2=0,index3=0;
        for(int i=0;i<4;i++){
            if(i==0){
                for(int j=0;j<2;j++){
                    p1[index1++]=arr[index++];
                }
                for(int j=0;j<2;j++){
                    p2[index2++]=arr[index++];
                }
                for(int j=0;j<2;j++){
                    p3[index3++]=arr[index++];
                }
            }else{
                for(int j=0;j<5;j++){
                    p1[index1++]=arr[index++];
                }
                for(int j=0;j<5;j++){
                    p2[index2++]=arr[index++];
                }
                for(int j=0;j<5;j++){
                    p3[index3++]=arr[index++];
                }
            }
        }
        for(int i=0;i<3;i++){
            p[i]=arr[index++];
        }
    }
    //排序
    public static void sortDeck(Deck[] arr,Map<Deck,Integer> map){
        Arrays.sort(arr,(o1,o2)->map.get(o1)-map.get(o2));
    }
}
