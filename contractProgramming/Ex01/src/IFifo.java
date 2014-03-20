public interface IFifo {
	
	//@ requires size() < capacity();
	//@ requires size() == 0 || (tail() + n == 0) || (tail() >= 0 && n >= 0) || (tail() < 0 && n < 0);
	//@ ensures size() == \old(size()) + 1;
	//@ ensures tail() == n;
	void enqueue(int n);
	
	//@ requires size() > 0;
	//@ ensures size() == \old(size()) - 1;
	//@ ensures \result == \old(head());
	int dequeue();
	
	//@ requires size() > 0;
	//@ pure
	int head();
	
	//@ requires size() > 0;
	//@ pure
	int tail();	
	
	//@ pure
	boolean isEmpty();
	
	//@ pure
	int size();
	
	//@ pure
	int capacity();
}