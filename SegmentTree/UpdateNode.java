package SegmentTree;

public class UpdateNode {
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
        if(qi > sj || qj < si){ //not include case
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

    public static void updateNodeUtil(int i, int si, int sj, int idx, int diff){
        if(idx < si || idx > sj){
            return;
        }

        tree[i] += diff;
        if( si != sj){
            int mid = (si + sj)/2;
            updateNodeUtil(2*i+1, si, mid, idx, diff);
            updateNodeUtil(2*i+2, mid+1, sj, idx, diff);
        }
    }
    public static void updateNode(int arr[], int idx, int num){
        int n = arr.length;
        int diff = num - arr[idx];
        arr[idx] = num;

        updateNodeUtil(0, 0, n-1, idx, diff);

    }
    public static void main(String[] args){
        int arr[] = {1,2,3,4,5,6,7,8};
        int n = arr.length;

        init(n);
        buildSegmentTree(arr, 0, 0, n-1);

        for(int i=0; i<tree.length; i++){
            System.out.print(tree[i] + " ");
        }

        updateNode(arr, 2, 2);
        System.out.println();
        
        for(int i=0; i<tree.length; i++){
            System.out.print(tree[i] + " ");
        }
    }

}
