# Bike rides

![bikerides](https://github.com/mostrovoi/bikerides/workflows/bikerides/badge.svg)

Proof of concept using OpenData from the Helsinki Open repository (https://classic.hsl.fi/avoindata)

We have used OpenData from public bike transportation to try to prove 2 things:

&nbsp;&nbsp; a) The public bike system adoption is on the rise and increases every year.

&nbsp;&nbsp; b) The people using the public bike system gets more fitted as they use it i.e. the trips average speed should increase.

This project consists of 2 parts:

&nbsp;&nbsp; 1.- Download **all** Helsinki bike trips from years 2016-2020 and parse them summarizing the findings. 

These trips include all data from all trips.
The service is only available from May to October, so we will only look at these months. The yearly data is not included in the repository as it takes up a lot of space, but you can download it from here:
http://dev.hsl.fi/citybikes/od-trips-{year}/od-trips-{year}.zip where {year} can be from 2016 to 2020 values.

&nbsp;&nbsp; 2.- Load the summarized data and present it in a visual way to be able to see the findings. We have used chartjs for that: (https://www.chartjs.org/)

### Findings

Below you can see a picture including 4 relevant charts with the summarized data. 
In 2016

![Bike rides charts](https://github.com/mostrovoi/bikerides/blob/master/ridesanalysis.png?raw=true)