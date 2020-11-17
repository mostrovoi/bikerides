<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Helsinki bike rides analysis from Open data</title>
        <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
        <style>
          .container {
            width: 100%;
            height: 100%;
            overflow: hidden;
          }
          .box {
            box-sizing: border-box;
            padding: 10px;
            float: left;
            width: 47%;
            height: 40%;
          }
        </style>
    </head>
    <body style="text-align: center; font-family: sans-serif">
        <h1>Bike rides analysis from Open data</h1>
        <div class="container">
          <div class="box">
            <canvas id="distance-chart"></canvas>
          </div>
          <div class="box">
            <canvas id="duration-chart"></canvas>
          </div>
          <div class="box">
            <canvas id="trips-chart"></canvas>
          </div>
          <div class="box">
            <canvas id="averagespeed-chart"></canvas>
          </div>
        </div>
        <script>
           var monthLabels = ["May", "June", "July", "August", "September", "October"];
           var yearColors = ['rgba(50, 200, 200, 1)', 'rgba(150, 200, 50, 1)', 'rgba(200, 200, 200, 1)','rgba(200, 250, 200, 1)','rgba(250, 200, 200, 1)'];
           var distanceChartData = {
                      labels: monthLabels,
                      datasets: [
                      <#list bikerides.items as yearsummary>
                          {
                             label: ${yearsummary.year?c},
                             backgroundColor: yearColors[${yearsummary?index}],
                             borderColor: 'rgba(0, 0, 0, 0.1)',
                             borderWidth: 1,
                             data : [
                                    <#list yearsummary.months as month>
                                    <#assign kmDistance=(month.data.totalDistance/1000)?round>
                                    ${kmDistance?c},<#sep>
                                    </#list>
                                    ]
                           },<#sep>
                           </#list>
                     ]
           };
           var durationChartData = {
                     labels: monthLabels,
                     datasets: [
                     <#list bikerides.items as yearsummary>
                         {
                            label: ${yearsummary.year?c},
                            backgroundColor: yearColors[${yearsummary?index}],
                            borderColor: 'rgba(0, 0, 0, 0.1)',
                            borderWidth: 1,
                            data : [
                                   <#list yearsummary.months as month>
                                   <#assign hoursDuration=(month.data.totalDuration/3600)?round>
                                   ${hoursDuration?c},<#sep>
                                   </#list>
                                   ]},
                            </#list>
                        ]
            };
              var tripChartData = {
                        labels: monthLabels,
                        datasets: [
                        <#list bikerides.items as yearsummary>
                            {
                               label: ${yearsummary.year?c},
                               backgroundColor: yearColors[${yearsummary?index}],
                               borderColor: 'rgba(0, 0, 0, 0.1)',
                               borderWidth: 1,
                               data : [
                                      <#list yearsummary.months as month>
                                      ${month.data.totalTrips?c}<#sep>,
                                      </#list>
                                      ]},
                               </#list>
                         ]
                };
                  var averageSpeedChartData = {
                            labels: monthLabels,
                            datasets: [
                            <#list bikerides.items as yearsummary>
                                {
                                   label: ${yearsummary.year?c},
                                   backgroundColor: yearColors[${yearsummary?index}],
                                   borderColor: 'rgba(0, 0, 0, 0.1)',
                                   borderWidth: 1,
                                   data : [
                                          <#list yearsummary.months as month>
                                          <#assign hoursDuration=(month.data.totalDuration/3600)?round>
                                          <#assign kmDistance=(month.data.totalDistance/1000)?round>
                                          <#assign kmPerHour=kmDistance/hoursDuration>
                                          ${kmPerHour?c}<#sep>,
                                          </#list>
                                          ]},
                                   </#list>
                             ]
                    };

            new Chart(document.getElementById("distance-chart"), {
               type: 'bar',
               data: distanceChartData,
               options: {
                 legend: { display: true },
                 title: {
                   display: true,
                   text: 'Distance in km'
                 }
               }
           });
          new Chart(document.getElementById("duration-chart"), {
               type: 'bar',
               data: durationChartData,
               options: {
                 legend: { display: true },
                 title: {
                   display: true,
                   text: 'Service utilization in hours'
                 }
               }
           });
           new Chart(document.getElementById("trips-chart"), {
              type: 'bar',
              data: tripChartData,
              options: {
                legend: { display: true },
                title: {
                  display: true,
                  text: 'Total number of bike trips'
                }
              }
          });
           new Chart(document.getElementById("averagespeed-chart"), {
              type: 'bar',
              data: averageSpeedChartData,
              options: {
                legend: { display: true },
                title: {
                  display: true,
                  text: 'Average speed in km/h'
                }
              }
          });

        </script>

    </body>
</html>