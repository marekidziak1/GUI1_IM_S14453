package zad1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Hailstone implements Iterable<Integer>, Iterator<Integer>{
	private int ini;
	private int count=-1;	//numer miejsca w liscie
	private int maxel=0;
	private Node head=new Node(0);
	private int size=0;		//wilekosc listy
	
	public Hailstone(int ini){
		this.ini=ini;
		add(ini);
	}
	public void add(Integer liczba){
		if(liczba>maxel){
			maxel=liczba;
		}
		if(head.getNext()==null){
	   		if(liczba%2==0){
	   			head.setNext(new Node(liczba));
	   			size++;
	   			if(liczba!=1){
	   				liczba=liczba/2;
	   				add(liczba);
	   			}
	   		}
	   		else{
	   			head.setNext(new Node(liczba));
	   			size++;
	   			if(liczba!=1){
	   				liczba=3*liczba+1;
	   				add(liczba);
	   			}
	   		}
	   	}
	   	else{
	   		if(liczba%2==0){
	   			Node last=head.getNext();
				while(last.getNext()!=null){
					last=last.getNext();
				}
				last.setNext(new Node(liczba));
				size++;
	   			if(liczba!=1){
	   				liczba=liczba/2;
	   				add(liczba);
	   			}
	   		}
	   		else{
	   			Node last=head.getNext();
				while(last.getNext()!=null){
					last=last.getNext();
				}
				last.setNext(new Node(liczba));
				size++;
	   			if(liczba!=1){
	   				liczba=3*liczba+1;
	   				add(liczba);
	   			}
	   		}
	   	}
	}
	public int get(int index)throws IndexOutOfBoundsException{
		if(index<0 || index>size){
			throw new IndexOutOfBoundsException();
		}
		else{
			Node find=head.getNext();
			for(int i=0; i<index; i++){
				find=find.getNext();
			}
			return find.getValue();
		}
	}
	public boolean hasNext(){
		if(count+1<size){
			return true;
		}
		else return false;
	}
	public Integer next(){
		if(count >=size){
			throw new NoSuchElementException();
		}
		else{
			count++;
			return get(count);
		} 
	}
	public void remove(){
		throw new UnsupportedOperationException();
	}
	public Iterator<Integer> iterator(){
		return this;
	}
	private static class Node {
		private int wartosc;
		private Node next=null;
		public Node(int wartosc){
			this(wartosc,null);
		}
		public Node(int wartosc, Node next){
			this.wartosc=wartosc;
			this.next=null;
		}
		public Node getNext(){
			return next;
		}
		public void setNext(Node next){
			this.next=next;		
		}
		public int getValue(){
			return wartosc;
		}
	}
}
