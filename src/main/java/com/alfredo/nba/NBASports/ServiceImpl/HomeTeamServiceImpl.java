package com.alfredo.nba.NBASports.ServiceImpl;

import com.alfredo.nba.NBASports.Models.HomeTeam;
import com.alfredo.nba.NBASports.Repository.HomeTeamRepository;
import com.alfredo.nba.NBASports.Service.HomeTeamService;
import com.alfredo.nba.NBASports.allEums.ApiKeyEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

@Service
public class HomeTeamServiceImpl implements HomeTeamService {
    @Autowired
    HomeTeamRepository homeTeamRepository;

    public HomeTeamServiceImpl() {
    }

    public HomeTeam getHomeTeamById(Long id) throws Exception {
        HomeTeam homeTeam = new HomeTeam();

        try {
            URL url = new URL(ApiKeyEnum.TARGET_URL.getValue());
            String pathTemplate = "/v1/teams/%d";
            String path = String.format(pathTemplate, id);
            URI baseUri = url.toURI();
            URI fullUri = baseUri.resolve(path);
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

                ObjectMapper objectMapper = new ObjectMapper();
                HomeTeam teamResponse = (HomeTeam)objectMapper.readValue(response.toString(), HomeTeam.class);
                if (teamResponse != null && teamResponse.getData() != null) {
                    homeTeam = teamResponse.getData();
                }

                homeTeam = (HomeTeam)this.homeTeamRepository.save(homeTeam);
                return homeTeam;
            }
        } catch (Exception var16) {
            var16.printStackTrace();
            return null;
        }
    }
}
