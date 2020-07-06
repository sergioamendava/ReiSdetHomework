package com.rei.sdet.homework;

/** Object to parse response retrieved by dictionary service */
public class Definition {
  private String word;
  private String definition;

  /**
   * Gets word.
   *
   * @return the word
   */
  public String getWord() {
    return word;
  }

  /**
   * Sets word.
   *
   * @param word the word
   */
  public void setWord(String word) {
    this.word = word;
  }

  /**
   * Gets definition.
   *
   * @return the definition
   */
  public String getDefinition() {
    return definition;
  }

  /**
   * Sets definition.
   *
   * @param definition the definition
   */
  public void setDefinition(String definition) {
    this.definition = definition;
  }
}
