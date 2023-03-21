package NO_0157_Read_N_Characters_Given_Read4;

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int idx = 0;
        char[] buf4 = new char[4];
        int size;
        while ((size = read4(buf4)) > 0 && idx < n) {
            for (int i = 0; i < size && idx < n; i++, idx++) {
                buf[idx++] = buf4[i];
            }
        }
        return idx;
    }
}
