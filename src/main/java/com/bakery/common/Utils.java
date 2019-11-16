package com.bakery.common;

import java.util.*;

public class Utils {
    public static <T> List<T> toList(Iterable<T> iterable) {
        List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

    public static int minChange(int[] denom, int targetAmount) {

        int actualAmount;
        int m = denom.length+1;
        int n = targetAmount + 1;
        int inf = Integer.MAX_VALUE-1;

        int[][] table = new int[m][n];
        for (int j = 1; j < n; j++)
            table[0][j] = inf;

        for (int denomPosition = 1; denomPosition < m; denomPosition++) {
            for (int currentAmount = 1; currentAmount < n; currentAmount++) {
                if (currentAmount - denom[denomPosition-1] >= 0)
                    actualAmount = table[denomPosition][currentAmount - denom[denomPosition-1]];
                else
                    actualAmount = inf;
                table[denomPosition][currentAmount] = Math.min(table[denomPosition-1][currentAmount], 1 + actualAmount);
            }
        }

        return table[m-1][n-1];

    }
    public static Map<Integer, Integer> withdrawAmount(int[] denom,int expectedAmount)
    {
        Map<Integer, Integer> denominations = new HashMap<>();
        for (int i : denom) {
            denominations.put(i,100);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, Integer> sortedMap = new TreeMap<>(Collections.reverseOrder());
        sortedMap.putAll(denominations);
        ArrayList<Integer> bills = new ArrayList<>();
        bills.addAll(sortedMap.keySet());


        int num;

        for (int i = 0; i < bills.size(); i++)
        {
            if (bills.get(i) <= expectedAmount)
            {
                num = expectedAmount / bills.get(i);
                map.put(bills.get(i), num);
                expectedAmount -= num * bills.get(i);
            }
        }
        return map;
    }

    public static void main(String[] args) throws Exception {
        int[] coins = new int[]{2, 5,9};
        System.out.println(minChange(coins,13));
        System.out.println(withdrawAmount(coins,13));
    }
}
