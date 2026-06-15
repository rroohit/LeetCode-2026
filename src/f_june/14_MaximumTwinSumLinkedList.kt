package f_june

import z_data_types.ListNode
import z_data_types.createLinkedList

fun main() {

    val testCases = listOf(
        listOf(5, 4, 2, 1),
        listOf(4, 2, 2, 3),
        listOf(1, 100000)
    )

    testCases.forEach { list ->
        val head = createLinkedList(list)
        println("Result ==> ${pairSum(head)}")
    }

}

// TC - O(n) :: SC - O(n)
fun pairSum(head: ListNode?): Int {
    var slow: ListNode? = head
    var fast: ListNode? = head

    while (fast != null && fast.next != null) {
        fast = fast.next?.next
        slow = slow?.next
    }

    var rightHead: ListNode? = null
    while (slow != null) {
        val temp = slow.next
        slow.next = rightHead
        rightHead = slow
        slow = temp
    }

    var leftHead = head
    var maxPair = 0
    while (rightHead != null && leftHead != null) {
        maxPair = maxOf(
            maxPair,
            rightHead.`val` + leftHead.`val`
        )
        leftHead = leftHead.next
        rightHead = rightHead.next
    }

    return maxPair
}

// TC - O(n) :: SC - O(n)
fun pairSum1(head: ListNode?): Int {
    val stack = ArrayDeque<ListNode>()
    var curr: ListNode? = head
    while (curr != null) {
        stack.addLast(curr)
        curr = curr.next
    }

    var i = stack.size / 2
    curr = head
    var max = 0

    while (i-- > 0) {
        val a = curr?.`val` ?: 0
        val b = stack.removeLast().`val`
        max = maxOf(a + b, max)
        curr = curr?.next
    }

    return max
}