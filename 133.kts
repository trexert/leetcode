class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}

class Solution {
    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null

        val nodeMapping = Array<Node?>(101) { null }
        nodeMapping[node.`val`] = Node(node.`val`)
        val queue = ArrayDeque<Node>()
        queue.addLast(node)

        while (queue.isNotEmpty()) {
            val currNode = queue.removeFirst()
            val mappedNode = nodeMapping[currNode.`val`]!!
            for (neighbor in currNode.neighbors) {
                if (neighbor == null) continue

                val mappedNeighbor = nodeMapping[neighbor.`val`] ?: Node(neighbor.`val`).also {
                    nodeMapping[neighbor.`val`] = it
                    queue.addLast(neighbor)
                }

                mappedNode.neighbors.add(mappedNeighbor)
            }
        }

        return nodeMapping[node.`val`]
    }
}