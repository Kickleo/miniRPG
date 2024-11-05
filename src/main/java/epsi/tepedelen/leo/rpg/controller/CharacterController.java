package epsi.tepedelen.leo.rpg.controller;

import epsi.tepedelen.leo.rpg.exceptions.NoCharacterWithNameException;
import epsi.tepedelen.leo.rpg.model.Character;
import epsi.tepedelen.leo.rpg.service.CharacterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(final CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping(value = "/characters/{name}", consumes = {"*/*"})
    public Character getCharacter(@PathVariable String name){
        try {
            return characterService.getCharacter(name);
        } catch (NoCharacterWithNameException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/characters")
    public List<Character> getAllCharacters(){
        return characterService.getCharacters();
    }

    @PostMapping(value = "/characters", consumes = {"application/xml","application/json"})
    public Character addCharacter(@RequestBody Character character){
        return characterService.addCharacter(character);
    }

    @PutMapping(value = "/characters/{name}", consumes = {"application/xml","application/json"})
    public Character updateCharacter(@PathVariable String name, @RequestBody Character character){
        try{
            return characterService.updateCharacter(name, character);
        }catch (NoCharacterWithNameException e){
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping(value = "characters/{name}", consumes = {"application/xml","application/json"})
    public Character deleteCharacter(@PathVariable String name){
        try {
            return characterService.removeCharacter(name);
        }
        catch (NoCharacterWithNameException e){
            throw new RuntimeException(e);
        }
    }

}
