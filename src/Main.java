import java.util.*;

public class Main {

    // bai so 26
//    public static int removeDuplicates(int[] nums) {
//        int n = nums.length;
//        int j = 1;
//        for (int i = 1; i < n; i++) {
//            if(nums[i] != nums[i-1] ) {
//                nums[j] = nums[i];
//                j++;
//            }
//        }
//        return j;
//    }

// bai so 27
//    public static int removeElement(int[] nums, int val) {
//
//        int j = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i] != val) {
//                nums[j] = nums[i]; j++;
//            }
//        }
//
//        return j;
//
//    }

    //bai 36
//    public static int searchInsert(int[] nums, int target) {
//        int l = 0;
//        int r = nums.length -1;
//        if (target <nums[0]) return 0;
//        if (target > nums[nums.length-1]) return nums.length;
//        while (l < r) {
//            int m = (l + r) /2;
//            if (target > nums[m]) l = m;
//            if (target == nums[m]) return m;
//            else r = m-1;
//        }
//        return l +1;
//    }

    // bai 58
//    public static int lengthOfLastWord(String s) {
//        s= s.trim();
//        int index = s.lastIndexOf(" ");
//        String s1 = s.substring(index +1);
//        return s1.length();
//    }

    // bai so 66
//    public static int[] plusOne(int[] digits) {
//        for (int i = digits.length -1; i >= 0; i--) {
//            if (digits[i] < 9) {
//                digits[i]++;
//                return digits;
//            }
//            digits[i] = 0;
//        }
//
//        int digits2[] = new int[digits.length + 1];
//        digits2[0] = 1;
//        return digits2;
//    }

    // bai so 67
//    public static String addBinary(String a, String b) {
//        StringBuilder res = new StringBuilder();
//        int i = a.length() -1;
//        int j = b.length() -1;
//        int nho = 0;
//        while (i >= 0 || j >= 0) {
//            int sum = nho;
//            if (i >=0) sum+= Integer.parseInt(String.valueOf(a.charAt(i))); i--;
//            if (j >=0) sum+= Integer.parseInt(String.valueOf(a.charAt(j))); j--;
//            nho = sum > 1 ? 1: 0;
//            res.append(sum %2);
//        }
//        if (nho != 0) res.append(nho);
//
//        return res.reverse().toString();
//    }
    //
    // bai so 69
//    public static int mySqrt(int x) {
//        if (x == 0 || x == 1) return 0;
//        int l = 1,r = x, mid = -1;
//        while(l <= r) {
//            mid = (l + r) / 2;
//            if((long)mid*mid > (long)x) r = mid;
//            else if (mid *mid == x) return mid;
//            else l = mid-1;
//        }
//        return Math.round(r);
//    }

    // bai 94 treeNode
//    /**
//     * Definition for a binary tree node.
//     * public class TreeNode {
//     *     int val;
//     *     TreeNode left;
//     *     TreeNode right;
//     *     TreeNode() {}
//     *     TreeNode(int val) { this.val = val; }
//     *     TreeNode(int val, TreeNode left, TreeNode right) {
//     *         this.val = val;
//     *         this.left = left;
//     *         this.right = right;
//     *     }
//     * }
//     */
//    class Solution {
//        //List<Integer> a = new ArrayList<>();
//        public List<Integer> inorderTraversal(TreeNode root) {
//            // if (root == null) return new ArrayList<>();
//            // inorderTraversal(root.left);
//            // a.add(root.val);
//            // inorderTraversal(root.right);
//            TreeNode x = root;
//            List<Integer> list = new ArrayList<>();
//            Stack<TreeNode> stack = new Stack<TreeNode>();
//            while (x != null || !stack.isEmpty()) {
//                while (x != null ) {
//                    stack.push(x);
//                    x= x.left;
//                }
//                x = stack.pop();
//                list.add(x.val);
//                x = x.right;
//            }
//
//            return list;
//        }
//    }

    // bai 118
//    public static List<List<Integer>> generate(int numRows) {
//        int n = numRows;
//        List<List<Integer>> result = new ArrayList<>();
//        if( n == 0) return result;
//        List<Integer> first = new ArrayList<>();
//        first.add(1);
//        result.add(first);
//        for(int i = 1; i  < n  ;i++) {
//            List<Integer> prevRow = result.get(i-1);
//            List<Integer> currentRow = new ArrayList<>();
//            currentRow.add(1);
//            for (int j = 1 ; j < i; j++) {
//                currentRow.add(prevRow.get(j) + prevRow.get(j-1));
//            }
//            currentRow.add(1);
//            result.add(currentRow);
//        }
//        return result;
//    }

