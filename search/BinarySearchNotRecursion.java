package search;

public class BinarySearchNotRecursion {

    public static void main(String[] args) {
	// TODO �Զ����ɵķ������
	// ����
	int[] arr = { 1, 3, 8, 10, 11, 67, 100 };
	int index = binarySearch(arr, -8);
	System.out.println("index=" + index);
    }

    // ���ֲ��ҵķǵݹ�ʵ��
    /**
     * 
     * @param arr    �����ҵ����飬arr����������
     * @param target ��Ҫ���ҵ���
     * @return ���ض�Ӧ�±�
     */
    public static int binarySearch(int[] arr, int target) {
	int left = 0;
	int right = arr.length - 1;
	
	while (left <= right) {// ˵����������
	    int mid = (left + right) / 2;
	    
	    if (arr[mid] == target) {
		return mid;
	    } else if (arr[mid] > target) {
		right = mid - 1;// ��Ҫ����߲���
	    } else {
		left = mid + 1;// ��Ҫ���ұ߲���
	    }
	}
	
	return -1;
    }

}