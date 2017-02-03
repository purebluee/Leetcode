// Forward declaration of the read4 API.
int read4(char *buf);

class Solution {
public:
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    int read(char *buf, int n) {
        if (n <= 0)
            return 0;
        int bytes = 0, totalBytes = 0;
        while (true){
            bytes = read4(buf + totalBytes);
            totalBytes += bytes;
            if (bytes == 0)
                return totalBytes; // end of file
            if (totalBytes >= n)
                return n; // we have read what we were expected to read
        }
    }
};