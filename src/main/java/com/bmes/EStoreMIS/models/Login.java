package com.bmes.EStoreMIS.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Embeddable
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(name = "Username",
                column = @Column(name = "Username")
        ),
        @AttributeOverride(name = "email",
                column = @Column(name = "Email")
        ),
        @AttributeOverride(name = "password",
        column = @Column(name = "Password")
),

})
public class Login {
    @Column(name = "Username")
    private String username;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;
}
