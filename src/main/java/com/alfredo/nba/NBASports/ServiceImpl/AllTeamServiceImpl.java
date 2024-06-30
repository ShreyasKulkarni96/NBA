package com.alfredo.nba.NBASports.ServiceImpl;

import com.alfredo.nba.NBASports.Models.AllTeamWrapper;
import com.alfredo.nba.NBASports.Repository.AllTeamRepository;
import com.alfredo.nba.NBASports.Service.AllTeamService;
import com.alfredo.nba.NBASports.allEums.ApiKeyEnum;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AllTeamServiceImpl implements AllTeamService {

    @Autowired
    AllTeamRepository allTeamsRepository;

    public AllTeamServiceImpl() {

    }

    public List<List<AllTeamWrapper>> getAllTeams() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        new ArrayList();

        try {
            URL url = new URL(ApiKeyEnum.TARGET_URL.getValue());
            URI baseUri = url.toURI();
            URI fullUri = baseUri.resolve("/v1/teams");
            URL fullUrl = fullUri.toURL();
            HttpURLConnection connection = (HttpURLConnection)fullUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", ApiKeyEnum.API_KEY.getValue());
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            if (responseCode != 200) {
                System.out.println("GET request failed");
                return null;
            } else {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();

                String inputLine;
                while((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();
                JsonNode responseNode = objectMapper.readTree(response.toString());
                JsonNode dataNode = responseNode.get("data");
                List<AllTeamWrapper> teams = (List) StreamSupport.stream(dataNode.spliterator(), false).map((node) -> {
                    AllTeamWrapper team = new AllTeamWrapper();
                    team.setConference(node.get("conference").asText());
                    team.setDivision(node.get("division").asText());
                    team.setCity(node.get("city").asText());
                    team.setName(node.get("name").asText());
                    team.setFullName(node.get("full_name").asText());
                    team.setAbbreviation(node.get("abbreviation").asText());
                    return team;
                }).collect(Collectors.toList());
                List<AllTeamWrapper> teamResponse = this.allTeamsRepository.saveAll(teams);
                return Arrays.asList(teamResponse);
            }
        } catch (Exception var16) {
            var16.printStackTrace();
            return null;
        }


    }

}
