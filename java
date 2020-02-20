public class DoublyLinkedList{
 DNode head;
 DNode tail;
 int item;
 int count;
 
 
 public boolean isEmpty(){
  return count == 0;
 }
 
 public void addFront(int item){
  DNode node = new DNode(item);
  if(isEmpty())
   tail = head = node;
  else
   {
    node.setRight(head);
    head.setLeft(node);
    head = node;
   }
    count++;
 }
 public void addLast(int item){
   
   DNode temp = new DNode(item);
   
   
   if(isEmpty())
   head = tail = temp;
   else
   {
   
   temp.setLeft(tail);
   tail.setRight(temp);
   tail = temp;
   }
   count++;
   
 }
 
 public void removeFront(){
  if(!isEmpty()){
   DNode p = head;
   head = head.getRight();
   head.setLeft(null);
   p.setRight(null);
   count--;
  }
 }
 
 public void removeLast(){
  if(!isEmpty()){
      DNode p = tail;
      tail = tail.getLeft();
      tail.setRight(null);
      p.setLeft(null);
      count--;
   }
 }
 
 
 public void remove(int item){
   
   if(!isEmpty()){
      if(head.getItem() == item){
         removeFront();
      }
      else if(tail.getItem() == item ){
         removeLast();
         
      }
      else{
         DNode p = head;
         p = p.getRight();
         while(p != null){
            if(p.getItem() == item){
               p = p.getRight();
               DNode tempRight = p;
               p = p.getLeft();
               p = p.getLeft();
                  DNode tempLeft = p;
                  p.setRight(tempRight);
                  p = p.getRight();
                  p.setLeft(tempLeft);
                 break;
            }
            else
            p = p.getRight();
         }
      }
   }
   
 }
 
 public void insertAt(int pos, int item){
   if(!isEmpty()){
      if(pos == 1){
         addFront(item);
      }
      else if(pos > count){
         addLast(item);
      }
      else{
         DNode node = new DNode(item);
         DNode p = head;
         int track = 2;
         p = p.getRight();
            while(p != null){
               if(track == pos){
                DNode tempRight = p;
                p = p.getLeft();
                DNode tempLeft = p;
                p.setRight(node);
                p = p.getRight();
                p.setRight(tempRight);
                p.setLeft(tempLeft);
                DNode tempM = p;
                p = p.getRight();
                p.setLeft(tempM);
                count++;
                break;
                  
               }
               else{
                  p = p.getRight();
                  ++track;
               }
            }
         
         
         
      }
   }
 }

  public void displayInReverse(){
  
   if(!isEmpty()){
      DNode p = tail;
         while(p != null){
            System.out.print(p.getItem() + " " );
            p = p.getLeft();
         }
   }
  }
 
 /*
  do the following methods:
  addLast - done
  removeLast - done
  remove(int item) - done 
  insertAt(int pos, int item) - done
  displayInReverse - done
  
 */
 
 public String toString(){
 StringBuffer sb = new StringBuffer();
 sb.append("{");
 DNode p = head;
 while(p != null){
 //System.out.println("cehck!'");
  sb.append(p.getItem() +  " ");
  p = p.getRight();
  
 }
 sb.append("}");
 return sb.toString();
 }
 public static void main(String [] args){
  DoublyLinkedList list = new DoublyLinkedList();
  list.addFront(1);
  list.addFront(2);
  list.addFront(3);
  
  
  list.addLast(4);
  list.addLast(5);
  list.addLast(6);

  
  System.out.println("list contains: " + list);
  
  list.removeFront();
  
  System.out.println("Removing Front : " + list);
  list.removeFront();
  System.out.println("Removing Front : " + list);
  
  list.removeLast();
  
  System.out.println("Removing Last : " + list);
  
System.out.println("\ncount =  " + list.count);
  
  list.remove(4);
  System.out.print("Remove # : " + list);
  
  list.insertAt(4,10);
  System.out.println("\nInserting # : " + list); 
  
  System.out.print("Reverse number : ");
  list.displayInReverse();
     
 }
}
