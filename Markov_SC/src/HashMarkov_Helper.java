import java.util.*;
import java.util.Random;

// @author Carmen 

import java.util.List;

public class HashMarkov_Helper implements MarkovInterface{


    /*
    first: split text 
    second: clear map
    third: loop through text
        potential for loop: 
            for(int i = 0; i < myWords.length - myOrder; i++){
                WordGram wg = new WordGram(myWords, i, myOrder); 
            fourth: add to map inside for-loop
    */
    @Override
    public void setTraining(String text) {
        
    }


    /*if the map contains the key, return a empty List<String>
     * else return the value of that key 
     */
    @Override
    public List<String> getFollows(WordGram wgram) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFollows'");
    }

/*helper function you might want to use in getRandomText to get the next word */

private String getNext(WordGram wgram) {
    List<String> follows = getFollows(wgram);
    if (follows.size() == 0) {
        int randomIndex = myRandom.nextInt(myWords.length);  //variables created before
        return myWords[randomIndex];
    }
    else {
        int randomIndex = myRandom.nextInt(follows.size());
        return follows.get(randomIndex);
    }
}


    /*
     * here you might want to use the helper function getNext()
     * rest same as BaseMarkov
     */
    @Override
    public String getRandomText(int length) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRandomText'");
    }

    @Override
    public int getOrder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrder'");
    }

    @Override
    public void setSeed(long seed) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSeed'");
    }

}