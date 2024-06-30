package com.alfredo.nba.NBASports.ServiceImpl;

import com.alfredo.nba.NBASports.Models.Game;
import com.alfredo.nba.NBASports.Models.HomeTeam;
import com.alfredo.nba.NBASports.Models.VisitorTeam;
import com.alfredo.nba.NBASports.Repository.GameRepository;
import com.alfredo.nba.NBASports.Service.GameService;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    GameRepository gameRepository;

    public GameServiceImpl() {

    }

    public List<Game> getAllGames() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        new ArrayList();

        try {
            URL url = new URL(ApiKeyEnum.TARGET_URL.getValue());
            String pathTemplate = "/v1/games";
            URI baseUri = url.toURI();
            URI fullUri = baseUri.resolve(pathTemplate);
            URL fullUrl = fullUri.toURL();
            HttpURLConnection connection = (HttpURLConnection)fullUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", ApiKeyEnum.API_KEY.getValue());
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            if (responseCode != 200) {
                System.out.println("GET request failed");
                return new ArrayList();
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
                if (dataNode != null && dataNode.isArray()) {
                    List<Game> games = (List) StreamSupport.stream(dataNode.spliterator(), false).map((node) -> {
                        Game game = new Game();

                        try {
                            String dateString = node.get("date").asText();
                            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
                            LocalDate localDate = LocalDate.parse(dateString, formatter);
                            game.setDate(localDate);
                            game.setSeason(node.get("season").asInt());
                            game.setStatus(node.get("status").asText());
                            game.setPeriod(node.get("period").asInt());
                            game.setTime(node.get("time").asText());
                            game.setPostseason(node.get("postseason").asBoolean());
                            game.setHomeTeamScore(node.get("home_team_score").asInt());
                            game.setVisitorTeamScore(node.get("visitor_team_score").asInt());
                            JsonNode homeTeamNode = node.get("home_team");
                            HomeTeam homeTeam = (HomeTeam)objectMapper.treeToValue(homeTeamNode, HomeTeam.class);
                            game.setHomeTeam(homeTeam);
                            JsonNode visitorTeamNode = node.get("visitor_team");
                            VisitorTeam visitorTeam = (VisitorTeam)objectMapper.treeToValue(visitorTeamNode, VisitorTeam.class);
                            game.setVisitorTeam(visitorTeam);
                        } catch (Exception var10) {
                            var10.printStackTrace();
                        }

                        return game;
                    }).collect(Collectors.toList());
                    this.gameRepository.saveAll(games);
                    System.out.println("Games saved to the database");
                    return games;
                } else {
                    System.out.println("No data found in the response");
                    return new ArrayList();
                }
            }
        } catch (Exception var16) {
            var16.printStackTrace();
            return new ArrayList();
        }
    }

    public List<Game> getAllGamesByDate(String date) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            LocalDate targetDate;
            switch (date.toLowerCase()) {
                case "yesterday":
                    targetDate = LocalDate.now().minusDays(1L);
                    break;
                case "today":
                    targetDate = LocalDate.now();
                    break;
                case "tomorrow":
                    targetDate = LocalDate.now().plusDays(1L);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid date value. Use 'yesterday', 'today', or 'tomorrow'.");
            }

            URL url = new URL(ApiKeyEnum.TARGET_URL.getValue());
            String pathTemplate = "/v1/games";
            URI baseUri = url.toURI();
            URI fullUri = baseUri.resolve(pathTemplate);
            URL fullUrl = fullUri.toURL();
            HttpURLConnection connection = (HttpURLConnection)fullUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", ApiKeyEnum.API_KEY.getValue());
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            if (responseCode != 200) {
                System.out.println("GET request failed");
                return new ArrayList();
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
                if (dataNode != null && dataNode.isArray()) {
                    List<Game> games = (List)StreamSupport.stream(dataNode.spliterator(), false).map((node) -> {
                        Game game = new Game();

                        try {
                            String dateString = node.get("date").asText();
                            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
                            LocalDate localDate = LocalDate.parse(dateString, formatter);
                            game.setDate(localDate);
                            game.setSeason(node.get("season").asInt());
                            game.setStatus(node.get("status").asText());
                            game.setPeriod(node.get("period").asInt());
                            game.setTime(node.get("time").asText());
                            game.setPostseason(node.get("postseason").asBoolean());
                            game.setHomeTeamScore(node.get("home_team_score").asInt());
                            game.setVisitorTeamScore(node.get("visitor_team_score").asInt());
                            JsonNode homeTeamNode = node.get("home_team");
                            HomeTeam homeTeam = (HomeTeam)objectMapper.treeToValue(homeTeamNode, HomeTeam.class);
                            game.setHomeTeam(homeTeam);
                            JsonNode visitorTeamNode = node.get("visitor_team");
                            VisitorTeam visitorTeam = (VisitorTeam)objectMapper.treeToValue(visitorTeamNode, VisitorTeam.class);
                            game.setVisitorTeam(visitorTeam);
                        } catch (Exception var10) {
                            var10.printStackTrace();
                        }

                        return game;
                    }).collect(Collectors.toList());
                    games = (List)games.stream().filter((game) -> {
                        return game.getDate().equals(targetDate);
                    }).collect(Collectors.toList());
                    return games;
                } else {
                    System.out.println("No data found in the response");
                    return new ArrayList();
                }
            }
        } catch (Exception var17) {
            var17.printStackTrace();
            return new ArrayList();
        }
    }

    public Game getAllGamesById(Long id) throws Exception {
        Optional<Game> optionalGame = this.gameRepository.findById(id);
        return (Game)optionalGame.orElse((Game) null);
    }
}
