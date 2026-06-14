package f_june

import z_data_types.ListNode

fun main() {


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