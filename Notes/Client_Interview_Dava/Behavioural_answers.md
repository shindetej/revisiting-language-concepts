How are you? -> I am doing well ,little excited

> Tell me about yourself

I am tejas,currently i am in pune
i have done my bachelor of engineering from Pune university in electrical engineering major
after passout I have done two jobs in electrical and lighting design field as almost 3+ years

post that i enrolled for cdac postgraduate diploma course in 2020 which is of 6 months duration
I got placed in Xcaliber infotech in July 2021 and currently working here since last three years
during these tenure I got opportunity to work on backend APIs for Reverse logistics software 
Primarily worked in Mulesoft integration platform and spring boot both are on top of Java


thats my brief introduction

----
 tell me about your project ? 
Projects that you worked on


As we worked in Reverse logistices chain we have recently implemented  device buyback solution for clients operating across over 3,000 stores in the US. The project enables customers to return devices like mobiles, tablets, and consoles through a web application that processes these transactions.

The system is designed to evaluate and process device returns by asking various questions and performing tests to generate accurate values based on the answers provided. It's a robust solution that simplifies the buyback process for both customers and store employees.
 
 
On the technology side, the backend is powered by Mulesoft and Java, while PHP is used for the frontend. We also use Python vision scripts for visual inspections and functional testing through a desktop application. The entire system is deployed on AWS instances.

  
"My role in this project involved developing the transaction and store management APIs. I also worked on the integration logic to connect our buyback solution, TruBuy, with another product, Midas, which handles the post-processing of returned devices."


Transactions APIs are the one used to track and update entire device specific states through value generation process explained above 
those transactions whose Offer accepted will be sent to our other sub module where we act on devices for cleaning and repairing before going to auction

We also integrated 3rd party APIs like Prolog which fetched device information based on IMEI and serial number and we used S3 bucket to 
store images and excel sheet used in project


----
Rule Editor :

Situation:
"I worked on a Spring Boot project focused on creating a rule editor, which is a Drools file creation engine. The application’s primary function was to generate Drools files from JSON inputs provided by the frontend."

Task:
"My responsibility involved automating the transfer of these Drools files to different environments like UAT and PRE-PROD without requiring intervention from the infrastructure team. This process required implementing workflow approvals for deployment."

Action:
"I automated the file transfer process using Linux commands and the JSCH library for secure transfers. Additionally, I integrated workflow microservices APIs for team lead approval, ensuring that only approved changes were deployed. This automation reduced manual intervention, which used to slow down the process."

Result:
"As a result, the deployment time was significantly reduced after approval, making the transition between environments more efficient. The automation streamlined the entire workflow, cutting down the delays caused by manual file transfers and ensuring a faster post-approval deployment."


---


### **WHAT ARE CHALLENGING SITUATION YOU FACED IN PROJECTS**
- Situation:
"Our backend application began crashing due to memory overload, which we identified through production logs and process monitoring. The issue was critical as it affected **AS GET TRANSACTION API HAS LOT OF DATA WHICH TAKING TIME TO FETCH**, 
- Task:
"We needed to stabilize the system quickly while also finding a sustainable solution to handle the high volume of monitoring requests."

- Action:
"We found that the heartbeat API was being called over 6,000 times per minute synchronously, blocking the main thread and overwhelming the request pool with concurrent database operations. As an immediate fix, we reduced the frequency of these calls to a manageable level, as they were primarily for monitoring purposes. Next, we refactored the API to handle requests asynchronously, which allowed the system to process these calls without blocking critical resources."

- Result:
"The application stabilized immediately after the frequency adjustment, and the asynchronous handling improved the system's resilience to high traffic. Memory usage decreased significantly, and uptime increased to 99.9%, ensuring reliable operations across all stores."
-----

- 2nd issue I encountered during Production that was our one of  server on build was creating different result for API
later I along with infra team found that even properties set are correct into later we found that there were extra space in one line which treated as string an hence query was failing to get the data to front end.
After space fix that issue resolved but what i learned extra invisible space in properties make 

- Situation:
"While working on a production environment, we encountered an issue where one of the servers on the build was producing different API results compared to others, even though the configuration and properties appeared to be correctly set."

- Task:
"My task was to identify the root cause of the discrepancy and resolve the issue to ensure consistent API responses across all servers."

- Action:
"After thorough investigation and collaboration with the infrastructure team, we found that, despite the properties file being correctly set, there was an invisible extra space in one line. This space was being treated as part of the string, causing the query to fail and resulting in incorrect or missing data being sent to the frontend. Once we identified the issue, we removed the space and tested the fix across environments to ensure it resolved the problem."

- Result:
"The fix immediately resolved the API inconsistency, and all servers started producing uniform results. This experience taught me the importance of paying attention to details, such as invisible spaces, when working with configuration files. As a preventive measure, we also added a validation script to catch such anomalies in properties files before deployment."

---

### MY ROLE AS DEVELOPER :
"In my role as a software developer, I start by working closely with the Business Analyst to fully understand the business needs. They help me get a clear picture of what’s required, and I make sure I’m aligned with the goals.

Once I have a good understanding of the requirements, I design the API specifications and the necessary database tables. I focus on making sure everything is efficient, scalable, and works well with the existing system.

After that, I get into the development phase, where I build the APIs and test them thoroughly in the development environment. I try to cover all possible edge cases and ensure everything works as expected.

Once the development is complete, I collaborate with the deployment team to make sure everything is smoothly pushed into production. If there are any issues after deployment, I jump into debugging mode—figuring out what went wrong, fixing the problem, and ensuring everything is back on track.

So, to sum it up, my role is all about understanding the business, translating that into technical solutions, developing and testing the APIs, and ensuring smooth deployment and troubleshooting if anything goes wrong."