class Solution:
    def longestCommonPrefix(self, strs: list[str]) -> str:
        common_index = 0; strs.sort(key=len)
        for i in range(len(strs[0])):
            check = True
            char = strs[0][i]
            for j in strs:
                if j[i] != char:
                    check = False
                    break
            if check:
                common_index += 1
            else:
                break
        
        return strs[0][:common_index]