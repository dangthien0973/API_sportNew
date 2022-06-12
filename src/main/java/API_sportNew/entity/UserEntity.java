package API_sportNew.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "useraccount",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "userName"),
        })
public class UserEntity extends BaseEntity {

    @Size(max = 20)
//    @Length(min = 5,max = 20, message = "*Your password must have at least 5 characters")
    @Column
    private String userName;
    @Column
    @NotBlank
    @Size(max = 50)
    private String email;
    @Column
    @Size(max = 120)
    private String passwords;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "userRoles",
            joinColumns = @JoinColumn(name = "userID"), inverseJoinColumns = @JoinColumn(name = "roleID"))
    private Set<RoleEntity> roles = new HashSet<>();
    @Column
    private String address;
    @Column
    private String phone;
    @Column
    private String gender;
    @Column
    private boolean enabled;
    @Column
    private int verificationCode;
    @Column
    private int verifiForgot;
    @Column
    private String statuss;

    @OneToOne(mappedBy = "userEntity")
    private RefreshTokenEntity refreshToken;

    public UserEntity(String username, String email, String password) {
        this.userName = username;
        this.email = email;
        this.passwords = password;
    }

    public UserEntity(String username,String email) {
        this.userName = username;
        this.email = email;

    }

}
