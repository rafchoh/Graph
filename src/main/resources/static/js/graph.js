function drawGraph(jsonData) {
    var graphData = JSON.parse(jsonData);

    var nodes = new vis.DataSet(graphData.nodes);
    var edges = new vis.DataSet(graphData.edges);

    var container = document.getElementById('graph');
    var data = {
        nodes: nodes,
        edges: edges
    };
    var options = {
        edges: {
            arrows: {
                to: {enabled: true, scaleFactor: 1}
            }
        }
    };
    var network = new vis.Network(container, data, options);
}

document.getElementById('drawGraphButton').addEventListener('click', function() {
    localStorage.setItem('graphDrawn', 'true');
});

if (localStorage.getItem('graphDrawn') === 'true') {
    var graphJson = document.getElementById("varGraphJson").value;
    drawGraph(graphJson);
    localStorage.removeItem('graphDrawn');
}
