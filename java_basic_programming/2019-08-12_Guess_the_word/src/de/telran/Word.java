package de.telran;

public class Word {

    private String word;
    private String description;
    private boolean[] guessed = {true, false, false, true, false};


    public Word(String word, String description) {
        this.word = word;
        this.description = description;
        //this.guessed = new boolean[word.length()];
    }

    // Better implementation with StringBuilder see below
    /*public String getWordWithStars() {
        String wordWithStars = "";
        for (int i = 0; i < word.length(); i++) {
            if (guessed[i]) {
                wordWithStars +=  word.charAt(i);
            } else {
                wordWithStars +=  "*";
            }
        }
        return wordWithStars;
    }*/

    public String getWordWithStars() {
        StringBuilder wordWithStars = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (guessed[i]) {
                wordWithStars.append(word.charAt(i));
            } else {
                wordWithStars.append("*");
            }
        }
        return wordWithStars.toString();
    }

    public boolean hasChar(char ch) {
        for (char currentChar: word.toCharArray()) {
            if (ch == currentChar)
                return true;
        }
        return false;
    }

    public String getWord() {
        return word;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word1 = (Word) o;

        if (word != null ? !word.equals(word1.word) : word1.word != null) return false;
        return description != null ? description.equals(word1.description) : word1.description == null;

    }

    @Override
    public int hashCode() {
        int result = word != null ? word.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", description='" + description + '\'' +
                "array length=" + guessed.length +
                '}';
    }
}