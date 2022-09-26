package fr.esiea.ex4A.api;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InscriptionController {

    private final InscriptionRepository inscriptionRepository;

    InscriptionController(InscriptionRepository inscriptionRepository) {
        this.inscriptionRepository = inscriptionRepository;
    }

    @PostMapping(path = "/api/inscription", consumes = MediaType.APPLICATION_JSON_VALUE)
    public InscriptionData inscription(@RequestBody InscriptionData inscriptionData) {
        return new InscriptionData(inscriptionData.userEmail, inscriptionData.userName, inscriptionData.userTweeter, inscriptionData.userCountry, inscriptionData.userSex, inscriptionData.userSexPref);
    }

    @GetMapping(path = "/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MatchingUsers> getMatchesUsers(@RequestParam(name = "userName", required = false) String userName, @RequestParam(name = "userCountry", required = false) String userCountry) {
        System.out.println(userName);
        List<MatchingUsers> response = new ArrayList<MatchingUsers>();

        for (int i = 0; i < inscriptionRepository.defaultUsers().size(); i++) {
            response.add(new MatchingUsers(inscriptionRepository.defaultUsers().get(i).getUserName(), inscriptionRepository.defaultUsers().get(i).getUserTweeter()));
        }
        return response;
    }
}
