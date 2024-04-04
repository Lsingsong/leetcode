package com.leetcode;

import com.model.ListNode;
import com.model.TreeNode;
import com.service.Singleton;
import javafx.util.Pair;

import java.util.*;
import java.util.stream.Stream;

public class Main {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {

        }
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Stream<String> stream = Arrays.stream(s.split(" "));
        int[] sts = stream.mapToInt(Integer::parseInt).toArray();
        Main.TreeNode root = new Main.TreeNode(sts[0]);
        Deque<Main.TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.push(root);
        boolean flag = true;
        Main.TreeNode node1 = new Main.TreeNode(-1);
        for (int i=1; i<sts.length; i++) {
            TreeNode node = treeNodes.peekLast();
            TreeNode node2 = new TreeNode(sts[i]);
            while (!treeNodes.isEmpty() && treeNodes.peekLast().val < node2.val) {
                node = treeNodes.removeLast();
                if (!treeNodes.isEmpty()) {
                    node1 = treeNodes.peekLast();
                }
            }

            assert node != null;
            if (node.val >= node2.val) {
                if (node2.val < node1.val) {
                    flag = false;
                    break;
                }
                node.left = node2;
            } else {
                node.right = node2;
                node1 = node;
            }
            treeNodes.addLast(node2);
        }
        if (flag) {
            test(root);
        } else {
            System.out.println("0 0 0");
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


//    public ListNode reverseList(ListNode head) {
//        ListNode newHead = new ListNode(-1);
//        while (head != null) {
//            ListNode next = head.next;
//            head.next = newHead.next;
//            newHead.next = head;
//            head = next;
//        }
//        return newHead.next;
//    }


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
//        Stream<String> stream = Arrays.stream(s.split(" "));
//        k = Integer.parseInt(in.nextLine());
//        int[] ns = stream.mapToInt(Integer::parseInt).toArray();
//        Arrays.sort(ns);
//        dfs1(ns, Integer.parseInt(in.nextLine()), 0, 0, 0);
//        System.out.println(result);
//    }
//
//    public static int k;
//    public static int result = 0;
//
//    public static void dfs1(int[] ns, int target, int m, int value, int ct) {
//        int i = m;
//        for (;;) {
//            if (i<ns.length) {
//                if (i > m && ns[i-1] == ns[i]) {
//                    i++;
//                    continue;
//                } else {
//                    int c = ct + 1;
//                    if (c == k) {
//                        if (target == value + ns[i]) {
//                            result++;
//                        } else {
//                            i++;
//                            continue;
//                        }
//                    } else {
//                        dfs1(ns, target, i+1, ns[i] + value, ct + 1);
//                    }
//                }
//            } else {
//                break;
//            }
//            i++;
//        }
//    }





//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String card = in.nextLine();
//        String lCard = in.nextLine();
//        Map<String, Integer> map = new HashMap<>();
//        Arrays.stream(cards).forEach(k-> map.put(k, 4));
//        test(map, card);
//        test(map, lCard);
//        int left = 0;
//        int right = 0;
//        for (int i=0; i<cards.length; i++) {
//            String card1 = cards[i];
//            if (map.get(card1) > 0) {
//                left = i;
//                while (i < cards.length - 1 && map.get(cards[i+1]) > 0) {
//                    i++;
//                }
//                right = i + 1;
//            }
//        }
//        String result = "NO-CHAIN";
//        if (right - left >= 5) {
//            StringBuilder stringBuffer = new StringBuilder();
//            for (int i=left; i<right; i++) {
//                stringBuffer.append(cards[i]).append("-");
//            }
//            if (stringBuffer.length() > 0) {
//                result = stringBuffer.substring(0, stringBuffer.length() - 1);
//            }
//        }
//        System.out.println(result);
//    }
//
//    public static String[] cards = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
//    private static void test(Map<String, Integer> map, String st) {
//        String[] sts = st.split("-");
//        Arrays.stream(sts).filter(map::containsKey).forEach(k->{
//            map.put(k, map.get(k) - 1);
//        });
//    }










































    public int maxProfit1(int[] prices) {
        int max = 0;
        if (prices.length == 1) {
            return 0;
        }
        int low = prices[0];
        for (int i=1; i<prices.length; i++) {
            if (low > prices[i]) {
                low = prices[i];
            } else {
                max = Math.max(max, prices[i] - low);
            }
        }
        return max;
    }

    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int right=0; right<nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (n == 0) {
                cur = nums1[p1--];
            } else if (m == 0) {
                cur = nums2[p2--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }


    private int m, n;
    private final int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        m = grid.length;
        n = grid[0].length;
        if (r < 0 || c < 0 || r >=m || c >= n || grid[r][c]==0) {
            return 0;
        }
        grid[r][c] = 0;
        int area = 1;
        for (int[] d : direction) {
            area += dfs(grid, r + d[0] , c + d[1]);
        }
        return area;
    }

    public static int shortestPathBinaryMatrix(int[][] grids) {
        if (grids == null || grids.length == 0 || grids[0].length == 0) {
            return -1;
        }
        int[][] direction = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};
        int m = grids.length;
        int n = grids[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0,0));
        int pathLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            while (size-- > 0) {
                Pair<Integer, Integer> cur = queue.poll();
                int cr = cur.getKey(), cc = cur.getValue();
                if (grids[cr][cc] == 1) {
                    continue;
                }
                if (cr == m - 1 && cc == n - 1) {
                    return pathLength;
                }
                grids[cr][cc] = 1; // 标记
                for (int[] d : direction) {
                    int nr = cr + d[0], nc = cc + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }
                    queue.add(new Pair<>(nr, nc));
                }
            }
        }
        return -1;
    }


