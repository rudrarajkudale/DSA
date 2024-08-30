package SegmentTree;

public class GetRangeSum {
    static int tree[];
    
    public static void init(int n){
        tree = new int[4 * n];
    }

    public static int buildSegmentTree(int arr[], int i, int start, int end){
        if(start == end){
            tree[i] = arr[start];
            return arr[start];
        }

        int mid = (start + end)/2;
        buildSegmentTree(arr, 2*i+1, start, mid);
        buildSegmentTree(arr, 2*i+2, mid+1, end);
        tree[i] = tree[2*i+1] + tree[2*i+2];
        return tree[i];
    }

    public static int getSumHelper(int i, int si, int sj, int qi, int qj){
        //case 1 - non overlapping
        if(qi > sj || qj < si){ 
            return 0;
        }

        //case 2 - full overlapping
        else if(qi <= si && qj >= sj){ 
            return tree[i];
        }

        //case 3 - partial ovelap
        else{
            int mid = (si + sj)/2;
            int left = getSumHelper(2*i+1, si, mid, qi, qj);
            int right = getSumHelper(2*i+2, mid + 1, sj, qi, qj);
            return left + right;
        }
    } 

    public static int getSum(int n, int qi, int qj){
        //pass values here so dont need to take all values from main function
        return getSumHelper(0, 0, n-1, qi, qj);
    }

    public static void main(String[] args){
        int arr[] = {1,2,3,4,5,6,7,8};
        int n = arr.length;

        init(n);
        buildSegmentTree(arr, 0, 0, n-1);

        System.out.println(getSum(n, 2, 5));
    }
}
