package PriorityQueue;

import java.util.Iterator;

/*
 * add (k x): 先把要加入的元素放在最后一个结点，然后比较(bubbleUP)是否 大于/小于 父节点 ，如果不符合，则 swap （recursive）
 * 
 * remove : 直接交换 root 和最后一个结点 。删除 root （尾结点的值）。此刻的root值不一定满足要求,需要检查(bubbleDown)
 * 
 * 记住两个位置：  child ：data[n]  ---> parent : data[(n-1)/2]
 * 				The first leaf : data[size/2]
 */
public class HeapPriorityQueue<K extends Comparable<K>> implements PriorityQueue<K>{
	private K data[];
	private int size;
	private int capacity;
	
	public HeapPriorityQueue() {
		capacity = 100;
		size =0; //array 的size
		data = (K[]) new Comparable[capacity];
	}
	public void swapData(int n, int m) {
		K temp = data[n];
		data[n]= data[m];
		data[m] =temp; 
	}
	/*
	 * 最小堆添加：每个子树中的父节点是3个中最小值
	 * 1.添加到最后
	 * 2.与父节点比较
	 * 3.如果小于父节点，与父节点交换数据
	 */
	public void addMin(K x) throws Exception {
		if(size>=capacity-1)
			throw new Exception("Priority Queue Full.");
		data[size] =x;
		size++;
		bubbleUpMin(size-1); //此刻size已经+1了， 所有要-1
	}
	/* （n 是子节点）
	 * 1.如果是root结点，直接返回
	 * 2.与父节点比较
	 */
	private void bubbleUpMin(int n) {
		if (n<=0) return; //root 
		K child = data[n];
		K parent = data[(n-1)/2];  //父节点的index 是 (n-1)/2
		if(child.compareTo(parent)<0) {
			swapData(n,(n-1)/2);
			bubbleUpMin((n-1)/2);}
		return;	
	}
	/*
	 * 最大堆添加：每个子树中的父节点是3个中最大值
	 * 1.添加到最后
	 * 2.与父节点比较
	 * 3.如果大于父节点，与父节点交换数据
	 */
	
	public void addMax(K x) throws Exception {
		if(size>=capacity-1)
			throw new Exception("Priority Queue Full.");
		data[size] =x;
		size++;
		bubbleUpMax(size-1); //此刻size已经+1了， 所有要-1
	}
	private void bubbleUpMax(int n) {  //n 是子节点
		if(n<=0) return ;
		K child = data[n];
		K parent = data[(n-1)/2];
		if(child.compareTo(parent)>0) {
			swapData(n,(n-1)/2);
			bubbleUpMax((n-1)/2);
		}
		return;
	}
	/*  
	 *  remove the min:
	 *  1.交换root 和 最后一个结点位置
	 *  2.bubbleDown(root)  （n 是父节点）
	 *  3.返回最后结点位置
	 */
	public K removeMin() {
		swapData(0,--size); //注意size的值 先--，再取值
		bubbleDownMin(0);
		return data[size];
	}
	/*
	 * 1.如果是叶子节点，直接返回
	 * 2.如果 data[n]< data[n*2+1] && data[n]< data[n*2+2] n是最小值，直接返回
	 * 3.如果 右子树<左子树 --> swap(parent,rightChild)
	 * 		 else : swap(parent,leftChild)
	 */
	private void bubbleDownMin(int n) { // n 是父节点
		if(2*n +1>=size)
			return; // at leaf
		K parent = data[n];
		K leftChild = data[n*2+1];
		K rightChild = leftChild;
		if(n*2+2 < size)
			rightChild = data[n*2+2]; // 防止overflow
		if(parent.compareTo(leftChild)<0 && parent.compareTo(rightChild)<0)
			return;
		if(rightChild.compareTo(leftChild)<0) {
			swapData(n,n*2+2);
			bubbleDownMin(n*2+2);
		}else {
			swapData(n,n*2+1);
			bubbleDownMin(n*2+1);
		}
	}
	
	public K removeMax() {
		swapData(0,--size); //注意size的值 先--，再取值
		bubbleDownMax(0);
		return data[size];
	}
	private void bubbleDownMax(int n) {
		if(2*n +1>=size)
			return; // at leaf
		K parent = data[n];
		K leftChild = data[n*2+1];
		K rightChild = leftChild;
		if(n*2+2 < size)
			rightChild = data[n*2+2]; // 防止overflow
		if(parent.compareTo(leftChild)>0 && parent.compareTo(rightChild)>0)
			return;
		if(rightChild.compareTo(leftChild)>0) {
			swapData(n,n*2+2);
			bubbleDownMin(n*2+2);
		}else {
			swapData(n,n*2+1);
			bubbleDownMin(n*2+1);
		}
	}
	// heap creation
	 public void heapify(Iterator<K> x) throws Exception {
		 while(x.hasNext()) {
			 if(size +1 == capacity)
				 break;
			 data[size] =x.next();
			 size++;
		 }
		 int n = size/2 ; // 第一个叶子结点的位置
		 while(--n >=0) { // 往前遍历
			 bubbleDownMin(n); // n 一定是父节点！
		 }
		 if(x.hasNext())
			 throw new Exception("Heap is Full");
	 }
}
