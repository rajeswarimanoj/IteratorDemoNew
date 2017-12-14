package com.java.iterators;

import java.util.Iterator;

public class FilteringIterator implements Iterator<Object> {
	private final Iterator<Object> myIterator;
	private final IObjectTest myTest;
	private Object next;

	FilteringIterator(Iterator<Object> myIterator, IObjectTest myTest) {
		this.myIterator = myIterator;
		this.myTest = myTest;
	}

	@Override
	public boolean hasNext() {
		while (next == null && myIterator.hasNext()) {
			next = myIterator.next();
			if (myTest.test(next))
				return true;
			next = null;
		}
		return next != null;
	}

	@Override
	public Object next() {
		if (next == null)
			hasNext();
			return next;
	}
}
