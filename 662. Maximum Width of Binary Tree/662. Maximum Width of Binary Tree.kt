class Solution {
    fun widthOfBinaryTree(root: TreeNode?): Int {
        val minPos = mutableListOf(0)
        var maxWidth = 0
        callDFS(root, 0, 0, minPos, maxWidth)
        return maxWidth
    }
    
    fun callDFS(node: TreeNode?, level: Int, pos: Int, minPos: MutableList<Int>, maxWidth: Int) {
        if (node == null) return
        if (minPos.size == level) minPos.add(pos)
        val diff = pos - minPos[level]
        maxWidth = maxOf(maxWidth, diff + 1)
        callDFS(node.left, level + 1, diff * 2, minPos, maxWidth)
        callDFS(node.right, level + 1, diff * 2 + 1, minPos, maxWidth)
    }
}
