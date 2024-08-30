package SegmentTree;

public class GetSumRange {
    static int tree[];
    public static void init(int n){
        tree = new int[4*n];
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

    public static int RangeSumUtil(int i, int si, int sj, int qi, int qj){
        if(qi >= sj || qj <= si){ //not include case
            return 0;
        }
        else if(qi <=si && qj >= sj){ //include case
            return tree[i];
        }
        else{ //partial include case
            int mid = (si+sj)/2;
            int left = RangeSumUtil( 2*i+1, si, mid, qi, qj);
            int right = RangeSumUtil( 2*i+2, mid+1, sj, qi, qj);
            return left + right;
        }
    }

    public static int RangeSum(int arr[], int qi, int qj){
        int n = arr.length;
        return RangeSumUtil(0, 0, n-1, qi, qj);
    }
    public static void main(String[] args){
        int arr[] = {1,2,3,4,5,6,7,8};
        int n = arr.length;

        init(n);
        buildSegmentTree(arr, 0, 0, n-1);

        System.out.println(RangeSum(arr, 2, 5));
    }
}
