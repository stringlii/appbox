package ink.radish.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Table(name = "fconfig")
@Entity
@Data
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class Fconfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer gridnum;

    private String gridtext;

    private String notice;

    private String actionsheettitle;

    private String accountBtn;

    private String passwordBtn;

    private String capsuletitle;
}
