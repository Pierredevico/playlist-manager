//This program mimics the functionality of a playlist allowing the user to add songs,
//play the next and previous song, and shuffle the playlist.
//Name: Pierce Coyle
//Date: 3/19/2024  
//Class: CS 145
//Assignment # 3
import java.util.Scanner;
public class Main {
     //Manages the user input and calls the required methods.
    public static void main(String[] args) { 
        MusicManager manager = new MusicManager();
        Scanner scan = new Scanner(System.in);
        int selection;
        String title;
        String artist;
        Node currentSong = null;

        do { //Menu start
            intro();
            try { //Try catch for alphabet input
                selection = Integer.parseInt(scan.nextLine());
                switch (selection) {
                    case 1:
                        System.out.println("Enter the title: ");
                        title = scan.nextLine();
                        System.out.println("Enter the artist: ");
                        artist = scan.nextLine();
                        Node node = new Node(title, artist);
                        if (currentSong == null) { //Sets first added song to current
                            currentSong = node;
                        }
                        manager.add(node, currentSong);
                        break;
                    case 2:
                        currentSong = manager.nextSong(currentSong);
                        break;
                    case 3:
                        currentSong = manager.previousSong(currentSong);
                        break;
                    case 4:
                        manager.shuffle();
                        break;
                    case 5:
                        manager.printList();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("\nInvalid option. Please enter a number between 1 and 6");
            }
        } catch (NumberFormatException e) {
            System.out.println("\nInvalid option. Please enter a number.");
            selection = 0;
        }
            if (currentSong != null && selection != 6) {
                System.out.println("\nCurrently playing: " + currentSong + "\n");
            }
        } while (selection != 6);
    } //End of Main

    public static void intro() { //Prints the intro 
        System.out.println("1 - Add Song");
        System.out.println("2 - Next Song");
        System.out.println("3 - Previous Song");
        System.out.println("4 - Shuffle Playlist");
        System.out.println("5 - Display Playlist");
        System.out.println("6 - Exit");
    } //End of intro
}
