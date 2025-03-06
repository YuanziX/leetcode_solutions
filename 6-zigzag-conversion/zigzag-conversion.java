class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder res = new StringBuilder();

        char[][] mat = new char[numRows][s.length()];

        int index = 0;
        int i = 0, j = 0;
        boolean down = true;
        char[] input = s.toCharArray();

        while (index < input.length) {
            if (down) {
                mat[i++][j] = input[index++];
            } else {
                mat[i--][j] = input[index++];
            }

            if (down && i == numRows) {
                down = false;
                i -= 2;
                j++;
            }

            if (!down && i == 0) {
                down = true;
                j++;
            }
        }

        for (i = 0; i < mat.length; i++) {
            for (j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != '\u0000')
                    res.append(mat[i][j]);
            }
        }

        return res.toString();
    }
}