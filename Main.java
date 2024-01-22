//taha burak sahin pjatk   Test all the methods on a chosen String variable.

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String java = " Java";
        System.out.println("Original String: " + java);

        java = java.replace('a', 'z');
        System.out.println("After replacing 'a' with 'z': " + java);

        java = java.toLowerCase();
        System.out.println("After changing all upper cases to lower cases: " + java);

        java = java.trim();
        System.out.println("After removing all whitespaces from the begin and end of the string: " + java);

        if (java.contains("c")) {
            System.out.println("The string contains 'c'.");
        } else {
            System.out.println("The string does not contain 'c'.");
        }

        String[] splits = java.split("a");
        System.out.println("After splitting the string by letter 'a':");
        for (String split : splits) {
            System.out.println(split);
        }
    }
}
class Song {

    private String singer;
    private String title;

    public Song(String singer, String title) {
        this.singer = singer;
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return singer + " - " + title;
    }
}

class Album  {
    private String title;
    private Song[] songs;

    public Album(String title, Song[] songs) {
        this.title = title;
        this.songs = songs;
    }

    public String getTitle() {
        return title;
    }

    public Song[] getSongs() {
        return songs;
    }
}

class Shelf {
    private Album[] albums;

    public Shelf(Album[] albums) {
        this.albums = albums;
    }

    public String findAlbumBySong(String songTitle) {
        for (Album album : albums) {
            for (Song song : album.getSongs()) {
                if (song.getTitle().equals(songTitle)) {
                    return album.getTitle();
                }
            }
        }
        return null;
    }

    public Song[] findSongsBySinger(String singer) {
        ArrayList<Song> songsList = new ArrayList<>();
        for (Album album : albums) {
            for (Song song : album.getSongs()) {
                if (song.getSinger().equals(singer)) {
                    songsList.add(song);
                }
            }
        }
        return songsList.toArray(new Song[0]);
    }
}