//    public static int shortestPathBinaryMatrix(int[][] grids) {
//        if (grids == null || grids.length == 0 || grids[0].length == 0) {
//            return -1;
//        }
//        int[][] direction = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
//        int m = grids.length, n = grids[0].length;
//        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
//        queue.add(new Pair<>(0, 0));
//        int pathLength = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            pathLength++;
//            while (size-- > 0) {
//                Pair<Integer, Integer> cur = queue.poll();
//                int cr = cur.getKey(), cc = cur.getValue();
//                if (grids[cr][cc] == 1) {
//                    continue;
//                }
//                if (cr == m - 1 && cc == n - 1) {
//                    return pathLength;
//                }
//                grids[cr][cc] = 1; // 标记
//                for (int[] d : direction) {
//                    int nr = cr + d[0], nc = cc + d[1];
//                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
//                        continue;
//                    }
//                    queue.add(new Pair<>(nr, nc));
//                }
//            }
//        }
//        return -1;
//    }


    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
           return 0;
        }
        int min = prices[0];
        int max = 0;
        for (int k=1; k<prices.length; k++) {
            if (min > prices[k]) {
                min = prices[k];
            } else {
                max = Math.max(max, prices[k]-min);
            }
        }
        return max;
    }

    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char n : s.toCharArray()) {
            index = t.indexOf(n, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }


    public List<Integer> test1(String s) {
        int[] charIndex = new int[26];
        for (int i=0; i<s.length(); i++) {
            charIndex[s.charAt(i) - 'a'] = i;
        }
        List<Integer> arrayList = new ArrayList<>();
        int firstIndex = 0;
        while (firstIndex < s.length()) {
            int lastIndex = firstIndex;
            for (int i=firstIndex; i<s.length() && i<=lastIndex; i++) {
                int charIndex1 = charIndex[s.charAt(i) - 'a'];
                if (charIndex1 > lastIndex) {
                    lastIndex = charIndex1;
                }
            }
            arrayList.add(lastIndex - firstIndex + 1);
            firstIndex = lastIndex + 1;
        }
        return arrayList;
    }


    public static int test(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int a = nums[0];
        int max = a;
        for (int k=1; k<nums.length; k++) {
            a = a > 0 ? a = a + nums[k] : nums[k];
            max = Math.max(a, max);
        }
        return max;
    }

    private volatile static Singleton uniqueInstance;

    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode i = headA;
        ListNode j = headB;
        while (i != j) {
            if (i==null) {
                i = headB;
            } else {
                i = i.next;
            }
            if (i == null) {
                j = headA;
            } else {
                j = j.next;
            }
        }
        return i;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode i=head;
        while (n-- > 0) {
            i = i.next;
        }
        if (i==null) {
            return head.next;
        }
        ListNode j=head;
        while (i.next !=null) {
            i = i.next;
            j = j.next;
        }
        j.next = j.next.next;
        return head;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode listNode = new ListNode(-1);
        while (head != null) {
            ListNode node = head.next;
            head.next = listNode.next;
            listNode.next = head;
            head = node;
        }
        return listNode.next;
    }

    public int binarySearch(int[] nums, int key) {
        int i=0;
        int j=nums.length-1;
        while (i<j) {
            int m = i + (j-i)/2;
            if (nums[m] == key) {
                return m;
            } else if (nums[m] > key) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return -1;
    }


    public static int topK3(int[] arr, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int i=0; i<k; i++) {
            maxHeap.add(arr[i]);
        }
        for (int i=k; i<arr.length; i++) {
            int top = maxHeap.peek();
            if (arr[i] > top) {
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }
        return maxHeap.peek();
    }

    public static int topK2(int[] arr, int k){
        int i=0;
        int j=arr.length-1;
        int index = partition(arr, i, j);
        while (index != k-1) {
            if (index > k-1) {
                index = partition(arr, i, index-1);
            } else {
                index = partition(arr, index + 1, j);
            }
        }
        return arr[index];
    }

    public static int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        int i = left;
        int j = right;
        while (i<j) {
            while (i<j && arr[j] > temp) {
                j--;
            }
            if (i<j) {
                arr[i] = arr[j];
                i++;
            }
            while (i<j && arr[i] < temp) {
                i++;
            }
            if (i<j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = temp;
        return i;
    }


    static Map<Character,Integer> map1 = new HashMap<>();
    static Map<Character,Integer> map2 = new HashMap<>();

    public static String minWindow(String s, String t) {
        for(int i = 0; i < t.length(); i ++) {
            map1.put(t.charAt(i), map1.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0;
        int r = 0;
        int minLength = s.length();
        int markL = -1;
        int markR = -1;

        while(r < s.length()) {
            //右滑动
            if(map1.containsKey(s.charAt(r))) {
                map2.put(s.charAt(r), map2.getOrDefault(s.charAt(r),0) + 1);
            }
            r ++;

            //左滑动
            while(judge()) {
                if((r - l) <= minLength) {
                    minLength = r - l;
                    markL = l;
                    markR = r;
                }
                if(map1.containsKey(s.charAt(l))) {
                    map2.put(s.charAt(l), map2.getOrDefault(s.charAt(l),0) - 1);
                }
                l ++;
            }
        }

        return markL == -1 ? "" : s.substring(markL,markR);
    }

    public static boolean judge() {
        for(Character ch : map1.keySet()) {
            if(map1.get(ch) > map2.getOrDefault(ch, 0)) return false;
        }
        return true;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(list);
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            cur = node.right;
        }
        return list;
    }

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        TreeNode node = new TreeNode();
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            node = treeNodes.poll();
            if (node.right != null) {
                treeNodes.add(node.right);
            }
            if (node.left != null) {
                treeNodes.add(node.left);
            }
        }
        return node.val;
    }


    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Double> result = new ArrayList<>();
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            double n = 0;
            for (int i=0; i<size; i++) {
                TreeNode node = treeNodes.poll();
                n = n + node.val;
                if (node.left != null) {
                    treeNodes.add(node.left);
                }
                if (node.right != null) {
                    treeNodes.add(node.right);
                }
            }
            result.add(n/size);
        }
        return result;
    }

    public static void treeDFS(TreeNode root) {
        if (root == null) {
           return;
        }
        System.out.println(root.val + " ");
        treeDFS(root.left);
        treeDFS(root.right);
    }

    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
           return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.val + " ");
        inOrderTraversal(node.right);
    }

    public static void inOrderTraversal2(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.println(node.val + " ");
                node = node.right;
            }
        }
    }

    public static void postOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        postOrder(tree.left);
        postOrder(tree.right);
        System.out.println(tree.val + " ");
    }

    public static void postOrder2(TreeNode tree) {
        if (tree == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(tree);
        while (!stack1.isEmpty()) {
            TreeNode treeNode = stack1.pop();
            stack2.push(treeNode);
            if (treeNode.left != null) {
                stack1.push(treeNode.left);
            }
            if (treeNode.right != null) {
                stack1.push(treeNode.right);
            }
        }
        while (!stack2.isEmpty()) {
            TreeNode treeNode2 = stack2.pop();
            System.out.println(treeNode2.val + " ");
        }
    }

    public static void preOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        System.out.println(tree.val + " ");
        preOrder(tree.left);
        preOrder(tree.right);
    }

    public static void preOrder2(TreeNode tree) {
        if (tree == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(tree);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            System.out.println(treeNode.val + " ");
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
    }


    public static void levelOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        List<List<Integer>> lists = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();;
        stack.add(tree);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.poll();
            List<Integer> list = new ArrayList<>();
            list.add(treeNode.val);
            if (treeNode.left != null) {
                stack.add(tree.left);
            }
            if (treeNode.right != null) {
                stack.add(tree.right);
            }
            lists.add(list);
        }
        System.out.println(lists);
    }

    public static void levelOrder2(TreeNode tree) {
        int depth = depth(tree);
        for (int i=0; i<depth; i++) {
            printLevel(tree, i);
        }
    }

    private static void printLevel(TreeNode tree, int level) {
        if (tree == null) {
            return;
        }
        if (level == 0) {
            System.out.println(" " + tree.val);
        } else {
            printLevel(tree.left, level -1);
            printLevel(tree.right, level-1);
        }
    }

    private static int depth(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        int depth1 = depth(tree.left);
        int depth2 = depth(tree.right);
        return Math.max(depth1, depth2) + 1;
    }

