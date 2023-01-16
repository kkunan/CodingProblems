package leetcode.linkedlist

class Cycle {
    class Solution {
        // we intentionally create self-loop for each node, and if we saw that again, it's a loop
        fun hasCycle(head: ListNode?): Boolean {
            // no node
            if(head == null){
                return false
            }

            // loop itself at head
            if(head.next == head){
                return true
            }
            if(head.next == null){
                return false
            }

            // at this point, should be at least two nodes
            var current = head
            var next = head.next

            while(next != null){
                if(current?.next == current){
                    return true
                }
                next = current?.next
                current?.next = current
                current = next
                next = current?.next
            }
            return false

        }
    }
}