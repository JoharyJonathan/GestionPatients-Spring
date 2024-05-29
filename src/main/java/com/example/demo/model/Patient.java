package com.example.demo.model;

public class Patient {

    private long id;
    private String nom;
    private int age;
    private String datedenaissance;
    private String email;
    private String genre;

    public Patient()
    {

    }

    public Patient(long id, String nom, int age, String datedenaissance, String email, String genre)
    {
        this.id = id;
        this.nom = nom;
        this.age = age;
        this.datedenaissance = datedenaissance;
        this.email = email;
        this.genre = genre;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getDatedenaissance()
    {
        return datedenaissance;
    }

    public void setDatedenaissance(String datedenaissance)
    {
        this.datedenaissance = datedenaissance;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    @Override
    public String toString()
    {
        return "Patient{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", age=" + age + 
                ", datedenaissance=" + datedenaissance + '\'' +
                ", email=" + email + '\'' +
                ", genre=" + '\'' +
        "}";
    }
}
