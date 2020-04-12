# Shortest-possible-path-
This is my Advanced Data Structure home assignment on developing an google maps application for finding the shortest possible path. Code is purely written in java and I have used Javascript and javaFX for UI.
Steps to execute:
1)Go to src-> application-> MapApp.java
2)Run MapApp.java
Now you will see the UI in front of you, drag the map to any location of your choice(Eg:- Vishwakarma Institue of technology,Pune campus). Make sure you don't select larger area as it will take lot of time to compute.
3)After you drag the map to your selected area, At the bottom of the UI there is small box where you will type any name you want to give to your map with .map as extension(Eg:- vit.map)
4)Click on "fetch data" button and wait for a while.
5) click 'OK' on the pop up.
6)Now minimize the UI and go to data-> maps folder and refresh the map folder, you will see your map file has appeared there(Eg:- vit.map)
6)Now go to src-> util-> GraphLoader.java
7)In the main function of GraphLoader.java, replace YOURMAP.map and YOURMAP.intersections with the name you given to your map earlier. 
8)Run GraphLoader.java
9)Go back to the UI and select your map in sliding window and click on "Show Intersections". Your map will appear on the screen with intersections.
These intersections are the vertices of your graph.
10)Select any vertex and click on "Start", this will select the starting point. Now again select any vertex and click on "Dest", this will select the destination point.
11)Click on algorithm you want(Eg:- Dijkstras).
12)Click on "show route". This will show the shortest path between two vertices.

You can also visualize the algorithm i.e, how vertices are visited to reach the goal by clicking on "Visualization" button.
