// Retail Price Calculator
// Author: Andrew Soutar
// CMP128-80229: Computer Science I
// County College of Morris
// Date Modified: Fri. 11/06/2015

/* Copyright (c) 2015 Andrew Soutar <andrew@andrewsoutar.com>
 *
 * See the LICENSE file for details.
 */

// github.com/andrewsoutarccm/utilities
import com.andrewsoutar.cmp128.Utilities;
import com.andrewsoutar.cmp128.Utilities.GenericScanner;
import com.andrewsoutar.cmp128.Utilities.UnaryFunction;

public class Main {
    private static void welcomeBanner () {
        Utilities.printBordered (new String [] {
                "Welcome to the Retail Price Calculator App",
                "Version 1.0. Last Modified: Fri. 11/06/2015",
                "Author: Andrew Soutar <andrew@andrewsoutar.com>"
            });
    }

    private static Float calculateRetail (float price, float percent) {
        return (price * (1 + percent));
    }

    public static void main (String... args) {
        GenericScanner kbdScanner = new GenericScanner ();
        welcomeBanner ();
        System.out.format
            ("The item's retail price is $%.2f%n",
             calculateRetail
             (kbdScanner.<Float, Float>
              prompt (Float.class, "Price",
                      new UnaryFunction <Float, Float> () {
                          public Float call (Float price) {
                              if (price > 0) {
                                  return (price);
                              } else {
                                  return (null);
                              }
                          }
                      }),
              kbdScanner.<Float, Float>
              prompt (Float.class, "Markup precentage",
                      new UnaryFunction <Float, Float> () {
                          public Float call (Float markup) {
                              if (0 <= markup) {
                                  return (markup / 100);
                              } else {
                                  return (null);
                              }
                          }
                      })));
    }
}
