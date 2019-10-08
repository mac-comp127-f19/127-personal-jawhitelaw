package libraryInterface;

public class Video implements Media {
    private String title;
    private String director;
    private int numCopies;
    private int currentCopies;

    public Video(String videoTitle, String nameDirector, int numberCopies){
        title=videoTitle;
        director=nameDirector;
        numCopies=numberCopies;
        currentCopies=numberCopies;
    }

    @Override
    public boolean checkOut() {
        if(currentCopies>0){
            currentCopies--;
            return true;
        }
        return false;
    }

    @Override
    public boolean checkIn() {
        if(currentCopies<numCopies){
            currentCopies++;
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return "Title: " + title + " Director: " + director + " Copies Available: " + currentCopies;
    }

    @Override
    public String getTitle(){
        return title;
    }
}
