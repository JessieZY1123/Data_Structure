package Sort;

//Divide and Conquer sorting of arrays

public abstract class Sort<K extends Comparable <K>> {
	public K array[];
	public int capacity;
	
	public Sort(K[] x) { //传进来的是数组
		array = x;
		capacity = array.length;
	}

	public void sort(int low, int high) {
		if(low >= high) return;
		int mid = partition(low, high);
		sort(low, mid-1);  //递归
		sort(mid,high);
		merge(low, mid ,high);
	}
	//定义了两个抽象方法，在子类中实现
    public abstract int partition(int low, int high);
    public abstract void merge(int low, int mid, int high);
    public abstract String sortType();
    
    public void print() {
        for(int i = 0; i < capacity; i++)
            System.out.print("" + array[i] + " ");
        System.out.println();
    }
}
