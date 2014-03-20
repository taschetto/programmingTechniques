package ex01;

public class Fifo implements IFifo {
	
	private int[] data;
	int tail;
	
	//@ requires capacity > 0;
	public Fifo(int capacity)
	{
		this.tail = -1;
		this.data = new int[capacity];
	}

	@Override
	public void enqueue(int n) {
		this.tail++;
		this.data[this.tail] = n;
	}

	@Override
	public int dequeue() {
		int first = data[0];
		
		for (int i = 0; i < tail; i++)
		{
			data[i] = data[i + 1]; 
		}
		
		this.tail--;
		
		return first;
	}

	@Override
	public int head() {
		return this.data[0];
	}
	
	@Override
	public int tail()
	{
		return this.data[this.tail];
	}

	@Override
	public int size() {
		return this.tail + 1;
	}

	@Override
	public int capacity() {
		return data.length;
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}
}
