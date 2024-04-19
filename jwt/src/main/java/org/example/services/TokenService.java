package org.example.services;

import org.example.model.Token;

public interface TokenService {
    Token createToken(Token token);
    Token findByToken(String token);

}
