package Arrays;

import java.time.chrono.MinguoChronology;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import Sorting.Sort;
// leetcode arrays easy
public class mainArrays {

	
    //448
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) { 
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        List<Integer> result = new ArrayList<>();
       
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
	
	
	// 455
	public static int findContentChildren(int[] g, int[] s) {
		int count =0,l =0,r=0;
		if (s == null || g == null) return 0;
		
		Arrays.sort(g);
		Arrays.sort(s);
		
		while(l < g.length && r < s.length) {
			int child = g[l];
			int cook = s[r];
			if(cook < child) r++;
			if( cook >= child) {
				count ++;
				r++;l++;
			}
		}
		
		return count;
	}

	
	//463
	public static int islandPerimeter(int[][] grid) {
		int row = grid.length, col = grid[0].length;
		int s = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col ; j++) {
				if(grid[i][j] == 1) {
					s+=4;
				}
				if(i > 0 && grid[i-1][j] == 1) s-=2;
				if(j > 0 && grid[i][j-1] == 1) s-=2;
			}
		}
		return s;
	}
    
	
	//485
	public static  int findMaxConsecutiveOnes(int[] nums) {
        int[] count = new int[nums.length]; 
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 0) x++;
			else count[x]++;
		}
        int m = count[0];
        for (int i : count) {
			if(i  > m) m = i;
		}
        return m;
    }
	
	
	//495
	public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = duration;
        if(timeSeries == null) return 0;
        for (int i = 0; i < timeSeries.length-1; i++) {
			if(timeSeries[i+1] - timeSeries[i] >= duration ) {
				count += duration;
			}else {
				count += timeSeries[i+1] - timeSeries[i] ;
			}
		}
		return count;
    }
	
	
	//496
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
		int [] ans = new int[n];int max = nums2[0];
        int[] vt =new int[n];
        for (int i = 0; i < m; i++) {
			if(max < nums2[i]) max = nums2[i];
		}
        
        int [] check = new int[max+1];
        for (int i = 0; i < max+1; i++) {
			check[i] = 0;
		}
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(nums1[i] == nums2[j]) vt[i] = j;
			}
		}
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(nums1[i] < nums2[j] && vt[i] < j) {check[nums1[i]] = nums2[j];break;}
				else check[nums1[i]] = -1;
			}
		}
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < check.length; j++) {
				if(nums1[i] == j) ans[i] = check[j];
			}
		}
		return ans;
    }
	
	
	//500
	public static String[] findWords(String[] words) {
        String[] n = new String[words.length];
        int k = 0;
        for(int i = 0; i < words.length; i++){
            int check = row(words[i].charAt(0));
            for(int j = 1; j < words[i].length(); j++){
                if(check != row(words[i].charAt(j))){
                    check = 0;
                    break;
                }
            }
            if(check!=0){
                n[k] = words[i];
                k++;
            }
        }
        String ans[] = new String[k];
        for(int i = 0; i < k; i ++){
            ans[i] = n[i]; 
        }
        return ans;
    }
    public static int row(char c){
        c = Character.toLowerCase(c);
        String str1= "qwertyuiop";
        String str2= "asdfghjkl";
        String str3= "zxcvbnm";
        if (str1.contains(String.valueOf(c))){
            return 1;            
        }else if(str2.contains(String.valueOf(c))){
            return 2;
        }else if(str3.contains(String.valueOf(c))){
            return 3;
        }
        return 0;
    }
	
    
    // 506
    //Input: score = [10,3,8,9,4]
    //Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
    public static String[] findRelativeRanks(int[] score) {
    	int n = score.length, max = 0;
    	
    	String [] answer = new String[n];
    	for (int i = 0; i < n; i++) {
			max = Math.max(max, score[i]);
		}
    	int[] temp = new int[max+1];
    	for (int i = 0; i < n; i++) {
			temp[score[i]] = i+1;
		}
    	int place =1;
    	for(int i = max; i >= 0; i--) {
    		if(temp[i]==0) continue;
    		int actualPlace = temp[i]-1;
    		if(place == 1) {
    			answer[actualPlace] = "Gold Medal";
    		}else if(place == 2) {
    			answer[actualPlace] = "Silver Medal";
    		}else if(place == 3) {
    			answer[actualPlace] = "Bronze Medal";
    		}else {
    			answer[actualPlace] = String.valueOf(place);
    			
    		}
    		place++;
    	}
    	return answer;
    }
    
    
    //561
    //Input: nums = [6,2,6,5,1,2]
    //Output: 9
    //Explanation: The optimal pairing is (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9.
    public static int arrayPairSum(int[] nums) {
    	nums=Sort.countingSort(nums);
    	int res = 0;
    	for (int i = 0; i < nums.length-1; i+=2) {
			res += nums[i];
		}
        return res;
    }
    
    
    
    //575
    //Input: candyType = [1,1,2,2,3,3]
    //Output: 3
    //Explanation: Alice can only eat 6 / 2 = 3 candies. Since there are only 3 types, she can eat one of each type.
    public static int distributeCandies(int[] candyType) {
        boolean[] types = new boolean[200001]; 
        int count = 0;
        for (int candy : candyType) {
            if (!types[candy + 100000]) {
                types[candy + 100000] = true;
                count++;
            }
        }
        return Math.min(count, candyType.length / 2);
    }
    
    //598
    //Input: m = 3, n = 3, ops = [[2,2],[3,3]]
    //Output: 4
    //Explanation: The maximum integer in M is 2, and there are four of it in M. So return 4.
    public static int maxCount(int m, int n, int[][] ops) {
    	if(ops.length==0){
            return m*n;
        } 
        int minrow=Integer.MAX_VALUE;
        int mincol=Integer.MAX_VALUE;
        for(int[] grid:ops){
            minrow=Math.min(minrow,grid[0]);
            mincol=Math.min(mincol,grid[1]);
        }
        return minrow*mincol;
    }
    
    
    //599
    public static String[] findRestaurant(String[] list1, String[] list2) {
//        // Bước 1: Tạo một HashMap cho list1
//        HashMap<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < list1.length; i++) {
//            map.put(list1[i], i);
//        }
//        // Bước 2: Duyệt qua list2 và tìm các chuỗi chung
//        List<String> result = new ArrayList<>();
//        int minSum = Integer.MAX_VALUE;
//        for (int j = 0; j < list2.length; j++) {
//            if (map.containsKey(list2[j])) {
//                int i = map.get(list2[j]);
//                int sum = i + j;
//
//                // Bước 3: Cập nhật tổng chỉ số nhỏ nhất và danh sách kết quả
//                if (sum < minSum) {
//                    result.clear();
//                    result.add(list2[j]);
//                    minSum = sum;
//                } else if (sum == minSum) {
//                    result.add(list2[j]);
//                }
//            }
//        }
//        // Bước 4: Trả về kết quả
//        return result.toArray(new String[result.size()]);
    	HashMap<String, Integer> map = new HashMap<>();
    	for (int i = 0; i < list1.length; i++) {
			map.put(list1[i], i);
		}
    	List<String> result = new ArrayList<>();
    	int minSum = Integer.MAX_VALUE;
    	for (int i = 0; i < list2.length; i++) {
			if(map.containsKey(list2[i])) {
				int j = map.get(list2[i]);
				int currentSum = i+j;
				
				if(currentSum < minSum) {
					result.clear();
					result.add(list2[i]);
					minSum = currentSum;
				}else if (currentSum == minSum) {
					result.add(list2[i]);
				}
			}
		}
    	return result.toArray(new String[result.size()]);
    }
    
    
    //605
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
//    	int count = 0;
//    	int len = flowerbed.length;
//    	for (int i = 0; i < len; i++) {
//			if(flowerbed[i] == 0 ) {
//				boolean l = (i==0) || (flowerbed[i-1] == 0);
//				boolean r = (i==len-1) || (flowerbed[i+1] == 0);
//				if(l && r) {
//					flowerbed[i] =1;
//					count ++;
//					
//					if(count >= n) return true;
//				}
//			}
//		}
//    	return count >=n;
    	
    	int count = 0;
        for (int i = 0; i < flowerbed.length; i += 2) {
            if (flowerbed[i] == 0) {
                if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                    count++;
                } else {
                    i++;
                }
            }
            if (count >= n) {
                return true;
            }
        }
        return false;
    }
    
    
    //628
    public static int maximumProduct(int[] nums) {
    	Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[n-1]*nums[n-2]*nums[n-3], nums[0]*nums[1]*nums[n-1]);
    }
    
    //628 nâng cấp cho n số
    public static int maximumProduct(int[] nums, int n) {
        Arrays.sort(nums);
        int len = nums.length;
        
        // Trường hợp tích của n số lớn nhất
        int maxProduct = 1;
        for (int i = len - 1; i >= len - n; i--) {
            maxProduct *= nums[i];
        }
        
        // Kiểm tra trường hợp kết hợp các số nhỏ nhất và lớn nhất
        for (int i = 0; i <= n; i++) {
            int tempProduct = 1;
            for (int j = 0; j < i; j++) {
                tempProduct *= nums[j];
            }
            for (int j = len - 1; j >= len - (n - i); j--) {
                tempProduct *= nums[j];
            }
            maxProduct = Math.max(maxProduct, tempProduct);
        }
        
        return maxProduct;
    }
    
    
    
    //643
    public static double findMaxAverage(int[] nums, int k) {
    	double sum = 0;
    	for (int i = 0; i < k; i++) {
			sum+=nums[i];
		}
    	double currentSum = sum;
    	for (int i = 0; i < nums.length-k; i++) {
			currentSum += nums[i+k] - nums[i];
			sum = Math.max(sum, currentSum);
		}
        return sum/k;
    }
    
    
    //674
    public static int findLengthOfLCIS(int[] nums) {
    	int count = 1;
    	if(nums == null) count =0;
    	int n = nums.length;
    	int curCount = count;
    	for (int i = 0; i < n-1; i++) {
			if(nums[i] < nums[i+1]) curCount++; 
			else {
				curCount= 1;
			}
			count = Math.max(count,curCount);
		}
        return count;
    }
    
    
    //682
    public static int calPoints(String[] operations) {
    	int n = operations.length;
    	int[] score = new int[n];
    	int index = 0;
    	for(String op : operations) {
    		if(op.equals("+")) {
    			score[index] = score[index-1] + score[index-2];
    			index++;
    		}else if (op.equals("D")) {
    			score[index] = 2 * score[index - 1];
                index++;
    		}else if(op.equals("C")) {
    			index--;
    		}else {
    			score[index] = Integer.parseInt(op);
    			index++;
    		}
    	}
    	int sum = 0;
    	for (int i = 0; i < index; i++) {
			sum+= score[i];
		}
        return sum;
        
//        Stack<Integer> stack = new Stack<>();
//        for(int i=0; i<operations.length; i++){
//            if(operations[i].equals("C")){
//                stack.pop();
//            }
//            else if(operations[i].equals("D")){
//                stack.push(2* stack.peek());
//            }
//            else if(operations[i].equals("+") && stack.size()>=2){
//                int x = stack.pop();
//                int y = stack.pop();
//                int z = x+y;
//
//                stack.push(y);
//                stack.push(x);
//                stack.push(z);
//            }
//            else{
//                stack.push(Integer.parseInt(operations[i]));
//            }
//        }
//        int sum =0;
//        while(!stack.isEmpty()){
//            sum+=stack.pop();
//        }
//        return sum;
    }
    
    //697
    public static int findShortestSubArray(int[] nums) {
//    	int n = nums.length;
//    	if(n == 1) return 1;
//    	int max=nums[0];
//    	for (int i = 1; i < n; i++) {
//			max = Math.max(max,nums[i]);
//		}
//    	int[] check = new int[max+1];
//    	for (int i = 0; i < n; i++) {
//    		check[nums[i]] ++;
//		}
//    	int degree = 0;
//    	for (int i = 0; i <= max; i++) {
//    		degree = Math.max(degree,check[i]);
//		}
//    	int minLength = Integer.MAX_VALUE;
//    	for (int i = 0; i <= max; i++) {
//			if(check[i] == degree) {
//				int l = 0,r = n-1;
//				while (l <= r) {
//					if(nums[l] == i && nums[r] == i) {
//						minLength = Math.min(minLength, r-l+1);
//						break;
//					}
//					if(nums[l] != i) l++;
//					if(nums[r]!= i) r--;
//				}
//			}
//		}
//        return minLength ;
    	 int max=0;
         for(int n:nums){
             if(max<n)max=n;
         }

         int arr[]=new int[max+1];
         int m=0;
         for(int n:nums){
             arr[n]++;
             if(m<arr[n]) m=arr[n];
         }

         if(m==1) return 1;

         int temp[]=new int[max+1];

         int start = 0;
         int end = 0;
         int n = nums.length;
         int ans = n;
         while(end<nums.length){
             int x = nums[end];
             temp[x]++;
             if(temp[x] == m){
                 while(nums[start]!=x){
                     temp[nums[start]]--;
                     start++;
                 }
                 ans = Math.min(ans,end-start+1);
             }
             end++;
         }
         return ans;
    }

    public static int search(int[] nums, int target) {
    	int l = 0, r = nums.length-1;
    	while(l <=r) {
    		int mid =l+ (r-l)/2;
    		if(nums[mid] == target) return mid;
    		if(nums[mid] > target) r = mid-1;
    		else l = mid+1;
    	}
        return -1;
    }

    
    //717
    public static boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        if (n < 2 ) return true;
        int i = 0;
        while(i < n-1) {
        	if(bits[i] == 1) i+=2;
        	else i++;
        }
        return i==n-1;
    }
    
    
    //724
    public static int pivotIndex(int[] nums) {
        int n = nums.length;
        if(n == 0) return -1;
        int sumL = 0, sumR = 0;
        for(int x : nums) {
        	sumR+= x;
        }
        for (int i = 0; i < n; i++) {
			sumR -= nums[i];
			if(sumR == sumL) return i;
			sumL += nums[i];
		}
        return -1;
    }
    
    
    //744
    public static char nextGreatestLetter(char[] letters, char target) {
        for(char l : letters) {
        	if( l > target) return l;
        }
    	return letters[0];
    }
    
    
    //746 dynamic programming
    public int minCostClimbingStairs(int[] cost) {
    	 int [] dp = new int [cost.length+1];
         for(int i=2; i<cost.length+1; i++) {
             dp[i] = Math.min( dp[i-1]+ cost[i-1], dp[i-2]+ cost[i-2]);
         }
         return dp[dp.length-1];
    }

    public static int dominantIndex(int[] nums) {
    	int n = nums.length;
    	int max  = nums[0],val = 0;
    	for (int i = 0; i < n; i++) {
			if(max < nums[i] ) {
				max = nums[i];val = i;
			}
		}
    	System.out.println(max  + " " + val);
    	for (int i = 0; i < n; i++) {
			if(max/2 < nums[i]) return -1;
		}
        return val;
    }
    
    
    //812
    public static double largestTriangleArea(int[][] points) {
    	int n = points.length;
        double maxArea = 0.0;
        
        // Iterate over all combinations of three points
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Extract points
                    int[] p1 = points[i];
                    int[] p2 = points[j];
                    int[] p3 = points[k];
                    
                    // Calculate area using the Shoelace formula

                    double area = 0.5 * Math.abs(p1[0] * (p2[1] - p3[1]) +
                                                p2[0] * (p3[1] - p1[1]) +
                                                p3[0] * (p1[1] - p2[1]));
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        
        return maxArea;
    }
    
    
    //819. Most Common Word
    public String mostCommonWord(String s, String[] banned) {
        Set<String> set = new HashSet<>();
        for (String b : banned)
            set.add(b);
        char[] cs = s.toCharArray();
        int n = cs.length;
        String ans = null;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n;) {
            if (!Character.isLetter(cs[i]) && ++i >= 0)
                continue;
            int j = i;
            while (j < n && Character.isLetter(cs[j]))
                j++;
            String sub = s.substring(i, j).toLowerCase();
            i = j + 1;
            if (set.contains(sub))
                continue;
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            if (ans == null || map.get(sub) > map.get(ans))
                ans = sub;
        }
        return ans;

    }
    
    
    // 821. Shortest Distance to a Character
    
    public static int[] shortestToChar(String s, char c) {
//    	int n =s.length();
//    	int [] answer = new int[n];
//    	
//    
//    	List<Integer> save= new ArrayList<Integer>();
//    	
//    	for (int i = 0; i < n; i++) {
//			if(s.charAt(i) == c) {
//				save.add(i);
//			}
//		}
//    	
//    	for (int i = 0; i < n; i++) {
//			int min = Integer.MAX_VALUE;
//			for (int j = 0; j < save.size(); j++) {
//				min = Math.min(min, Math.abs(i - save.get(j)));
//			}
//			answer[i] = min;
//		}
//        return answer;
        
        
        int n =s.length();
    	int [] answer = new int[n];
    	
    	int k = 0,count =0;
    	for (int i = 0; i < n; i++) {
			if(s.charAt(i) == c) {
				count++;
			}
		}
    	int save [] = new int[count];
    	for (int i = 0; i < n; i++) {
			if(s.charAt(i) == c) {
				save[k++] = i;
			}
		}
    	
    	for (int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < save.length; j++) {
				min = Math.min(min, Math.abs(i - save[j]));
			}
			answer[i] = min;
		}
        return answer;
    }
    
    
    //860. Lemonade Change
    public static boolean lemonadeChange(int[] bills) {
    	int n = bills.length;
    	if(bills[0] !=5) return false;
    	int count5 = 0,count10 = 0;
    	for (int i = 0; i < n; i++) {
			if(bills[i] == 5) {
				count5++;
			}
			else if(bills[i] == 10) {
				if(count5 == 0) return false;
				else {
					count5--;count10++;
				}
			}else {
				if(count5 == 0 ) return false;
				else if(count5 <3 && count10==0) return false; 
				else {
					if(count5 >=3 && count10 == 0) count5-=3;
					else {
						count5--;count10--;
					}
				}
			}
		}
        return true;
    }
    
    
    //867. Transpose Matrix
    public static int[][] transpose(int[][] matrix) {
    	int row = matrix.length;
    	int col = matrix[0].length;
    	int[][] temp = new int[col][row];
    	for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				temp[i][j] = matrix[j][i];
			}
		}
        return temp;
    }
    
    
    //883. Projection Area of 3D Shapes
    public static int projectionArea(int[][] grid) {
    	int m = grid.length;
    	int n = grid[0].length;
    	int result = 0,x = 0;;
    	for (int i = 0; i < m; i++) {
    		int maxRow = Integer.MIN_VALUE;
    		int maxCol = Integer.MIN_VALUE;
			for (int j = 0; j < n; j++) {
				if(grid[i][j] != 0) x+=1;
				maxRow = Math.max(maxRow,grid[i][j]);
				maxCol = Math.max(maxCol, grid[j][i]);
			}
			result+= maxRow + maxCol;
		}
    	
        return result+x;
    }
    
    
    //888. Fair Candy Swap
    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
    	int sumAlice = 0,sumBob = 0;
        for (int candy : aliceSizes) {sumAlice += candy;}
        for (int candy : bobSizes) { sumBob += candy;}
        int diff = (sumAlice - sumBob) / 2;
        Set<Integer> bobSet = new HashSet<>();
        for (int candy : bobSizes) {
            bobSet.add(candy);
        }
        for (int a : aliceSizes) {
            int b = a - diff;
            if (bobSet.contains(b)) {
                return new int[]{a, b};
            }
        }
        return new int[0];
        
