package com.alfredo.nba.NBASports.Models;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    public String Email;

    public int ErrorCode;

    public String Error_Message;
}
