package model;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import model.Guitar;
import model.GuitarSpec;

public class Inventory {

  private List guitars;

  public Inventory() {
    guitars = new LinkedList();
  }
  
  public void addGuitar(String serialNumber, double price,
                            GuitarSpec spec) {
    Guitar guitar = new Guitar(serialNumber, price, spec);
    guitars.add(guitar);
  }

  public Guitar getGuitar(String serialNumber) {
	  for (Iterator i = guitars.iterator(); i.hasNext(); ) {
	  Guitar guitar = (Guitar)i.next();
	  if (guitar.getSerialNumber().equals(serialNumber)) {
	  return guitar;
	  }
	  }
	  return null;
	  }

  public  List search(GuitarSpec searchSpec) {
	  List matchingGuitars = new LinkedList();
	  for (Iterator i = guitars.iterator(); i.hasNext(); ) {
	  Guitar guitar = (Guitar)i.next();
	  if (guitar.getSpec().matches(searchSpec))
	  matchingGuitars.add(guitar);
	  }
	  return matchingGuitars;
	  }

public int size() {
	// TODO Auto-generated method stub
	return 0;
}

public boolean isEmpty() {
	// TODO Auto-generated method stub
	return false;
}

public boolean contains(Object o) {
	// TODO Auto-generated method stub
	return false;
}

public Iterator<Guitar> iterator() {
	// TODO Auto-generated method stub
	return null;
}

public Object[] toArray() {
	// TODO Auto-generated method stub
	return null;
}

public <T> T[] toArray(T[] a) {
	// TODO Auto-generated method stub
	return null;
}

public boolean add(Guitar e) {
	// TODO Auto-generated method stub
	return false;
}

public boolean remove(Object o) {
	// TODO Auto-generated method stub
	return false;
}

public boolean containsAll(Collection<?> c) {
	// TODO Auto-generated method stub
	return false;
}

public boolean addAll(Collection<? extends Guitar> c) {
	// TODO Auto-generated method stub
	return false;
}

public boolean addAll(int index, Collection<? extends Guitar> c) {
	// TODO Auto-generated method stub
	return false;
}

public boolean removeAll(Collection<?> c) {
	// TODO Auto-generated method stub
	return false;
}

public boolean retainAll(Collection<?> c) {
	// TODO Auto-generated method stub
	return false;
}

public void clear() {
	// TODO Auto-generated method stub
	
}

public Guitar get(int index) {
	// TODO Auto-generated method stub
	return null;
}

public Guitar set(int index, Guitar element) {
	// TODO Auto-generated method stub
	return null;
}

public void add(int index, Guitar element) {
	// TODO Auto-generated method stub
	
}

public Guitar remove(int index) {
	// TODO Auto-generated method stub
	return null;
}

public int indexOf(Object o) {
	// TODO Auto-generated method stub
	return 0;
}

public int lastIndexOf(Object o) {
	// TODO Auto-generated method stub
	return 0;
}

public ListIterator<Guitar> listIterator() {
	// TODO Auto-generated method stub
	return null;
}

public ListIterator<Guitar> listIterator(int index) {
	// TODO Auto-generated method stub
	return null;
}

public List<Guitar> subList(int fromIndex, int toIndex) {
	// TODO Auto-generated method stub
	return null;
}
	  }