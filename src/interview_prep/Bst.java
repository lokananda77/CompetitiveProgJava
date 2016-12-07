package interview_prep;

public class Bst {

	public class Node {
		public Node right;
		public Node left;
		public int value;
		
		
		Node(int value) {
			this.value = value;
		}
	}
	
	Node createMinimalBST(int arr[], int left, int right) {
		if (right < left) {
			return null;
		}
		int mid = ( left + right ) / 2;
		Node n = new Node(arr[mid]);
		n.left = this.createMinimalBST(arr, left, mid - 1);
		n.right = this.createMinimalBST(arr, mid + 1, right);
		return n;
	}
	
//	public static void main(String[] args) {
//		//createMinimalBST()
//	}
	
//	int findDia() {
//		
//	}
}
