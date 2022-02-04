### Technical stack
* Selenium WebDriver 4.1.2
* Maven 3.8.1
* Java 8
* TestNG 7.5.0
* Chrome 98
* Edge 97

###Common information
####System under test:
https://sportsdirect.com - The UK’s No 1 Sports Retailer

####Feature to test:
Please create Selenium TCs for buying good in e-shop (i.e. from sportsdirect.com).

####Off-topic:
I'd like to mention that previously I did test using Selenide hence I do understand that not all assertions are on their place. 
This is something that should be improved.

At the same time I wasn't tried to cover and test everything because:
* I respect your time, because you'll check it and spend your own time;
* I respect my time, I believe what you'll see is enough for your understanding - if not, let's talk :)
* There is no borderline of success story here, I mean during development I all the time found places for improvement. In the end I won't finish it in time if I start to make it better over and over again :)

###How to
####run the suite
* using runner.xml
* using classes under /src/test/java/cases/

####set browser under test
Suite is working under Chrome & Edge browsers. Default browser for test run can be set in base.properties e.g.
- browser=chrome
- browser=edge

####find onward sprint plans
* add Firefox support
* improve test coverage by adding new tests
* improve locators
* add Allure
* add Grid 4