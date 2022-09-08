package dev.justinstevens.movierankings.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document()
public class Movie {

    @Id
    private String id;

    @Indexed(unique = true)
    private String name;
    private double rating;

    public Movie(String id, String name, double rating) {
        super();
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    public Movie() {
        super();
        this.id = null;
        this.name = null;
        this.rating = 0;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }
}
