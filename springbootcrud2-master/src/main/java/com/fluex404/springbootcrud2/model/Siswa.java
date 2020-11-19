package com.fluex404.springbootcrud2.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "siswa")
public class Siswa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    @NotBlank(message = "lol")
    private String nama;
    @NotBlank(message = "lol")
    private String jurusan;

    public Siswa(String nama, String jurusan) {
        this.nama = nama;
        this.jurusan = jurusan;
    }

    public Siswa() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    @Override
    public String toString() {
        return "Siswa{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", jurusan='" + jurusan + '\'' +
                '}';
    }

}
