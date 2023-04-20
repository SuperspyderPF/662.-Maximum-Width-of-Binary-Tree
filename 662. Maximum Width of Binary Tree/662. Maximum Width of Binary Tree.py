class Solution:
    def widthOfBinaryTree(self, root: TreeNode) -> int:
        minPos = [0]
        maxWidth = 0
        self.callDFS(root, 0, 0, minPos, maxWidth)
        return maxWidth
    
    def callDFS(self, node: TreeNode, level: int, pos: int, minPos: List[int], maxWidth: int) -> None:
        if not node:
            return
        if len(minPos) == level:
            minPos.append(pos)
        diff = pos - minPos[level]
        maxWidth = max(maxWidth, diff + 1)
        self.callDFS(node.left, level + 1, diff * 2, minPos, maxWidth)
        self.callDFS(node.right, level + 1, diff * 2 + 1, minPos, maxWidth)
