  package com.practice.interfaces;

public interface DupListInterface {
	void existingMethod();
	default void sort() {
		System.out.println("sort() : List in CF implemented sort as default method as in demo,hence backward compatibility i.e No Impact on Existing Impl in Libraries");
	}
	default void spliterator() {
		System.out.println("spliterator() : List in CF implemented sort as default method as in demo");
	}
}
