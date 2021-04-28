package com.puru.random;

import java.util.*;
public class AwardTopKHotels {
    /*
     * Complete the 'awardTopKHotels' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING positiveKeywords
     *  2. STRING negativeKeywords
     *  3. INTEGER_ARRAY hotelIds
     *  4. STRING_ARRAY reviews
     *  5. INTEGER k
     */

    public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords, List<Integer> hotelIds, List<String> reviews, int k) {
        int count = hotelIds.size();
        if (count < k) {
            return hotelIds;
        }
        Map<Integer, Integer> hotelRatings = new HashMap<>();
        Set<String> positiveKeywordSet = fetchTokens(positiveKeywords);
        Set<String> negativeKeywordSet = fetchTokens(negativeKeywords);

        for (int i = 0; i < count; i++) {
            int score = 0;
            int hotelId = hotelIds.get(i);
            String review = reviews.get(i);
            String[] reviewTokens = review.split(" ");
            for (String token : reviewTokens) {
                if (positiveKeywordSet.contains(token.toLowerCase())) {
                    score += 3;
                } else if (negativeKeywordSet.contains(token.toLowerCase())) {
                    score -= 1;
                }
            }
            hotelRatings.put(hotelId, hotelRatings.getOrDefault(hotelId, 0) + score);
        }
        List<Integer> topHotelIds = findTopHotels(hotelRatings, k);
        return topHotelIds;
    }
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>>  pq = new PriorityQueue<>(
                (p1, p2)->{return p2.getValue().compareTo(p1.getValue());}
        );
        for(int i=0; i<nums.length;i++){
            Integer frq = map.getOrDefault(map.get(nums[i]),0)+1;
            map.put(nums[i], frq);
        }
        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(entry);
        }

        int[] res = new int[pq.size()];
        int i=0;
        while(!pq.isEmpty()){
            res[i++] = pq.poll().getKey();
        }
        return res;
    }
    private static List<Integer> findTopHotels(Map<Integer, Integer> hotelRatings, int k) {

        List<Integer> hotelIds = new ArrayList<>();
        TreeMap<Integer, Integer> sortedMap = new TreeMap<>(new ValueCompartor(hotelRatings));
        sortedMap.putAll(hotelRatings);
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            if (count < k) {
                hotelIds.add(entry.getKey());
                k++;
            } else {
                break;
            }
        }
        return hotelIds;
    }

    private static Set<String> fetchTokens(String keywords) {
        Set<String> keywordSet = new HashSet<>();
        String[] words = keywords.split(" ");
        for (String keyword : words) {
            keywordSet.add(keyword.toLowerCase());
        }
        return keywordSet;
    }

    static class ValueCompartor implements Comparator<Integer> {

        private Map<Integer, Integer> baseMap;

        ValueCompartor(Map<Integer, Integer> map) {
            this.baseMap = map;
        }

        @Override
        public int compare(Integer h1, Integer h2) {
            if (baseMap.get(h1) >= baseMap.get(h2)) {
                return -1;
            } else if (baseMap.get(h1) < baseMap.get(h2)) {
                return 1;
            } else {
                if (h1 <= h2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }

    }
}
