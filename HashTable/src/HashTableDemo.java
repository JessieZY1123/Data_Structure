
public class HashTableDemo {
	public static void main(String[] args) throws Exception {
		Entry<String, String> flag =new Entry<>("FLAG",null);
		OpenHashTable<Entry<String,String>> table = new OpenHashTable<Entry<String,String>>(4,flag);
		Map<String,String> m = new SetAdapterMap<>(table);
		m.put("a", "apple");
		m.get("a");
		m.remove("a");
		m.dumpTable();
	}
}