    // bai 121
//    public static int maxProfit(int[] prices) {
//        int maxProfit = 0;
//        int minPrice = prices[0];
//        for (int i = 1; i < prices.length; i++) {
//            if( maxProfit < prices[i] - minPrice ) {
//                maxProfit = prices[i] - minPrice;
//            }
//            if(prices[i] < minPrice) minPrice = prices[i];
//        }
//        return maxProfit;
//    }
//    public int singleNumber(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i = 0 ; i < nums.length; i++) {
//            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//            //map[nums[i]]++;
//        }
//        for( int num :nums) {
//            if(map.get(num) == 1) {
//                return num;
//            }
//        }
//        return 0;
//    }
//    public static int majorityElement(int[] nums) {
//        int n= nums.length;
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            map.put(nums[i],map.getOrDefault(nums[i], 0) +1 );
//        }
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() > n/2) {
//                return entry.getKey();
//            }
//        }
//        return 0;
//    }
//bai 217
//    public static boolean containsDuplicate(int[] nums) {
//        int i = 0, dem = 1;
//        Arrays.sort(nums);
//        while (i < nums.length -1 ) {
//            if (nums[i] != nums[i+1]) dem++;
//            i++;
//        }
//        if(dem == nums.length) return false;
//        return true;
//    }
    
    // 219
//    public static boolean containsNearbyDuplicate(int[] nums, int k) {
////        for (int i = 0; i < nums.length -k ; i++) {
////            for (int j = i+1; j < i+k+1 ;  j++) {
////                if(nums[i] == nums[j] ) return true;
////            }
////        }
////        return false;
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k) {
//                return true;
//            }
//            map.put(nums[i], i);
//        }
//
//        return false;
//    }

    // 268
//    public static int missingNumber(int[] nums) {
//        int n = nums.length;
//        int[] temp = new int[n+1];
//        Arrays.fill(temp, -1);
//        for (int i = 0; i < n; i++) {
//            temp[nums[i]] = nums[i];
//        }
//        for (int i = 0; i < temp.length; i++) {
//            if(temp[i] == -1) {
//                return i;
//            }
//        }
//        return temp.length+1;
//    }

    // 349
//    public static int[] intersection(int[] nums1, int[] nums2) {
//        Set<Integer> set1 = new HashSet<>();
//        Set<Integer> set2 = new HashSet<>();
//        for (int x : nums1) {
//            set1.add(x);
//        }
//        for (int x : nums2) {
//            set2.add(x);
//        }
//
//        set1.retainAll(set2);
//        int[] ans = new int[set1.size()];
//        int index= 0;
//        for (int x: set1) {
//            ans[index] = x;
//        }
//        return ans;
//    }

    //350
//    public static int[] intersect(int[] nums1, int[] nums2) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int x : nums1) map.put(x, map.getOrDefault(x, 0) +1);
//        List<Integer> list = new ArrayList<>();
//        for(int x : nums2) {
//            if(map.containsKey(x) && map.get(x) > 0) {
//                list.add(x) ;
//                int y = map.get(x);
//                y--;
//                map.put(x, y);
//            }
//        }
//
//        int [] ar = new int[];
//        for (int i = 0; i < list.size(); i++) {
//            ar[i] = list.get(i);
//        }
//        return ar;
//    }

    // 125
////    public static boolean isPalindrome(String s) {
////        StringBuilder stringBuilder = new StringBuilder();
////        StringBuilder stringBuilder1 = new StringBuilder();
////        if(s.equals("")) return true;
////        s = s.toLowerCase().trim();
////        for (int i = 0; i < s.length(); i++) {
////            char x = s.charAt(i);
////            if(x >= 'a' && x <= 'z' || x >= '0' && x<='9') {
////                stringBuilder.append(x);
////            }
////        }
////
////        for (int i = stringBuilder.length()-1;i >= 0; i--) {
////            stringBuilder1.append(stringBuilder.charAt(i));
////        }
////        return stringBuilder.toString().equals(stringBuilder1.toString());
//
//    }\

//// 168
//    public static String convertToTitle(int columnNumber) {
//        StringBuilder columnName = new StringBuilder();
//        while (columnNumber > 0) {
//            int mod = (columnNumber - 1) % 26;
//            columnName.insert(0, (char) (mod + 'A'));
//            columnNumber = (columnNumber - mod) / 26;
//        }
//        return columnName.toString();
//    }
//
//    //171
//    public static int convertToTitle(String columnTitle) {
//        int res = 0;
//        for (int i = 0; i < columnTitle.length(); i++) {
//            res *= 26;
//            res+= (columnTitle.charAt(i)-'A' +1);
//        }
//        return res;
//    }
    public static void main(String[] args) {

    }
}