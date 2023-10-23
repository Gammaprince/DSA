/*
We use array of linkedlist to store values in hashmap 
We use hashFunction which give us index (Math.abs(key.getHashCode()) % size());
here is lambda we use it is known as loading factor , it always less of equal to threshold value k lambda = n/N , where n is size of value exist and N is size of hashmap buckets
n = Number of existing values 
N = size of buckets
lambda = n/N (loading Factor)

hashFunction(Key k){
    int hashCode = k.getHashCode();
    return Math.abs(hashCode) % buckets.size();
}

*/

public static class HashMap<K,V>{
  private static class HMNode{
    K key;
    V value;
    public HMNode(K key , V value){
      this.key = key;
      this.value = value;
    }
  }
  private int size;
  Private LinkedList<HMNode>[] buckets;

  public HashMap(){
    initBuckets(4);
    size = 0;
  }
  public initBuckets(int N){
    buckets = new LinkedList<>()[N];
    for(int i = 0 ; i < N ; i++){
      buckets[i] = new ArrayList<>();
    }
  }
  private int hashFunction(K key){
    int hc = key.hashFunction();
    return Math.abs(hc) % buckets.length();
  }
  public void put(K key , V value){
    int bi = hashFunction(K);
    int di = getIndexWithinBuckets(bi);
    if(di != -1){
      HMNode node = buckets[bi].get(di);
      node.value = value;
    }
    else{
      HMNode node = new HMNode(key,value);
      buckets[i].add(node);
      size++;
    }
    double lambda = size * 1.0 / buckets.lenght();
    if(lambda > 2.0){
      reHash();
    }
  }
  private int getIndexWithinBuckets(K key , int bi){
    int di = 0;
    for(HMNode node : buckets[i]){
      if(node.key.equals(key)){
        return di;
      }
      di++;
    }
    return -1;
  }
}
