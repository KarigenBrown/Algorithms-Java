package search;

public class BinarySearchNotRecursion {

    public static void main(String[] args) {
	// TODO 自动生成的方法存根
	// 测试
	int[] arr = { 1, 3, 8, 10, 11, 67, 100 };
	int index = binarySearch(arr, -8);
	System.out.println("index=" + index);
    }

    // 二分查找的非递归实现
    /**
     * 
     * @param arr    待查找的数组，arr是升序排列
     * @param target 需要查找的数
     * @return 返回对应下标
     */
    public static int binarySearch(int[] arr, int target) {
	int left = 0;
	int right = arr.length - 1;
	
	while (left <= right) {// 说明继续查找
	    int mid = (left + right) / 2;
	    
	    if (arr[mid] == target) {
		return mid;
	    } else if (arr[mid] > target) {
		right = mid - 1;// 需要向左边查找
	    } else {
		left = mid + 1;// 需要向右边查找
	    }
	}
	
	return -1;
    }

}
