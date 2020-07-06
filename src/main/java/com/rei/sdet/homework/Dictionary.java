package com.rei.sdet.homework;

import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** Main class that contains the logic for dictionary handling. */
public class Dictionary {

  /** The Dictionary. */
  public Map<String, String> dictionary;

  /**
   * Gets dictionary.
   *
   * @return the dictionary
   */
  public Map<String, String> getDictionary() {
    return dictionary;
  }

  /**
   * Sets dictionary.
   *
   * @param dictionary the dictionary
   */
  public void setDictionary(Map<String, String> dictionary) {
    this.dictionary = dictionary;
  }

  /**
   * This function checks the correct writing of the word to search and will return true if within
   * in the English words list, otherwise it will return false.
   *
   * @param word to search
   * @return the boolean
   */
  public boolean isEnglishWord(String word) {
    boolean isEnglishWord = false;

    if (!Strings.isNullOrEmpty(word) && (word.matches("^[a-z]*$")))
      isEnglishWord = dictionary.containsKey(word);

    return isEnglishWord;
  }

  /**
   * Get a String list with all English words contained in a given string
   *
   * @param word the word
   * @return the matches words as string list
   */
  public List<String> getMatchesWords(String word) {
    List<String> wordsList = new ArrayList<>();
    List<String> matches = new ArrayList<>();

    if (isEnglishWord(word)) {
      dictionary.forEach((key, value) -> wordsList.add(key));

      int[] hashWordSearch = getHashWord(word);

      for (String wordList : wordsList) {
        int[] hashWordList = getHashWord(wordList);
        if (isWordListContainedInWordSearh(hashWordSearch, hashWordList)) matches.add(wordList);
      }
    }
    return matches;
  }

  private boolean isWordListContainedInWordSearh(int[] hashWordSearch, int[] hashWordsList) {
    for (int i = 0; i < 26; i++) {
      if (hashWordSearch[i] == 0 && hashWordsList[i] > 0) {
        return false;
      } else if (hashWordSearch[i] < hashWordsList[i]) {
        return false;
      }
    }
    return true;
  }

  private int[] getHashWord(String word) {
    int[] hash = new int[26];
    for (char c : word.toCharArray()) {
      if ((c - 'a') >= 0 && (c - 'a') < 26) {
        hash[c - 'a']++;
      }
    }
    return hash;
  }
}
