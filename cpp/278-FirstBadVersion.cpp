// Forward declaration of isBadVersion API.
//The only scenario left is where isBadVersion(mid)⇒trueisBadVersion(mid)
//\Rightarrow trueisBadVersion(mid)⇒true. This tells us that midmidmid may
//or may not be the first bad version, but we can tell for sure that all
//versions after midmidmid can be discarded. Therefore we set right=midright = midright=mid
//as the new search space of interval [left,mid][left,mid][left,mid] (inclusive).
bool isBadVersion(int version);

class Solution {
public:
    int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid))
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }
};
