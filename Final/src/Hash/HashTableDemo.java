package Hash;

public class HashTableDemo {
	public static void main(String[] args) {
        Entry<String, String> flag = new Entry<>("FLAG", null);
        
        OpenHashTable<Entry<String, String>> table =
                new OpenHashTable<Entry<String, String>> (4, flag);
        Map<String, String> m = new SetAdapterMap<> (table);
        try{
                m.put("a", "apple");
                m.get("a");
             //   m.remove("a");
                System.out.println(m.get("a"));
                System.out.println(m.size());
        }catch(Exception e){}
    }
}
