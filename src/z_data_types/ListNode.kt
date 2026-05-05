package z_data_types

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

// ─────────────────────────────────────────────
// CONSTRUCTION
// ─────────────────────────────────────────────

/** Build a linked list from a list of integers. Returns the head node, or null if empty. */
fun createLinkedList(values: List<Int>): ListNode? {
    if (values.isEmpty()) return null
    val head = ListNode(values[0])
    var current = head
    for (i in 1..<values.size) {
        current.next = ListNode(values[i])
        current = current.next!!
    }
    return head
}

/** Convenience overload — accepts varargs: fromVararg(1, 2, 3, 4, 5) */
fun fromVararg(vararg values: Int): ListNode? = createLinkedList(values.toList())

/** Build a cyclic linked list (last node points back to the node at `cyclePos`).
 *  cyclePos = -1 means no cycle (same as a plain list). */
fun fromListWithCycle(values: List<Int>, cyclePos: Int = -1): ListNode? {
    if (values.isEmpty()) return null
    val head = createLinkedList(values)
    if (cyclePos < 0 || cyclePos >= values.size) return head

    var tail = head
    var cycleEntry: ListNode? = null
    var idx = 0
    var current = head
    while (current != null) {
        if (idx == cyclePos) cycleEntry = current
        if (current.next == null) tail = current
        current = current.next
        idx++
    }
    tail!!.next = cycleEntry
    return head
}

// ─────────────────────────────────────────────
// CONVERSION
// ─────────────────────────────────────────────

/** Convert a linked list back to a Kotlin List<Int> (cycle-safe). */
fun toList(head: ListNode?): List<Int> {
    val result = mutableListOf<Int>()
    val visited = mutableSetOf<ListNode>()
    var current = head
    while (current != null && visited.add(current)) {
        result.add(current.`val`)
        current = current.next
    }
    return result
}

// ─────────────────────────────────────────────
// PRINTING / DISPLAY
// ─────────────────────────────────────────────

/** Print the list as:  1 -> 2 -> 3 -> 4 -> 5 -> null */
fun printLinkedList(head: ListNode?) = println(listToString(head))

/** Return a string representation: "1 -> 2 -> 3 -> null" */
fun listToString(head: ListNode?): String {
    if (head == null) return "null"
    val sb = StringBuilder()
    val visited = mutableSetOf<ListNode>()
    var current: ListNode? = head
    while (current != null) {
        if (!visited.add(current)) {
            sb.append("... (cycle back to ${current.`val`})")
            return sb.toString()
        }
        sb.append(current.`val`)
        sb.append(" -> ")
        current = current.next
    }
    sb.append("null")
    return sb.toString()
}

/** Pretty-print with index labels:  [0]:1 -> [1]:2 -> [2]:3 -> null */
fun printWithIndices(head: ListNode?) {
    if (head == null) {
        println("null"); return
    }
    val sb = StringBuilder()
    var current: ListNode? = head
    var idx = 0
    val visited = mutableSetOf<ListNode>()
    while (current != null && visited.add(current)) {
        sb.append("[$idx]:${current.`val`} -> ")
        current = current.next
        idx++
    }
    if (current != null) sb.append("... (cycle)")
    else sb.append("null")
    println(sb.toString())
}

// ─────────────────────────────────────────────
// SIZE / STRUCTURE
// ─────────────────────────────────────────────

/** Return the number of nodes (cycle-safe). */
fun size(head: ListNode?): Int {
    var count = 0
    val visited = mutableSetOf<ListNode>()
    var current = head
    while (current != null && visited.add(current)) {
        count++
        current = current.next
    }
    return count
}

/** Return true if the list is empty (head == null). */
fun isEmpty(head: ListNode?): Boolean = head == null

/** Detect whether the list contains a cycle (Floyd's tortoise & hare). */
fun hasCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head
    while (fast != null && fast.next != null) {
        slow = slow?.next
        fast = fast.next?.next
        if (slow === fast) return true
    }
    return false
}

/** Find the node where a cycle begins, or null if no cycle. */
fun detectCycleStart(head: ListNode?): ListNode? {
    var slow = head
    var fast = head
    var hasCycle = false
    while (fast != null && fast.next != null) {
        slow = slow?.next
        fast = fast.next?.next
        if (slow === fast) {
            hasCycle = true; break
        }
    }
    if (!hasCycle) return null
    slow = head
    while (slow !== fast) {
        slow = slow?.next
        fast = fast?.next
    }
    return slow
}

// ─────────────────────────────────────────────
// SEARCH / ACCESS
// ─────────────────────────────────────────────

/** Return the node at a given 0-based index, or null if out of bounds. */
fun getNodeAt(head: ListNode?, index: Int): ListNode? {
    var current = head
    var i = 0
    while (current != null) {
        if (i == index) return current
        current = current.next
        i++
    }
    return null
}

/** Return the value at a given index, or null if out of bounds. */
fun getValueAt(head: ListNode?, index: Int): Int? = getNodeAt(head, index)?.`val`

/** Find the first node with the given value, or null if not found. */
fun findFirst(head: ListNode?, value: Int): ListNode? {
    var current = head
    while (current != null) {
        if (current.`val` == value) return current
        current = current.next
    }
    return null
}

/** Return true if any node holds the given value. */
fun contains(head: ListNode?, value: Int): Boolean = findFirst(head, value) != null

/** Return the tail node, or null if the list is empty / cyclic. */
fun getTail(head: ListNode?): ListNode? {
    if (head == null) return null
    val visited = mutableSetOf<ListNode>()
    var current = head
    while (current!!.next != null) {
        if (!visited.add(current)) return null  // cycle detected
        current = current.next!!
    }
    return current
}

// ─────────────────────────────────────────────
// COMPARISON
// ─────────────────────────────────────────────

/** Return true if two linked lists have identical values in the same order. */
fun areEqual(a: ListNode?, b: ListNode?): Boolean {
    var p = a;
    var q = b
    while (p != null && q != null) {
        if (p.`val` != q.`val`) return false
        p = p.next; q = q.next
    }
    return p == null && q == null
}

/** Return true if the list is a palindrome. */
fun isPalindrome(head: ListNode?): Boolean {
    val values = toList(head)
    return values == values.reversed()
}

/** Return true if the list is sorted (ascending by default). */
fun isSorted(head: ListNode?, ascending: Boolean = true): Boolean {
    var current = head ?: return true
    while (current.next != null) {
        val ok = if (ascending) current.`val` <= current.next!!.`val`
        else current.`val` >= current.next!!.`val`
        if (!ok) return false
        current = current.next!!
    }
    return true
}

// ─────────────────────────────────────────────
// AGGREGATES
// ─────────────────────────────────────────────

fun sum(head: ListNode?): Int = toList(head).sum()
fun max(head: ListNode?): Int? = toList(head).maxOrNull()
fun min(head: ListNode?): Int? = toList(head).minOrNull()
fun average(head: ListNode?): Double? = toList(head).takeIf { it.isNotEmpty() }?.average()

// ─────────────────────────────────────────────
// DEEP COPY
// ─────────────────────────────────────────────

/** Return a deep copy of the list (does not share nodes with the original). */
fun deepCopy(head: ListNode?): ListNode? = createLinkedList(toList(head))


