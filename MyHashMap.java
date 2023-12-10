import java.security.Key;

public class MyHashMap<K,V> {
    
    public static final int  initialSize =16;
    public static final int  maxCapacity =1<<30;

    Entry[] hashtable;

    MyHashMap()
    {
       hashtable = new Entry[initialSize];
    }
    MyHashMap(int size)
    {
       hashtable = new Entry[size];
       //should be allocated in nearest power of two
       
    }
    
    public class Entry<K,V>
    {
        K Key;
        V Value;
        Entry next;

        Entry(K k,V v)
        {
            Key = k;
            Value = v;

        }

        public K getKey() {
            return Key;
        }

        public void setKey(K key) {
            Key = key;
        }

        public V getValue() {
            return Value;
        }

        public void setValue(V value) {
            Value = value;
        }
        


    }
    public void put(K key, V value)
    {
        int hashIndex=(key.hashCode())% hashtable.length;
        Entry node = hashtable[hashIndex];

        if(node==null)
        {
            Entry newnode =new Entry<K,V>(key, value);
            hashtable[hashIndex]=newnode;
        }
        else
        {

            Entry temp=node;
            while(temp!=null)
            {
                if(temp.Key == key)
                {
                    temp.Value=value;
                    return;
                }
               
                node=temp;
                temp=temp.next;

            }
            Entry newnode =new Entry<K,V>(key, value);
            node.next=newnode;
        }

    }
    
    public V get(K key)
    {
        int hashIndex=(key.hashCode())% hashtable.length;
        Entry node = hashtable[hashIndex];

        while(node != null) {
            if(node.Key.equals(key)) {
                return (V)node.Value;
            }
            node = node.next;
        }
        return null;

    }

    public static void main(String args[]) {


        MyHashMap<Integer,String> myHashMap =new MyHashMap<>(10);
        myHashMap.put(1,"aman");
        myHashMap.put(2,"raj");
        System.out.println(myHashMap.get(2));

       





    }
}
