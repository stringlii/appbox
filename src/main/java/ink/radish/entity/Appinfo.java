package ink.radish.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Table(name = "appinfo")
@Entity
@Data
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class Appinfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String logo;

    private String name;

    private Integer price;

    private String category;

    private String account;

    private String password;
}
