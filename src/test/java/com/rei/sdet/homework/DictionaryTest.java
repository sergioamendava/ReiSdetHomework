package com.rei.sdet.homework;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.*;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class DictionaryTest {
  static Dictionary dictionary;

  @BeforeClass
  public static void setUp() throws Exception {
    dictionary = new Dictionary();
    dictionary.setDictionary(
        Utils.getDictionaryFromService(
            "https://49c48062-1308-4ed1-bd78-89ad5d3a1df5.mock.pstmn.io/v1/definitionslist"));
    System.out.println("Mocked service is consumed responding with an English words and definitions list, and is assigned to the dictionay object");
  }

  @Test
  public void isEnglishWord_WordEmpty() {
    assertThat(dictionary.isEnglishWord(""), is(false));
    System.out.println("isEnglishWord(\"\") : " + dictionary.isEnglishWord(""));
  }

  @Test
  public void isEnglishWord_WordNull() {
    assertThat(dictionary.isEnglishWord(null), is(false));
    System.out.println("isEnglishWord(null) : " + dictionary.isEnglishWord(null));
  }

  @Test
  public void isEnglishWord_WordSpecialCharacter() {
    assertThat(dictionary.isEnglishWord("wor!king"), is(false));
    System.out.println("isEnglishWord(\"wor!king\") : " + dictionary.isEnglishWord("wor!king"));
  }

  @Test
  public void isEnglishWord_WordNumber() {
    assertThat(dictionary.isEnglishWord("8working"), is(false));
    System.out.println("isEnglishWord(\"8working\") : " + dictionary.isEnglishWord("8working"));
  }

  @Test
  public void isEnglishWord_WordSpace() {
    assertThat(dictionary.isEnglishWord("wor king"), is(false));
    System.out.println("isEnglishWord(\"wor king\") : " + dictionary.isEnglishWord("wor king"));
  }

  @Test
  public void isEnglishWord_WordUppercase() {
    assertThat(dictionary.isEnglishWord("Working"), is(false));
    System.out.println("isEnglishWord(\"Working\") : " + dictionary.isEnglishWord("Working"));
  }

  @Test
  public void isEnglishWord_WordNotInList() {
    assertThat(dictionary.isEnglishWord("pqkghzx"), is(false));
    System.out.println("isEnglishWord(\"pqkghzx\") : " + dictionary.isEnglishWord("pqkghzx"));
  }

  @Test
  public void isEnglishWord_PluralWord() {
    assertThat(dictionary.isEnglishWord("rows"), is(false));
    System.out.println("isEnglishWord(\"rows\") : " + dictionary.isEnglishWord("rows"));
  }

  @Test
  public void isEnglishWord_WordInList() {
    assertThat(dictionary.isEnglishWord("working"), is(true));
    System.out.println("isEnglishWord(\"working\") : " + dictionary.isEnglishWord("working"));
  }

  @Test
  public void getMatchesWords_WordWithoutAnagrams() {
    assertThat(dictionary.getMatchesWords("strengths").size(), is(1));
    System.out.println(
        "dictionary.getMatchesWords(\"strengths\") : " + dictionary.getMatchesWords("strengths"));
  }

  @Test
  public void getMatchesWords_WordWithAnagrams() {
    List<String> expectedList = Arrays.asList("ring", "king", "work", "know", "working", "row", "wing");
    assertThat(dictionary.getMatchesWords("working"), containsInAnyOrder(expectedList.toArray()));
    assertThat(dictionary.getMatchesWords("working").size(), is(7));
    System.out.println(
        "dictionary.getMatchesWords(\"working\") : " + dictionary.getMatchesWords("working"));
  }

  @Test
  public void getMatchesWords_WordsListHasDuplicates() {
    assertThat(Utils.hasWordsDuplicated(dictionary.getMatchesWords("working")), is(false));
    System.out.println(
        "dictionary.getMatchesWords(\"working\") : " + dictionary.getMatchesWords("working") + " - Has duplicates?: "
            + Utils.hasWordsDuplicated(dictionary.getMatchesWords("working")));
  }
}