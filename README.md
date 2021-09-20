# FantasyPL Assist

## An app to assist FantasyPL managers

- **What will the application do?**

The main aim of this app is to assist Fantasy Premier League (**FPL**) managers with their decision-making when 
selecting players for their teams. Fantasy Premier League is a fantasy football/soccer game for England's top tier
Premier League.
Currently, the app will allow users to edit their fantasy team which includes adding/removing players as well
as viewing the entire team and checking balances. To help make decision, managers will be able to select a football
team and view all the necessary information and stats too. In the future, the app will include additional 
functionalities such as point projections of players and stats based player analysis which will enhance the user's 
interaction with the app. 

Rules for playing Fantasy Premier League (FPL) can be viewed here- https://fantasy.premierleague.com/help/rules

- **Who will use the app?**

Manager who plays Fantasy Premier League (FPL)

- **Why is this project of interest to you?**

With an increasing number of FPL players over the years, the game is getting more and more popular. However, there is 
one thing lacking from this game, and it is a tool that can help managers visualise and utilise the underlying stats 
within the football/soccer games. These stats are critical in making decisions for all the managers who play FPL 
however, I have noticed since a long time ago, that these stats are not presented properly to the users. When I started 
playing this 6 years ago, there was only a handful of sites where you can search all the necessary information. Lately, 
the FPL app itself has added multiple stats, however, they are not well-designed enough for a user like me to use them 
for decision-making. The lack of functionalities related to these stats is what drives me to work on this topic, and
after completion, I hope to utilise this app to make decisions for my fantasy team based on the stats input.

## User Stories

- As a user, I want to be able to create a fantasy team of my own.
- As a user, I want to be able to add players to my fantasy team.
- As a user, I want to be able to remove players to my fantasy team.
- As a user, I want to be able to view the player list of my fantasy team.
- As a user, I want to be able to view the balance of my fantasy team.
- As a user, I want to be able to view the stats of the available football teams in the app.
- As a user, I want to be able to view instructions on how to use this app.
- As a user, I want to be able to save my fantasy team.
- As a user, I want to be able to load my fantasy team from where I left before.

**"Phase 4 - Task 2"**

I have included Option 2 - "Include a type hierarchy in your code other than the one that uses the Saveable interface 
introduced in Phase 2".
Classes involved - Team, FantasyTeam, FootballTeam
Under "team" package in model, I created an abstract class named "Team". Two other classes in the same package 
"FantasyTeam" and "FootballTeam" extend "Team" with 2 abstract methods from "Team" overridden (addPlayer and
RemovePlayer). The process of adding players to a fantasy team is different from football team (e.g., the process 
of checking players' teams is only necessary in fantasy team but not in football team) thus, this abstract method has 
to be overridden in both classes. The same applies to removePlayer.

**"Phase 4 - Task 3"**

A major change I would make is to establish a bi-directional relationship between Football Team and Player. I had an 
idea to implement this when writing the console application, but I did not know how to do this during that time. It 
makes sense to have a list of players in a football team and on the other hand, it makes sense for a player to have a 
football team, thus having a bi-directional relationship.

