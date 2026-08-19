class Solution {
    public int minProd(int[] arr) {
	int negativeCount = 0;
	int smallestNegEle = Integer.MIN_VALUE;
	for(int ele: arr) {
		if(ele < 0) {
			negativeCount++;
			smallestNegEle = Math.max(ele, smallestNegEle);
		}
	}

	if(negativeCount % 2 != 0) {
		int ans = 1;
		for(int ele: arr) {
			if(ele == 0) {
				continue;
			}

			ans *= ele;
		}

		return ans;
	} else {

		if(negativeCount == 0) {
			int ans = Integer.MAX_VALUE;
			for(int ele: arr) {
				ans = Math.min(ele, ans);
			}

			return ans;
		} else {
			int ans = 1;
			for(int ele: arr) {
				if(ele == 0) {
					continue;
				}
				ans *= ele;
			}

			return ans/(1 * smallestNegEle);
		}
	}
	  }
}