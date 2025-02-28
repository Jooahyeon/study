package com.ohgiraffers.section02.annotation.subsection02.qualifier;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceQualifier")
public class PokemonService {
    /* 설명. bean에 @primary가 설정되어 있더라도 주입을 받는 시점에 원하는 bean을 고를 수 있다. */
//    @Autowired
    // +) primary가 있더라도 더 우선되는 것 @Qualifier
//    @Qualifier("squirtle")
    private Pokemon pokemon;



    // 생성자 주입은 @Autowired 생략 가능 (웬만하면 달아라)
    @Autowired
    public PokemonService(@Qualifier("pikachu") Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}
