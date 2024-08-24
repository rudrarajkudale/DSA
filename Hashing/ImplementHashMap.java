package Hashing;
import java.util.*;

public class ImplementHashMap{

    //K and V are generiv can support all the types
    static class HashMap<K, V>{

        //Create Node class to store the data
        private class Node{
            K key;
            V val;
            Node(K key, V val){
                this.key = key;
                this.val = val;
            }
        }

        //create global variables
        //N for bucket size
        private static int N;
        //n for linked list size
        private static int n;
        // create array bucket which consists linked list
        private LinkedList<Node> bucket[];
        

        //Now create HashMap Constructor 
        //so whenever create object constructor will be called
        //we have to suppress warning cause we are creating Array of LinkedList
        @SuppressWarnings("unchecked")
        public HashMap(){
            N = 4;
            n = 0;
            bucket = new LinkedList[N];

            //initialize whole array with LinkedList
            for(int i=0; i<N; i++){
                bucket[i] = new LinkedList<>();
            }
        }

        //create a function to put elements
        public void put(K key, V val){
            //It will hash Our Key
            //And give the index bi of bucket
            int bi  = hashCode(key);
            //now ckeck if the key present on that linked list
            int di = searchLL(key, bi);

            //if key present then replace it
            if(di != -1){
                Node node =  bucket[bi].get(di);
                node.val = val;
            }
            else{
                Node node = new Node(key, val);
                bucket[bi].add(node);
                n++;
            }


            //Now check lambda if increased than threshould then rehash
            double lambda = (double)n/N;
            if(lambda > 2.0){
                rehash();
            }
        }

        //HashCode gives Unque hashcode
        private int hashCode(K key){
            //it will give unique hash code 
            int hc = key.hashCode();

            //but we want between array size so
            return Math.abs(hc) % N;
        }

        //Seach key in the Linked List
        private int searchLL(K key, int bi){
            LinkedList<Node> ll = bucket[bi];

            //If key found return index othrwise -1
            for(int i=0; i<ll.size(); i++){
                if(ll.get(i).key == key){
                    return i;
                }
            }
            return -1;
        }

        //If our hashMap is full the rehash
        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> old[] = bucket;
            N = N*2;
            n = 0;

            bucket = new LinkedList[N];
            for(int i=0; i<N; i++){
                bucket[i] = new LinkedList<>();
            }

            for(int i=0; i<old.length; i++){
                LinkedList<Node> ll = old[i];
                for(int j=0; j<ll.size(); j++){
                    Node node = ll.get(i);
                    put(node.key, node.val);
                }
            }
        }

        //fucntion to remove key
        public V remove(K key){
            int bi = hashCode(key);
            int di = searchLL(key, bi);

            if(di != -1){
                Node node =  bucket[bi].remove(di);
                n--;
                return node.val;
            }
            return null;
        }
        //function to get value
        public V get(K key){
            int bi = hashCode(key);
            int di = searchLL(key, bi);

            if(di != -1){
                return bucket[bi].get(di).val;
            }
            return null;
        }

        //check key is contain or not
        public boolean containsKey(K key){
            int bi = hashCode(key);
            int di = searchLL(key, bi);

            if(di != -1){
                return true;
            }
            return false;
        }

        //check is empty
        public boolean isEmpty(){
            return n == 0;
        }

        //return size
        public int size(){
            return  n;
        }

        //clear all th hashmap
        @SuppressWarnings("unchecked")
        public void clear(){
            N = 4;
            bucket= new LinkedList[N];
            n = 0;
            for(int i=0; i<N; i++){
                bucket[i] = new LinkedList<>();
            }
        }

        //all Keys
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0; i<N; i++){
                LinkedList<Node> ll = bucket[i];
                for(Node node : ll){
                    keys.add(node.key);
                }
            }

            return keys;
        }
    }
    
    public static void main(String[] args) {

        HashMap<String, Integer> hm = new HashMap<>();

        //Adding and replacing
        hm.put("Rudra", 100);
        hm.put("Amar", 99);
        hm.put("Akabar", 87);
        hm.put("Antheny", 35);

        //Get key
        System.out.println(hm.get("Rudra"));

        //check the key is present or not
        System.out.println(hm.containsKey("Anamol"));
        System.out.println(hm.containsKey("Akabar"));

        //remove key
        hm.remove("Akabar");

        //check size
        System.out.println(hm.size());

        //print all the keys and values
        ArrayList<String> keys = hm.keySet();
        for(String key : keys){
            System.out.print(key + " ");
        }
        System.out.println();

        //clear all the keys from hasmap
        hm.clear();

        //check hashmap is empty or not
        System.out.println(hm.isEmpty());
    }
}
