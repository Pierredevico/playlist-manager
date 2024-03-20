//This program mimics the functionality of a playlist allowing the user to add songs,
//play the next and previous song, and shuffle the playlist.
//Name: Pierce Coyle
//Date: 3/19/2024  
//Class: CS 145
//Assignment # 3
import java.util.Random;
public class MusicManager {
    Node head;
    Node current;

    public MusicManager() {
        this.head = null;
    } //End of constructor MusicManager

    void add(Node newNode, Node current) { //Adds the new node
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    } //End of add

    void shuffle() { //Calls the recursive shuffling method and passes the list length
        int listLength = 0;
        Node temp = head;
        
        while (temp.next != null) {
            temp = temp.next;
            listLength++;
        }

        if (listLength <= 1) {
            return;
        }
        head = shuffle(head, listLength);
    } //End of shuffle

    Node shuffle(Node head, int count) { //Shuffles the linked list

        if (count > 1) {
            Random rand = new Random();
            int randInt = rand.nextInt(count) + 1;
            
            Node temp = head;
            Node prev = null;
            
            for (int i = 0; i < randInt; i++) {
                if (temp == null) { 
                    break;
                }
                prev = temp;
                temp = temp.next;
            }
    
            if (temp == null) {
                return head;
            }
    
            if (prev != null) { //checks if temp is head
                prev.next = temp.next;
            } else {
                head = temp.next;
            }
    
            temp.next = shuffle(head, count - 1);
            return temp; //Return the shuffled node
        } else {
            return head;
        }
    } //End of shuffle

    void printList() { //Calls the printList method and passes the list head
            printList(head);
        return;
    }  //End of printList

    void printList(Node head) { //Prints the playlist
        Node temp = head;
        System.out.println("");
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.next;
        }
        System.out.println("");
        return;
    } //End of printList

    Node nextSong(Node current) { //Calls the nextSong method and passes the list head
        return nextSong(current, head);
    } //End of nextSong

    Node nextSong(Node current, Node head) { //Skips to the next song
        if (current == null) {
            return head;
        } 

        if (current.next == null) {
            System.out.println("\nEnd of playlist reached.\n");
            return current;
        }
            return current.next;
    } //End of nextSong
    

    Node previousSong(Node current) { //Calls the previousSong method and passes the list head
        return previousSong(current, head);
    } //End of previousSong

    Node previousSong(Node current, Node head) { //returns to the previous song
        if (current == null) { //returns if the playlist is empty
            System.out.println("Playlist is empty.\n");
            return null;
        }
    
        if (current == head) { //returns if there is no previous song
            System.out.println("\nAlready at the beginning of the playlist.\n");
            return current;
        }
    
        Node temp = head;
        while (temp != null && temp.next != current) {
            temp = temp.next;
        }
        return temp;
    } //End of previousSong
}

