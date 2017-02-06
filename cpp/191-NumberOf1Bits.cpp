class Solution {
public:
    int hammingWeight(uint32_t n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((1 << i) & n) != 0) {
                count++;
            }
        }
        return count;
    }
};
/*
The key idea here is to realize that for any number nnn,
doing a bit-wise AND of nnn and n−1n - 1n−1 flips the least-significant
111-bit in nnn to 000. Why? Consider the binary representations of nnn and n−1n - 1n−1.
*/
class Solution {
public:
    int hammingWeight(uint32_t n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
};
