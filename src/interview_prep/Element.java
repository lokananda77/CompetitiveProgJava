package interview_prep;

public class Element {
	  Element next;
	  Object  data;
	  
	  public Element(Object data) {
	    this.data = data;
	  }
	  
	  public Element findnthlast (Element head, int n) {
	      Element p1 = head, p2= head;
	      while (n-- > 0) {
	          if (p1.next != null) {
	              p1 = p1.next;
	          } else {
	              return null;
	          }
	      }
	      while(p1.next != null) {
	          p1 = p1.next;
	          p2 = p2.next;
	      }
	      return p2;
	  }
	  
	  public static void main(String[] args) {
		  Element e1 = new Element(3);
		  Element e2 = new Element(4);
		  Element e3 = new Element(5);
		  Element e4 = new Element(6);
		  Element e5 = new Element(7);
		  e1.next = e2;
		  e2.next = e3;
		  e3.next = e4;
		  e4.next = e5;
		  System.out.println(e1.findnthlast(e1, 2).data);
	  }
	}