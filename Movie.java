public class Movie {
    private String id,title,genres,director,country,poster;
    private int year,minutes;

    public Movie(String id, String title, String genres, String director, String country, String poster, int year, int minutes) {
        this.id = id;
        this.title = title;
        this.genres = genres;
        this.director = director;
        this.country = country;
        this.poster = poster;
        this.year = year;
        this.minutes = minutes;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenres() {
        return genres;
    }

    public String getDirector() {
        return director;
    }

    public String getCountry() {
        return country;
    }

    public String getPoster() {
        return poster;
    }

    public int getYear() {
        return year;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", genres='" + genres + '\'' +
                ", director='" + director + '\'' +
                ", country='" + country + '\'' +
                ", poster='" + poster + '\'' +
                ", year=" + year +
                ", minutes=" + minutes +
                '}';
    }
}
