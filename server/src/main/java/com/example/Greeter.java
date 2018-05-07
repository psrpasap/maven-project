package com.example;

/**
 * This is a class.
 */
public class Greeter {

  /**
   * This is a constructor.
   */
  public Greeter() {

  }

/**
 * This is a class.
 * @param someone **text data to be displayed**
 * @return String
 */

  public final String greet(final String someone) {
    return String.format("Hello Prasad, %s!", someone);
  }
}
