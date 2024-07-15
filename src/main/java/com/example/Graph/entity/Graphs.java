package com.example.Graph.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="graphsTable")
public class Graphs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int nodesCount;
    private int edgesCount;

    public int getNodesCount() {
        return nodesCount;
    }
    public void setNodesCount(int nodesCount) {
        this.nodesCount = nodesCount;
    }

    public int getEdgesCount() {
        return edgesCount;
    }
    public void setEdgesCount(int edgesCount) {
        this.edgesCount = edgesCount;
    }
}