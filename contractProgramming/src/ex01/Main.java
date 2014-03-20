package ex01;

public class Main {
	public static void main(String [] args)
	{
		Fifo q = new Fifo(5);
		System.out.println("Capacity: " + q.capacity());
		System.out.println("Size: " + q.size());
		
		q.enqueue(1);
		q.enqueue(-1);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(-1);
		
		System.out.println("Dequeue: " + q.dequeue());
		System.out.println("Dequeue: " + q.dequeue());
		System.out.println("Dequeue: " + q.dequeue());
		System.out.println("Dequeue: " + q.dequeue());
		System.out.println("Dequeue: " + q.dequeue());		
	}
}