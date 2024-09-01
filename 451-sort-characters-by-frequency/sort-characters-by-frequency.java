public class Solution {
    public String frequencySort(String str) {
        char[] ch = new char[62];
        int[] count = new int[62];
        int arrInd = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int ind = indexOf(ch, c);

            if (ind == -1) {
                ch[arrInd] = c;
                count[arrInd] = 1;
                arrInd++;
            } else {
                count[ind]++;
                while (ind > 0 && count[ind] > count[ind - 1]) {
                    char tempChar = ch[ind];
                    ch[ind] = ch[ind - 1];
                    ch[ind - 1] = tempChar;

                    int tempCount = count[ind];
                    count[ind] = count[ind - 1];
                    count[ind - 1] = tempCount;

                    ind--;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arrInd; i++) {
            for (int j = 0; j < count[i]; j++) {
                res.append(ch[i]);
            }
        }
        return res.toString();
    }

    public static int indexOf(char[] list, char c) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == c) {
                return i;
            }
        }
        return -1;
    }
}