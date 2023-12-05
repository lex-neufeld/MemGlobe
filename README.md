# MemGlobe

Short Description:

Learn and stay up-to-date of Geography Trivia with spaced repetition. Establish a Mind Map of the globe with latitude and longitude. Create targeted learning goals (ex: selected demographics in a region) and generate progress reports. 

The goal is easy-to-use software for mobile devices for people to learn the name and location of all countries which then enables faster learning and understanding of global issues. 

Mnemonic theory suggests that learning SEVERAL pieces of interlinked or useful trivia for each country speeds up knowledge acquisition and increases retention. Therefore, user can select from a broad range of trivia to learn.

Extended Description:

⦁	List of countries is stored locally, can self-generate, self-update, and is journaling. Or just download an update from a mirror. 

⦁	Advanced cross-linked spaced repetition  triggers review of related trivia. The answer to one trivia is several other trivia.

⦁	Pictures optimized for mobile devices.

⦁	Low-distortion maps always centered on subject.

⦁	Country and Group-based rules for determining which Trivia to learn. User can use pre-defined groups (such as continents, alliances, cultural or economic blocks), define new groups, and set rules for groups or individual countries.

⦁	track user progress

⦁	pronunciation guides/audio


Trivia (subject to change)
1.		Name
2.		Capital
3.		Lat/Long of Captial
4.		Political Borders
5.		Flag
6.		Level of Recognician
7.		Neighboring Countries
8.		Spoken Languages
9.		"Hello" in local languages
10.		Monuments
11.		Food
12.		Mountain Ranges
13.		Rivers
14.		Lakes
15.		Major Cities
16.		Demographics
17.		Economy
18.		Climate
19.		History

Learning goals:	
Political Borders
This actually goes quite quickly as every country reviewed is also a passive reivew of all neighboring countries.

Lat/Long
It's only 90degrees north and south and 180degrees east and west. This is only 540 lines across the globe. Learning where a couple hundred locations are in relation to just 540 "streets" is very doable and then provides a framework that any knew geophraphical knowledge can be attached to so it can also be learned and retained more effeciently. For comparison, London taxi drivers memorize 25,000 streets and 100,000 landmarks to pass "The Knowledge" test. This takes 4 years of study. With just 540 lines and ~250 landmarks we are talking single digit months even for casual users.

The rest
~250 countries * ~45 trivia per country yields 11,250. While this is still a fraction of what a London cab driver learns, it is probably out of the reach of casual users and they will have to choose a subset using the rules functionality. 

SWOT:
strengths
⦁	lead dev (Lex) previously built a memosyn card set and memorized all countries+capitals+flags+political boundries
weaknesses
⦁	low experience in most areas (scraping, databases, mobile apps, graphic editing) 
⦁	no experience in map generation or mneumonic algorythims
⦁	no planned revenue model, unknown demand or market size
opportunities
⦁	potential demand from multinationals with no gold standard for education or certification of knowledge. People just kind of pretend to be "worldly" but are ignorant of a majority of countries which can lead to embarassment and costly mistakes
⦁	increased globalisation, multiculturalism, and online propaganda demands better geographical education for casual users
threats
⦁	map and image copyrights (some places even claim to have a copyright on their official state flag...)
⦁	maintaining political neutrality and credibility in the face of border disputes and choosing key representations for countries


flat trivia hierarchy goal

each trivia item will have
- the information itself (name, picture, number, etc.)
- a flag to say what category of information it is (country, flag, river, GDP, etc.)
- a flag to say if it can be used as a question
- links to all possible answers

this allows trivia that don't have any, or have more than 1, country to exist seamlessly in the database instead of being limited to trivia that nicely fits an Object Oriented model of countries
it also allows a question like "river" to easily point to all the countries it flows through
or for two contries to point to the same language, and that language to point back to both of them

adding/maintaining information to the database can still be done with a hierarchy when it makes sense by using templates
Call up a trivia, and it will display all, or a pre-defined set of, the linked information as if they were members of it, but really france links to paris the same way paris links to france and neither are members of eachother, and a treaty could link back to paris without france or paris being linked to that treaty

it has occured to Lex that he has no idea how a river is supposed to work. If the category is river and the id is Sein_river, but I acutally want the name of the river and the map of the river as two seperate trivia that could be used as questions or answers, what do I do?