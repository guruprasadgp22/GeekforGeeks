/*
Problem: Next Permutation5226
Difficulty: Medium
Tags: N/A
URL: https://www.geeksforgeeks.org/problems/next-permutation5226/1
*/

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