package ch.commonmethods;

import com.google.common.base.Objects;

public class OverrideEquals {
	private String example = "a string";

/* Item 8 
 * don't override if 
 * +each instance is inherently unique
 * +don't care about logical equality
 * +a superclass has already overridden equals and its behavior is ok for the subclass
 * +class is private or package private and equals will never be invoked
 * 
 * Equals contract should be
 * Reflexive x.equals(x)
 * Symmetric x.equals(y) -> y.equals(x)
 * Transitive x.equals(y) and y.equals(z) -> x.equals(z)
 * Consistent x.equals(y) is consistently true or consistently false
 * 
 * Scala "case" class auto-generates equals, hashCode, toString

	@Override // for classes when equals should never be called
	public boolean equals(Object obj) {
		throw new AssertionError(); 
	}
 */	
	@Override // Guava Objects.equals() checks for nulls
	public boolean equals(Object obj) {
		if(obj instanceof OverrideEquals) {
			return Objects.equal(this.example,((OverrideEquals)obj).example); 
		}
		return false;
	}
	
	// JDK7 use http://docs.oracle.com/javase/7/docs/api/index.html equals or deepEquals
	/*
	 * @see http://docs.oracle.com/javase/7/docs/api/java/util/Objects.html#deepEquals(java.lang.Object,%20java.lang.Object)
	 */
	public boolean deepEquals(Object obj) {
		if(obj instanceof OverrideEquals) {
			return java.util.Objects.deepEquals(this,((OverrideEquals)obj)); 
		}
		return false;
	}
}
