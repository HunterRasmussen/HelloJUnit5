package com.makotojava.learn.hellojunit5;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.time.LocalDateTime;


import org.junit.jupiter.api.Nested;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JUnit 5 (with JUnitPlatform.class)
 * 
 * Class-level Exercises:
 * <ol>
 * <li>Enable Eclipse JUnit support for this test class using the {@link org.junit.runner.RunWith @RunWith} and
 * {@link org.junit.platform.runner.JUnitPlatform
 * JUnitPlatform} class.</li>
 * <li>Give the class a cool {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the JUnit test
 * report.</li>
 * </ol>
 *
 */
public class JUnit5AppTest {

  // Create a JDK Logger here
  private static final Logger logger = LoggerFactory.getLogger(App.class);


  // Create a fixture for the class under test
  App classUnderTest;

  // Do something before ANY test is run in this class
  @BeforeAll
  public static void init() {
    logger.info("Initializing before tests");
  }

  // Do something after ALL tests in this class are run
  @AfterAll
  public static void done() {
    logger.info("Finished all tests.");
  }

  // Create an instance of the test class before each @Test method is executed
  @BeforeEach
  public void setupClass() {
    classUnderTest = new App();
  }
  // Destroy reference to the instance of the test class after each @Test method is executed

  @AfterEach
  public void deleteClass() {
    classUnderTest = null;
  }
  // Disabled test
  @Test
  @Disabled
  @DisplayName("Asserts the number 1 equals the number 2")
  void testNotRun() {
    assertEquals(1,2);
  }

  /**
   * testAdd() - Exercises:
   * <ol>
   * <li>Tell JUnit this method is a test method.</li>
   * <li>Give it a cool display name for the test report.</li>
   * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
   * <li>Create a group of three tests of the add methods with the following arrays of positive numbers:
   * <ol>
   * <li>1, 2, 3, 4</li>
   * <li>20, 934, 110</li>
   * <li>2, 4, 6</li>
   * </ol>
   * Ensure the actual sum matches the expected sum for each group of numbers. Make sure that all groups of numbers are
   * tested (i.e., if one fails, it should not fail the test method). Hint: use
   * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...) assertAll()}
   * </ol>
   */
  @Test
  @DisplayName("Verifies that the add method works when given appropriate lists of positive numbers")
  public void testAdd() {
    //
    // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see the
    // buttery smooth javadoc above.)
    //
    assertNotNull(classUnderTest);
    assertAll(
      () -> {
        long[] toTest = {1,2,3,4};
        long result = classUnderTest.add(toTest);
        assertEquals(10,result);
      },
      () -> {
        long[] toTest = {20,934,110};
        long result = classUnderTest.add(toTest);
        assertEquals(1064,result);
      },
      () -> {
        long[] toTest = {2,4,6};
        long result = classUnderTest.add(toTest);
        assertEquals(12,result);
      }
    );
  }

  /**
   * Class-level Exercises:
   * <ol>
   * <li>Make this class a nested test class (hint: use {@link org.junit.jupiter.api.Nested @Nested}).
   * <li>Give the class a cool {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the JUnit test
   * report.</li>
   * <li>Create an instance of the {@link com.makotojava.learn.hellojunit5.App App} class specifically for this nested
   * class:
   * <ul>
   * <li>Set the <code>classUnderTest</code> variable in a method called <code>setUp()</code> that runs before the test
   * method does (hint: use {@link org.junit.jupiter.api.BeforeEach @BeforeEach})</li>
   * </ul>
   * <li>Set the <code>classUnderTest</code> variable to null in a method called <code>tearDown()</code> that runs after
   * the
   * test method does (hint: use {@link org.junit.jupiter.api.BeforeEach @AfterEach})</li>
   * </ol>
   * 
   */
  @Nested
  @DisplayName("All the negative number tests")
  class NegativeNumbersTest {

    App negativeNumbersAppClassToTest;
    @BeforeEach
    void setUp(){
      negativeNumbersAppClassToTest = new App();
    }

    @AfterEach
    void tearDown(){
      negativeNumbersAppClassToTest = null;
    }
    /**
     * testAdd() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Create a group of three tests of the add methods with the following arrays of positive numbers:
     * <ol>
     * <li>-1, -2, -3, -4</li>
     * <li>-20, -934, -110</li>
     * <li>-2, -4, -6</li>
     * </ol>
     * Ensure the actual sum matches the expected sum for each group of numbers. Make sure that all groups of numbers
     * are
     * tested (i.e., if one fails, it should not fail the test method). Hint: use
     * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...) assertAll()}
     * </ol>
     */
    @Test
    @DisplayName("Tests add on negative numbers")
    public void testAdd() {
      //
      // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see
      // the buttery smooth javadoc above.)
      //
      assertNotNull(negativeNumbersAppClassToTest);
      assertAll(
      () -> {
        long[] toTest = {-1,-2,-3,-4};
        long result = negativeNumbersAppClassToTest.add(toTest);
        assertEquals(-10,result);
      },
      () -> {
        long[] toTest = {-20,-934,-110};
        long result = negativeNumbersAppClassToTest.add(toTest);
        assertEquals(-1064,result);
      },
      () -> {
        long[] toTest = {-2,-4,-6};
        long result = negativeNumbersAppClassToTest.add(toTest);
        assertEquals(-12,result);
      }
    );

    }
  }

  /**
   * Class-level Exercises:
   * <ol>
   * <li>Make this class a nested test class (hint: use {@link org.junit.jupiter.api.Nested @Nested}).
   * <li>Give the class a cool {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the JUnit test
   * report.</li>
   * </ol>
   * 
   */
  @Nested
  @DisplayName("All the mixed sign number tests")
  class PositiveAndNegativeNumbersTest {

    App mixedSignAppClassUnderTest;
    @BeforeEach
    void setUp(){
      mixedSignAppClassUnderTest = new App();
    }

    @AfterEach
    void tearDown(){
      mixedSignAppClassUnderTest = null;
    }

    /**
     * testAdd() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Create a group of three tests of the add methods with the following arrays of positive numbers:
     * <ol>
     * <li>-1, 2, -3, 4</li>
     * <li>-20, 934, -110</li>
     * <li>-2, -4, 6</li>
     * </ol>
     * Ensure the actual sum matches the expected sum for each group of numbers. Make sure that all groups of numbers
     * are
     * tested (i.e., if one fails, it should not fail the test method). Hint: use
     * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...) assertAll()}
     * </ol>
     */
    @Test
    @DisplayName("Tests add on negative and positive numbers")
    public void testAdd() {
      assertNotNull(mixedSignAppClassUnderTest);
      assertAll(
      () -> {
        long[] toTest = {-1,2,-3,4};
        long result = mixedSignAppClassUnderTest.add(toTest);
        assertEquals(2,result);
      },
      () -> {
        long[] toTest = {-20,934,-110};
        long result = mixedSignAppClassUnderTest.add(toTest);
        assertEquals(804,result);
      },
      () -> {
        long[] toTest = {2,-4,6};
        long result = mixedSignAppClassUnderTest.add(toTest);
        assertEquals(4,result);
      }
    );
    }

    /**
     * testAdd_OnlyOnFriday - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>Use the JDK 8 Date/Time API to get the current local date/time, along with a simple Assumption (hint: use
     * {@link org.junit.jupiter.api.Assumptions#assumeTrue(boolean) assumeTrue()}) that today is Friday
     * (or any other day of the week of your choosing, just so you pick one), or the test is skipped.</li>
     * <li>Pass the following numbers as operands to the {@link com.makotojava.learn.hellojunit5.App#add(long[]) add}
     * method: 1, 2, 3, 4, 5</li>
     * <li>Ensure the actual sum matches the expected sum.</li>
     * </ol>
     */
    @Test
    @DisplayName("Tests add if today is Friday")
    public void testAdd_OnlyOnFriday() {
      assertNotNull(mixedSignAppClassUnderTest);
      LocalDateTime ldt = LocalDateTime.now();
      assumeTrue(ldt.getDayOfWeek().getValue() == 5, "Skipped test because it isn't Friday");
      long[] toTest = {1,2,3,4,5};
      long result = mixedSignAppClassUnderTest.add(toTest);
      assertEquals(15,result);
      
    }

    /**
     * testAdd_OnlyOnFriday_WithLambda - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>Use the JDK 8 Date/Time API to get the current local date/time, along with a simple Assumption (hint: use
     * {@link org.junit.jupiter.api.Assumptions#assumingThat(boolean, org.junit.jupiter.api.function.Executable)
     * assumingThat()}) that today is Friday
     * (or any other day of the week of your choosing, just so you pick one), or the test is skipped.</li>
     * <li>Pass the following numbers as operands to the {@link com.makotojava.learn.hellojunit5.App#add(long[]) add}
     * method: 1, 2, 3, 4, 5</li>
     * <li>Ensure the actual sum matches the expected sum.</li>
     * </ol>
     */
    @Test
    @DisplayName("Tests on Friday using assumingThat()")
    public void testAdd_OnlyOnFriday_WithLambda() {
      //
      // EXERCISE: TODO: ADD CODE HERE (See Javadoc comments for instructions. Use the Javadoc View in Eclipse to see
      // the buttery smooth javadoc above.)
      //
      assertNotNull(mixedSignAppClassUnderTest);
      LocalDateTime ldt = LocalDateTime.now();
      assumingThat(ldt.getDayOfWeek().getValue() == 5, 
        () -> {
          long[] toTest = {1,2,3,4,5};
          long result = mixedSignAppClassUnderTest.add(toTest);
          assertEquals(15,result);
        });
    }
  }

  /**
   * Class-level Exercises:
   * <ol>
   * <li>Make this class a nested test class (hint: use {@link org.junit.jupiter.api.Nested @Nested}).
   * <li>Give the class a cool {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the JUnit test
   * report.</li>
   * </ol>
   * 
   */
  @Nested
  @DisplayName("Tests using a single operand")
  class JUnit5AppSingleOperandTest {

    /**
     * testAdd_NumbersGt0() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Create a group of two tests of the add methods with the following arrays of positive numbers:
     * <ol>
     * <li>1</li>
     * <li>0</li>
     * </ol>
     * Ensure the actual sum matches the expected sum for each group of numbers. Make sure that all groups of numbers
     * are
     * tested (i.e., if one fails, it should not fail the test method). Hint: use
     * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...) assertAll()}
     * </ol>
     */
    @Test
    @DisplayName("Tests add works correctly when given a list with only one element of non-negative nature")
    public void testAdd_NumbersGt0() {
      assertNotNull(classUnderTest);
      assertAll(
          () -> {
            long[] numbersToSum = { 1 };
            long actualSum = classUnderTest.add(numbersToSum);
            assertEquals(1, actualSum);
          },
          () -> {
            long[] numbersToSum = { 0 };
            long actualSum = classUnderTest.add(numbersToSum);
            assertEquals(0, actualSum);
          });
    }

    /**
     * testAdd_NumbersLt0() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Create a group of two tests of the add methods with the following arrays of positive numbers:
     * <ol>
     * <li>-1</li>
     * <li>-10</li>
     * </ol>
     * Ensure the actual sum matches the expected sum for each group of numbers. Make sure that all groups of numbers
     * are
     * tested (i.e., if one fails, it should not fail the test method). Hint: use
     * {@link org.junit.jupiter.api.Assertions#assertAll(org.junit.jupiter.api.function.Executable...) assertAll()}
     * </ol>
     */
    @Test
    @DisplayName("Testing add works appropiately with single integer lists of negative numbers")
    public void testAdd_NumbersLt0() {
      assertNotNull(classUnderTest);
      assertAll(
        () -> {
          long[] numbersToSum = { -1 };
          long actualSum = classUnderTest.add(numbersToSum);
          assertEquals(-1, actualSum);
        },
        () -> {
          long[] numbersToSum = { -10 };
          long actualSum = classUnderTest.add(numbersToSum);
          assertEquals(-10, actualSum);
        });
    }
  }

  /**
   * Class-level Exercises:
   * <ol>
   * <li>Make this class a nested test class (hint: use {@link org.junit.jupiter.api.Nested @Nested}).
   * <li>Give the class a cool {@link org.junit.jupiter.api.DisplayName @DisplayName} that shows up in the JUnit test
   * report.</li>
   * </ol>
   * 
   */
  @Nested
  @DisplayName("Tests with 0 operantds")
  class JUnit5AppZeroOperandsTest {

    /**
     * testAdd_ZeroOperands_EmptyArgument() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Pass an empty array as operands argument to the {@link com.makotojava.learn.hellojunit5.App#add(long[]) add}
     * method.</li>
     * <li>Ensure that an {@link java.lang.IllegalArgumentException IllegalArgumentException} is thrown (hint: use the
     * {@link org.junit.jupiter.api.Assertions#assertThrows(Class, org.junit.jupiter.api.function.Executable)
     * assertThrows()} method).</li>
     * </ol>
     */
    @Test
    @DisplayName("Test when given an empty argument on add")
    public void testAdd_ZeroOperands_EmptyArgument() {
      assertNotNull(classUnderTest);
      long [] myList = {};
      assertThrows(IllegalArgumentException.class, ()-> classUnderTest.add(myList));
    }

    /**
     * testAdd_ZeroOperands_NullArgument() - Exercises:
     * <ol>
     * <li>Tell JUnit this method is a test method.</li>
     * <li>Give it a cool display name for the test report.</li>
     * <li>The reference to the class under test cannot be null. If it is, the test should fail.</li>
     * <li>Pass an empty array as operands argument to the {@link com.makotojava.learn.hellojunit5.App#add(long[]) add}
     * method.</li>
     * <li>Ensure that an {@link java.lang.IllegalArgumentException IllegalArgumentException} is thrown (hint: use the
     * {@link org.junit.jupiter.api.Assertions#assertThrows(Class, org.junit.jupiter.api.function.Executable)
     * assertThrows()} method).</li>
     * <li>The test should fail if the message in the exception is not "Operands argument cannot be null".</li>
     * </ol>
     */
    @Test
    @DisplayName("Test add with null argument")
    public void testAdd_ZeroOperands_NullArgument() {
      assertNotNull(classUnderTest);
      long[] mylist = null;
      Throwable expectedException = assertThrows(IllegalArgumentException.class,
      () -> classUnderTest.add(mylist));
      assertEquals("Operands argument cannot be null", expectedException.getLocalizedMessage());
    }
  }

}
