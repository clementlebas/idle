package fr.esiea.ex4A;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.esiea.ex4A.api.InscriptionData;
import fr.esiea.ex4A.api.InscriptionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class InscriptionControllerIT {

    private final MockMvc mockMvc;

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @MockBean
    private InscriptionRepository repository;

    InscriptionControllerIT(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void hello_delegates_to_repository_when_name_param_is_present() throws Exception {
        when(repository.defaultUsers()).thenReturn(List.of(
            new InscriptionData("test@gmail.com","Isabelle", "isatweet", "FR", "F", "H"),
            new InscriptionData("test@gmail.com","Michelle", "michelletweet","FR", "F", "H"),
            new InscriptionData("test@gmail.com","Bernadette", "bernatweet", "FR", "F", "H")
        ));



        InscriptionData data = new InscriptionData("test","test", "test", "FR", "M", "M");

        mockMvc
            .perform(MockMvcRequestBuilders.post("/api/inscription")
                .content(asJsonString(data))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json("""
                {
                    "userEmail": "test",
                    "userName": "test",
                    "userTweeter": "test",
                    "userCountry": "FR",
                    "userSex": "M",
                    "userSexPref": "M"
                }
                        """));

        //verify(repository).getHelloFor("test");
    }
/*
    @Test
    void hello_delegates_to_random_when_name_param_is_absent() throws Exception {
        when(repository.randomHello()).thenReturn(new HelloData("randomtest"));

        mockMvc
            .perform(MockMvcRequestBuilders.get("/hello"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.type").value("hello"))
            .andExpect(jsonPath("$.name").value("randomtest"))
            .andExpect(jsonPath("$.completeSentence").value(allOf(startsWith("hello"), endsWith("!"))));

        verify(repository).randomHello();
    }*/
}
