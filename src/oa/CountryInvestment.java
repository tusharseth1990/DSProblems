package oa;

import java.util.HashMap;
import java.util.Map;

//1. Country Investment Summation
//👉 Asked in Guidewire Codility : You are given two arrays:
//* accounts[]: a list of account numbers (strings), where the first two letters represent
// the country code.
//* investments[]: an integer list, where investments[i] is the investment amount in accounts[i].
//
//Task: Find the country code with the maximum total investment.
//Example:
//
//accounts = ["US123", "IN345", "US567", "IN111"]
//investments = [100, 200, 300, 150]
//Output:
//
//"US"   // because US → 100+300 = 400, IN → 200+150 = 350
public class CountryInvestment {
    public static String maxInvestmentCountry(String[] accounts, int[] investments) {
        Map<String, Integer> countryMap = new HashMap<>();

        for (int i = 0; i < accounts.length; i++) {
            String country = accounts[i].substring(0, 2); // first 2 chars = country code
            countryMap.put(country, countryMap.getOrDefault(country, 0) + investments[i]);
        }
        String result = "";
        int maxInvestment = 0;

        for (Map.Entry<String, Integer> entry : countryMap.entrySet()) {
            if (entry.getValue() > maxInvestment) {
                maxInvestment = entry.getValue();
                result = entry.getKey();
            }
        }


//        return countryMap.entrySet()
//                .stream()
//                .max(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey)
//                .orElse("");
        return result;
    }

    // Test
    public static void main(String[] args) {
        String[] accounts = {"US123", "IN345", "US567", "IN111"};
        int[] investments = {100, 200, 300, 150};
        System.out.println(maxInvestmentCountry(accounts, investments)); // US
    }
}
