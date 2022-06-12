package API_sportNew.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "refreshtoken")
public class RefreshTokenEntity extends BaseEntity {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userID", referencedColumnName = "id")
    private UserEntity userEntity;
    @Column()
    private String token;
    @Column
    private Instant expiryDate;
}

