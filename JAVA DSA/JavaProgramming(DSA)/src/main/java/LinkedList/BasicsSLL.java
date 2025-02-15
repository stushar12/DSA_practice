package LinkedList;

public class BasicsSLL {
    public static void main(String[] args) {
        Node obj = new Node();
        int[] arr1 = {0, 2};
        int[] arr2 = {1, 2, 2, 1};
        Node head1 = obj.convertArray2LL(arr1);
        Node head2 = obj.convertArray2LL(arr2);
        boolean head3 = obj.isPalindromeLL(head2);
        System.out.println(head3);
//        obj.traverseLL(head3);
    }
}

class Node {
    int data;
    Node next;

    Node(int data, Node nextPtr) {
        this.data = data;
        this.next = nextPtr;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node() {

    }

    public Node convertArray2LL(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public void traverseLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int countLLNodes(Node head) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public boolean valueExistsInLL(Node head, int valueToBeSearched) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == valueToBeSearched) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public Node deleteHeadInLL(Node head) {
        if (head == null) return head;
        head = head.next;
        return head;
    }

    public Node deleteTailInLL(Node head) {
        if (head == null || head.next == null) return null;
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public Node deleteKthElementInLL(Node head, int k) {
        if (head == null) return head;
        Node prev = null;
        if (k == 1) return deleteHeadInLL(head);

        Node temp = head;
        int currentCounter = 0;
        while (temp != null) {
            currentCounter++;
            if (currentCounter == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public Node deleteElementInLL(Node head, int val) {
        if (head == null) return head;
        else if (head.data == val) return head.next;
        Node prev = null;
        Node temp = head;
        while (temp != null) {
            if (temp.data == val) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public Node insertAtHeadInLL(Node head, int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        return newNode;
    }

    public Node insertAtTailInLL(Node head, int val) {
        Node newNode = new Node(val);
        Node temp = head;
        if (head == null) return newNode;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public Node insertAtKPositionInLL(Node head, int val, int k) {
        Node newNode = new Node(val);
        int llLength = countLLNodes(head);
        if (head == null) return newNode;
        else if (k == 1) return insertAtHeadInLL(head, val);
        else if (llLength + 1 == k) return insertAtTailInLL(head, val);
        else if (llLength < k) {
            System.out.println("Not possible");
            return null;
        }
        Node temp = head;
        Node prev = null;
        int currentCounter = 0;

        while (temp != null) {
            currentCounter++;
            if (currentCounter == k) {
                newNode.next = prev.next;
                prev.next = newNode;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public Node insertElementBeforeValueInLL(Node head, int data, int val) {
        Node newNode = new Node(data);
        if (head == null) return newNode;
        else if (head.data == val) return insertAtHeadInLL(head, data);
        else if (!valueExistsInLL(head, val)) {
            System.out.println("Not possible");
            return null;
        }
        Node temp = head;

        while (temp != null) {
            if (temp.next.data == val) {
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    /**
     * Takes 2 list and sum them up and return a new head
     *
     * @param head1 Node
     * @param head2 Node
     * @return Node
     */
    public Node add2LL(Node head1, Node head2) {
        if (head1 == null && head2 == null) return null;
        else if (head1 == null) return head2;
        else if (head2 == null) return head1;
        Node temp1 = head1, temp2 = head2;
        Node dummyNode = new Node(-1);
        Node head3 = dummyNode;
        int carry = 0;

        while (temp1 != null || temp2 != null) {
            int sum1 = temp1 == null ? 0 : temp1.data;
            int sum2 = temp2 == null ? 0 : temp2.data;
            int sum = sum1 + sum2 + carry;
            carry = sum / 10;
            Node newNode = new Node(sum % 10);
            head3.next = newNode;
            temp1 = temp1 == null ? null : temp1.next;
            temp2 = temp2 == null ? null : temp2.next;
            head3 = head3.next;
        }

        if (carry > 0) {
            Node newNode = new Node(carry);
            head3.next = newNode;
        }

        return dummyNode.next;
    }


    /**
     * groups oddIndex nodes followed by evenIndex nodes
     *
     * @param head
     * @return Node
     */
    public Node groupOddEvenIndexLL(Node head) {
        if (head == null || head.next == null) return head;
        Node odd = head;
        Node even = head.next;
        Node evenHead = head.next;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        //now points oddEnd to evenHead

        odd.next = evenHead;
        return head;
    }

    public Node sor012LL(Node head) {
        if (head == null || head.next == null) return head;
        Node temp = head;
        Node onesHead = null;
        Node twosHead = null;
        Node twosPointer = null;
        Node onesPointer = null;
        Node zeroesPointer = null;
        Node zeroHead = null;

        while (temp != null) {
            if (temp.data == 0) {
                if (zeroesPointer == null) {
                    zeroesPointer = temp;
                    zeroHead = zeroesPointer;
                } else {
                    zeroesPointer.next = temp;
                    zeroesPointer = zeroesPointer.next;
                }
            } else if (temp.data == 1) {
                if (onesPointer == null) {
                    onesPointer = temp;
                    onesHead = onesPointer;
                } else {
                    onesPointer.next = temp;
                    onesPointer = onesPointer.next;
                }
            } else {
                if (twosPointer == null) {
                    twosPointer = temp;
                    twosHead = twosPointer;
                } else {
                    twosPointer.next = temp;
                    twosPointer = twosPointer.next;
                }
            }
            temp = temp.next;
        }
        if (zeroesPointer == null) {
            zeroHead = onesPointer != null ? onesHead : twosHead;
        }
        if (zeroesPointer != null)
            zeroesPointer.next = onesHead != null ? onesHead : twosHead;
        if (onesPointer != null)
            onesPointer.next = twosHead;

        if (twosPointer != null) {
            twosPointer.next = null;
        }

        return zeroHead;
    }

    public Node removeNthNodeFromEndInLL(Node head, int n) {
        if (head == null) return null;
        Node fast = head, slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        //means you have to delete head
        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public Node reverseLL(Node head) {
        if (head == null || head.next == null) return head;

        Node previousNode = null, currentNode = head, nextNode = head.next;

        while (currentNode.next != null) {
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            nextNode = nextNode.next;
        }
        currentNode.next = previousNode;

        return currentNode;
    }

    public Node addOneToLL(Node head) {
        if (head == null) {
            return new Node(1);
        }
        Node temp = head;
        int carryLeft = helper(temp, 1);
        if (carryLeft == 1) {
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }
        return head;
    }

    public int helper(Node head, int carry) {
        if (head.next == null) {
            int sum = (head.data + carry);
            head.data = sum % 10;
            carry = sum / 10;
            return carry;
        }
        int carryOver = helper(head.next, carry);
        int sum = head.data + carryOver;
        head.data = sum % 10;
        return sum / 10;
    }

    public boolean isPalindromeLL(Node head) {
        if (head == null || head.next == null) return true;
        Node temp = head;
        Node middleNode = findMiddleNode(head);
        Node reverseLLHead = reverseLL(middleNode.next);
        Node reverseHeadClone = reverseLLHead;

        while (reverseLLHead != null) {
            if (temp.data != reverseLLHead.data) {
                reverseLL(reverseHeadClone);
                return false;
            }
            temp = temp.next;
            reverseLLHead = reverseLLHead.next;
        }
        reverseLL(reverseHeadClone);
        return true;
    }

    public Node findMiddleNode(Node head) {
        if (head == null || head.next == null) return head;
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {   // first condition is for odd length link list and second one is for even length link list
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
}
