package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {

    List<String> words = new ArrayList<>();

    public List<String> getWords() {
        return new ArrayList<>(words);
    }

    public void addWord(String word){
        for(int i = 0; i < word.length(); i++){
            if(Character.isWhitespace(word.charAt(i))){ //word.indexof(" ")
                throw new IllegalArgumentException("It should be one word!");
            }
            if(!Character.isLowerCase(word.charAt(i))){ //.equals(word); ellenőrzés külön methódus legyen: validate
                throw new IllegalArgumentException("Word should be lower case!");
            }
        }
        words.add(word);
    }

    public boolean isThereAWordTwice(){

        for(int i = 0; i < words.size(); i++){
            String word = words.get(i);  //if (checkWord)
            for(int j = 0; j < words.size(); j++){
                if(i != j){
                    if(word.equals(words.get(j))){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //private boolean checkword(int i)
}
