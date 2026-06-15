package f_june

import z_data_types.ListNode
import z_data_types.createLinkedList
import z_data_types.printLinkedList

fun main() {

    val testCases = listOf(
        listOf(1, 3, 4, 7, 1, 2, 6),
        listOf(1, 2, 3, 4),
        listOf(2, 1)
    )

    testCases.forEach { list ->
        val head = createLinkedList(list)
        val result = deleteMiddle(head)
        printLinkedList(result)
    }


}

// TC - O(n) :: SC - O(1)
fun deleteMiddle(head: ListNode?): ListNode? {
    if (head?.next == null) return null
    var slow : ListNode? = head
    var fast : ListNode? = head.next
    while (fast?.next != null && fast.next?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }
    slow?.next = slow.next?.next
    return head
}

// TC - O(n) :: SC - O(1)
fun deleteMiddle1(head: ListNode?): ListNode? {
    val dummy = ListNode().apply { next = head }
    var slow: ListNode? = dummy
    var fast: ListNode? = dummy
    while (fast?.next != null && fast.next?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }
    slow?.next = slow.next?.next
    return dummy.next
}