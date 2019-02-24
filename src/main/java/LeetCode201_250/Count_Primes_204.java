package LeetCode201_250;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-02-23 13:47
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 **/
public class Count_Primes_204 {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; j*i < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return count;
    }
}



