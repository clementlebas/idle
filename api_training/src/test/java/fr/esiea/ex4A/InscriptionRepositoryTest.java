package fr.esiea.ex4A;

import fr.esiea.ex4A.api.InscriptionData;
import fr.esiea.ex4A.api.InscriptionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InscriptionRepositoryTest {

    private final InscriptionRepository inscriptionRepository = new InscriptionRepository();

    @Test
    void randomHello_returns_an_hello_based_on_internal_list() {
        List<InscriptionData> data = inscriptionRepository.defaultUsers();

        assertThat(data.get(0).userEmail).isEqualTo("test@gmail.com");
        //assertThat(helloData.type).isEqualTo("hello");
        //assertThat(helloData.completeSentence).startsWith("hello ").endsWith("!");
    }

    /*@ParameterizedTest
    @CsvSource({
        "aby, aby",
        "Broly, Broly Broly",
        "cuevin, cuevin cuevin cuevin",
    })
    void hello_for_name_repeats_it_according_to_its_first_letter(String inputName, String expectedOutputName) {
        HelloData helloData = helloRepository.getHelloFor(inputName);

        assertThat(helloData.name).isEqualTo(expectedOutputName);
    }*/
}
