
public class DListNode{
	public int[] item;
	public DListNode prev,next;
	public DListNode(int runLength,int red,int green,int blue){
		item=new int[4];
		item[0]=runLength;
		item[1]=red;
		item[2]=green;
		item[3]=blue;
		prev=null;
		next=null;
	}
}