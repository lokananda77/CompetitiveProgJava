package interview_prep;

public class FirstBadVersion {
	int a[] = {0,0,0,0,0,1,1,1};
	
	boolean isBadVersion(int index) {
		if (a[index] == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public int firstBadVersion(int n) {
        return binSearch(0, n);
    }
    
    public int binSearch(int low, int high) {
    	if (low > high) {
    		return -1;
    	}
        int mid = low + (high-low)/2;
        if (isBadVersion(mid) == false) {
                return binSearch(mid + 1, high);
        } else {
            while(isBadVersion(mid) != false && mid >= 0) {
                mid--;
            }
            return mid + 1;
        }
    }
    
    public int firstBadVersion2(int n) {
        return binSearch2(0, n-1);
    }
    
    public int binSearch2(int low, int high) {
        int ans=1;
        while(low<=high){
            int mid = low + (high-low) / 2;
            if(isBadVersion(mid+1)==false)
                low = mid+1;
            else if(isBadVersion(mid+1)==true && (isBadVersion(mid)==false || mid==0)) {
                    ans = mid+1;
                    break;
            }
            else{
                high = mid-1;    
            }
            
        }
        return ans;
    }
    
    public static void main(String[] args) {
    	FirstBadVersion fb = new FirstBadVersion();
    	System.out.println(fb.firstBadVersion(8));
    	System.out.println(fb.firstBadVersion2(8));
	}
}
