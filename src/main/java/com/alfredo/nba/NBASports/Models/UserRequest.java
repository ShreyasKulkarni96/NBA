package com.alfredo.nba.NBASports.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
}
