package e_may

import z_data_types.ListNode
import z_data_types.createLinkedList
import z_data_types.printLinkedList

fun main() {

    val testCases = listOf(
        Pair(
            listOf(1, 2, 3, 4, 5), 2
        )
    )

    testCases.forEach { (list, k) ->
        val head = createLinkedList(list)
        val newHead = rotateRight(head, k)
        printLinkedList(newHead)
    }

}

// TC - O(n) :: SC - O(1)
fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head == null) return null

    var n = 1
    var curr: ListNode? = head
    while (curr?.next != null) {
        n++
        curr = curr.next
    }

    curr?.next = head
    curr = head
    for (i in 0..<(n - (k % n)) - 1) curr = curr?.next

    val newHead = curr?.next
    curr?.next = null
    return newHead
}
