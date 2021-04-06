package com.example.demo;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Job {

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    private String name;

    private String description;

}
