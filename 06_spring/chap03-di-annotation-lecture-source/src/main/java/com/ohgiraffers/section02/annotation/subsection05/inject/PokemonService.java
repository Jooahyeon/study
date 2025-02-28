package com.ohgiraffers.section02.annotation.subsection05.inject;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pokemonServiceResource")
public class PokemonService {

//    /* 설명. @Primary보다 우선순위 높게 빈의 id(이름)으로 하나의 빈을 선정 */
//    @Resource(name = "pikachu")
//    private Pokemon pokemon;
//
//    public void pokemonAttack() {
//        pokemon.attack();
//    }

    @Resource
    // 생성자 주입 안됨.
    private List<Pokemon> pokemonList;

    public void pokemonAttack() {
//        pokemonList.forEach(pokemon -> pokemon.attack());
        pokemonList.forEach(Pokemon::attack);
    }
}
