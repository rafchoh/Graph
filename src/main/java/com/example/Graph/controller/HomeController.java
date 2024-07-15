package com.example.Graph.controller;

import com.example.Graph.entity.Graphs;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class HomeController {

    @Autowired
    GraphCreator gc;

    Map<String, Object> graph;

    @GetMapping("/")
    public String getHomeScreen(Model model) throws JsonProcessingException {
        model.addAttribute("page_name", "Graph creator");
        model.addAttribute("graphsTable", new Graphs());

        if (graph != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            String graphJson = objectMapper.writeValueAsString(graph);
            model.addAttribute("graphJson", graphJson);
        }

        return "home";
    }

    @PostMapping("/")
    public String createGraph(@ModelAttribute Graphs graphTable, Model model) {
        try {
            graph = gc.graphCreator(graphTable.getNodesCount(), graphTable.getEdgesCount());
            System.out.println(graph);

            return "redirect:/";
        } catch (IllegalArgumentException e) {
            model.addAttribute("graphException", e.getMessage());
            return "errgraph";
        }
    }
}
