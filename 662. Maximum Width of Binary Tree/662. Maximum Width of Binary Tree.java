class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> minPos = new ArrayList<Integer>();
        int maxWidth = 0;
        callDFS(root, 0, 0, minPos, maxWidth);
        return maxWidth;
    }
    
    public void callDFS(TreeNode node, int level, int pos, List<Integer> minPos, int maxWidth) {
        if(node == null) return;
        if(minPos.size() == level) minPos.add(pos);
        int diff = pos - minPos.get(level);
        maxWidth = Math.max(maxWidth, diff + 1);
        callDFS(node.left, level + 1, diff * 2, minPos, maxWidth);
        callDFS(node.right, level + 1, diff * 2 + 1, minPos, maxWidth);
    }
}
