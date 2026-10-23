/* BST Node Structure
class Node {
	int data;
	Node left, right;
	
	Node(int val) {
		data = val;
		left = right = null;
	}
}
*/

class Solution {
	ArrayList<Integer> list;
	public int pairsViolatingBST(Node root) {
		list = new ArrayList<>();
		inOrder(root);
		
		int n = list.size();
		int[] arr = new int[n];
		for (int i = 0; i<n; i++) {
			arr[i] = list.get(i);
		}
		int[] sorted = new int[n];
		return mergeSort(arr, sorted, 0, n - 1);
	}
	
	private int mergeSort(int[] arr, int[] sorted, int low, int high) {
		if (low >= high) {
			return 0;
		}
		
		int mid = low + (high - low)/2;
		int count = mergeSort(arr, sorted, low, mid) + mergeSort(arr, sorted, mid + 1, high);
		
		int i = low;
		int j = mid + 1;
		int m = j;
		int n = high + 1;
		int k = low;
		
		while (i < m && j < n) {
			if (arr[i] <= arr[j]) {
				sorted[k++] = arr[i++];
			} else {
				count += mid - i + 1;
				sorted[k++] = arr[j++];
			}
		}
		
		while (i < m) {
			sorted[k++] = arr[i++];
		}
		
		while (j < n) {
			sorted[k++] = arr[j++];
		}
		
		for (int x = low; x <= high; x++) {
			arr[x] = sorted[x];
		}
		
		return count;
	}
	
	private void inOrder(Node root) {
		if (root == null) {
			return;
		}
		
		inOrder(root.left);
		list.add(root.data);
		inOrder(root.right);
	}
}
