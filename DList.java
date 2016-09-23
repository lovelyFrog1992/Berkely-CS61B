public class DList{
	public DListNode head=null;
	public int size=0;
	public DList(){
		head=new DListNode(0,-1,-1,-1);
		head.next=head;
		head.prev=head;
	}
	public void addDListFront(DListNode nd){
		if(size==0){
		   head.next=nd;
		   nd.next=head;
		   head.prev=nd;
		   nd.prev=head;
		}else{
			nd.next=head.next;
			head.next=nd;
			nd.next.prev=nd;
			nd.prev=head;
		}
		size++;
	}
	public void addDListEnd(DListNode nd){
		if(size==0){
		   head.next=nd;
		   nd.next=head;
		   head.prev=nd;
		   nd.prev=head;
		}else{
			head.prev.next=nd;
			nd.next=head;
			nd.prev=head.prev;
			head.prev=nd;
		}
//		System.out.println("c:"+nd.prev.item[1]+"l:"+nd.prev.item[0]);
	//	System.out.println("c:"+nd.next.item[1]+"l:"+nd.next.item[0]);
		size++;
	}
	public void insertNode(DListNode nd1,DListNode nd2,DListNode nd){
		  nd.prev.next=nd1;
	    //  System.out.println("l:"+nd.prev.item[0]+" c:"+nd.prev.item[1]);
		  nd1.next=nd2;
		  nd2.next=nd.next;
		  nd.next.prev=nd2;
		  nd2.prev=nd1;
		  nd1.prev=nd.prev;
	}
	public void insertNode(DListNode nd1,DListNode nd2,DListNode nd3,DListNode nd){
		nd.prev.next=nd1;
		nd1.next=nd2;
		nd2.next=nd3;
		nd3.next=nd.next;
		nd.next.prev=nd3;
		nd3.prev=nd2;
		nd2.prev=nd1;
		nd1.prev=nd.prev;
	}
	public void change(DListNode nd1,DListNode nd){
		nd.prev.next=nd1;
		nd1.next=nd.next;
		nd.next.prev=nd1;
		nd1.prev=nd.prev;
	}
}