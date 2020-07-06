package com.rei.sdet.homework;

public class Main {

  public static void main(String[] args) throws Exception {
    Dictionary dictionary = new Dictionary();
    dictionary.setDictionary(
        Utils.getDictionaryFromService(
            "https://49c48062-1308-4ed1-bd78-89ad5d3a1df5.mock.pstmn.io/v1/definitionslist"));

    System.out.println(dictionary.isEnglishWord("row"));

    System.out.println(dictionary.getMatchesWords("working"));
  }
}
