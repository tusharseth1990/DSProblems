package array.binarysearch;
//Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
// The guards have gone and will come back in h hours.
//Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some
// pile of bananas and eats k bananas from that pile. If the pile has less than k bananas,
// she eats all of them instead and will not eat any more bananas during this hour.
//Koko likes to eat slowly but still wants to finish eating all the bananas before the
// guards return.
//Return the minimum integer k such that she can eat all the bananas within h hours.
//       Example 1:
//        Input: piles = [3,6,7,11], h = 8
//        Output: 4

//log(max(p))*p
public class KokoEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {
        // Initalize the left and right boundaries
        //finding the range in this case L...R = 1...11
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
    //now applying binary search on the above L..R range
        while (left < right) {
            // Get the middle index between left and right boundary indexes.
            // hourSpent stands for the total hour Koko spends.
            int middle = (left + right) / 2;
            int hourSpent = 0;

            // Iterate over the piles and calculate hourSpent.
            // We increase the hourSpent by ceil(pile / middle)
            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / middle);
            }

            // Check if middle is a workable speed, and cut the search space by half.
            if (hourSpent <= h) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        // Once the left and right boundaries coincide, we find the target value,
        // that is, the minimum workable eating speed.
        return right;
    }

    public static void main(String[] args) {
        KokoEatingBanana kokoEatingBanana = new KokoEatingBanana();
        int[] a = {3,6,7,11};
        System.out.println(kokoEatingBanana.minEatingSpeed(a,8));
    }
}
