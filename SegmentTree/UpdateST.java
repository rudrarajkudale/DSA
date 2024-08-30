package SegmentTree;

public class UpdateST {
    static int tree[];
    
    public static void init(int n){
        //ffor safety take 4n space
        //but nodes are only 2n-1
        tree = new int[4 * n];
    }

    public static int buildSegmentTree(int arr[], int i, int start, int end){
        //if start == end then place node at leaf
        if(start == end){
            tree[i] = arr[start];
            return arr[start];
        }

        int mid = (start + end)/2;
        buildSegmentTree(arr, 2*i+1, start, mid);
        buildSegmentTree(arr, 2*i+2, mid+1, end);
        //store the sum on upper levels
        tree[i] = tree[2*i+1] + tree[2*i+2];
        return tree[i];
    }

    public static void updateUtil(int i, int idx, int si, int sj, int diff){
        //not ovelap comdition
        if(idx < si || idx > sj){
            return;
        }

        //otherwise change in tree
        tree[i] += diff;

        if(si != sj){
            //if it is not leaf node then.
            int mid = (si + sj)/2;
            updateUtil(2*i+1, idx, si, mid, diff);
            updateUtil(2*i+2, idx, mid+1, sj, diff);
        }
    }
    public static void updateNode(int arr[], int idx, int num){
        int n = arr.length;
        int diff = num - arr[idx];
        arr[idx] = num;

        updateUtil(0, idx, 0, n-1, diff);
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