//        Arrays.sort(aliceSizes);
//        Arrays.sort(bobSizes);
//        int i = 0, j = 0;
//        while (i < aliceSizes.length && j < bobSizes.length) {
//            int a = aliceSizes[i];
//            int b = bobSizes[j];
//            if (a - b == diff) {
//                return new int[]{a, b};
//            } else if (a - b < diff) {
//                i++;
//            } else {
//                j++;
//            }
//        }
//        return new int[0];
    }
    
    
    
    //896. Monotonic Array
    public static boolean isMonotonic(int[] nums) {
    	int n=nums.length-1;
        boolean inc=true;
        boolean dec=true;
        for(int i=0;i<n;i++){
            if(nums[i]>nums[i+1])
                inc=false;
            if(nums[i]<nums[i+1])
                dec=false;
        }
        return (inc||dec);
        
        
//        if (nums[0] < nums[nums.length - 1]) {
//            for (int i = 0; i < nums.length - 1; i++) {
//
//                if (nums[i] > nums[i + 1]) {
//                    return false;
//                }
//            }
//        }
//        else if (nums[0] > nums[nums.length - 1]) {
//            for (int i = 0; i < nums.length - 1; i++) {
//
//                if (nums[i] < nums[i + 1]) {
//                    return false;
//                }
//            }
//        }
//        else if (nums[0] == nums[nums.length - 1]) {
//            for (int i = 0; i < nums.length - 1; i++) {
//
//                if (nums[i] != nums[i + 1]) {
//                    return false;
//                }
//            }
//        }
//        return true;
    }
    
    
    
    //905. Sort Array By Parity
    public static int[] sortArrayByParity(int[] nums) {
    	int n = nums.length;
    	int [] temp = new int[n];
    	int l=0,r=n-1;
    	for (int i = 0; i < n; i++) {
			if(nums[i] %2==0) {
				temp[l++] = nums[i];
			}else {
				temp[r--] = nums[i];
			}
		}
        return temp;
    }
    
    
    //908. Smallest Range I
    public static int smallestRangeI(int[] nums, int k) {
    	int max_val = nums[0];
        int min_val = nums[0];

        for(int i=0; i<nums.length; i++){
            min_val = Math.min(min_val, nums[i]);
            max_val = Math.max(max_val, nums[i]);
        }

        if(min_val + k >= max_val - k){
            return 0;
        }else{
            return (max_val-k) - (min_val+k);
        }
        
    }


    
    //922. Sort Array By Parity II
    public static int[] sortArrayByParityII(int[] nums) {
    	int n = nums.length;
    	int [] temp = new int[n];
    	int l=0,r=1;
    	for (int i = 0; i < n; i++) {
			if(nums[i] %2==0) {
				temp[l] = nums[i];l+=2;
			}else {
				temp[r] = nums[i];r+=2;
			}
		}
        return temp;
    }
    
    
    
    //929. Unique Email Addresses
    
    public static String newEmail(String email) {
    	StringBuilder str = new StringBuilder();
    	int atIndex = email.indexOf('@');
    	for (int i = 0; i < atIndex; i++) {
			char ch = email.charAt(i);
			if(ch == '+') break;
			else if(ch != '.') str.append(ch);
		}
    	str.append(email.substring(atIndex));
    	return str.toString();
    }
    public static int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            uniqueEmails.add(newEmail(email));
        }
        return uniqueEmails.size();
        
        
