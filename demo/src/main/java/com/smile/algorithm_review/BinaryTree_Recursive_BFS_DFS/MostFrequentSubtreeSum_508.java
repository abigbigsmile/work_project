package com.smile.algorithm_review.BinaryTree_Recursive_BFS_DFS;

import com.smile.algorithm.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MostFrequentSubtreeSum_508 {



    /* -----------------------------------
     *  WARNING:
     * -----------------------------------
     *  Your code may fail to compile
     *  because it contains public class
     *  declarations.
     *  To fix this, please remove the
     *  "public" keyword from your class
     *  declarations.
     */

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    public int[] findFrequentTreeSum(TreeNode root) {
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        Map<Integer, Integer> map = new HashMap<>();
        if(root!=null) countSum_x(map, root);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }
        if (queue.isEmpty()) return new int[0];
        List<Integer> list = new ArrayList<>();
        int count = queue.peek().getValue();
        while (!queue.isEmpty()) {
            if (queue.peek().getValue() == count) list.add(queue.poll().getKey());
            else break;
        }
        int[] result = list.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }

    /*public void helper(Map<Integer, Integer> map, TreeNode root, Map<TreeNode, Integer> rem) {
        if (root == null) return;
        map.put(countSum(root, rem), map.getOrDefault(countSum(root, rem), 0) + 1);
        helper(map, root.left,  rem);
        helper(map, root.right, rem);
    }


    public int countSum(TreeNode root, Map<TreeNode, Integer> rem) {
        if (root == null) return 0;
        if(rem.containsKey(root)) return rem.get(root);
        int res = root.val + countSum(root.left, rem) + countSum(root.right, rem);
        rem.put(root, res);
        return res;
    }*/

    public int countSum_x(Map<Integer, Integer> map, TreeNode root) {
        int leftSum=0,rightSum=0,res=0;

        if(root.left!=null){
            leftSum = countSum_x(map, root.left);
            //map.put(leftSum, map.getOrDefault(leftSum, 0) + 1);
        }
        if(root.right!=null) {
            rightSum = countSum_x(map, root.right);
            //map.put(rightSum, map.getOrDefault(rightSum, 0) + 1);
        }

        res = root.val + leftSum + rightSum;
        map.put(res, map.getOrDefault(res, 0) + 1);
        return res;
    }
}


class MainClass {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int[] ret = new MostFrequentSubtreeSum_508().findFrequentTreeSum(root);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}
