package dev.justinstevens.movierankings.documents;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Movie {

    @Id
    private String id;

    private String name;
    private int rating;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime dateWatched;

    public Movie(String id, String name, int rating, LocalDateTime dateWatched) {
        super();
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.dateWatched = dateWatched;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDateTime getDateWatched() {
        return dateWatched;
    }

    public void setDate(LocalDateTime dateWatched) {
        this.dateWatched = dateWatched;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", dateWatched='" + dateWatched + '\'' +
                '}';
    }
}
