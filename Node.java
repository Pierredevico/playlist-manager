//This program mimics the functionality of a playlist allowing the user to add songs,
//play the next and previous song, and shuffle the playlist.
//Name: Pierce Coyle
//Date: 3/19/2024  
//Class: CS 145
//Assignment # 3
import java.util.Scanner;
class Node {
    String title;
    String artist;
    Node next; 

    //Initializes a new node with given values
    public Node(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.next = null;
    } //End of constructor Node

    public String toString() { //Returns a string representation of the node
        return String.format("\"%s\" by \"%s\"", title, artist);
    } //End of toString
}
