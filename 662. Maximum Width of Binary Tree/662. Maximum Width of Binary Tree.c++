class Solution {
public:
    int widthOfBinaryTree(TreeNode* root) {
        vector<int> minPos{0};
        int maxWidth = 0;
        callDFS(root, 0, 0, minPos, maxWidth);
        return maxWidth;
    }
    
    void callDFS(TreeNode* node, int level, int pos, vector<int>& minPos, int& maxWidth) {
        if(!node) return;
        if(minPos.size() == level) minPos.push_back(pos);
        int diff = pos - minPos[level];
        maxWidth = max(maxWidth, diff + 1);
        callDFS(node->left, level + 1, diff * 2, minPos, maxWidth);
        callDFS(node->right, level + 1, diff * 2 + 1, minPos, maxWidth);
    }
};
