package calculator;

import java.util.NoSuchElementException;

/**
 * This class represents a reference-based implementation of the Queue interface
 * @author Alyer
 *
 * @param <T> The data type of the elements being held in the queue
 */
public class LinkedQueue<T> implements Queue<T> {

	private Node<T> front;
	private Node<T> back;
	
	public LinkedQueue() {
		front = null;
		back = null;
	}
	
	/**
	 * Add an element to the queue
	 * @param t the element to add to the queue
	 */
	@Override
	public void enqueue(T t) {
		if (isEmpty()) {
			front = new Node<T>(t,null);
			back = front;
		} else {
			back.setNext(new Node<T>(t,null));
			back = back.getNext();
		}
	}

	/**
	 * Check what the first element of the queue is
	 * @return The first element
	 * @throws NoSuchElementException if there is no first element
	 */
	@Override
	public T front() throws NoSuchElementException {
		if (!this.isEmpty())
			return front.getData();
		throw new NoSuchElementException("Queue is Empty!");
	}

	/**
	 * Takes the least recently placed item out of the queue
	 * @return The element that was just removed from the queue
	 * @throws NoSuchElementException if there is no element to remove
	 */
	@Override
	public T dequeue() throws NoSuchElementException {
		if (!this.isEmpty()) {
			T data = front.getData();
			front = front.getNext();
			if (front == null)
				back = null;
			return data;
		}
		throw new NoSuchElementException("Queue is Empty!");
	}

	/**
	 * Checks whether the queue is empty
	 * @return true if the queue is empty
	 */
	@Override
	public boolean isEmpty() {
		return back==null;
	}

	
	
}
