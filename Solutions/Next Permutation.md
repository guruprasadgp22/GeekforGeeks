## 01. Next Permutation

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/next-permutation5226/1)

### Problem Description

**Task:** Given an array of integers arr[] representing a permutation, implement the next permutation that rearranges the numbers into the lexicographically smallest greater (or next) permutation. If no next permutation exists, rearrange the numbers into the lowest possible order (i.e., sorted in ascending order). Examples:Input: arr[] = [2, 4, 1, 7, 5, 0]

#### Examples

##### Example 1

- **Output:**
```text
[3, 4, 5, 1, 2]
```
- **Explanation:** The next permutation of the given array is [3, 4, 5, 1, 2].

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (5)

#### Solution 1 (Java)

- **Submitted:** 2026-11-25 19:14:48
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    void nextPermutation(int[] arr) {
        int n = arr.length;
        int index = -1;
        for(int i=n-1;i>0;i--) {
            if(arr[i-1] < arr[i]) {
                index = i-1;
                break;
            }
        }
        
        if(index == -1) {
            reverse(arr, 0, n-1);
        } else {
            for(int i=n-1;i>index;i--) {
                if(arr[index] < arr[i]) {
                    int temp = arr[index];
                    arr[index] = arr[i];
                    arr[i] = temp;
                    reverse(arr, index+1, n-1);
                    break;
                }
            }
        }
    }
    
    private void reverse(int[] arr, int left, int right) {
        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }  
}
```

#### Solution 2 (Java)

- **Submitted:** 2026-11-25 19:13:25
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    void nextPermutation(int[] arr) {
        int n = arr.length;
        int index = -1;
        for(int i=n-1;i>0;i--) {
            if(arr[i-1] < arr[i]) {
                index = i-1;
                break;
            }
        }
        
        if(index == -1) {
            reverse(arr, 0, n-1);
        } else {
            for(int i=n-1;i>index;i--) {
                if(arr[index] < arr[i]) {
                    int temp = arr[index];
                    arr[index] = arr[i];
                    arr[i] = temp;
                    reverse(arr, index+1, n-1);
                    break;
                }
            }
        }
    }
    
    private void reverse(int[] arr, int left, int right) {
        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }  
}
```

#### Solution 3 (Java)

- **Submitted:** 2026-11-25 18:57:40
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    void nextPermutation(int[] arr) {
        int n = arr.length;
        int index = -1;
        for(int i=n-1;i>0;i--) {
            if(arr[i-1] < arr[i]) {
                index = i-1;
                break;
            }
        }
        
        if(index == -1) {
            reverse(arr, 0, n-1);
        } else {
            for(int i=n-1;i>index;i--) {
                if(arr[index] < arr[i]) {
                    int temp = arr[index];
                    arr[index] = arr[i];
                    arr[i] = temp;
                    reverse(arr, index+1, n-1);
                    break;
                }
            }
        }
    }
    
    private void reverse(int[] arr, int left, int right) {
        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }  
}
```

#### Solution 4 (Java)

- **Submitted:** 2026-11-25 18:56:14
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    void nextPermutation(int[] arr) {
        int n = arr.length;
        int index = -1;
        for(int i=n-1;i>0;i--) {
            if(arr[i-1] < arr[i]) {
                index = i-1;
                break;
            }
        }
        
        if(index == -1) {
            reverse(arr, 0, n-1);
        } else {
            for(int i=n-1;i>index;i--) {
                if(arr[index] < arr[i]) {
                    int temp = arr[index];
                    arr[index] = arr[i];
                    arr[i] = temp;
                    reverse(arr, index+1, n-1);
                    break;
                }
            }
        }
    }
    
    private void reverse(int[] arr, int left, int right) {
        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }  
}
```

#### Solution 5 (Java)

- **Submitted:** 2026-11-25 18:54:52
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    void nextPermutation(int[] arr) {
        int n = arr.length;
        int index = -1;
        for(int i=n-1;i>0;i--) {
            if(arr[i-1] < arr[i]) {
                index = i-1;
                break;
            }
        }
        
        if(index == -1) {
            reverse(arr, 0, n-1);
        } else {
            for(int i=n-1;i>index;i--) {
                if(arr[index] < arr[i]) {
                    int temp = arr[index];
                    arr[index] = arr[i];
                    arr[i] = temp;
                    reverse(arr, index+1, n-1);
                    break;
                }
            }
        }
    }
    
    private void reverse(int[] arr, int left, int right) {
        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }  
}
```

*Generated on: 11/25/2026, 7:20:53 PM*
