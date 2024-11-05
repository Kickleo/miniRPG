package epsi.tepedelen.leo;

import epsi.tepedelen.leo.rpg.controller.CharacterController;
import epsi.tepedelen.leo.rpg.service.CharacterService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import epsi.tepedelen.leo.rpg.model.Character;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CharacterController.class)
class CharacterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CharacterService characterService;


    @Test
    void testGetCharacter() throws Exception {
        // Mock the service response
        Character mockCharacter = new Character("Gandalf", "wizard");
        Mockito.when(characterService.getCharacter("Gandalf")).thenReturn(mockCharacter);

        // Perform the GET request
        mockMvc.perform(get("/characters/Gandalf"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Gandalf"))
                .andExpect(jsonPath("$.classType").value("wizard"))
                .andExpect(jsonPath("$.treasure").value(""))
                .andExpect(jsonPath("$.level").value(1))
                .andExpect(jsonPath("$.health").value(100))
                .andExpect(jsonPath("$.maxHealth").value(100))
                .andExpect(jsonPath("$.quest").isEmpty());
    }
}
