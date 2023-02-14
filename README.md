# GoStudy 
<em>(incomplete project)</em>

It aims to solve the problem of reducing the negative impact long hours of study can have on students. It solves this problem by measuring and analyzing the users heart rate, stress level, emotions and their state when they're studying. By getting this analysis, we will be able to tell the users when its time to stop studying and take a break. During this break when their state is ok, we can recommend when to start studying again.

<br>

# Data collection
- We wore an E4 wristband and oura ring to collect our heart rate, temperature and electrodermal activity(EDA) over a number of weeks.
- We preformed data processing on the collected data to analyse when the users state is in a decline from long hours of study. 
- We wanted to use our collected data to identify patterns to find out during which hours is most appropriate for the users to take break and suggest break time.

<br>

# Visualisation
The data was explored and here is some visualisation of some of our explored data for the heart rate, temperature and EDA:

**Temperature**
![Temperature](https://github.com/erifejams/Study/blob/main/Data%20Analysis/data%20visualisations/temp.png)

**Heart Rate**
![heart rate](https://github.com/erifejams/Study/blob/main/Data%20Analysis/data%20visualisations/heartrate.png)

**EDA**
![EDA](https://github.com/erifejams/Study/blob/main/Data%20Analysis/data%20visualisations/eda.png)

<br>

# App Architecture
Changes to the architecture were made. In the database, its uses sqlite instead of CloremDB.

![architecture](https://user-images.githubusercontent.com/44726422/218860762-5cbb4ae8-2ee2-4318-8836-a8bf9db8e014.png)

<br>

# Video of App running
https://user-images.githubusercontent.com/44726422/218853647-3c7f365a-fe56-493c-b4f1-995bed6a54de.mp4

<br>

# Todo
- finish implementing the database in the app.
- Train a machine learning model using our data for receommendation.
- Provide some visualization to the user about the stress level or the productivity.
