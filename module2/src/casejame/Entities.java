package casejame;

import java.io.Serializable;

public class Entities implements Serializable {
    private String keyword;
    private String typeWord;
    private String meaning;

    public Entities() {
    }

    public Entities(String keyword, String typeWord,String meaning) {
        this.keyword = keyword;
        this.meaning = meaning;
        this.typeWord = typeWord;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getTypeWord() {
        return typeWord;
    }

    public void setTypeWord(String typeWord) {
        this.typeWord = typeWord;
    }

    @Override
    public String toString() {
        return keyword+"\n"+"*type word: " + typeWord +"\n"+
                "- meaning: " + meaning+
                "\n"
                ;
    }

}
