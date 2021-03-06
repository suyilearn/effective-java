package ch.generics;

import java.util.Collection;

/* Item 28
 * PECS mnemonic Producer Extends, Consumer Super 
 * All comparables and comparators are consumers
 * DO NOT USE WILDCARDS as RETURN TYPES
 * Wildcards make APIs more flexible but are very tricky
 * 
 * Scala Upper bound T <: A means T is a subtype of A (A is the upper bound)
 * Scala Lower bound T >: A means T is a supertype of A (A is the lower bound)
 */
public class BoundedWildcardsAPI {
	/*
	 * <E> before the return type is the formal argument type. It can moved to classname BoundedWildcardsAPI<E>
	 */
	private <E> void push(E e) {
	}

	private <E> E pop() {
		E result = null;
		return result;
	}
	
	private boolean isEmpty() {
		return false;
	}
	
	// Producer <? extends E> works for all subtypes
	public <E> void pushAll(Iterable<? extends E> src) {
		for ( E e : src) {
			push(e);
		}
	}
	
	// Consumer <? super E> works for supertypes
	public <E> void popAll(Collection<? super E> dst) {
		while(!isEmpty()) {
			dst.add((E) pop());
		}
	}
}
