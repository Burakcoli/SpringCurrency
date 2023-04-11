package com.burakunutmaz.CurrencySpring.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    private final String baseApiUrl = "https://www.tcmb.gov.tr/kurlar";
    private final String apiUrl = "https://www.tcmb.gov.tr/kurlar/%s/%s.xml";
    @GetMapping("/today")
    public ResponseEntity<String> today() throws Exception {
        String url = baseApiUrl + "/today.xml";

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/xml");

        InputStream responseStream = connection.getInputStream();
        Scanner scanner = new Scanner(responseStream).useDelimiter("\\A");
        String response = scanner.hasNext() ? scanner.next() : "";

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<String> date(
            @RequestParam(name = "date") String date
    ) throws Exception {
        String[] parts = date.split("-");
        String year = parts[0];
        String month = parts[1];
        String day = parts[2];

        String url = String.format(apiUrl, year+month, day+month+year);

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/xml");

        InputStream responseStream = connection.getInputStream();
        Scanner scanner = new Scanner(responseStream).useDelimiter("\\A");
        String response = scanner.hasNext() ? scanner.next() : "";

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
}
