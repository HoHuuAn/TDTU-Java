package com.hohuuan.Exercise.payload;

import com.hohuuan.Exercise.model.account.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
    private Account account;
    private String jwtToken;
}
