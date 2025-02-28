package com.ohgiraffers.section02.annotation.subsection01.primary;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pokemonServicePrimary")
public class PokemonService {

    // +) 포케몬이라는 인터페이스에 의존하고 있는 것.
    private Pokemon pokemon;


    // 생성자 주입은 @Autowired 생략 가능 (웬만하면 달아라)
    @Autowired
    public PokemonService(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}
