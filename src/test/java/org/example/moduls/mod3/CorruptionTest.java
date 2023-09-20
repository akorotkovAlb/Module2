package org.example.moduls.mod3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CorruptionTest {

    public static final int SMALL_PERCENT = -5;
    public static final int PERCENT = 5;
    public static final int BIG_PERCENT = 101;
    public static final double RESULT = 4151.5d;
    public static final List<Double> BILLS = Arrays.asList(1000d, 1100d, 1200d, 1300d);

    @BeforeAll
    public static void init() {
        System.out.println("Run before all tests.");
    }

    @BeforeEach
    public void start() {
        System.out.println("Before each!");
    }


    @Test
    void operationWithSmallPercentTest() throws Exception {

        Corruption corruption = new Corruption();
        Assertions.assertThrows(ValidationException.class,
                () -> corruption.operation(SMALL_PERCENT, BILLS));
    }

    @Test
    void operationWithBigPercentTest() throws Exception {

        Corruption corruption = new Corruption();
        Assertions.assertThrows(ValidationException.class,
                () -> corruption.operation(BIG_PERCENT, BILLS));
    }

    @Test
    void operationBadBillInListTest() throws Exception {

        List<Double> newBills = new ArrayList<>();
        newBills.addAll(BILLS);
        newBills.add(0d);

        Corruption corruption = new Corruption();
        Assertions.assertThrows(ValidationException.class,
                () -> corruption.operation(PERCENT, newBills));
    }

    @Test
    void operationBadBillListSizeTest() throws Exception {

        List<Double> newBills = new ArrayList<>();
        newBills.add(110d);

        Corruption corruption = new Corruption();
        Assertions.assertThrows(ValidationException.class,
                () -> corruption.operation(PERCENT, newBills));
    }

    @Test
    void operationEmptyBillsListTest() throws Exception {

        List<Double> newBills = new ArrayList<>();

        Corruption corruption = new Corruption();
        Assertions.assertThrows(ValidationException.class,
                () -> corruption.operation(PERCENT, newBills));
    }

    @Test
    void operationTwoBillsTest() throws Exception {

        List<Double> newBills = new ArrayList<>();
        newBills.add(100d);
        newBills.add(100d);

        Corruption corruption = new Corruption();
        double result = corruption.operation(PERCENT, newBills);

        Assertions.assertEquals(190.0d, result);
    }

    @Test
    void operationTest() throws Exception {

        List<Double> newBills = new ArrayList<>();
        newBills.add(1000d);
        newBills.add(1100d);
        newBills.add(1200d);
        newBills.add(1300d);

        Corruption corruption = new Corruption();
        double result = corruption.operation(PERCENT, newBills);

        Assertions.assertEquals(RESULT, result);
    }

    @AfterEach
    public void finish() {
        System.out.println("After each!");
    }

    @AfterAll
    public static void down() {
        System.out.println("After all!");
    }
}