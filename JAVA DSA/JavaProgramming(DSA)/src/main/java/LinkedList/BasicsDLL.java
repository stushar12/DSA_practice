package LinkedList;

public class BasicsDLL {
    public static void main(String[] args) {
        DLLNode obj = new DLLNode();
        int[] arr = {10, 9, 4, 1, 7};
        DLLNode head = obj.convertArray2DLL(arr);
        DLLNode modifiedHead = obj.reverseDLL(head);
        obj.traverseDLL(modifiedHead);
    }
}

class DLLNode {
    int data;
    DLLNode next;
    DLLNode back;

    DLLNode(int data, DLLNode nextPtr, DLLNode prev) {
        this.data = data;
        this.back = prev;
        this.next = nextPtr;
    }

    DLLNode(int data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }

    DLLNode() {

    }

    public DLLNode convertArray2DLL(int[] arr) {
        if (arr.length == 0) return null;
        DLLNode head = new DLLNode(arr[0]);
        DLLNode prev = head;

        for (int i = 1; i < arr.length; i++) {
            DLLNode temp = new DLLNode(arr[i]);
            prev.next = temp;
            temp.back = prev;
            prev = temp;
        }
        return head;
    }

    public void traverseDLL(DLLNode head) {
        DLLNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void traverseDLLReverse(DLLNode head) {
        DLLNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        DLLNode reverseTemp = temp;
        while (reverseTemp != null) {
            System.out.print(reverseTemp.data + "  ");
            reverseTemp = reverseTemp.back;
        }
        System.out.println();
    }

    public int countDLLNodes(DLLNode head) {
        int count = 0;
        DLLNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public boolean valueExistsInDLL(DLLNode head, int valueToBeSearched) {
        DLLNode temp = head;
        while (temp != null) {
            if (temp.data == valueToBeSearched) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public DLLNode deleteHeadInDLL(DLLNode head) {
        if (head == null || head.next == null) return null;
        DLLNode prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;
        return head;
    }

    public DLLNode deleteTailInDLL(DLLNode head) {
        if (head == null || head.next == null) return null;
        DLLNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        System.out.println(temp.data);
        temp.back.next = null;
        temp.back = null;
        return head;
    }

    public DLLNode deleteKthElementInDLL(DLLNode head, int k) {
        if (head == null) return head;
        DLLNode prev = null;
        DLLNode next = null;
        if (k == 1) return deleteHeadInDLL(head);

        DLLNode temp = head;
        int currentCounter = 0;
        while (temp != null) {
            currentCounter++;
            if (currentCounter == k) {
                prev = temp.back;
                next = temp.next;
                if (prev != null) {   //means we have to delete first element in the array
                    prev.next = next;
                }
                if (next != null) {   //means we have to delete last element in the array
                    next.back = prev;
                }
                temp.next = null;
                temp.back = null;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public DLLNode deleteElementInDLL(DLLNode head, int val) {
        if (head == null) return head;
        else if (head.data == val) return head.next;
        DLLNode prev = null;
        DLLNode next = null;
        DLLNode temp = head;
        while (temp != null) {
            if (temp.data == val) {
                prev = temp.back;
                next = temp.next;
                prev.next = prev.next.next;
                if (prev != null) {   //means we have to delete first element in the array
                    prev.next = next;
                }
                if (next != null) {   //means we have to delete last element in the array
                    next.back = prev;
                }
                temp.next = null;
                temp.back = null;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public DLLNode insertAtHeadInDLL(DLLNode head, int val) {
        DLLNode newNode = new DLLNode(val);
        newNode.next = head;
        head.back = newNode;
        return newNode;
    }

    public DLLNode insertAtTailInDLL(DLLNode head, int val) {
        DLLNode newNode = new DLLNode(val);
        if (head.next == null) {
            newNode.next = head;
            head.back = newNode;
            return newNode;
        }
        DLLNode temp = head;
        DLLNode prev = null;
        while (temp.next != null) {
            temp = temp.next;
        }
        prev = temp.back;
        prev.next = newNode;
        newNode.back = prev;
        newNode.next = temp;
        temp.back = newNode;
        return head;
    }

    public DLLNode insertAtKPositionInDLL(DLLNode head, int val, int k) {
        DLLNode newNode = new DLLNode(val);
        int llLength = countDLLNodes(head);
        if (head == null) return newNode;
        else if (k == 1) return insertAtHeadInDLL(head, val);
        else if (llLength + 1 == k) return insertAtTailInDLL(head, val);
        else if (llLength < k) {
            System.out.println("Not possible");
            return null;
        }
        DLLNode temp = head;
        DLLNode prev = null;
        int currentCounter = 0;

        while (temp != null) {
            currentCounter++;
            if (currentCounter == k) {
                prev = temp.back;
                prev.next = newNode;
                newNode.back = prev;
                newNode.next = temp;
                temp.back = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public DLLNode insertElementBeforeValueInDLL(DLLNode head, int data, int val) {
        DLLNode newNode = new DLLNode(data);
        if (head == null) return newNode;
        else if (head.data == val) return insertAtHeadInDLL(head, data);
        else if (!valueExistsInDLL(head, val)) {
            System.out.println("Not possible");
            return null;
        }
        DLLNode temp = head;
        DLLNode prev = null;
        while (temp != null) {
            if (temp.data == val) {
                prev = temp.back;
                prev.next = newNode;
                newNode.back = prev;
                newNode.next = temp;
                temp.back = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public DLLNode reverseDLL(DLLNode head) {
        DLLNode temp = head;
        if (temp == null || temp.next == null) return temp;
        DLLNode lastNode = null;
        while (temp != null) {
            lastNode = temp.back;
            temp.back = temp.next;
            temp.next = lastNode;
            temp = temp.back;
        }
        return lastNode.back;
    }

}