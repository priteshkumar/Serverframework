use world;
show tables;
describe city;
describe country;
describe countrylanguage;

-- 1. count of cities
select count (*) from city

-- 2. Country having highest number of cities
#Method 1:
select country."Name", count(*) as number from city inner join country on "CountryCode" = "Code" group 
by country."Name" order by number desc

-- fix query 
--Method 2:
select country."Name", count(*) as mycount from city inner join country 
on "CountryCode" = "Code" group by country."Name"
having count(*) >= All(select count(*) from city group by "CountryCode")


-- alternative solution
select country."Name", count(*) as mycount from city inner join country 
on "CountryCode" = "Code" group by country."Name"
having count(*) = (select max(mycount)
		from (select count(*) as mycount
		      from city
		      group by "CountryCode") as mytable)



--3. Which language is its country’s official language and spoken by 80 to 90 percent of people
select * from countrylanguage where "IsOfficial" = 'T' and "Percentage" between 80 and 90

-- 4. In India, how many cities have been listed in “Maharashtra” district?
select count(*) as count_MH from city where District = "Maharashtra";

-- 5. Which country has the maximum population (if population is taken as the population from the country table)
select * from Country where population = (select max(population) from country)

-- Which language is spoken in the maximum number of countries?
select language,count(*) as number from countrylanguage 
group by language 
order by number desc


# 7. Among the following, which language is the official language of the more number of countries?
-- alternative solution
select "Language" 
from countrylanguage
where "IsOfficial" = 'T'
group by "Language"
having count(*) = (select max(mycount)
                   from (select count(*) as mycount
                   from countrylanguage
                   where "IsOfficial" = 'T' 
                   group by "Language") as mytable)



-- solution 2
select language,count(*) as number from country inner join countrylanguage on code = CountryCode 
where IsOfficial = "T"
group by language 
order by number desc



--8. How many cities in North America are there where English is the official language

select count(*) from city c 
inner join country co on c."CountryCode" = co."Code"
inner join countrylanguage cl on co."Code" = cl."CountryCode"
where co."Continent" = 'North America' and cl."Language" = 'English' and cl."IsOfficial" = 'T';



# 9. Which city has the least population among these
#Method 1:
Select * from city inner join country on city.CountryCode = country.code inner join countrylanguage on country.code = countrylanguage.CountryCode
where
country.Continent = "North America" 
and 
countrylanguage.language = "English"
and 
countrylanguage.IsOfficial = "T"
and
city.Population >= all(Select city.population from city inner join country on city.CountryCode = country.code inner join countrylanguage on country.code = countrylanguage.CountryCode
where
country.Continent = "North America" 
and 
countrylanguage.language = "English"
and 
countrylanguage.IsOfficial = "T")

--Method 2 - Smart Method (especially in a MCQ test)
select ID, Name, Population 
from city 
where Name="Phoenix" or Name="Los Angeles" or Name="Chicago" or Name="New York"
order by Population asc;

-- 10. How many row entries are there with any value in the country table being NA
select count(*) from country
where "Code" is null or "Name" is null or "Continent" is null or "Region" is null 
or "SurfaceArea" is null or "IndepYear" is null or "Population" is null 
or "LifeExpectancy" is null or "GNP" is null or "GNPOld" is null or "LocalName" is null 
or "GovernmentForm" is null or "HeadOfState" is null or "Capital" is null or "Code2" is null


-- alternative solution
select count(*) from country where not (country is not null)


-- How many countries are there whose name starts with I and ends with A
select count(*) from country 
where "Name" like '%a'
and "Name" in (select "Name" from country where "Name" like 'I%');


-- Which continent has least surface area
select continent, sum(SurfaceArea) from country group by Continent order by sum(SurfaceArea) desc

