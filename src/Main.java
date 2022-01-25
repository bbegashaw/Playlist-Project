import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("Thriller", "Michael Jackson");
        album.addSong("Wanna Be Startin' Somethin'",6.02);
        album.addSong("Baby Be Mine",4.20);
        album.addSong("The Girl Is Mine",3.42);
        album.addSong("Thriller",5.57);
        album.addSong("Beat It",4.17);
        album.addSong("Billie Jean",4.53);
        album.addSong("Human Nature",4.06);
        album.addSong("P.Y.T",3.58);
        album.addSong("The Lady in My Life",4.58);
        albums.add(album);

        album = new Album("The Miseducation of Lauryn Hill", "Lauryn Hill");
        album.addSong("Lost Ones",5.33);
        album.addSong("Ex-Factor",5.26);
        album.addSong("To Zion",6.09);
        album.addSong("Doo Wop",5.20);
        album.addSong("Superstar",4.56);
        album.addSong("Final Hour",4.15);
        album.addSong("When It Hurts So Bad",5.41);
        album.addSong("I Used To Love Him",5.39);
        album.addSong("Forgive Them Father",5.15);
        album.addSong("Every Ghetto",5.14);
        album.addSong("Nothing Even Matters",5.50);
        album.addSong("Everything is Everything",4.15);
        album.addSong("The Misseduction of Lauryn Hill",3.54);
        album.addSong("Can't Take My Eyes Off You",3.41);
        album.addSong("Tell Him",4.40);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(1).addToPlayList("Nothing Even Matters",playList);
        albums.get(0).addToPlayList("Thriller",playList);
        albums.get(0).addToPlayList("Billie Jean",playList);
        albums.get(0).addToPlayList(5, playList);
        albums.get(1).addToPlayList(7, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(11, playList);
        albums.get(0).addToPlayList(7, playList);

        play(playList);
    }

    private static void play(LinkedList<Song> playList)
    {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0)
        {
            System.out.println("No songs in playlist");
            return;
        }else{
            System.out.println("WELCOME TO YOUR PLAYLIST");
            System.out.println(" ");
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }
        while(!quit)
        {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action)
            {
                case 0:
                    System.out.println("Playslist complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward)
                    {
                        if(listIterator.hasNext())
                        {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    }else
                    {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward)
                    {
                        if(listIterator.hasPrevious())
                        {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious())
                    {
                        System.out.println("Now playing "+listIterator.previous().toString());
                    }
                    else{
                        System.out.println("We are the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward)
                    {
                        if(listIterator.hasPrevious()){
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        }else{
                            System.out.println("At satrt of list");
                        }
                    }else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("End of list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playList.size() > 0)
                    {
                        System.out.println("Deleting " + listIterator.previous().getTitle());
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing "+listIterator.next());
                        }
                        else{
                            System.out.println("Now playing "+listIterator.previous());
                        }
                    }
            }

        }
    }

    private static void printMenu()
    {
        System.out.println("Actions: \npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song \n" +
                "2 - to replay the previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions\n" +
                "6 - remove current song from playlist");
    }

    private static void printList(LinkedList<Song> playList)
    {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("----------------------------------");
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        System.out.println("-----------------------------------");
    }
}
