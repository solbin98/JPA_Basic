package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Member {
    @Id
    private Long id;
    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDats;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiredDate;

    @Lob
    private String description;

    @Transient
    private int tmp;

    public Member(long l, String a1) {
        this.id = l;
        this.name = a1;
    }

    public Member() {}
}
