package org.flowdev.base;

 
public interface Port<T> {
	void send(T data);
}
