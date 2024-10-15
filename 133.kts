class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}

class Solution {
    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null

        val nodeMapping = mutableMapOf<Node, Node>()
        nodeMapping[node] = Node(node.`val`)
        val queue = ArrayDeque<Node>()
        queue.addLast(node)

        while (queue.isNotEmpty()) {
            val currNode = queue.removeFirst()
            val mappedNode = nodeMapping[currNode]!!
            for (neighbor in currNode.neighbors) {
                if (neighbor == null) continue

                if (!nodeMapping.containsKey(neighbor)) {
                    nodeMapping[neighbor] = Node(neighbor.`val`)
                    queue.addLast(neighbor)
                }

                mappedNode.neighbors.add(nodeMapping[neighbor])
            }
        }

        return nodeMapping[node]
    }
}