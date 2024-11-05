package epsi.tepedelen.leo.rpg.service;

import java.util.*;

import epsi.tepedelen.leo.rpg.exceptions.NoCharacterWithNameException;
import epsi.tepedelen.leo.rpg.model.Character;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {
    private final Map<String, Character> characters = new HashMap<>();
    private static final String NO_SUCH_CHARACTER = "No Such Character";

    public List<Character> getCharacters() {
        return new ArrayList<>(characters.values());
    }

    public Character getCharacter(String name) throws NoCharacterWithNameException {
        try {
            return Optional.ofNullable(characters.get(name)).orElseThrow(() -> new NullPointerException(NO_SUCH_CHARACTER));
        }catch(Exception e) {
            throw new NoCharacterWithNameException(e);
        }
    }

    public Character addCharacter(Character character) {
        return characters.put(character.getName(), character);
    }

    public Character updateCharacter(String name, Character character) throws NoCharacterWithNameException {
        if (characters.containsKey(name)) {
            return characters.put(name, character);
        }else{
            throw new NoCharacterWithNameException(new Exception(NO_SUCH_CHARACTER));
        }
    }

    public Character removeCharacter(String name) throws NoCharacterWithNameException {
        try {
            return Optional.ofNullable(characters.remove(name)).orElseThrow(() -> new NullPointerException(NO_SUCH_CHARACTER));
        }catch(NullPointerException e) {
            throw new NoCharacterWithNameException(e);
        }
    }

}
