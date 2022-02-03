package Hash;

public class ChainedHashTableDemo {
	public static void main(String[] args) {
        ChainedHashTable<Entry<String, String>> table =
                new ChainedHashTable<Entry<String, String>> (4);
        Map<String, String> m = new SetAdapterMap<>(table);
        try{
                m.put("a", "airplane");
                m.put("b", "bee");
                System.out.println( m.get("a"));
                m.remove("b");
                System.out.println(m.size()); // 1
        }catch(Exception e){}
    }
}
