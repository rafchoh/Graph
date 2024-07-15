package com.example.Graph.controller;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GraphCreator {
    public Map<String, Object> graphCreator(int maxNodes, int maxEdges) {
        if(maxNodes < 1 || maxEdges < 0 || (maxNodes < 3 && maxNodes < maxEdges)){
            throw new IllegalArgumentException("Invalid number of nodes or edges.");
        } else {
            Random random = new Random();

            List<Map<String, Object>> nodesList = new ArrayList<>();
            List<Map<String, Object>> edgesList = new ArrayList<>();

            for (int i = 0; i < maxNodes; i++) {
                Map<String, Object> node = new HashMap<>();
                node.put("id", i);
                node.put("label", "" + (i + 1));
                nodesList.add(node);
            }


            for (int i = 0; i < maxEdges; i++) {
//                Set<String> uniqueEdges = new HashSet<>();

                Map<String, Object> edge = new HashMap<>();

                int from = random.nextInt(maxNodes);
                int to = random.nextInt(maxNodes);
//                String edgeKey = from + "-" + to;

//                if (uniqueEdges.contains(edgeKey)) {
//                    --i;
//                    continue;
//                } else {
//                    uniqueEdges.add(edgeKey);
//                }

                edge.put("from", from);
                edge.put("to", to);
                edgesList.add(edge);
            }

            Map<String, Object> graph = new HashMap<>();
            graph.put("nodes", nodesList);
            graph.put("edges", edgesList);

            return graph;
        }
    }
}