//    public static boolean isB = true;
//
//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int i = maxDepth(root.left);
//        int j = maxDepth(root.right);
//        if (Math.abs(i - j) > 1) {
//            isB = false;
//        }
//        return Math.max(i,j) + 1;
//    }

//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//    }
//    public ListNode mergeKLists(ListNode[] lists) {
//        ListNode head = null;
//        for (ListNode list : lists) {
//            head = mergeTwoLists(head, list);
//        }
//        return head;
//    }
//
//    public ListNode mergeTwoLists(ListNode a, ListNode b) {
//        ListNode head = new ListNode(-1);
//        ListNode first = head;
//        ListNode aP = a;
//        ListNode bP = b;
//        while (aP != null && bP != null) {
//            if (aP.val < bP.val) {
//                first.next = aP;
//                aP = aP.next;
//            } else {
//                first.next = bP;
//                bP = bP.next;
//            }
//            first = first.next;
//        }
//        first.next = aP != null ? aP : bP;
//        return head.next;
//    }
//
//    public int binarySearch(int[] nums, int key) {
//        int i = 0;
//        int j= nums.length-1;
//        while (i<j) {
//            int index = i + (j -i)/2;
//            if (nums[index] == key) {
//               return index;
//            } else if (nums[index] > key) {
//                j = index -1;
//            } else {
//                i = index + 1;
//            }
//        }
//        return -1;
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n1 = in.nextInt();
//        int[] n1s = new int[n1];
//        for (int i=0; i<n1; i++) {
//            n1s[i] = in.nextInt();
//        }
//        int n2 = in.nextInt();
//        int[] n2s = new int[n2];
//        for (int i=0; i<n2; i++) {
//            n2s[i] = in.nextInt();
//        }
//        List<Integer> objects = new ArrayList<>(n1 * n2);
//        for (int s1 : n1s) {
//            for (int s2 : n2s) {
//                objects.add(s1 + s2);
//            }
//        }
//        int sum = 0;
//        int count = in.nextInt();
//        List<Integer> collect = objects.stream().sorted().collect(Collectors.toList());
//        for (int a : collect) {
//            if (count > 0) {
//                sum = sum + a;
//                count--;
//            }
//        }
//        System.out.println(sum);
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String st = in.nextLine();
//        String[] strings = st.split(";");
//        int x = 0;
//        int y = 0;
//        for (String s : strings) {
//            if (null == s || s.length() == 0 || !s.matches("^[AWSD]\\d+$")) {
//                continue;
//            }
//            char c = s.charAt(0);
//            int sum = Integer.parseInt(s.substring(1));
//            if (c == 'A') {
//                x = x - sum;
//            } else if (c == 'D') {
//                x = x + sum;
//            }  else if (c == 'W') {
//                y = y + sum;
//            }else if (c == 'S') {
//                y = y - sum;
//            }
//        }
//        System.out.printf("%d,%d\n", x, y);
//    }
}
