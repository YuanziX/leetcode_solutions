class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        group_anagram = {}
        for word in strs:
            group_anagram.setdefault(''.join(sorted(word)), []).append(word)
        
        return list(group_anagram.values())