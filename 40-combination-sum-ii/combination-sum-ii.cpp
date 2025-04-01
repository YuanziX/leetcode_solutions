class Solution {
public:
    void help(int id, int sum, int target, vector<int> &candidates, vector<int> &cur, vector<vector<int>> &ot) {
        if (sum == target) {
            ot.push_back(cur);
            return;
        }
        if (id >= candidates.size() || sum > target) return;

        for (int i = id; i < candidates.size(); i++) {
            if (i > id && candidates[i] == candidates[i - 1]) continue;

            cur.push_back(candidates[i]);
            help(i + 1, sum + candidates[i], target, candidates, cur, ot);
            cur.pop_back();
        }
    }

    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<int> cur;
        vector<vector<int>> ot;
        help(0, 0, target, candidates, cur, ot);
        return ot;
    }
};
