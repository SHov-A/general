package com.inomma.acceptance.helper;

import com.inomma.acceptance.exception.StarTrekException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.*;

/**
 * The helper methods.
 */
public class TestUtil {

    public static List<String> splitString(String text, String symbol) {
        if (text == null) throw new StarTrekException("Text is invalid");
        return new ArrayList<>(Arrays.asList(text.split(symbol)));
    }

    public static double getMultiplePurchaseOuterTextLastMember(String text) {
        if (text == null) throw new StarTrekException("Text is invalid");
        List<String> arr = splitString(getMultiplePurchaseOuterTextLastMemberInUSD(text), " ");
        String price = arr.get(0);
        return Double.parseDouble(price);
    }

    public static String getMultiplePurchaseOuterTextLastMemberInUSD(String text) {
        if (text == null) throw new StarTrekException("Text is invalid");
        List<String> array = splitString(text, "\n");
        return array.get(array.size() - 1);
    }

    public static int randomNumberGenerator(int number) {
        Random random = new Random();
        return random.nextInt(number);
    }

    public static String decrementTextFirstMember(String text, String symbol) {
        String[] arr = text.split(symbol);
        int firstMember;
        try {
            firstMember = Integer.parseInt(arr[0]);
        } catch (Exception e) {
            throw new StarTrekException("first member must be a int format", e);
        }
        int decrementFirstMember = --firstMember;
        arr[0] = Integer.toString(decrementFirstMember);
        return String.join(symbol, arr);
    }

    public static String getRandomIndex(List<Integer> list) {
        Objects.requireNonNull(list, "list is invalid: " + list);
        int size = list.size();
        int index = randomNumberGenerator(size);
        return list.get(index).toString();
    }

    public static void deleteInputtedStringData(String number, WebElement webElement) {
        int count = 0;
        try {
            count = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new StarTrekException(number + ": can't parse to int, input valid format", e);
        }
        if (count < 0) throw new StarTrekException("please input without minus sign");
        for (int i = 0; i < number.length(); i++) {
            webElement.sendKeys(Keys.BACK_SPACE);
        }
    }

    public static double getDigitsInString(String text) {
        return Double.parseDouble(text.replaceAll("[^.0123456789]", ""));
    }

}
