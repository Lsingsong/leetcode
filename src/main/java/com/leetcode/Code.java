package com.leetcode;

import com.model.ListNode;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Code {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
//        Stream<String> stream = Arrays.stream(s.split(" "));
//        int[] sts = stream.mapToInt(Integer::parseInt).toArray();
//        Main.TreeNode root = new Main.TreeNode(sts[0]);
//        Deque<Main.TreeNode> treeNodes = new ArrayDeque<>();
//        treeNodes.push(root);
//        boolean flag = true;
//        Main.TreeNode node1 = new Main.TreeNode(-1);
//        for (int i=1; i<sts.length; i++) {
//            Main.TreeNode node = treeNodes.peekLast();
//            Main.TreeNode node2 = new Main.TreeNode(sts[i]);
//            Main.TreeNode treeNode = treeNodes.peekLast();
//            while (!treeNodes.isEmpty() && treeNode.val < node2.val) {
//                node = treeNodes.removeLast();
//                if (!treeNodes.isEmpty()) {
//                    node1 = treeNodes.peekLast();
//                }
//            }
//
//            assert node != null;
//            if (node.val >= node2.val) {
//                if (node2.val < node1.val) {
//                    flag = false;
//                    break;
//                }
//                node.left = node2;
//            } else {
//                node.right = node2;
//                node1 = node;
//            }
//            treeNodes.addLast(node2);
//        }
//        if (flag) {
//            test(root);
//        } else {
//            System.out.println("0 0 0");
//        }


        System.out.println(lengthOfLastWord("}{"));
    }























    public static int lengthOfLastWord(String s) {
        String[] s1 = s.trim().split(" ");
        return s1[s1.length-1].length();
    }







    public static boolean find(String st) {
        if (StringUtils.isEmpty(st) || st.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = st.toCharArray();
        for (int i=0; i<chars.length; i++) {
            if (')' == chars[i]) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character peek = stack.peek();
                if ('(' == peek) {
                    stack.pop();
                }
            } else if ('(' == chars[i]) {
                stack.push(chars[i]);
            }
            if ('}' == chars[i]) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character peek = stack.peek();
                if ('{' == peek) {
                    stack.pop();
                }
            } else if ('{' == chars[i]) {
                stack.push(chars[i]);
            }
            if (']' == chars[i]) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character peek = stack.peek();
                if ('[' == peek) {
                    stack.pop();
                }
            } else if ('[' == chars[i]) {
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty();
    }

    //判断两个位置的字符是否匹配
    public static boolean find2(String st, int left, int right) {
        char c1 = st.charAt(left);
        char c2 = st.charAt(right);
        if ('(' == c1 && ')' == c2) {
            return true;
        } else if ('{' == c1 && '}' == c2) {
            return true;
        } else if ('[' == c1 && ']' == c2) {
            return true;
        } else {
            return false;
        }
    }






























    public static String findString(String st, int num) {
        String na = "NA";
        if (StringUtils.isEmpty(st) || 0 == num) {
            return na;
        }
        String[] sts = st.split(" ");
        int length = sts.length;
        if (length < num) {
            return na;
        }
        //String[] strings = new String[length + 1];
        final Map<String, Integer> map = new LinkedHashMap<>(length);
        Arrays.stream(sts)
                .filter(k->!StringUtils.isEmpty(k))
                .forEach(k->{
                    if (map.containsKey(k)) {
                        map.put(k, map.get(k) + 1);
                    } else {
                        map.put(k, 1);
                    }
                });
//        //方式1
//        map.forEach((k,v) -> strings[v] = k);
//        return strings[num] == null ? na : strings[num];
        //方式2
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (num == entry.getValue()) {
                na = entry.getKey();
            }
        }
        return na;
    }

















    static class TreeNode {
        int val;
        Main.TreeNode left;
        Main.TreeNode right;

        public TreeNode() {

        }
        public TreeNode(int val) {
            this.val = val;
        }
    }





    public static void test(Main.TreeNode root) {
        Main.TreeNode rightNode = root;
        while (rightNode.left != null || rightNode.right != null) {
            if (rightNode.right != null) {
                rightNode = rightNode.right;
            } else {
                rightNode = rightNode.left;
            }
        }
        Main.TreeNode leftNode = root;
        while (leftNode.left != null || leftNode.right != null) {
            if (leftNode.left != null) {
                leftNode = leftNode.left;
            } else {
                leftNode = leftNode.right;
            }
        }
        int left = leftNode.val == root.val ? 0 : leftNode.val;
        int right = rightNode.val == root.val ? 0 : rightNode.val;
        System.out.println("1 " + (left) + " " + (right));
    }

































    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) { // 当数组只有一个元素时结束递归
            int partitionIndex = partition(arr, left, right); // 对数组进行划分，获取基准元素位置
            quickSort(arr, left, partitionIndex - 1); // 对左子数组递归执行快速排序
            quickSort(arr, partitionIndex + 1, right); // 对右子数组递归执行快速排序
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left]; // 将数组的第一个元素设置为基准元素
        int i = left; // 初始化左指针
        int j = right; // 初始化右指针
        while (i < j) { // 当左指针和右指针没有相遇时循环
            while (i < j && arr[j] >= pivot) { // 右指针从右向左遍历，找到第一个小于基准元素的元素
                j--;
            }
            if (i < j) { // 如果左指针和右指针没有相遇，将右指针所指的元素赋值给左指针所指的位置
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i] < pivot) { // 左指针从左向右遍历，找到第一个大于等于基准元素的元素
                i++;
            }
            if (i < j) { // 如果左指针和右指针没有相遇，将左指针所指的元素赋值给右指针所指的位置
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = pivot; // 将基准元素放到最终位置
        return i; // 返回基准元素的位置
    }



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = buildStack(l1);
        Stack<Integer> l2Stack = buildStack(l2);
        ListNode head = new ListNode(-1);
        int carry = 0;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0) {
            int x = l1Stack.isEmpty() ? 0 : l1Stack.pop();
            int y = l2Stack.isEmpty() ? 0 : l2Stack.pop();
            int sum = x + y + carry;
            ListNode node = new ListNode(sum % 10);
            node.next = head.next;
            head.next = node;
            carry = sum / 10;
        }
        return head.next;
    }

    private Stack<Integer> buildStack(ListNode l) {
        Stack<Integer> stack = new Stack<>();
        while (l != null) {
            stack.push(l.val);
            l = l.next;
        }
        return stack;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        if (fast == null) return head.next;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }

    public static int maxSubArray(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
           return 2;
        }
        if (N == 2) {
            return 3;
        }
        if (N == 3) {
            return 3;
        }

        int num = (int)Math.pow(2, N);

        int s = 0;
        for (int i = 1; i<N; i++) {
            s = s + i;
        }
        return num - s;
    }

    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    public void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public String reverseOnlyLetters2(String s) {
        StringBuilder st = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i <= chars.length - 1; i++) {
            char c = chars[i];
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                st.append(c);
            }
        }
        int index = 0;
        char[] chars1 = st.toString().toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            if ((c > 'a' && c < 'z') || (c > 'A' && c < 'Z')) {
                chars[i] = chars1[index++];
            }
        }
        return new String(chars);
    }


    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }


    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (size > num.length || size < 1)
            return ret;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);  /* 大顶堆 */
        for (int i = 0; i < size; i++)
            heap.add(num[i]);
        ret.add(heap.peek());
        for (int i = 0, j = i + size; j < num.length; i++, j++) {            /* 维护一个大小为 size 的大顶堆 */
            heap.remove(num[i]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }


    public static ArrayList<Integer> GetLeastNumbers_Solution2(int[] nums, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (k > nums.length || k <= 0)
            return ret;
        findKthSmallest(nums, k - 1);
        /* findKthSmallest 会改变数组，使得前 k 个数都是最小的 k 个数 */
        for (int i = 0; i < k; i++)
            ret.add(nums[i]);
        return ret;
    }

    public static void findKthSmallest(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition1(nums, l, h);
            if (j == k)
                break;
            if (j > k)
                h = j - 1;
            else
                l = j + 1;
        }
    }

    private static int partition1(int[] nums, int l, int h) {
        int p = nums[l];     /* 切分元素 */
        int i = l, j = h + 1;
        while (true) {
            while (i != h && nums[++i] < p) ;
            while (j != l && nums[--j] > p) ;
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
        if (k > nums.length || k <= 0)
            return new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }

    public static boolean IsPopOrder(int[] pushSequence, int[] popSequence) {
        int n = pushSequence.length;
        Stack<Integer> stack = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushSequence[pushIndex]);
            while (popIndex < n && !stack.isEmpty()
                    && stack.peek() == popSequence[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public static int[] FindGreatestSumOfSubArray(int[] array) {
        // 动态规划，初始化第一位的最大子数组为自己，长度为1，结束下标为0
        int sum = array[0], len = 1;
        // 初始化最优的子数组的和、长度、结束下标
        int max_sum = array[0], max_len = 1, res_i = 0;

        //从第1位开始动态规划，遍历
        for (int i = 1; i < array.length; i++) {
            //递推条件，更新当前位置最大子数组和、子数组长度
            if (array[i] + sum >= array[i]) {
                sum += array[i];
                len += 1;
            } else {
                sum = array[i];
                len = 1;
            }

            //更新目前最大子数组和，以及最大长度和结束下标
            if (sum > max_sum) {
                max_sum = sum;
                max_len = len;
                res_i = i;
            } else if (sum == max_sum) {
                if (len > max_len) {
                    max_len = len;
                    res_i = i;
                }
            }
        }
        //返回对应的子数组
        return Arrays.copyOfRange(array, res_i + 1 - max_len, res_i + 1);
    }

    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }

    public static int findRepeatNumber(int[] nums) {
        //检查参数合法性
        if (nums == null || nums.length == 0) return -1;
        //数组中有数字不在0~n-1范围内时不符合题意，直接返回-1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] > nums.length - 1) return -1;
        }
        int[] temp = new int[nums.length];//声明数组用于标记nums数组中每个数字出现的次数
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]]++;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > 1) {//次数大于1，i就是重复的
                return i;//注意返回的是i，temp[i]是出现的次数，i才是重复的数字
            }
        }
        Set<Integer> objects = new HashSet<>();
        return -1;//没有重复的数字
    }

    public ListNode ReverseList(ListNode head) {
        //pre指针：用来指向反转后的节点，初始化为null
        ListNode pre = null;
        //当前节点指针
        ListNode cur = head;
        //循环迭代
        while (cur != null) {
            //Cur_next 节点，永远指向当前节点cur的下一个节点
            ListNode Cur_next = cur.next;
            //反转的关键：当前的节点指向其前一个节点(注意这不是双向链表，没有前驱指针)
            cur.next = pre;
            //更新pre
            pre = cur;
            //更新当前节点指针
            cur = Cur_next;
        }
        //为什么返回pre？因为pre是反转之后的头节点
        return pre;
    }

    public String ReverseSentence(String str) {
        String[] st = str.trim().split(" ");
        List<String> strings = new ArrayList<>(Arrays.asList(st));
        Collections.reverse(strings);

        return String.join(" ", strings);
    }
}
