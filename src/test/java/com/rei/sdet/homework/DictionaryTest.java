package com.rei.sdet.homework;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.*;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
  }

  @Test
  public void isEnglishWord_WordEmpty() {
    assertThat(dictionary.isEnglishWord(""), is(false));
  }

  @Test
  public void isEnglishWord_WordNull() {
    assertThat(dictionary.isEnglishWord(null), is(false));
  }

  @Test
  public void isEnglishWord_WordSpecialCharacter() {
    assertThat(dictionary.isEnglishWord("wor!king"), is(false));
  }

  @Test
  public void isEnglishWord_WordUppercase() {
    assertThat(dictionary.isEnglishWord("Working"), is(false));
  }

  @Test
  public void isEnglishWord_WordNotInList() {
    assertThat(dictionary.isEnglishWord("perencejito"), is(false));
  }

  @Test
  public void isEnglishWord_PluralWord() {
    assertThat(dictionary.isEnglishWord("rows"), is(false));
  }

  @Test
  public void isEnglishWord_WordInList() {
    assertThat(dictionary.isEnglishWord("working"), is(true));
  }

  @Test
  public void getMatchesWords_WordWithoutAnagrams() {
    assertThat(dictionary.getMatchesWords("strengths").size(), is(1));
  }

  @Test
  public void getMatchesWords_WordWithAnagrams() {
    List<String> expectedList = Arrays.asList("ring", "king", "work", "know", "working", "row", "wing");
    assertThat(dictionary.getMatchesWords("working"), containsInAnyOrder(expectedList.toArray()));
    assertThat(dictionary.getMatchesWords("working").size(), is(7));
  }
}