//        String[] uniqueEmails = new String[emails.length];
//        int uniqueCount = 0;
//
//        for (String email : emails) {
//            String[] parts = email.split("@");
//            String local = parts[0];
//            String domain = parts[1];
//
//            local = local.replace(".", "");
//
//            int plusIndex = local.indexOf('+');
//            if (plusIndex != -1) {
//                local = local.substring(0, plusIndex);
//            }
//
//            String normalizedEmail = local + "@" + domain;
//
//            boolean found = false;
//            for (int i = 0; i < uniqueCount; i++) {
//                if (uniqueEmails[i].equals(normalizedEmail)) {
//                    found = true;
//                    break;
//                }
//            }
//
//            if (!found) {
//                uniqueEmails[uniqueCount] = normalizedEmail;
//                uniqueCount++;
//            }
//        }
//
//        return uniqueCount;
    }
    
    
    //941. Valid Mountain Array
    public boolean validMountainArray(int[] arr) {
    	int n = arr.length;
        if (n < 3) return false;
        int i = 0;
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }
        if (i == 0 || i == n - 1) return false;
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }
        return i == n - 1;
    }
    
    
    
    //942. DI String Match
    public static int[] diStringMatch(String s) {
    	int n = s.length()+1;
    	int[] arr = new int[n];
    	int index = 0;
    	int l = 0, r = n-1;
    	for(char ch : s.toCharArray()) {
    		if(ch == 'I') {
    			arr[index++] = l++;	
    		}else {
    			arr[index++] = r--;
    		}
    	}
    	arr[n-1] = l;
        return arr;
    }
    
    
    
    //944. Delete Columns to Make Sorted
    public static int minDeletionSize(String[] strs) {
    	int numRows = strs.length;
        int numCols = strs[0].length();
        int count = 0;
        
        for (int col = 0; col < numCols; col++) {
            for (int row = 1; row < numRows; row++) {
                if (strs[row].charAt(col) < strs[row - 1].charAt(col)) {
                    count++;
                    break;  
                }
            }
        }
        
        return count;
    }
    
    
    
    //953. Verifying an Alien Dictionary
    public static boolean isAlienSorted(String[] words, String order) {
        int[] charOrder = new int[26];    
        for (int i = 0; i < order.length(); i++) {
            charOrder[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isInCorrectOrder(words[i], words[i + 1], charOrder)) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean isInCorrectOrder(String word1, String word2, int[] charOrder) {
        int len1 = word1.length();
        int len2 = word2.length();
        int len = Math.min(len1, len2);
        
        for (int i = 0; i < len; i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            
            if (c1 != c2) {
                return charOrder[c1 - 'a'] < charOrder[c2 - 'a'];
            }
        }
        
        return len1 <= len2;
    }
    
    
    
    //961. N-Repeated Element in Size 2N Array
    public static int repeatedNTimes(int[] nums) {
//    	int n = nums.length/2;
//        Arrays.sort(nums);
//        int c1=0,c2=0;
//        for (int i = 0; i < 2*n; i++) {
//			if(nums[i] == nums[n-1])c1++;
//			else if(nums[i] == nums[n]) c2++;
//		}
//        if(c1>c2) return nums[n-1];
//        else return nums[n];
    	
    	
//    	int max= nums[0];
//    	for(int s : nums) {
//    		max = Math.max(max, s);
//    	}
//    	int [] check = new int[max];
//    	for (int i = 0; i < nums.length; i++) {
//			check[nums[i]]++;
//		}
//    	for (int i = 0; i <= max; i++) {
//			if(check[i] > 1) return check[i];
//		}
//    	
//    	return -1;
    	
    	 HashSet<Integer> hp = new HashSet<>();

         for(var a : nums){
             if(hp.contains(a)) return a;
             else hp.add(a);
         }
         return -1;
    }
    
    
    
    //976. Largest Perimeter Triangle
    public static int largestPerimeter(int[] nums) {
    	Arrays.sort(nums);
        for(int i=nums.length-1;i>1;i--){
            int a = nums[i-2];
            int b = nums[i-1];
            int c = nums[i];
    		int s = a + b + c;
            if(a+b>c)
    		{
                return s;
            }
        }
        return 0;
    }
 
 
 
 
    //977. Squares of a Sorted Array
    public static int[] sortedSquares(int[] nums) {
    	int n=nums.length;
        int[] result=new int[n];
        int left = 0;
        int right = n-1;
        int index = n-1;
        while(left<=right)
        {
            int leftSquare=nums[left]*nums[left];
            int rightSquare=nums[right]*nums[right];
            if(leftSquare>rightSquare)
            {
                result[index]=leftSquare;
                left++;
            }
            else
            {
                result[index]=rightSquare;
                right--;
            }
            index--;
        }
       return result; 
    }
    
    
    
    //989. Add to Array-Form of Integer
    public static List<Integer> addToArrayForm(int[] num, int k) {
        String nums = "";
        for(int nb : num) nums += String.valueOf(nb);
        int sum = Integer.parseInt(nums) + k;
        System.out.println(sum);
        List<Integer> list = new ArrayList<Integer>();
        while (sum >0) {
        	list.add(sum%10);sum/=10;
        }
    	 
    	Collections.reverse(list);
    	return list;
    }
    
    
    
    //1002. Find Common Characters
    public static List<String> commonChars(String[] words) {
    	int [] minFrequency = new int[26];
    	Arrays.fill(minFrequency, Integer.MAX_VALUE);
    	
    	for( String word : words) {
    		int[] charCount = new int[26];
    		for(char s: word.toCharArray()) {
    			charCount[s -'a']++;
    		}
    		for (int i = 0; i < 26; i++) {
				minFrequency[i] = Math.min(minFrequency[i], charCount[i]);
			}
    	}
    	List<String> list = new ArrayList<String>();
    	for (int i = 0; i < 26; i++) {
			while(minFrequency[i] >0) {
				list.add(String.valueOf((char) (i+'a')));
				minFrequency[i]--;
			}
		}
    	return list;
    }
    
    
    
    //1005. Maximize Sum Of Array After K Negations
    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n ; i++) {
			if(k > 0 && nums[i] < 0) {
				k--;
				nums[i] = -nums[i];
			}
		}
        int res = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
			res+= nums[i];
			min = Math.min(min, nums[i]);
		}
        // nếu k sau còn là số lẻ thì đổi dấu min
    	return res - ( k%2 ) *min *2;
    }
    
    
    
    
    //1013. Partition Array Into Three Parts With Equal Sum
    public static boolean canThreePartsEqualSum(int[] arr) {
    	int sum = 0;
    	for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
        if (sum%3!=0) return false;
        int part = sum/3, temp = 0, count=0;
        for(int x : arr) {
        	temp+=x;
        	if(temp == part) {
        		temp = 0;count++;
        	}
        }
        return count >=3;
    }
    
    
    
    
    //1018. Binary Prefix Divisible By 5
    public List<Boolean> prefixesDivBy5(int[] nums) {
    	List<Boolean>list=new ArrayList<>();
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
             sum = (sum * 2 + nums[i]) % 5;
            if(sum!=0)
            {
                list.add(false);
            }
            else
            {
                list.add(true);
            }
        }
        return list;
    }
    
    public static long calcBinary(String str) {
    	long sum = 0,index = 0;
    	for (int i = str.length()-1; i >=0; i--) {
			char k = str.charAt(i);
			if( k == '1') sum+= Math.pow(2, index);
			index++;
		}
    	return sum/=5;
    }
    
    
    
    
    //1037. Valid Boomerang
    public static boolean isBoomerang(int[][] points) {
        if(points[1][1] == points[2][1] && points[2][1] == points[3][1]) return false;
        if(points[1][2] == points[2][2] && points[2][2] == points[3][3]) return false;
        if((points[0][0] * (points[1][1] - points[2][1]) +
                points[1][0] * (points[2][1] - points[0][1]) +
                points[2][0] * (points[0][1] - points[1][1])) == 0) return false;
        return true;
    }
    
    
    
    //1051. Height Checker
    public static int heightChecker(int[] heights) {
    	int n = heights.length;
    	int [] temp = new int[n];
    	int index=0,count=0;
    	for(int x : heights) temp[index++] = x;
    	heights = Sort.countingSort(heights);
    	for (int i = 0; i < n; i++) {
			if(temp[i] != heights[i]) count++;
		}
        return count;
    }
    public static void main(String[] args) {
    	//findShortestSubArray(new int[] {1,2,3,1,4,2});
    	//System.out.println(dominantIndex(new int[] {3,6,1,0}));
    	//System.out.println(nextGreatestLetter(new char[] {'x', 'c'}, 'a') + "");
    	//countingSort(new int[] {1,4,3,2});
    	//System.out.println(distributeCandies(new int[] {6,6,6,6}));
    	System.out.println(calcBinary("011"));
    	
//        int x1 = 999;
//        int x2=999;
//        int y1=-999;
//        int y2=-999;
//        Integer a1 =1;
//        Integer a2 = 1;
//        Integer b1 = 999;
//        Integer b2 = 999;
//        Integer c1 = -0;
//        Integer c2 = 0;
//        Integer d1 = -999;
//        Integer d2 = -999;
//        int g1=500;
//        Integer g2 = 500;
//        System.out.println("x1==x2 " + (x1==x2));
//        System.out.println("y1==y2 " + (y1==y2));
//        System.out.println("a1==a2 " + (a1==a2));
//        System.out.println("b1==b2 " + (b1==b2));
//        System.out.println("c1==c2 " + (c1==c2));
//        System.out.println("d1==d2 " + (d1==d2));
//        System.out.println("g1==g2 " + (g1==g2));
    }
}
