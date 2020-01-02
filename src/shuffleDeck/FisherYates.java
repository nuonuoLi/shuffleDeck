package shuffleDeck;

import entity.Deck;

import java.util.Random;

/**
 * fisherYates算法
 */
public class FisherYates implements Shuffle {

    @Override
    public void shuffle(Deck[] arr) {
        if(arr==null) return;
        Random random=new Random();
        for(int i=arr.length-1;i>=0;i--){
            int index= random.nextInt(i+1);
            Deck temp=arr[index];
            arr[index]=arr[i];
            arr[i]=temp;
        }
    }
}
