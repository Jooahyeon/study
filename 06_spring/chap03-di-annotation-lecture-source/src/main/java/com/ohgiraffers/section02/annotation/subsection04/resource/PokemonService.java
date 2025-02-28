package com.ohgiraffers.section02.annotation.subsection04.resource;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("pokemonServiceInject")
public class PokemonService {

    /* 설명. 1. Inject 라이브러리를 활용한 필드 주입 */
//    @Inject
//    @Named("squirtle")
//    private Pokemon pokemon;
//
    /* 설명. 2. 생성자 주입 */
//    private Pokemon pokemon;
//
//    @Inject
//    public PokemonService(@Named("pikachu") Pokemon pokemon) {
//        this.pokemon = pokemon;
//    }

    /* 설명. 3. Setter 주입 */
    private Pokemon pokemon;

    @Inject
    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}
