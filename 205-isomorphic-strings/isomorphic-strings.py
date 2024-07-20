class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        st = []
        ts = []
        for i in s:
            st.append(s.index(i))
        for j in t:
            ts.append(t.index(j))
        return st == ts